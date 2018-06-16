#!/usr/bin/python
#------------------------------------------------------------------------
#
#    Pokemon Walker (a Snake and Pokemon clone mix)
#
#    Pokemon Walker is free software: you can redistribute it and/or modify
#    it under the terms of the GNU General Public License as published by
#    the Free Software Foundation, either version 3 of the License, or
#    (at your option) any later version.
#
#    Pokemon Walker is distributed in the hope that it will be useful,
#    but WITHOUT ANY WARRANTY; without even the implied warranty of
#    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
#    GNU General Public License for more details.
#
#    You should have received a copy of the GNU General Public License
#    along with Ardentryst.  If not, see <http://www.gnu.org/licenses/>.
#
#    Copyright 2015 Joshua Abraham (joshuasl8a@gmail.com)
#
#------------------------------------------------------------------------
import pygame
from pygame.locals import * # imports K_ESCAPE, K_a, etc. global names to identify event.key values

SPRITESUP     = 'up/'
SPRITESDOWN  = 'down/'
SPRITESLEFT   = 'left/'
SPRITESRIGHT  = 'right/'
SPRITESMOVEUP     = 'up/frame2/'
SPRITESMOVEDOWN  = 'down/frame2/'
SPRITESMOVELEFT   = 'left/frame2/'
SPRITESMOVERIGHT  = 'right/frame2/'

IMAGESDICT = {'logo': pygame.image.load('logo.png'),
              'icon': pygame.image.load('gen1Icons/002venosaur.png'),
              'grass1': pygame.image.load('floors/Grass1.png'),
              'grass2': pygame.image.load('floors/Grass2.png'),
              'grass3': pygame.image.load('floors/Grass4.png'),
              'grass4': pygame.image.load('floors/Grass3.png'),
              'grass5': pygame.image.load('floors/Grass5.png'),
              'flower': pygame.image.load('floors/Flower.png')}

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

SPRITEWIDTH = 32 #Pixel widht of the sprites being used
SPRITEHEIGHT = 32 # Pixel height of the sprites being used
WINWIDTH = SPRITEWIDTH * 20  # Width of the window in pixels. Allows for 21 movements from far left to far right. Make sure to be even.
WINHEIGHT = SPRITEHEIGHT * 16  # Height of the windows in pixels. Allows for 17 movements from top to bottom. Make sure to be even.
	
