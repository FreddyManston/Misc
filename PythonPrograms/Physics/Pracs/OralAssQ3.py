from visual import *
from visual.graph import *

acc = 9.8	# m.s^(-2)
vel = gcurve(color=color.blue)
disp = gcurve(color=color.red)
time = 0.0
dt = 0.1

while time < 5.1:
	vel.plot(pos=(time, acc * time))		# Integral of acceleration
	disp.plot(pos=(time, 0.5 * acc * (time**2)))	# Integral of velocity

	time += dt
