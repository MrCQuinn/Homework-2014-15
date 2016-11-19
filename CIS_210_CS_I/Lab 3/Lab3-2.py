#Charlie Quinn

def count_length(string):
    counter= 0
    for letter in string:
        counter+=1
    return counter

a = "*" + 20 * "-"

b =  "VW\nBMW"

c =  ''

alength = count_length(a)

blength = count_length(b)

clength = count_length(c)

#print(a + " " + alength + "\n" + b + " " + blength + "\n" + c + " " + clength)

print(a , alength)
print(b, blength)
print(c, clength)