def main():
	
	#MOVERATE: Percentage of the full speed at which the Sprite will move.
	#FPS:Frames per second
	global SURFACE, MOVERATE, FPS, SPRITEPOS, SPRITENo, poke_map, MOVEUP, MOVEDOWN, MOVERIGHT, MOVELEFT, UPMOTION, DOWNMOTION, RIGHTMOTION, LEFTMOTION
	
	SPRITENo = str(input("Character from 1-493: ")) # Index of the desired sprite in lists SPRITESUP, SPRITESDOWN, SPRITESLEFT, etc.
	SPRITEPOS = [0, 0] #[WINWIDTH / 2, WINHEIGHT / 2] # Pixel position of the sprite.
	SPRITE = SPRITESDOWN + SPRITENo + '.png' # Sprite to use: Sprites consist of diff. characters facing diff. directions
	MOVERATE = 20
	FPS = 30

	pygame.init()
	poke_map = pygame.image.load("maps/CeladonCity.png") # File path to a map
	pygame.display.set_icon(IMAGESDICT['icon']) # Set the windows icon to be poke_icon
	SURFACE = pygame.display.set_mode((WINWIDTH, WINHEIGHT))
	pygame.display.set_caption("Pokemon Walker")
	pygame.key.set_repeat(150, 20) # .set_repeat(delay, interval) generates multiple pygame.KEYDOWN events. First event, after initial,
	                             # is generated after key has been pressed down for 'delay' amount of milliseconds. The rest are
	                             # generated every 'interval' amount of milliseconds.
	startMenu()	
	readMapFile("PokeWalkerLevels.txt")

	FRAMES = 0

	while True:
		#FRAMES = (FRAMES + 1) % FPS
		#if (FRAMES == 0):
			# Allows track keeping of whether a sprite's position should be changed :
			MOVEUP = False
			MOVEDOWN = False
			MOVERIGHT = False
			MOVELEFT = False
			# Allows for walking motion without changing sprite's position, e.g. incase of walking into a wall :
			UPMOTION = False
			DOWNMOTION = False
			RIGHTMOTION = False
			LEFTMOTION = False
			
			event = pygame.event.poll()
			
			if event.type == pygame.QUIT:
				break
			elif event.type == pygame.MOUSEBUTTONDOWN:	# Check if mouse button was clicked.
				posn_of_click = event.dict["pos"]	# Get the coordinates of the click from dictionary using key 'pos'	
				print posn_of_click
			elif event.type == pygame.KEYDOWN:
				if event.key == K_ESCAPE:  # event.key global name of ESC button down event
					break 
				elif event.key == K_e: # event.key global name of E button down event
					if canEvolve(SPRITENo): # If the sprite can evolve, then evolve it.
						direction = getDirection(SPRITE) # Current direction sprite is facing.
						SPRITENo = evolve(SPRITENo) # NationalDex number of evolved sprite.
						SPRITE = direction + SPRITENo + '.png' # File path to new 
				elif event.key == K_f: # event.key global name of F button down event
					print pygame.display.list_modes(32, pygame.FULLSCREEN)
					print "FULL"
					pygame.display.toggle_fullscreen # Not working?
					print "SCREEN"
					print pygame.FULLSCREEN
				elif event.key == K_n: # event.key global name of N button down event
					direction = getDirection(SPRITE) # Current direction sprite is facing.
					SPRITENo = evolve(SPRITENo) # NationalDex number of evolved sprite.
					SPRITE = direction + SPRITENo + '.png' # File path to new sprite.
				elif event.key == K_p: # event.key global name of P button down event
					direction = getDirection(SPRITE) # Current direction sprite is facing.
					SPRITENo = deevolve(SPRITENo) # NationalDex number of evolved sprite.
					SPRITE = direction + SPRITENo + '.png' # File path to new sprite.
				elif event.key == K_w or event.key == K_UP: # event.key global name of W, UP button down event
					if canMove("up", SPRITEPOS [1]):
						MOVEUP = True
					else:
						UPMOTION = True
					moveSprite()
				elif event.key == K_s or event.key == K_DOWN: # event.key global name of S, DOWN button down event
					if canMove("down", SPRITEPOS [1]):
						MOVEDOWN = True
					else:
						DOWNMOTION = True
					moveSprite()
				elif event.key == K_d or event.key == K_RIGHT: # event.key global name of D, RIGHT button down event
					if canMove("right", SPRITEPOS [0]):
						MOVERIGHT = True
					else:
						RIGHTMOTION = True
					moveSprite()
				elif event.key == K_a or event.key == K_LEFT: # event.key global name of A, LEFT button down event
					if canMove("left", SPRITEPOS [0]):
						MOVELEFT = True
					else:
						LEFTMOTION = True
					moveSprite()
			
			SURFACE.fill( BRIGHTBLUE )
			SURFACE.blit( poke_map, (0, 0) )
			SURFACE.blit( pygame.image.load(SPRITE), SPRITEPOS )	
			pygame.display.flip()
	
	pygame.quit()


def startMenu():

	top_coord = 24 # y value of where to position the top of the text

	logo = IMAGESDICT['logo']
	logo_rect = logo.get_rect()
	logo_rect.top = top_coord
	logo_rect.centerx = WINWIDTH / 2 # x value of where to center the text
	top_coord += logo_rect.height

	SURFACE.fill( BRIGHTBLUE )
	SURFACE.blit( logo, logo_rect )	

	#pygame.display.set_caption("Pokemon Walker")
	keep_calm_and_carry_on = False

	while True:
		event = pygame.event.poll()

		if event.type == pygame.QUIT:
			break
		elif event.type == pygame.MOUSEBUTTONDOWN:	# Check if mouse button was clicked.
			posn_of_click = event.dict["pos"]	# Get the coordinates of the click from dictionary using key 'pos'	
			print posn_of_click
		elif event.type == pygame.KEYDOWN:
			if event.key == K_ESCAPE:
				break 
			elif event.key == 13: # event.key value of ENTER button
				keep_calm_and_carry_on = True
				break
		
		pygame.display.update()

	if keep_calm_and_carry_on:
		return
	else:
		pygame.quit()
		sys.exit()


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


