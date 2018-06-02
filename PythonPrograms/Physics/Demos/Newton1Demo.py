from __future__ import division
from visual import *
from visual.graph import *

print """
Aaron Titus Fall 2009
Use this program to demonstrate Newton's first law.
Use the keyboard's arrow keys to fire thrusters in
the +x, -x, +y, and -y directions, respectively.

If you simultaneously press the shift key and an arrow key,
two thrusters on opposite sides will fire simultaneously.
"""

h = w = 800
scene.width = w
scene.height = h
scene.x = scene.y = 0
wide = 1.
scene.fov = 0.001
scene.range = wide
a = 0.1*wide
spaceship=box(pos=vector(0,0,0), size=(a,a,a), color=color.cyan)

trail = curve(color=spaceship.color)

m=1
v=vector(0,0,0)
p=m*v
F=2
Fnet=vector(0,0,0)
Fleft=vector(0,0,0)
Fright=vector(0,0,0)
Fup=vector(0,0,0)
Fdown=vector(0,0,0)

scale=0.1
arrowColor=color.yellow
arrowWidth=a/2
leftarrow=arrow(pos=spaceship.pos-vector(a,0,0)/2, axis=scale*Fleft, color=arrowColor, shaftwidth=arrowWidth)
rightarrow=arrow(pos=spaceship.pos+vector(a,0,0)/2, axis=scale*Fright, color=arrowColor, shaftwidth=arrowWidth)
uparrow=arrow(pos=spaceship.pos+vector(0,a,0)/2, axis=scale*Fup, color=arrowColor, shaftwidth=arrowWidth)
downarrow=arrow(pos=spaceship.pos-vector(0,a,0)/2, axis=scale*Fdown, color=arrowColor, shaftwidth=arrowWidth)

graphWidth = 400
graphHeight = 400
vxgraph=gdisplay(x=w,y=0,width=graphWidth, height=graphHeight,
			title='v_x vs t',
			xtitle='t (s)',
			ytitle='v_x (m/s)',
			background=color.black)
			
function=gcurve(color=color.yellow)

vygraph=gdisplay(x=w,y=graphHeight,width=graphWidth, height=graphHeight,
			title='v_y vs t',
			xtitle='t (s)',
			ytitle='v_y (m/s)',
			background=color.black)
			
function2=gcurve(color=color.cyan)


dt=0.01
t=0
r=vector(0,0,0)

while 1:
    rate(50)
    if scene.kb.keys:
        s = scene.kb.getkey()
        if(s=="left"):
            Fleft=vector(-F,0,0)
        if(s=="right"):
            Fright=vector(F,0,0)
        if(s=="up"):
            Fup=vector(0,F,0)
        if(s=="down"):
            Fdown=vector(0,-F,0)
        if(s=="shift+left" or s =="shift+right"):
            Fleft=vector(-F,0,0)
            Fright=vector(F,0,0)
        if(s=="shift+up" or s =="shift+down"):
            Fup=vector(0,F,0)
            Fdown=vector(0,-F,0)


    Fnet=Fleft+Fright+Fup+Fdown
    p=p+Fnet*dt
    v=p/m
    spaceship.pos = spaceship.pos + v*dt
    r = r + v*dt

    t=t+dt

    trail.append(pos=spaceship.pos)

    leftarrow.axis=scale*Fleft
    leftarrow.pos=spaceship.pos-vector(a,0,0)/2
    rightarrow.axis=scale*Fright
    rightarrow.pos=spaceship.pos+vector(a,0,0)/2
    uparrow.axis=scale*Fup
    uparrow.pos=spaceship.pos+vector(0,a,0)/2
    downarrow.axis=scale*Fdown
    downarrow.pos=spaceship.pos-vector(0,a,0)/2

    Fleft=vector(0,0,0)
    Fright=vector(0,0,0)
    Fup=vector(0,0,0)
    Fdown=vector(0,0,0)

    if not (-wide <= spaceship.pos.x <= wide):
        trail.visible = 0
        trail = curve(color=spaceship.color)
        if p.x > 0:
            spaceship.pos.x = -wide
        else:
            spaceship.pos.x = wide
    if not (-wide <= spaceship.pos.y <= wide):
        trail.visible = 0
        trail = curve(color=spaceship.color)
        if p.y > 0:
            spaceship.pos.y = -wide
        else:
            spaceship.pos.y = wide

    function.plot(pos=(t,v.x))
    function2.plot(pos=(t,v.y))


