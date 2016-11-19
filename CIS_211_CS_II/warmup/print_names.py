# reads file line by line and creates a list of Name objects
# Name object has attributes first_name and last_name
# Sort by attributes
# print it out

#Author: Charlie Quinn

from sys import argv

class Name:

    def __init__(self,first,last):
        self.first_name = first
        self.last_name = last

    def first(self):
        return self.first_name

    def last(self):
        return self.last_name


def main(li, first_or_last):
    """
    Sends the txt file to a name_list function, then sends the list of
    name objects to the sort_names function, and finally prints out the
    list.
    """

    a = name_list(li)
    sort_names(a,first_or_last)
    if(first_or_last=='first'):
        for i in range(len(a)):
            print('{} {}'.format(a[i].first_name, a[i].last_name))
    else:
        for i in range(len(a)):
            print('{}, {}'.format(a[i].first_name, a[i].last_name))
        
def name_list(file_name):
    """
    reads the txt file and goes line by line and splits the name using the
    space between the first and last name. Then it takes strings and creates
    Name objects whilst adding them to a list. returns said list of Name objects
    """
    
    li = open(file_name)
    list_of_names = []

    for name in li:
        (first,last) = str.split(name,' ')
        list_of_names.append(Name(first,last))
    return list_of_names

def sort_names(li, by_which):
    """
    uses the argument that is either first or last to choose which way to sort
    the list of name objects. Sorting key is an attribute of the Name object
    """
    
    if by_which == 'first':
        li.sort(key = Name.first)
    elif by_which == 'last':
        li.sort(key = Name.last)
            
        
    

if __name__ == '__main__':

    main(argv[1],argv[2])