def canEvolve (pokedex_no):
#Check evolution of these: 25,35,37,39,43,48,58,60,64,67,70,75,79,90,93,95,108,111,114,123,125,126,133
	# A list of pokemon (by national dex number) who evolve into a pokemon with a national dex
	# number of plus one, e.g. Charmander - Charmeleon - Charizard
	DIRECTEVOLVERS = [1,2,4,5,7,8,10,11,13,14,16,17,19,21,23,27,29,30,32,33,41,46,
	50,52,54,56,63,66,69,72,74,77,81,84,86,88,92,96,98,100,102,104,109,116,118,120,129,138,
	140,147,148,152,153,155,156,158,159,161,163]
	
	if (int(pokedex_no) in DIRECTEVOLVERS):
		return True
	else:
		return False


def evolve(pokedex_no):
	new_dex_no = str((int(pokedex_no) + 1) % 493)
	
	#if new_dex_no == '0':
	#	return '1'
	#else:
	return new_dex_no

def deevolve(pokedex_no):
	print pokedex_no
	new_dex_no = str((int(pokedex_no) - 1) % 493)
	
	#if new_dex_no == '0':
	#	return '493'
	#else:
	return new_dex_no

def moveSprite():
	global poke_map, SPRITEPOS, SPRITENo, MOVEUP, MOVEDOWN, MOVERIGHT, MOVELEFT, UPMOTION, DOWNMOTION, RIGHTMOTION, LEFTMOTION
	# Once either of the 4 for loops has elapsed, the sprite will have moved up/down or
	# right/left by a number of pixels equal to the sprites width or height, respectively.
	# Half way through any for loops, the sprite will be switched with a frame2 version
	# of itself (SPRITESMOVE-), to give the illusion of a walking sprite.			
	if MOVEUP or UPMOTION:
		for i in range(SPRITEHEIGHT * (100/MOVERATE)):
			if MOVEUP: # Change sprite's position iff there's no blockage
				SPRITEPOS [1] = SPRITEPOS [1] - (MOVERATE/100.0) 
			if (i < SPRITEHEIGHT * (100/MOVERATE/2) or i == SPRITEHEIGHT * (100/MOVERATE) - 1):
				SPRITE = SPRITESUP + SPRITENo + '.png'
			else:
				SPRITE = SPRITESMOVEUP + SPRITENo + '.png'
			SURFACE.fill( BRIGHTBLUE )
			SURFACE.blit( poke_map, (0, 0))
			SURFACE.blit( pygame.image.load(SPRITE), SPRITEPOS )		
			pygame.display.flip()
		pygame.event.clear() # Clear all surplus events on the event queue, allows for more controlled game play.
		MOVEUP = False
		UPMOTION = False
	elif MOVEDOWN or DOWNMOTION:
		for i in range(SPRITEHEIGHT * (100/MOVERATE)):
			if MOVEDOWN: # Change sprite's position iff there's no blockage
				SPRITEPOS [1] = SPRITEPOS [1] + (MOVERATE/100.0)
			if (i < SPRITEHEIGHT * (100/MOVERATE/2) or i == SPRITEHEIGHT * (100/MOVERATE) - 1):
				SPRITE = SPRITESDOWN + SPRITENo + '.png'
			else:
				SPRITE = SPRITESMOVEDOWN + SPRITENo + '.png'
			SURFACE.fill( BRIGHTBLUE )
			SURFACE.blit( poke_map, (0, 0))
			SURFACE.blit( pygame.image.load(SPRITE), SPRITEPOS )	
			pygame.display.flip()
		pygame.event.clear() # Clear all surplus events on the event queue, allows for more controlled game play.
		MOVEDOWN = False
		DOWNMOTION = False
	elif MOVERIGHT or RIGHTMOTION:
		for i in range(SPRITEWIDTH * (100/MOVERATE)):
			if MOVERIGHT: # Change sprite's position iff there's no blockage
				SPRITEPOS [0] = SPRITEPOS [0] + (MOVERATE/100.0)
			if (i < SPRITEWIDTH * (100/MOVERATE/2) or i == SPRITEWIDTH * (100/MOVERATE) - 1):
				SPRITE = SPRITESRIGHT + SPRITENo + '.png'
			else:
				SPRITE = SPRITESMOVERIGHT + SPRITENo + '.png'
			SURFACE.fill( BRIGHTBLUE )
			SURFACE.blit( poke_map, (0, 0))
			SURFACE.blit( pygame.image.load(SPRITE), SPRITEPOS )		
			pygame.display.flip()
		pygame.event.clear() # Clear all surplus events on the event queue, allows for more controlled game play.
		MOVERIGHT = False
		RIGHTMOTION = False
	elif MOVELEFT or LEFTMOTION:
		for i in range(SPRITEWIDTH * (100/MOVERATE)):
			if MOVELEFT: # Change sprite's position iff there's no blockage
				SPRITEPOS [0] = SPRITEPOS [0] - (MOVERATE/100.0)
			if (i < SPRITEWIDTH * (100/MOVERATE/2) or i == SPRITEWIDTH * (100/MOVERATE) - 1):
				SPRITE = SPRITESLEFT + SPRITENo + '.png'
			else:
				SPRITE = SPRITESMOVELEFT + SPRITENo + '.png'
			SURFACE.fill( BRIGHTBLUE )
			SURFACE.blit( poke_map, (0, 0))
			SURFACE.blit( pygame.image.load(SPRITE), SPRITEPOS )		
			pygame.display.flip()
		pygame.event.clear() # Clear all surplus events on the event queue, allows for more controlled game play.
		MOVELEFT = False
		LEFTMOTION = False	


