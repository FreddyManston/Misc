N = 11
K = 5
clock = [0] * N
for i in range(1, N + 1):
    clock [i - 1] = i

fish = 0
kills = []
while (len(clock) > 1):
        fish += K
	if (fish < len(clock)):
	    kills.append(fish)
	else:
	    fish -= K
	    rev_kills = kills[::-1]
	    for elem in rev_kills:
	        clock.pop(elem - 1)
	    fish = (fish - len(kills))
	    fish = ((fish + K) % len(clock)) - K
	    kills = []

print(clock[0])
