public class List {
	Element headElem;

	public List(int headValue) {
		this.headElem = new Element(headValue);
	}

	public void addElement(int value) {
		Element lastElement = getLastElement();
		Element newElement = new Element(value);
		lastElement.address = newElement;
	}

	public void deleteElement(int index) {
		Element deleteElement = headElem;
		Element lastElement = null;
		while(index > 0)
		{
			lastElement = deleteElement;
			deleteElement = deleteElement.address;
			index--;
		}
		lastElement.address = deleteElement.address;
	}

	public Element getLastElement() {
		Element lastElement = headElem;
		while(lastElement.address != null) {
			lastElement = lastElement.address;
		}
		return lastElement;
	}

	public int lenght() {
		int lenght = 1;
		Element nextElement = headElem.address;
		while(nextElement != null) {
			lenght++;
			nextElement=nextElement.address;
		}
		return lenght;
	}

	public void writeList() {
		Element elem = headElem;
		while(elem != null) {
			System.out.println(elem.value);
			elem = elem.address;
		}
	}
}