#Name: Trippy Squares
#Details: Contains functions to make a Polyspiral and a Square Pinwheel, of whatever length
#Copywright 2014 Manston inc.

import turtle

def make_square(length):
	
	Greg.pencolor('green')
	for i in range(5):				#}
		if (i == 0 or i == 4):			#}
			Greg.forward(length/2)		#}
			Greg.left(90)			#} Creates a square with sides that are all tangent to the circle.
		else:					#}
			Greg.forward(length)		#}
			Greg.left(90)			#}
	Greg.right(90)				

def make_many_square(length, complexity):		
							
	Greg.circle(length/2) #Makes a circle		
	make_square(length)				
	
	for i in range(360//complexity + 1):	#}
		Greg.pencolor('red')		#}
		#Greg.penup()			#}
		Greg.setposition (0, 0)		#}
		Greg.sety(length/2)		#} 
		Greg.right(90-complexity)	#} Repeats the make_square function, to make squares around the circle.
		#Greg.pendown()			#}	
		Greg.forward(length/2)		#}
		Greg.left(90)			#}
		make_square(length)		#}


def vortex(length):
	
	i = 2

	while (i != length**2):
		Greg.forward(i)
		Greg.right(91)
		i += 1

def goaway():
	window.bye()


Greg = turtle.Turtle()
Greg.pencolor('green')
Greg.shape('classic')
Greg.speed(0)
Greg.pensize(0)

window = turtle.Screen()
window.title('Square Me Silly.')
window.bgcolor('black')


#make_many_square (1000, 12)
vortex (300)

window.onkey (goaway, 'q')
window.listen()
window.mainloop()
