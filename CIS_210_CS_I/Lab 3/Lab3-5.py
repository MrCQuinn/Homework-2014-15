#Charlie Quinn

def get_float(prompt):
    '''Recieves user input, converts input to a float, multiplies it by two, then rounds it to two decimal places'''
    newnum = float(prompt)
    newnum = newnum*2
    newnum = round(newnum,2)
    return newnum
    

number = input("Enter the price.")

whattoprint = get_float(number)

print(whattoprint)

