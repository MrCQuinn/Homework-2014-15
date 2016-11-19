#by Charlie Quinn Extra Credit.py

def what_balance(prompt_message):
    """ takes user input
    """

    prompt = prompt_message + ' '
    temp = input(prompt)
    #get input from user
    return float(temp)

def what_min(balance,percent,min_amt):
    ''' takes the account balance and
        uses complex mathematics to determine the  user's
        minimum balance
        '''
    minipay = balance * percent
    if minipay < min_amt:
        minipay = min_amt
    minipay = round(minipay, 2)
    return minipay


do_again = 'y'

print("Tiny National Bank of Charlieville")

while do_again =='y':

    balance = what_balance("\nEnter your credit card balance: ")
    
    if balance <= 0:
        print("You don't owe any money")
    elif balance < 10:
        print("Your minimum payment is " , balance)
    else:
        minimumpayment = what_min(balance,.032,10)
        print("Your minimum payment is " , minimumpayment)
        
    do_again = input("\nAnother one? (y or no) ")

    

