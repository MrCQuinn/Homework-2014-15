#Flippin' Cards program
#By Charlie Quinn
from tkinter import *
from random import randint
from CardLabel import *

side = ["back","front","blank"]

n = 0
a = 2

def flip():
    """
    Function that runs when "Flip" button is pressed.
    a is a value that starts at 0 and goes to 8 before going back to 0
    w and n are both dependent upon a
    w starts at 1, repeats at 1 three times then goes to 2, repeats three times, and 3 three times
    w is used to so that each card knows what side to display
    w is derived by using integer division, dividing a by 3
    n has a pattern of 0,1,2,0,1,2,... in order to alternate between cards every click
    """
    global a, n, card
    a = (a + 1) % 9
    w = a // 3
    n = a % 3

    #print(a,n,w)
    
    card[n].display(side[w], randint(0,51))

root = Tk()

CardLabel.load_images()

card = []

for i in range(3):
    card.append(CardLabel(root))
    card[i].grid(row = 0, column = i)

root.rowconfigure(0, minsize = 115)
root.columnconfigure(0, minsize=85)

button = Button(root, text = "Flip", command =flip)
button.grid(row=1,column=1, pady =10)

if __name__ == "__main__":
    root.mainloop()

