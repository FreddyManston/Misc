class FirstClass:
	# The attributes
	age = 0	# Default value
	name = "Mrs. Jones"	# Default name

def main():
	me = FirstClass()	# An object of MyClass
	me.name = "Drapes"	# Overwrite default name
	me.age = 21		# Overwrite default age

	friend = FirstClass()
	friend.name = "Kailen"
	friend.age = 20

	print "My name is: " + me.name + " and I am " + str(me.age) + " y/o."
	print "My friend's name is: " + friend.name + " and he is " + str(friend.age) + " y/o."

if __name__ == "__main__":
	main()
