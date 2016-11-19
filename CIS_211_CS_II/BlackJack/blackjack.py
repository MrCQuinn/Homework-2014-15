# Blackjack game using Card class I created and Deck class I wrote to build a
# blackjack game. Works super well.


#BlackJack
#By Charlie Quinn
from tkinter import *
from tkinter import messagebox
from random import randint
from CardLabel import *
from Card import *
from Deck import *


side = ["back","front","blank"]
dealer_hand = []
player_hand = []

a = 1
b = 1

deck = Deck()

def deal():
    """
    resets the game by putting all the cards in play back into the deck,
    shuffling the deck, and dealing two cards to each player. the user
    has both cards face up and the dealer has one face down.
    """

    global deck, a, b
    #returns all cards to deck
    deck.restore(dealer_hand)
    deck.restore(player_hand)
    #deletes the hands
    del dealer_hand[:]
    del player_hand[:]
    #shuffles
    deck.shuffle()
    #returns hit counter to default
    a = 1
    b = 1
    #deals hands
    for i in range(2):
        dealer_hand.extend(deck.deal(1))
        player_hand.extend(deck.deal(1))
        
##    print(dealer_hand)
##    print(player_hand)
        
    #displays dealer's hand
    d_display[0].display(side[0], dealer_hand[0]._id)
    d_display[1].display(side[1], dealer_hand[1]._id)
    #"displays" invisible dealer cards
    for i in range(4):
        d_display[i+2].display(side[2])
    #displays two cards for user and then "displays" invisible cards
    for i in range(6):
        if i < 2:
            p_display[i].display(side[1], player_hand[i]._id)
        else:
            p_display[i].display(side[2])
    if total(dealer_hand) == 21:
        d_display[0].display(side[1],dealer_hand[0]._id)
        messagebox.showinfo('You lose', 'Dealer achieves blackjack')
    if total(player_hand) == 21:
        messagebox.showinfo('You win!', 'You got dealt BLACKJACK!!')

def hit():
    """
    deals a new card to the user and checks for a user bust or a user Blackjack
    """

    global a
    a = (a + 1) % 6
    player_hand.extend(deck.deal(1))
    p_display[a].display(side[1],player_hand[-1]._id)

    if total(player_hand) > 21:
        messagebox.showinfo('You win!', 'You busted')
    elif total(player_hand) == 21:
        messagebox.showinfo('You win!', 'BLACKJACK!!')


def passs():
    """
    I mispelled this method on purpose because its a command for a button and
    I didn't want the button to pass. This is for when the user is done being
    dealt new cards. The dealer will hit as long he has less than 17 points.
    This method also checks to see who wins, or if its a tie.
    """

    global b
    b = (b + 1) % 6
    d_display[0].display(side[1],dealer_hand[0]._id)
    while total(dealer_hand) < 17:
        dealer_hand.extend(deck.deal(1))
        d_display[b].display(side[1], dealer_hand[-1]._id)
    if total(dealer_hand) > 21:
        messagebox.showinfo('You win!', 'Dealer has busted')
    elif total(dealer_hand) > total(player_hand):
        messagebox.showinfo('You lose', 'Dealer wins')
    elif total(dealer_hand) == 21:
        messagebox.showinfo('You lose', 'Dealer has achieved blackjack')
    elif total(dealer_hand) == total(player_hand):
        messagebox.showinfo('Tie game', 'At least you didnt lose')
    else:
        messagebox.showinfo('You win!', 'Victory is yours')


def total(hand):
    'returns the value of the blackjack hand'
    values = {0:2, 1:3, 2:4, 3:5, 4:6, 5:7, 6:8,7:9, 8:10, 9:10, 10:10, 11:10, 12:11}
    result = 0
    numAces = 0

    for card in hand:
        result += values[card.rank()]
        if card.rank() == 12:
            numAces += 1

    while result > 21 and numAces > 0:
        result -= 10
        numAces -= 1
        
    return result

root = Tk()

CardLabel.load_images()

p_display = []
d_display = []


for i in range(6):
    d_display.append(CardLabel(root))
    d_display[i].grid(row = 0, column = i)

for i in range(6):
    p_display.append(CardLabel(root))
    p_display[i].grid(row = 1, column = i)

deal()

root.rowconfigure(0, minsize = 115)
root.columnconfigure(0, minsize=85)

button = Button(root, text = "Deal", command = deal)
button.grid(row= 3,column=0, pady =10)

button = Button(root, text = "Hit", command = hit)
button.grid(row= 3,column=1, pady =10)

button = Button(root, text = "Pass", command = passs)
button.grid(row= 3,column=2, pady =10)

if __name__ == "__main__":
    root.mainloop()

