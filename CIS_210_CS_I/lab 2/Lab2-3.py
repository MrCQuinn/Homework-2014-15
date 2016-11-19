# by Charlie Quinn
# Lab2-1.py

import turtle


turtle.left(60)


def draw_triangle(size):

    ''' draws a triangle pretty cool stuff, needs to be given a number for how long each side is. Turtle is left in same direction'''
    for i in range (3):
        turtle.forward(size)
        turtle.right(120)
 #   turtle.forward(size)


draw_triangle(30)

x = 40

draw_triangle(x)

draw_triangle(x + 20)

turtle.forward(60)

length=70
for i in range (8):
    draw_triangle(length)
    length = length +15
    
    
    
