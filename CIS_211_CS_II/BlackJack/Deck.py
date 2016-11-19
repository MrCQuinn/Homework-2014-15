#Charlie Quinn

#Deck class

from sys import argv
from Card import *
import random

class Deck(list):
    """
    deck class, inherits from list class and constructor builds a list of
    52 card objects. shuffle randomizes list, deal returns first n items, and
    restore adds card items back into the list
    """

    def __init__(self):
        for i in range(52):
            self.append(Card(i))

    def shuffle(self):
        """
        randomizes order of Card objects in Deck object
        """
        random.shuffle(self)

    def deal(self,n):
        """
        removes first n items from Deck object and then returns those
        items in a list
        """
        h = self[:n]
        self[:n] = []
        return h

    def restore(self,h):
        """
        adds items in h back to the end of Deck object
        """
        self = self.extend(h)

class PinochleDeck(Deck):
    """
    type of deck used in Pinochle, inherits from deck class and constructor
    builds deck with cards 9 and up with two of each card
    """
    def __init__(self):
        for i in range(52):
            if Card(i).rank() > 6:
                self.append(Card(i))
                self.append(Card(i))

def main():
    print("Create a deck:")
    d = Deck()
    print(d)
    print("length of deck:")
    print(len(d))
    d.shuffle()
    print("shuffled deck:")
    print(d)
    h = d.deal(7)
    print("Hand dealt:")
    print(h)
    print("updated deck")
    print(d)
    print("restored deck:")
    d.restore(h)
    print(d)

    print("Create a Pinochle deck:")
    d = PinochleDeck()
    print(d)
    print("length of deck:")
    print(len(d))
    d.shuffle()
    print("shuffled deck:")
    print(d)
    h = d.deal(7)
    print("Hand dealt:")
    print(h)
    print("updated deck:")
    print(d)
    print("restored deck:")
    d.restore(h)
    print(d)

if __name__ == '__main__':
    main()
    
