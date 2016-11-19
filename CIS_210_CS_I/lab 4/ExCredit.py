#Charlie Quinn if.py
#Check < in an 'if' statement
#use a 'while' loop to make testing easier

def income_input(prompt_message):

    prompt = prompt_message + ' '
    temp = input(prompt)
    #get input from user
    return float(temp)


do_again = 'y'


while do_again =='y':
    income = income_input("\nHow much did you make this year?: ")
    
    if income < 15001:
        rate = .005
    elif income < 17501:
        rate = .006
    elif income < 22401:
        rate = .010
    elif income < 47301:
        rate = .014
    elif income < 75001:
        rate = .018
    elif income < 112450:
        rate = .022
    elif income < 277000:
        rate = .027
    else:
        rate = .03

    taxesdue = income *rate

    print("Income: ",income,"\nRate: ",rate,"\nTaxes Due: ",taxesdue)

    #loop will end when you type in an n
    do_again = input("\nAnother one? (y or no) ")

    


        
