class Node:
	def __init__(self, data=None, next_node=None):
		self.data = data
		self.next_node = next_node

	def getData(self):
		return self.data

	def getNext(self):
		return self.next_node

	def setNext(self, new_next):
		self.next_node = new_next

class SingleLinkedList:
	def __init__(self, head=None):
		self.head = head
	
	# Makes new node the head and points it to the previous head
	def insert(self, data):
		new_node = Node(data)
		new_node.setNext(self.head)
		self.head = new_node

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
		previous = None
		found = False
		while current and found is False:
			if current.getData() == data:
				found = True
			else:
				previous = current
				current = current.getNext()
		if current is None:
			print "Error: Can't delete data that isn't there."
		elif previous is None:
			self.head = current.getNext()
		else:
			previous.setNext(current.getNext())
		
def main():
	node1 = Node(12)
	node2 = Node(11, node1)
	node3 = Node(10, node2)
	print node2.getNext().getData()

	list1 = SingleLinkedList(node3)
	print list1.size()

	print list1.search(9)

	print list1.head.getData()
	list1.delete(10)
	print list1.size()
	print list1.head.getData()

if __name__ == '__main__':
	main()