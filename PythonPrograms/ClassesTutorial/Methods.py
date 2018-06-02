import math

class Vector2D:
	x = 0.00
	y = 0.00
	
	# Special python function for initialising an object
	# Only one __init__ (i.e. constructor/initialiser function) is allowed in python
	def __init__(self, x, y):
		self.x = x
		self.y = y
	
	# Special python function for when '+' used on an object
	def __add__(self, other):
		return Vector2D(self.x + other.x, self.y + other.y)
	
	# Special python function to override '+=' when used on an object of this class
	def __iadd__(self, other):
		self.x += other.x
		self.y += other.y
		return self

	# Special python function to override '-' when used on an object of this class
	def __sub__(self, other):
		return Vector2D(self.x - other.x, self.y - other.y)

	# Special python function to override '-=' when used on an object of this class
	def __isub__(self, other):
		self.x -= other.x
		other.y -= other.y
		return self

	# Special python function to override '*' when used on an object of this class
	def __mul__(self, other):
		return Vector2D(self.x * other.x, self.y * other.y)

	# Special python function to override '*=' when used on an object of this class
	def __imul__(self, other):
		self.x *= other.x
		self.y *= other.y
		return self

	# Special python function to override '/' when used on an object of this class
	def __div__(self, other):
		return Vector2D(self.x / float(other.x), self.y / float(other.y))

	def getLength(self):
		return math.sqrt(self.x**2 + self.y**2) 

	def normalised(self):
		length = self.getLength()
		if length != 0:
			return self/Vector2D(length, length)
		return Vector2D(self)

	def getAngle(self):
		return math.degrees(math.atan2(self.y, self.x))

	# Special python function to override str() function when used on object of this class (also works on print function)
	def __str__(self):
		return "X = " + str(self.x) + ", Y = " + str(self.y)

def main():
	vec1 = Vector2D(5, 6)
	vec2 = Vector2D(2, 3)
	print vec1
	print vec2
	print

	# Method object
	tempmethod = vec1.getAngle	# Run method, but don't execute i.e. no brackets, and store it

	vec1 = vec1 + vec2
	print vec1

	vec1 += vec2
	print vec1
	print

	vec1 = vec1 * vec2
	print vec1

	vec1 *= Vector2D(2, 2)
	print vec1
	print 

	print "Length of vector " + str(vec1) + " is: " + str(vec1.getLength())
	print "The normalised vecotr of " + str(vec1) + " is: " + str(vec1.normalised())
	print "The angle vector " + str(vec1) + " makes is: " + str(vec1.getAngle())

	print "The angle was " + str(tempmethod())	# Execute stored method, thus brackets

if __name__ == "__main__":
	main()
