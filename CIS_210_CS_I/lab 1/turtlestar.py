import turtle


#turtle.setx(150)

turtle.bgcolor(0,0,0)

turtle.color('yellow')



#turtle.fill(True)

def web(size):
    for i in range (5):
        turtle.left(72)
        for i in range (5):
            turtle.forward(size)
            turtle.right(144)
        turtle.right(144)
        for i in range (5):
            turtle.forward(size)
            turtle.left(144)

web(100)
        
turtle.left(36)

web(200)

turtle.left(36)

web(300)

turtle.left(36)

web(400)

