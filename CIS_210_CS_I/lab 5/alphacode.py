"""
  Too Many PINs.  Lab 1, CIS 210
  Author:  Charlie Quinn
  Credits:  None
   
  Python program designed to encode PINs into readable words.
   
"""

def encodepin(pin):
    """
    recieves pin and seperates each chunk and then sends it to numbertoletter
    """
    
    word = ''
    ogpin = pin
    while pin>0:
        pinchunk = pin%100
        pin= pin//100
        wordchunk = numbertoletter(pinchunk)
        
        

        word = wordchunk + word

    print('Encoding of ',ogpin,' is ', word)
    

def numbertoletter(pinchunk):
    """
    converts chunks from two digit numbers into a pair of letters,
    one vowel and one consonant. Then returns letter pair to encodepin.
    """

    vowels = ['a','e','i','o','u']
    consonants = ['b','c','d','f','g','h','j','k','l','m','n','p','q','r','s','t','v','w','y','z']
    vowelnum = pinchunk % 5
    consonantnum = pinchunk // 5
    thevowel = vowels[vowelnum]
    theconsonant = consonants[consonantnum]
    
    letterpair = ''
    letterpair = letterpair + theconsonant + thevowel

    return letterpair



def main():
    """
    Interaction if run from the command line.
    Magic for now; we'll look at what's going on here
    in the next week or two. 
    """

    parser = argparse.ArgumentParser(description="Create mnemonic for PIN code")
    parser.add_argument("PIN", type=int, 
                        help="personal identifier number (an integer)")
    args = parser.parse_args()  # gets arguments from command line
    pin = args.PIN
    encodepin(pin)

