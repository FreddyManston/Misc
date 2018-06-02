import pygame

SPRITESUP     = 'up/'
SPRITESDOWN  = 'down/'
SPRITESLEFT   = 'left/'
SPRITESRIGHT  = 'right/'
SPRITESMOVEUP     = 'up/frame2/'
SPRITESMOVEDOWN  = 'down/frame2/'
SPRITESMOVELEFT   = 'left/frame2/'
SPRITESMOVERIGHT  = 'right/frame2/'

SPRITEWIDTH = 32 #Pixel widht of the sprites being used
SPRITEHEIGHT = 32 # Pixel height of the sprites being used
WINWIDTH = SPRITEWIDTH * 22  # Width of the window in pixels. Allows for 20 movements from far left to far right.
WINHEIGHT = SPRITEHEIGHT * 18  # Height of the windows in pixels. Allows for 15 movements from top to bottom.

#               R    G    B
WHITE       = (255, 255, 255)
GRAY        = (185, 185, 185)
BLACK       = (  0,   0,   0)
RED         = (155,   0,   0)
LIGHTRED    = (175,  20,  20)
GREEN       = (  0, 155,   0)
LIGHTGREEN  = ( 20, 175,  20)
BLUE         = (  0,   0, 155)
LIGHTBLUE   = ( 20,  20, 175)
BRIGHTBLUE  = (  0, 170, 255)
YELLOW      = (155, 155,   0)
LIGHTYELLOW = (175, 175,  20)

def main():
	
	SPRITENo = str(input("Character from 1-493: ")) # Index of the desired sprite in lists SPRITESUP, SPRITESDOWN, SPRITESLEFT, etc.
	SPRITEPOS = [WINWIDTH / 2, WINHEIGHT / 2] # Pixel position of the sprite.
	SPRITE = SPRITESDOWN + SPRITENo + '.png' # Sprite to use: Sprites consist of diff. characters facing diff. directions
	MOVERATE = 10 # Percentage of the full speed at which the Sprite will move.
	
	pygame.init()
		
	SURFACE = pygame.display.set_mode((WINWIDTH, WINHEIGHT))
	pygame.display.set_caption("PGSpriteMovement")
	FPS = 15 # Frames per second
	FRAMES = 0
	#count = 0
	
	while True:
		FRAMES = (FRAMES + 1) % FPS
		if (FRAMES == 0):
			#count += 1
			#print count
			MOVEUP = False
			MOVEDOWN = False
			MOVELEFT = False 
			MOVERIGHT = False
			
			event = pygame.event.poll()
			
			if event.type == pygame.QUIT:
				break
			elif event.type == pygame.MOUSEBUTTONDOWN:	# Check if mouse button was clicked.
				posn_of_click = event.dict["pos"]	# Get the coordinates of the click from dictionary using key 'pos'	
				print posn_of_click
			
			elif event.type == pygame.KEYDOWN:
				if event.key == 27:  # event.key value of ESC button
					break 
				elif event.key == 273: # event.key value of UP button
					if canMove("up", SPRITEPOS [1]):
						MOVEUP = True
				elif event.key == 274: # event.key value of DOWN button
					if canMove("down", SPRITEPOS [1]):
						MOVEDOWN = True
				elif event.key == 275: # event.key value of RIGHT button
					if canMove("right", SPRITEPOS [0]):
						MOVERIGHT = True
				elif event.key == 276: # event.key value of LEFT button
					if canMove("left", SPRITEPOS [0]):
						MOVELEFT = True
						
			# Once either of the 4 for loops has elapsed, the sprite will have moved up/down or
			# right/left by a number of pixels equal to the sprites width or height, respectively.
			# Half way through any for loops, the sprite will be switched with a frame2 version
			# of itself (SPRITESMOVE-), to give the illusion of a walking sprite.			
			if MOVEUP:
				for i in range(SPRITEHEIGHT * (100/MOVERATE)):
					SPRITEPOS [1] = SPRITEPOS [1] - (MOVERATE/100.0) 
					if (i < SPRITEHEIGHT * (100/MOVERATE/2) or i == SPRITEHEIGHT * (100/MOVERATE) - 1):
						SPRITE = SPRITESUP + SPRITENo + '.png'
					else:
						SPRITE = SPRITESMOVEUP + SPRITENo + '.png'
					SURFACE.fill( BRIGHTBLUE )
					SURFACE.blit( pygame.image.load(SPRITE), SPRITEPOS )		
					pygame.display.flip()
				MOVEUP = False
			elif MOVEDOWN:
				for i in range(SPRITEHEIGHT * (100/MOVERATE)):
					SPRITEPOS [1] = SPRITEPOS [1] + (MOVERATE/100.0)
					if (i < SPRITEHEIGHT * (100/MOVERATE/2) or i == SPRITEHEIGHT * (100/MOVERATE) - 1):
						SPRITE = SPRITESDOWN + SPRITENo + '.png'
					else:
						SPRITE = SPRITESMOVEDOWN + SPRITENo + '.png'
					SURFACE.fill( BRIGHTBLUE )
					SURFACE.blit( pygame.image.load(SPRITE), SPRITEPOS )	
					pygame.display.flip()
				MOVEDOWN = False
			elif MOVERIGHT:
				for i in range(SPRITEWIDTH * (100/MOVERATE)):
					SPRITEPOS [0] = SPRITEPOS [0] + (MOVERATE/100.0)
					if (i < SPRITEWIDTH * (100/MOVERATE/2) or i == SPRITEWIDTH * (100/MOVERATE) - 1):
						SPRITE = SPRITESRIGHT + SPRITENo + '.png'
					else:
						SPRITE = SPRITESMOVERIGHT + SPRITENo + '.png'
					SURFACE.fill( BRIGHTBLUE )
					SURFACE.blit( pygame.image.load(SPRITE), SPRITEPOS )		
					pygame.display.flip()
				MOVERIGHT = False
			elif MOVELEFT:
				for i in range(SPRITEWIDTH * (100/MOVERATE)):
					SPRITEPOS [0] = SPRITEPOS [0] - (MOVERATE/100.0)
					if (i < SPRITEWIDTH * (100/MOVERATE/2) or i == SPRITEWIDTH * (100/MOVERATE) - 1):
						SPRITE = SPRITESLEFT + SPRITENo + '.png'
					else:
						SPRITE = SPRITESMOVELEFT + SPRITENo + '.png'
					SURFACE.fill( BRIGHTBLUE )
					SURFACE.blit( pygame.image.load(SPRITE), SPRITEPOS )		
					pygame.display.flip()
				MOVELEFT = False
				
			SURFACE.fill( BRIGHTBLUE )
			SURFACE.blit( pygame.image.load(SPRITE), SPRITEPOS )		
			pygame.display.flip()
				
	pygame.quit()
	
	
def canMove(direction, position):
	if direction == 'up':
		if (position - SPRITEHEIGHT >= 0):
			return True
		else:
			return False
	elif direction == 'down':
		if (position + SPRITEHEIGHT <= WINHEIGHT - SPRITEHEIGHT):
			return True
		else:
			return False
	elif direction == 'left':
		if (position - SPRITEWIDTH >= 0):
			return True
		else:
			return False
	elif direction == 'right':
		if (position + SPRITEWIDTH <= WINWIDTH - SPRITEWIDTH):
			return True
		else:
			return False

main()
