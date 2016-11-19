#Charlie Quinn if.py
#Check < in an 'if' statement
#use a 'while' loop to make testing easier

def take_float(prompt_message):

    prompt = prompt_message + ' '
    temp = input(prompt)
    #get input from user
    return float(temp)


do_again = 'y'

Z=0
C=0
B=0
A=0
S=0


while do_again =='y':
    BMI = take_float("\nEnter BMI: ")
    age = take_float("\nEnter age: ")

    young = age < 45
    slim = BMI < 0.22
    
    if young and slim:
        risk = "Low"
    elif young and not slim:
        risk = "Moderate"
    elif slim and not young:
        risk = "Moderate"
    else:
        risk = "High"
        
    print(BMI,"\n",age)
    print("You are at " , risk , "risk")

    #loop will end when you type in an n
    do_again = input("\nAnother one? (y or no) ")



        
