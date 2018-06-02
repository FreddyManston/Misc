# Notes:
# Polymorphism: when you override a method in a subclass that's been inherited from the super class
# Multiple Inheritance: possible to inherit from more than one super classes, however, care must be taken when the super classes contain the same attribute/method name

class Pet:
	def __init__(self, name, age):
		self.name = name
		self.age = age
	
	def talk(self):
		return "Generic animal sound"
		#raise NotImplementedError("Subclass must implement abstract method")

# Doggo is a subclass of the super class Pet
class Doggo(Pet):
	def __init__(self, name, age):
		Pet.__init__(self, name, age)	# Inherit __init__ method from Pet class
	# Override talk function in super class (i.e. polymorphism)
	def talk(self):
		return "Wooof"

class Cat(Pet):
	def __init__(self, name, age):
		Pet.__init__(self, name, age)	# Inherit __init__ method from Pet class

	# Override talk function in super class (i.e. polymorphism)
	def talk(self):
		return "Meoow"

def main():
	thePet = Pet('Pet', 1)
	dog = Doggo('Jack', 3)
	
	# isinstance(object, type) checks if object is an instance of class type
	print "is " + dog.name + " a dog? " + str(isinstance(dog, Doggo))
	print "is " + dog.name + " a pet? " + str(isinstance(dog, Pet))
	print "is " + thePet.name + " a dog? " + str(isinstance(thePet, Doggo))
	print "is " + thePet.name + " a pet? " + str(isinstance(thePet, Pet))
	
	pets = [Cat('Kittzo', 3), dog, Cat("Jacob", 6), thePet]

	for pet in pets:
		print "Name: " + pet.name + ", Age: " + str(pet.age) + ", Sound: " + pet.talk()

if __name__ == "__main__":
	main()
