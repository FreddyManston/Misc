from visual.graph import *

T = 25.0	# Initial temp. [degrees Celcius]
F = 10.0	# Ambient temp. [degrees Celcius]
K = 0.05	# Conduction coefficient
dt = 0.1	# Time increments
time = 0.0
graph = gcurve(color=color.blue)

while T > 15:
	graph.plot(pos=(time, T))
	T = T - (K * dt * F * T)
	time += dt
