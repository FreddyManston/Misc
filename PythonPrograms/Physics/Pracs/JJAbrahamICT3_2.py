# Name: Joshua Abraham
# Student No: 3475896
# Date: 05/08/2015
# Description: Simulates a ball being thrown from the top of a building

from visual import *
from visual.graph import *

# Setting up the scene:


# Initialise the ball:
ball = sphere(pos = (1.4,2.18,3), radius = 0.15, color = color.red, make_trail = True)
ball_vel = vector(0, 2, 0)
ball_mass = 0.25

# Initialise the grass and the building:
grass = box(pos = (0,-2,0), size = (7, 0.05, 10), color = color.green)
building = box(pos = (1.8,0,1.8), size = (1,4,4), color = color.white)

# Doing the drop:
t = 0
dt = 0.01
gravity = 9.8
vx = 5	# Initial velocity in the x direction (i.e. throwing velocity)
finished = False

while not (finished):
	rate(5)

	t = t + dt	# Incrementing the time
	# position equation is: y(t) = y0 + v0 * t + 0.5 * a * t**2
	ball.pos.y = 2.18 - 0.5 * gravity * t**2
	ball.pos.x = (-vx * t) + 1.4
	
	if (ball.pos.y + 1.85 < 0):
		finished = True
		
