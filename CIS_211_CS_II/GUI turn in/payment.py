#Payment Program
#by Charlie Quinn

from tkinter import *

def FindPay():
    """
    This is the function run when the user presses the button that says "Payment"
    It reads the values in my Entry objects and uses them to compute the payment.
    Then it inserts the value rounded to two decimal places into my payment
    entry object with a read-only status
    """
    ratev = float(rate.get())
    yearsv = float(years.get())
    amountv = float(amount.get())
    r = ratev/100/12
    p = 12*yearsv
    payment.insert(0,str("{0:.2f}".format((r*amountv)/(1-(1+r)**-p))))
    payment.configure(state='readonly')

root = Tk()
#Amount label and entry
amount_label = Label(master = root, text="Loan amount:").pack()
amount = Entry(root)
amount.pack()
#Rate label and entry
rate_label = Label(master = root, text="Interest rate:").pack()
rate = Entry(root)
rate.pack()
#Years label and entry
years_label = Label(master = root, text="Number of years to repay loan:").pack()
years = Entry(root)
years.pack()

#defining payment as Entry object
payment = Entry(root)
#builds button to do dirty work
button = Button(root, text = "Payment", command = FindPay)
button.pack()
#label and display of payment
payment_label = Label(master = root, text="Payment:").pack()
payment.pack()

root.mainloop()
