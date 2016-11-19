#Searches for scores using regular expressions
#Author: Charlie Quinn
from urllib.request import urlopen
import re
from sys import argv


def main(html):
    """
    extracts team names and scores and prints them out
    """
    #opens and reads the html passed from the command line
    doc = urlopen(html).read().decode()
    #scans the file created and makes a list of the lines I want to use
    li = []
    for line in doc.split('\n'):
        if '<table class="linescore' in line:
            li.append(line)

    #creates a list m with tuples that contain the two team names
    #creates a list of lists named s that holds all the integers. 
    m = []
    s = []
    
    for i in range(len(li)):
        m.append(re.findall(r'<a.*?>(.*?)</a>', li[i]))
        s.append(re.findall(r'(\d+)', li[i]))

    #prints out the first teams name, their score, then second teams name and their score
    # Strange bug with s[2], the score of the first team is the 12th integer in the list and not the 11th. this is unique and I solved the issue with an if statement

    for i in range(len(li)):
        if i == 2:
            print(m[i][0], s[i][12] + ", ", m[i][1], s[i][-1])
        else:
            print(m[i][0], s[i][11] + ", ", m[i][1], s[i][-1])

if __name__ == "__main__":
    main(argv[1])
