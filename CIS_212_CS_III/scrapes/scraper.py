#Searches for scores using the html.parser module. Uses a class Scraper that inherits from HTMLParser
#Author: Charlie Quinn
from urllib.request import urlopen
from html.parser import HTMLParser
from sys import argv


class Scraper(HTMLParser):
    """
    class Scraper that inherits from HTMLParser
    """
    def __init__(self):
        """
        constructor uses same __init__ as HTMLParser with the addition of
        _grab_this flag and an empty list game_list
        """
        HTMLParser.__init__(self)
        self._grab_this = False
        self.game_list = []
        
    def handle_starttag(self, tag, attrs):
        """
        appends empty list to the end of game_list and raises _grab_this flag
        if tag is table and class = "linescore"
        """
        if tag == 'table' and attrs == [('class','linescore')]:
            li = []
            self.game_list.append(li)
            self._grab_this = True
        #raises flag if tag is div and class = "team"
        if tag == 'div' and attrs == [('class', 'team')]:
            self._grab_this = True
        #raises flag if tag is table data and class = "final score"
        if tag == 'td' and attrs == [('class', 'final score')]:
            self._grab_this = True

    def handle_data(self, text):
        """
        Checks to see if the flag is raised, if it is appends the text to the
        newest list in game_list and lowers flag
        """
        if self._grab_this:
            self.game_list[-1].append(text.strip())
            self._grab_this = False

def main(html):
    """
    uses urlopen() to open html link from the command line so I wouldn't have
    to download the file. Creates a Scraper object and .feed()s it the doc.
    sets game_list = parser.game_list just so I would'nt have to type
    parser.game_list over and over in the print statement. Prints out
    scores in correct format.
    """
    response = urlopen(html)
    doc = response.read().decode()
    parser = Scraper()
    parser.feed(doc)

    game_list = parser.game_list

    for i in range(len(game_list)):
        print(game_list[i][1],game_list[i][2]+",",game_list[i][3],game_list[i][4])
    
if __name__ == "__main__":
    main(argv[1])
