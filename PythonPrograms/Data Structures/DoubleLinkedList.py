import sys 

class Node:
	data = None
	next_node = None
	prev_node = None

	def __init__(self, data=None):
		self.data = data

	def getData(self):
		return self.data

	def getNext(self):
		return self.next_node

	def getPrev(self):
		return self.prev_node

	# set functions should only be used in DoubleLinkedList class' methods, to maintain prev_node attribute correctly
	def setNext(self, new_next):
		self.next_node = new_next

	def setPrev(self, new_prev):
		self.prev_node = new_prev

class DoubleLinkedList:
	def __init__(self, head=None):
		self.head = head
	
	# Builds list from left to right. Makes next link and previous link connection where applicable
	def insert(self, data):
		new_node = Node(data)
		if self.head is None:
			self.head = new_node
		else:
			current = self.head
			while current.getNext():
				current = current.getNext()
			current.setNext(new_node)
			current.getNext().setPrev(current)

	def size(self):
		current = self.head
		count = 0
		while current:
			count += 1
			current = current.getNext()

		return count

	def search(self, data):
		current = self.head
		found = False
		while current and found is False:
			if current.getData() == data:
				found = True
			else:
				current = current.getNext()

		return found

	# Implements it's own search so that list is traversed once intsead of twice
	def delete(self, data):
		current = self.head
		while current:
			if current.getData() == data:
				break
			else:
				current = current.getNext()
		if current is None:
			print "Error: Can't delete data that isn't there."
		else:
			# i.e. delete head node
			if current.getPrev() is None:
				self.head = current.getNext()
				if self.head is not None:
					self.head.setPrev(None)
			# i.e. delete last node
			elif current.getNext() is None:
				current.getPrev().setNext(None)
			# i.e. delete a middle node
			else:
				current.getPrev().setNext(current.getNext())
				current.getNext().setPrev(current.getPrev())

	def __str__(self):
		current = self.head
		while current:
			sys.stdout.write (str(current.getData()) + ' ')	# Caters for no new line character
			current = current.getNext()
		sys.stdout.flush()
		return ''

def main():
	list1 = DoubleLinkedList()
	list1.insert(9)
	list1.insert(10)
	list1.insert(11)
	list1.insert(12)
	print list1

	print list1.head.getData()

	print list1.size()

	print list1.search(9)

	list1.delete(11)
	print list1.size()
	print list1.head.getData()

	print list1

if __name__ == '__main__':
	main()