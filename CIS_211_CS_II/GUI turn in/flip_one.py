from tkinter import *
from random import randint
from CardLabel import *

side = ["back","front","blank"]

n = 0

def flip():
    global n, label
    n = (n + 1) % 3
    label.display(side[n], randint(0,51))

root = Tk()

CardLabel.load_images()

label = CardLabel(root)
label.grid(row=0,column=0)

root.rowconfigure(0, minsize = 115)
root.columnconfigure(0, minsize=85)

button = Button(root, text = "Flip", command =flip)
button.grid(row=1,column=0, pady =10)

if __name__ == "__main__":
    root.mainloop()

