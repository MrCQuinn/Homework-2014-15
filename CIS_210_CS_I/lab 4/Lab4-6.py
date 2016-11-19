#Charlie Quinn if.py
#Check < in an 'if' statement
#use a 'while' loop to make testing easier

def take_a_grade(prompt_message):
    """ takes in a grades and sorts them
    """

    prompt = prompt_message + ' '
    temp = input(prompt)
    #get input from user
    return int(temp)


do_again = 'y'

Z=0
C=0
B=0
A=0
S=0


while do_again =='y':
    grade = take_a_grade("\nEnter grade: ")
    
    if grade < 25:
        Z+=1
    elif grade < 30:
        C+=1
    elif  grade < 40:
        B+=1
    elif grade < 50:
        A+=1
    else:
        S+=1

    #loop will end when you type in an n
    do_again = input("\nAnother one? (y or no) ")

print("S: ",S,"\nA: ",A,"\nB: ",B,"\nC: ",C,"\nZ: ", Z)


        
