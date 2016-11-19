#Charlie Quinn

#Basic playing card class, blackjack card subclass and total method
#I did the extra credit involving the Exceptions being raised

from sys import argv
from random import sample

class Card:
    """
    Basic playing card class with init for rank suit and points
    """
    
    def __init__(self, n):
        if n > 51:
            raise Exception("ID must be less than 51")
        if n < 0:
            raise Exception("ID must be a positive number between 0 and 51")
        points_key = {0:0,1:0,2:0,3:0,4:0,5:0,6:0,7:0,8:0,9:1,10:2,11:3,12:4}
        self._id = n
        self.r = n % 13 #should be 0 through 12 for each suit
        self.s = n // 13 #should be 0 through 4 for each number
        self.p = points_key[self.r] #should be different for face cards only
    def suit(self):
        return self.s
    def rank(self):
        return self.r
    def points(self):
        return self.p
    def __lt__(self, other):
        return self._id < other._id
    def __repr__(self):
        suits = {0: '\u2663',1: '\u2666',2:'\u2665',3:'\u2660'}
        ranks = {0: 2, 1:3,2:4,3:5,4:6,5:7,6:8,7:9,8:10,9:'J',10:'Q',11:'K',12:'A'}
        return str(ranks[self.r]) + suits[self.s]

class BlackJackCard(Card):
    """
    subclass of Card that overrides points()
    """
    def __init__(self,n):
        Card.__init__(self,n)
    def points(self):
        bj_points = {9:10,10:10,11:10,12:11}
        if self.r < 9:
            return self.r + 2
        else:
            return bj_points[self.r]
    def __lt__(self,other):
        return self.rank() < other.rank()
    

def total(h):
    """
    adds up point values in a hand
    """
    totality = 0
    for i in h:
        totality = totality + i.points()
    return totality
    
def main():
    deck = []
    for i in range(52):
        deck.append(Card(i))
    bj_deck = []
    for i in range(52):
        bj_deck.append(BlackJackCard(i))
    
    #print(deck)
    #print(bj_deck)

    bj_hand = sample(bj_deck,5)
    hand = sample(deck,5)
    print(hand)
    print(total(hand))
    print(bj_hand)
    print(total(bj_hand))
    

if __name__ == '__main__':
    main()
