import random

rng = random.Random()

dice_throw = rng.randrange(1,7)	#Returns a random int, 0 - 6 
delay_in_seconds = rng.random() * 5.0#Returns a random float, 0.0 - 4.9999999999999

cards = list(range(1, 53)) #Creates a list of numbers, [1 - 52]
rng.shuffle(cards) #Returns a shuffled version of the 'cards' list

print (dice_throw)
print (delay_in_seconds)
("\n")
print (cards)
