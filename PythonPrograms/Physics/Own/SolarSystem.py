# Author: Joshua J. Abraham
# Date: 22 Aug 2015
# Description: 

from visual import *
from math import *
# Initialise the Sun:
sun = sphere(pos=(0,0,0), radius=0.3, color=color.yellow, material=materials.emissive)

# Initialise the Earth:
earth = sphere(pos=(0.5,0.5,0.5), radius=0.1, material=materials.earth)
#earth.rotate(angle=pi/4, axis=(0,0,0), origin=(0.5, 0.5, 0.5))

# Initialise the Jupiter:
jupiter = sphere(pos=(1,1,1), radius=0.2, color=color.orange, material=materials.rough)