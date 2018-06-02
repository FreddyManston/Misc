class Reverse:
	def __init__(self, data):
		self.data = data
		self.index = len(data)
	# Special python method iter() which returns iterator object of the class
	# iterator object uses next() method to get the next item.
	# for loop stops when StopIteration Exception is raised.
	def __iter__(self):
		return self

	def next(self):
		if self.index == 0:
			raise StopIteration
		self.index = self.index - 1
		return self.data[self.index]

def main():
	rev = Reverse('Drapsicle')
	for char in rev:
		print char

if __name__ =='__main__':
	main()
