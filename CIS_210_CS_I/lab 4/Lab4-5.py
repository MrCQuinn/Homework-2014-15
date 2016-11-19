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
    
    if 14 < argon:
        print("\nYes! 14 is less than ", argon)
    if 14 == argon:
        print("\nYes! 14 is equal to ", argon)
    if  14 > argon:
        print("\nYes! 14 is greater to ", argon)
    if  14 != argon:
        print("\nYes! 14 is not equal to ", argon)
    #loop will end when you type in an n
    do_again = input("\nTry another? (y or no) ")


        
