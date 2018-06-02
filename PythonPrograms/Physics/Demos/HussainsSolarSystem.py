from visual import *
import time

class solor_system:
 
    def __init__(self):
        scene.width=1000
        scene.height=800
        scene.autoscale=0
        scene.range=(100,100,100)
        scene.center=(0,0,0)
       
        self.sun = sphere(pos=(0,0,0), radius=6, color=color.red,material=materials.emissive)
        lamp = local_light(pos=(0,0,0), color=color.orange)

        self.mercury = sphere(pos=(0,0,0), radius=1, color=color.green)
        self.venus = sphere(pos=(0,0,0), radius=1.5, color=color.blue)
        self.earth = sphere(pos=(0,0,0), radius=2, color=color.yellow,material=materials.earth)
        self.mars = sphere(pos=(0,0,0), radius=2.5, color=color.orange)
        self.jupiter = sphere(pos=(0,0,0), radius=3, color=color.cyan)
        self.saturn = sphere(pos=(0,0,0), radius=3.5, color=color.magenta)
        self.uranus = sphere(pos=(0,0,0), radius=4, color=color.white)
        self.neptune = sphere(pos=(0,0,0), radius=4.5, color=color.blue)
        self.pluto = sphere(pos=(0,0,0), radius=5, color=color.cyan)
       
        self.mercury_angle = 0
        self.venus_angle = 0
        self.earth_angle = 0
        self.mars_angle = 0
        self.jupiter_angle = 0
        self.saturn_angle = 0
        self.uranus_angle = 0
        self.neptune_angle = 0
        self.pluto_angle = 0
       
    def create_orbit(self):
       
        self.mercury.trail = curve(color=color.white)
        self.venus.trail = curve(color=color.white)
        self.earth.trail = curve(color=color.white)
        self.mars.trail = curve(color=color.white)
        self.jupiter.trail = curve(color=color.white)
        self.saturn.trail = curve(color=color.white)
        self.uranus.trail = curve(color=color.white)
        self.neptune.trail = curve(color=color.white)
        self.pluto.trail = curve(color=color.white)

    def draw_ellipse(self,x, y, a, b, angle, steps,ball,i):
        if steps == None:
            steps = 36
            # Angle is given by Degree Value
        beta = -angle * (math.pi / 180); #(Math.pi/180) converts Degree Value into Radians
        sinbeta = math.sin(beta);
        cosbeta = math.cos(beta)
        
        time.sleep(0.01)
        alpha = i * (math.pi / 180)
        sinalpha = math.sin(alpha)
        cosalpha = math.cos(alpha)
       
        X = x + (a * cosalpha * cosbeta - b * sinalpha * sinbeta)
        Y = y + (a * cosalpha * sinbeta + b * sinalpha * cosbeta)
        
        ball.x=(X)
        ball.y=(Y)
               
        
        ball.trail.append(pos=ball.pos)
       

    def main(self):
        self.create_orbit()
        while True:
            self.draw_ellipse(0,0,20,10,0,None,self.mercury, self.mercury_angle)
            self.mercury_angle = (self.mercury_angle + 5) % 360
            self.draw_ellipse(0,0,25,15,0,None,self.venus, self.venus_angle)
            self.venus_angle = (self.venus_angle + 4.5) % 360
            self.draw_ellipse(0,0,30,20,0,None,self.earth,self.earth_angle)
            self.earth_angle = (self.earth_angle + 4) % 360
            self.draw_ellipse(0,0,35,25,0,None,self.mars,self.mars_angle)
            self.mars_angle = (self.mars_angle + 3.5) % 360
            self.draw_ellipse(0,0,40,30,0,None,self.jupiter,self.jupiter_angle)
            self.jupiter_angle = (self.jupiter_angle + 3) % 360
            self.draw_ellipse(0,0,47,37,0,None,self.saturn,self.saturn_angle)
            self.saturn_angle = (self.saturn_angle + 2.5) % 360
            self.draw_ellipse(0,0,55,45,0,None,self.uranus,self.uranus_angle)
            self.uranus_angle = (self.uranus_angle + 2) % 360
            self.draw_ellipse(0,0,65,55,0,None,self.neptune,self.neptune_angle)
            self.neptune_angle = (self.neptune_angle + 1.5) % 360
            self.draw_ellipse(0,0,80,70,0,None,self.pluto,self.pluto_angle)
            self.pluto_angle = (self.pluto_angle + 1) % 360


if __name__=='__main__':
    ss=solor_system()
    ss.main()
