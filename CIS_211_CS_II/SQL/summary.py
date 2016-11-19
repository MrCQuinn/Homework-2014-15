#Prints a report showing the monthly bill for a customer at the Sakila DVD Store
#Author: Charlie Quinn
from sys import argv
import sqlite3
import datetime as dt
from datetime import datetime

def is_late(rent_date,return_date):
    """
    computes whether the film is late or not by utilizing
    pythons datetime library
    """
    date_format = "%Y-%m-%d %H:%M:%S.%f"
    rented = datetime.strptime(rent_date, date_format)
    returned = datetime.strptime(return_date, date_format)
    diff = returned - rented
    if diff.days >= 0:
        return True
    else:
        return False
    
def fixed_width(item, width, pad_char):
    """
    used for padding, taken from previous assignment in CIS210
    """
    n = len(item)
    pad_len = width - n
    fixed_width_item = item + (pad_len * pad_char)
    return fixed_width_item

def main(last,year,month):
    """
    Using sqlite3, selects information from a database
    and uses the information to summarize a customer's
    monthly report for his/her rental history. 
    """
    db = sqlite3.connect('sakila211.db')
    cur = db.cursor()
    cur.execute('SELECT first_name FROM customer WHERE last_name = ?',(last,))    
    first = cur.fetchone()
    first = first[0]
    print("--- Sakila DVD Rentals ---")
    print("\n")
    print("Monthly report for " + first + " " + last)
    
    films = []
    month = month.zfill(2)
    for row in cur.execute("SELECT title, rental_date, return_date, rental_rate FROM film JOIN inventory USING(film_id) JOIN rental USING (inventory_id) JOIN customer USING(customer_id) WHERE last_name = ? AND strftime('%m',rental_date)=? AND strftime('%Y',rental_date)=?",(last,month,year)):
        films.append(row)
    total = 0
    for i in films:
        print(fixed_width(i[0],30,' ') +fixed_width(i[1],30," ")+"   "+ "$" + str(i[3]))
        if(is_late(i[1],i[2])):
            print("            " + fixed_width("**late fee**",51,' ') + "$" +  str(i[3]))
        total = total + i[3]
    print("Monthly total: $" + ("%.2f"%total))
        



if __name__ == '__main__':
    main(argv[1],argv[2],argv[3])
