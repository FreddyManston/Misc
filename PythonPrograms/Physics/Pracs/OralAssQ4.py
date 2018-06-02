init_speed = 95.0	# for both trains [km/h]
init_dist = 8.5		# [km]

# Since they're travelling at the same speed, they will have covered the same distance
#  when they meet, i.e. init_dist / 2
time = (init_dist * 0.5) / init_speed	# time = dist/vel
print ("%f seconds") % (time)
