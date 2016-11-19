# Element class
# CIS 211
# Winter 2015

class Element:
	"""
	An instance of the Element class contains information about one element
	from the periodic table.
	"""
	def __init__(self, name, sym, atno, atwt):
		"Create a new Element object with a specified name, symbol, atomic number, and atomic weight."
		self._name = name
		self._sym = sym
		self._atno = atno
		self._atwt = atwt
		
	def __repr__(self):
		"Represent an element by the symbol used in the periodic table."
		return self._sym
		
	def name(self):
		"Return the name of this element."
		return self._name
		
	def sym(self):
		"Return the symbol (one- or two-letter string) for this element."
		return self._sym
		
	def atno(self):
		"Return the atomic number of this element."
		return self._atno
		
	def atwt(self):
		"Return the atomic weight of this element."
		return self._atwt

def load_elements(fn):
	"""
	Return a dictionary of elements created by reading descriptions from the file fn.
	The file should be in CSV format, one element per line, where each line has the
	element name, symbol, number, and weight, in that order.
	"""
	res = { }
	for line in open(fn):
		name, sym, atno, atwt = line.strip().split(',')
		res[sym] = Element(name, sym, int(atno), float(atwt))
	return res
