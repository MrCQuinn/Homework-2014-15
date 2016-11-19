# Charlie Quinn
# check for palindrome check1.py


#Run a cleaning function to restrict my string to alphabet characters

def clean_string(string):
    new = ''
    for letter in string:
        if letter in 'abcdefghijklmnopqrstuvwxyz':
            new = new + letter
    return new

#Run the "cleaned" string through a reverser and make it all backwards

def reverse_string(string):
    reverse = ''
    for letter in string:
        reverse = letter + reverse
        
    return reverse



#get input
original_string = input('Enter a phrase in lower case:')

#clean the string
clean = clean_string(original_string)

#get reverse of string
reverse = reverse_string(clean)


#print out the word forward and then backwards for a visual comparison
print(clean,reverse)


#compare the alphabetic string to its reverse and see if it is indeed a palindrome
if clean == reverse:
    print("ITS A PALINDROME")
else:
    print("THIS AIN'T NO PALINDROME")
