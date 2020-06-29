public class Element {
	int value;
	Element prevAddress;
	Element nextAddress;
	public Element(int value) {
		this.value=value;
		this.prevAddress=null;
		this.nextAddress=null;
	}
}