import turtle

turtle.setup(400,500)
wn = turtle.Screen()
wn.title("Handling keypresses!")
wn.bgcolor("purple")
barry = turtle.Turtle()

def h1():
	barry.forward(30)

def h2():
	barry.left(45)

def h3():
	barry.right(45)

def h4():
	wn.bye()

wn.onkey(h1, "Up")
wn.onkey(h2, "Left")
wn.onkey(h3, "Right")
wn.onkey(h4, "q")

wn.listen()
wn.mainloop()
