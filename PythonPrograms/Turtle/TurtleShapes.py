#Author: Joshua Abraham
#Name: Triangle and square
#Description: Using turtle, draws a square and a triangle with user-determined side length.

import turtle

def draw_square (edge_len):
	
	Barry.pencolor('yellow')
	Barry.shape('turtle')
	#Barry.penup()
	#Barry.setx(-edge_len)
	#Barry.pendown()
	
	for side in range(4):
		Barry.forward(edge_len)
		Barry.left(90)

	xplace = Barry.xcor()
	yplace = Barry.ycor()
	print ("x-co: ", xplace, "y-co : ", yplace)
	
	#if (xplace != 0.00 and yplace != 0.00):
		#Barry.left(90)	
	#	draw_square (edge_len)
	
def draw_triangle (edge_len):

	Chloe.pencolor('purple')
	Chloe.shape('blank')

	Chloe.backward(edge_len)
	Chloe.left(60)
	Chloe.forward(edge_len)
	Chloe.right(120)
	Chloe.forward(edge_len)
	Chloe.left(60)
			
def goaway ():
	window.bye()



window = turtle.Screen()
window.bgcolor ('grey')

Barry = turtle.Turtle() #Turtle Barry
Chloe = turtle.Turtle() #Turtle Chloe
Barry.pensize(5)
Chloe.pensize(10)
side_size = 300
draw_square ((((side_size)**2 - (side_size/2)**2)**0.5)), draw_triangle (side_size)

window.onkey (goaway, 'q')
window.listen()
window.mainloop()


