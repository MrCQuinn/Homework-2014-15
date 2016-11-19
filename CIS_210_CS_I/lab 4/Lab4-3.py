#Charlie Quinn if.py
#Check < in an 'if' statement
#use a 'while' loop to make testing easier

def get_float(prompt_message):
    """ (str) -> int
        displays prompt message,
        gets input from user
        converts input string to number,
        returns number to caller
    """

    prompt = prompt_message + ' '
    temp = input(prompt) #get input from user
    return float(temp)

limit = 10


do_again = 'y'


while do_again =='y':
    x = get_float("\nPUT IN A DOLLAR AND CENTS FROM -10 to 20")
    
    if limit <x:
        print("Yes!", limit, "is less than ", x)
    if limit <= x:
        print("Yes!", limit, "is less than or equal to ", x)
    if  limit == x:
        print("\nYes!", limit, "is equal to", x)
    else:
        print("\nNope, ", limit, "is not equal to", x)
    #loop will end when you type in an n
    do_again = input("\nTry another? (y or no) ")


        
