import random
import turtle

window = turtle.Screen()


Bob = turtle.Turtle()
Mary = turtle.Turtle()
Kate = turtle.Turtle()
Ashley = turtle.Turtle()

turtles = ['Bob', 'Mary', 'Kate', 'Ashley'] 

for move in range(10):
	Bob.left(random.randrange(90,180))
	Bob.forward(50)
	Mary.left(random.randrange(-180,180))
	Mary.forward(100)
	Kate.left(random.randrange(-180,180))
	Kate.forward(150)
	Ashley.left(random.randrange(-180,180))
	Ashley.forward(200)
	

window.exitonclick()
