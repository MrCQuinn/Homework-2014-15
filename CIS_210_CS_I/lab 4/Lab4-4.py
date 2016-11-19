#Charlie Quinn if.py
#Check < in an 'if' statement
#use a 'while' loop to make testing easier

def get_string(prompt_message):
    """ (str) -> int
        displays prompt message,
        gets input from user
        converts input string to number,
        returns number to caller
    """

    prompt = prompt_message + ' '
    temp = input(prompt)
    #get input from user
    return str(temp)


do_again = 'y'


while do_again =='y':
    argon = get_string("\nPUT IN ARGON")
    
    if 'A' < argon:
        print("\nYes! A is less than ", argon)
    if 'a' < argon:
        print("\nYes! a is less than ", argon)
    if  'Aster' < argon:
        print("\nYes! Aster is less than", argon)
    if  'Z' < argon:
        print("\nYes! Z is less than ", argon)
    #loop will end when you type in an n
    do_again = input("\nTry another? (y or no) ")


        
