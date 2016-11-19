## This is a simple Hello, World program that uses a dictionary to
## speak different languages. After the argument from the command line
## is passed to the main function, it is used as a key and then it prints out
## Hello, World in the specified language.

##Author: Charlie Quinn

from sys import argv

def main(language):
    """
    Main function designed to take a language and print out
    "Hello, World" if the language is in the dictionary
    """
    di = {'Spanish': "Hola, Mundo", 'German' : "Hallo, Welt", 'French' : "Bounjour, le Monde","Japanese" : "こんにちは世界"}
    if language in di:
        print(di[language])
    else:
        print("I'm sorry, I don't speak " + language + " yet.")

if __name__ == '__main__':
    #get args from argv
    #call the top level function
    #default case
    """
    prints out Hello, World in English if there is no user input
    """
    if len(argv) == 1:
        print('Hello World')
    else:
        main(argv[1])
