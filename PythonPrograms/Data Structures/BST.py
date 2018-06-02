class DNode:
	data = None
	left = None
	right = None

	def __init__(self, new_data=None):
		self.data = new_data

	def getData(self):
		return self.data

	def getLeft(self):
		return self.left

	def getRight(self):
		return self.right

	def setData(self, new_data):
		self.data = new_data

	def setLeft(self, new_left):
		self.left = new_left

	def setRight(self, new_right):
		self.right = new_right

class BST:
	def __init__(self, new_data=None):
		self.root = DNode(new_data)

	def getRoot(self):
		return self.root

	def insert(self, data):
		put_me_in = DNode(data)
		if self.root is None:
			self.root = put_me_in
		elif self.search(data):
			print ("Data is already in tree. Duplicates are not allowed in this virtual organism.")
		else:
			parent = None
			child = self.root
			while True:
				parent = child
				if put_me_in.getData() < child.getData():
					child = child.getLeft()
					if child is None:
						parent.setLeft(put_me_in)
						break
				else:
					child = child.getRight()
					if child is None:
						parent.setRight(put_me_in)
						break

	def delete(self, start_node, data):
		if start_node is None:
			print "Can't delete something that isn't there."
		elif data < start_node.getData():
			start_node.setLeft(self.delete(start_node.getLeft(), data))
			return start_node
		elif data > start_node.getData():
			start_node.setRight(self.delete(start_node.getRight(), data))
			return start_node
		else:
			if start_node.getLeft() is None and start_node.getRight() is None:
				return None
			elif start_node.getLeft() is not None:
				return start_node.getLeft()
			elif start_node.getRight() is not None:
				return start_node.getRight()
			else:
				max_in_left = self.getMax(start_node.getLeft())
				start_node.setData(max_in_left)
				self.delete(start_node.getLeft(), max_in_left)
				return start_node


	def search(self, data):
		if self.root is None:
			return False
		else:
			parent = self.root
			while parent is not None:
				if data == parent.getData():
					return True
				elif data < parent.getData():
					parent = parent.getLeft()
				else:
					parent = parent.getRight()
			return False

	def getMin(self):
		if self.root is None:
			return None
		else:
			parent = self.root
			while parent.getLeft() is not None:
				parent = parent.getLeft()
			return parent.getData()

	def getMax(self):
		if self.root is None:
			return None
		else:
			parent = self.root
			while parent.getRight() is not None:
				parent = parent.getRight()
			return parent.getData()

	def printInOrder(self, start_node):
		if start_node.getLeft() is not None:
			self.printInOrder(start_node.getLeft())
		if start_node.getData() is not None:
			print start_node.getData()
		if start_node.getRight() is not None:
			self.printInOrder(start_node.getRight())
	"""
	def printPreOrder(self, start_node):
		print start_node.getData()
		if start_node.getLeft() is not None:
			self.printPreOrder(start_node.getLeft())
		if start_node.getRight() is not None:
			self.printPreOrder(start_node.getRight())
	"""
	def printPostOrder(self, start_node):
		if start_node.getRight() is not None:
			self.printPostOrder(start_node.getRight())
		if start_node.getData() is not None:
			print start_node.getData()
		if start_node.getLeft() is not None:
			self.printPostOrder(start_node.getLeft())

def main():
	tree = BST()

	for i in range(1, 6):
		tree.insert(i)

	tree.insert(10)
	tree.insert(9)
	tree.insert(8)
	tree.insert(7)
	tree.insert(6)
	tree.insert(12)
	tree.insert(11)
	tree.insert(14)
	tree.insert(13)
	tree.insert(15)
	tree.insert(32)
	tree.insert(90)
	tree.insert("a")
	tree.insert("novelty")
	tree.insert("Novelty")
	tree.insert("abBac")
	tree.insert("zealous")

	tree.printInOrder(tree.getRoot())
	
	print
	print

	tree.delete(tree.getRoot(), "novelty")

	tree.printInOrder(tree.getRoot())

	print tree.getMin()
	print tree.getMax()

if __name__ == "__main__":
	main()


"""
1
 2
  3
   4
    5
     6
      10
     9 12
    8 11 14
   7    13 15
            32
             90
               a
              N n
               ab z
"""