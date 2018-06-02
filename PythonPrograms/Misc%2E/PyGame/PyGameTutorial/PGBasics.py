import pygame
import time

def start_up():
	""" Set up the game and run the main game loop """
	pygame.init()	# prepare the pygame module for use
	
	main_surface = pygame.display.set_mode((480, 480)) # Create surface of (width, height).
	my_text = pygame.font.SysFont("Comic Sans", 17).render("Click this block for Batman", False, (100, 0, 105)) # Setting up text to blit to main_surface.
	
	# set up some data to describe a small rectangle and its color
	small_rect = (300, 200, 150, 90)
	some_color = (255, 0, 0)	# A color is a mix of (Red, Green, Blue)

	while True:
		ev = pygame.event.poll()		# look for any event from keyboard, mouse, joystick, etc.
		
		if ev.type != pygame.NOEVENT:		#} Print all  occuring events which are
			print ev			#} recognised from the poll.
				
		if ev.type == pygame.MOUSEBUTTONDOWN:	# Check if mouse button was clicked.
			posn_of_click = ev.dict["pos"]	# Get the coordinates of the click from dictionary using key 'pos' 
		
			print posn_of_click
			
			x_coord = posn_of_click [0]	#} Split the coordinate into a 
			y_coord = posn_of_click [1]	#} x and y position

			if x_coord >= 39 and x_coord <= 189 and y_coord >= 215 and y_coord <= 275:
				showBatman()	#... start the new window

		if ev.type == pygame.QUIT:	# window close button clicked?				
			break			# Stop program

		# Completely redraw everything from scratch on each frame.
		
		main_surface.fill((0, 200, 255))			# Fill everything with the background color.	
		main_surface.fill(some_color, small_rect)		# Overpaint a smaller rectangle on the main surface.
		main_surface.fill((255, 100, 0), (40, 215, 150, 60))	# Overpaint an even smaller rectangle onto main_surface.
		main_surface.blit(my_text, (44, 240))
		# Now that everything is drawn, put it on display!
		pygame.display.flip()

	pygame.quit()	# once we leave the loop, close the window.

def showBatman():
	pygame.init()	# initialiase pygame again (prep module)
	
	main_surface = pygame.display.set_mode((600, 600))
	batman = pygame.image.load("I'm Batman.png")			# instantiate a picture of Batman.	
	my_font = pygame.font.SysFont('freesansbold.ttf', 16)			# instantiate 16 point Courier font to draw text.
	the_text = my_font.render("I'm Batman!", True, (150, 50, 150))	# .render(text phrase, smooth edges, text colour)
	count = 1
	
	while True:
		print(count)	#} A count to bring to attention how 
		count += 1	#} many times the loop has ran, during the program
		ev = pygame.event.poll()
		if ev.type == pygame.QUIT:
			frameRatesEtc()
			break

		main_surface.fill((200, 50, 100))
		main_surface.blit(batman, (-300, -130))	# insert Batman into the frame .blit(picture, (x-coord, y-coord))
		main_surface.blit(the_text, (325, 75))	# insert text into the frame .blit(text, (x-coord, y-coord))
		
		pygame.display.flip()

	pygame.quit()
	
def frameRatesEtc():
	pygame.init()
	
	main_surface = pygame.display.set_mode((400, 400))
	my_font = pygame.font.SysFont("Courier", 16)
	
	frame_count = 0
	frame_rate = 0
	t0 = time.clock()
	
	while True:
		ev = pygame.event.poll()
		if ev.type == pygame.QUIT:
			break

		# Do game logic here: Updating the frame rate every 500 frames
		frame_count += 1
		if (frame_count % 500 == 0):
			t1 = time.clock()
			frame_rate = 500 / (t1 - t0)	# Get frame rate per second
			t0 = t1
		
		# Completely redraw the surface, starting with background
		main_surface.fill((200, 0, 200))
		
		the_text = my_font.render("Frame = {0}, rate = {1:.2f} fps,".format(frame_count, frame_rate, 50, 66), True, (0,0,0))	# Make a new surface with an image of the text
		main_surface.blit(the_text, (10, 10))	# Copy the text surface to the main surface
		
		pygame.display.flip()

	pygame.quit()
	
start_up()
