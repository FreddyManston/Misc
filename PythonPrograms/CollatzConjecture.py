x = [i for i in range(22002,99999999)]

for i in x:
	print str(i) + ": "

	while (i != 1):
		if (i % 2 == 0):
			i = i / 2
		else:
			i = 3 * i + 1
	print " true"
