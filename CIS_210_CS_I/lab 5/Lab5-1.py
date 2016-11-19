#by Charlie Quinn Lab5-1.py

def what_balance(prompt_message):
    """ takes user input
    """

    prompt = prompt_message + ' '
    temp = input(prompt)
    #get input from user
    return float(temp)

def what_min(balance):
    minipay = balance * .027
    if minipay < 12:
        minipay = 12
    minipay = round(minipay, 2)
    return minipay


do_again = 'y'

print("Tiny National Bank of Charlieville")

while do_again =='y':

    balance = what_balance("\nEnter your credit card balance: ")
    
    if balance <= 0:
        print("You don't owe any money")
    elif balance < 12:
        print("Your minimum payment is " , balance)
    else:
        minimumpayment = what_min(balance)
        print("Your minimum payment is " , minimumpayment)
        
    do_again = input("\nAnother one? (y or no) ")

    