def getDirection(direction_extension):
	if direction_extension [0:1] == 'u':
		return SPRITESUP
	elif direction_extension [0:1] == 'd':
		return SPRITESDOWN
	elif direction_extension [0:1] == 'r':
		return SPRITESRIGHT
	else:
		return SPRITESLEFT

def readMapFile(filename):				
	assert os.path.exists(filename), 'Cannot find the level file: %s' % (filename)
	mapFile = open(filename, 'r')
	# Each level must end with a blank line
	content = mapFile.readlines() + ['\r\n']
	mapFile.close()

	levels = [] # Will contain a list of level objects.
	levelNum = 0
	mapTextLines = [] # contains the lines for a single level's map.
	mapObj = [] # the map object made from the data in mapTextLines
	for lineNum in range(len(content)):
		# Process each line that was in the level file.
		line = content[lineNum].rstrip('\r\n')

		if ';' in line:
			# Ignore the ; lines, they're comments in the level file.
			line = line[:line.find(';')]

		if line != '':
			# This line is part of the map.
			mapTextLines.append(line)
		elif line == '' and len(mapTextLines) > 0:
			# A blank line indicates the end of a level's map in the file.
			# Convert the text in mapTextLines into a level object.

			# Find the longest row in the map.
			maxWidth = -1
			for i in range(len(mapTextLines)):
				if len(mapTextLines[i]) > maxWidth:
					maxWidth = len(mapTextLines[i])
			# Add spaces to the ends of the shorter rows. This ensures the map will be rectangular.
			for i in range(len(mapTextLines)):
				mapTextLines[i] += ' ' * (maxWidth - len(mapTextLines[i]))

			# Convert mapTextLines to a map object.
			for x in range(len(mapTextLines[0])):
				mapObj.append([])
			for y in range(len(mapTextLines)):
				for x in range(maxWidth):
					mapObj[x].append(mapTextLines[y][x])

			# Loop through the spaces in the map and find the @, ., and $ characters for the starting game state.
			startx = None # The x and y for the player's starting position
			starty = None
			goals = [] # list of (x, y) tuples for each goal.
			stars = [] # list of (x, y) for each star's starting position.
			for x in range(maxWidth):
				for y in range(len(mapObj[x])):
					if mapObj[x][y] in ('@', '+'): # '@' is player, '+' is player & goal
						startx = x
						starty = y
					if mapObj[x][y] in ('.', '+', '*'): # '.' is goal, '*' is star & goal
						goals.append((x, y))
					if mapObj[x][y] in ('$', '*'): # '$' is star
						stars.append((x, y))

		# Basic level design sanity checks:
		assert startx != None and starty != None, 'Level %s (around line %s) in %s is missing a "@" or "+" to mark the start point.' % (levelNum+1, lineNum, filename)
		assert len(goals) > 0, 'Level %s (around line %s) in %s must have at least one goal.' % (levelNum+1, lineNum, filename)
		assert len(stars) >= len(goals), 'Level %s (around line %s) in %s is impossible to solve. It has %s goals but only %s stars.' % (levelNum+1, lineNum, filename, len(goals), len(stars))

		# Create level object and starting game state object.
		gameStateObj = {'player': (startx, starty),
			       'stepCounter': 0,
			       'stars': stars}
		levelObj = {'width': maxWidth,
                          'height': len(mapObj),
                          'mapObj': mapObj,
                          'goals': goals,
                          'startState': gameStateObj}

		levels.append(levelObj)

		# Reset the variables for reading the next map.
		mapTextLines = []
		mapObj = []
		gameStateObj = {}
		levelNum += 1
	return levels
	
main()
