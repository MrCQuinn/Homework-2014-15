
##if name[i] is the start of an element name:
##    set e to the element
##    add the weight of e to the toal
##if name[i] is a digit:
##    convert the string of digits to a number n
##    add (n-1) the weight of e to the toal
##update i to point one past the element or number

from sys import argv
from Element import *



def mol_wt(name,table):

    total = 0
    for ch in name:
        x = table[ch].atwt()
    total += x
    return total

if __name__ == '__main__':
    if len(argv) < 2:
        print('Usage:python3 ' + argv[0] + ' ARG')
        exit(1)
    tbl = load_elements('periodic_table.csv')
    t = mol_wt(argv[1],tbl)
    print(t)

