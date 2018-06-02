# Name: Joshua Abraham
# Student No: 3475896
# Date: 05/08/2015
# Description: 

from visual import *
from visual.graph import *

# Get the x and y distance:
height = input("Type in the max height: ")
x_dist = input("Type in the max x-distance")

# Getting the initial x and y velocities (using energy equations):
vel_y = (2 * 9.8 * height) ** 0.5
time = 2 * (vel_y / 9.8)	# Time of the total motion
vel_x = (x_dist - 0.5 * 9.8 * (time)**2) /time

# Initialise the ball:
ball = sphere(pos = (-3,0.15,3), radius = 0.15, color = color.red, make_trail = True)

# Initialise the grass and the building:
grass = box(pos = (0,0,0), size = (7, 0.05, 10), color = color.green)
building = box(pos = (0,2,1.8), size = (1,4,4), color = color.white)

# Doing the drop:
t = 0
dt = 0.01
gravity = 9.8
vx = 5	# Initial velocity in the x direction (i.e. throwing velocity)
finished = False

while not (t == time):
	rate(30)
	
	t = t + dt	# Incrementing the time
	
	ball.pos.y = vel_y * t -0.5 * gravity * t**2
	ball.pos.x = (vx * t)
	
	if (ball.pos.y + 1.85 < 0):
		finished = True
