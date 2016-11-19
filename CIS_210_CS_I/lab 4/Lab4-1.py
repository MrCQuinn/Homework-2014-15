#Charlie Quinn if.py
#Check < in an 'if' statement
#use a 'while' loop to make testing easier

def get_int(prompt_message):
    """ (str) -> int
        displays prompt message,
        gets input from user
        converts input string to number,
        returns number to caller
    """

    prompt = prompt_message + ' '
    temp = input(prompt) #get input from user
    return int(temp)

limit = 10
do_again = 'y'
while do_again =='y':
    x = get_int("PUT IN X AS A NUMBER FROM -10 to 20")
    # is limit < x?
    if limit <x:
        print("Yes!", limit, "is less than", x)
    else:
        print("Nope, ", limit, "is not less than", x)
    #loop will end when you type in an n
    do_again = input("Try another? (y or no) ")


#it works fine but doesn't recognize that 10 is equal to 10
        
