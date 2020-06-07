public class WoessListMain 
{
	static long addElementTime;
	static long deleteElementTime;
	static long writeListTime;
	static long lenghtTime;
	static long getLastElementTime;

	public static void main(String[] args) 
	{
		List woess = new List(0);
		/*woess.addElement(4);
		woess.addElement(3);
		woess.addElement(2);
		woess.deleteElement(2);
		woess.writeList();
		 */
		
		for(int i=0;i<1000;i++) {
			long start = System.nanoTime();
			woess.addElement(4);
			long finish = System.nanoTime();
			addElementTime += finish - start;
			}
		
		for(int i=0;i<7;i++) {
			woess.addElement(5);
			}
		
		for(int i=0;i<1000;i++) {
			long start = System.nanoTime();
			woess.deleteElement(2);
			long finish = System.nanoTime();
			deleteElementTime += finish - start;
		}
		
		for(int i=0;i<1000;i++) {
			long start = System.nanoTime();
			woess.getLastElement();
			long finish = System.nanoTime();
			getLastElementTime += finish - start;
			}
		
		for(int i=0;i<1000;i++) {
			long start = System.nanoTime();
			woess.lenght();
			long finish = System.nanoTime();
			lenghtTime += finish - start;
			}
		
		for(int i=0;i<1000;i++) {
			long start = System.nanoTime();
			woess.writeList();
			long finish = System.nanoTime();
			writeListTime += finish - start;
			}
		
		System.out.println("+-------------------------------+-----------------------+---------------+");
		System.out.println("|\tFull addElementTime\t|\t"+addElementTime+" ns\t|\t"+(addElementTime/1000000)+" ms\t|");
		System.out.println("+-------------------------------+-----------------------+---------------+");
		System.out.println("|\tFull deleteElementTime\t|\t"+deleteElementTime+" ns\t|\t"+(deleteElementTime/1000000)+" ms\t|");
		System.out.println("+-------------------------------+-----------------------+---------------+");
		System.out.println("|\tFull getLastElemetTime\t|\t"+getLastElementTime+" ns\t|\t"+(getLastElementTime/1000000)+" ms\t|");
		System.out.println("+-------------------------------+-----------------------+---------------+");
		System.out.println("|\tFull lenghtTime\t\t|\t"+lenghtTime+" ns\t|\t"+(lenghtTime/1000000)+" ms\t|");
		System.out.println("+-------------------------------+-----------------------+---------------+");
		System.out.println("|\tFull writeListTime\t|\t"+writeListTime+" ns\t|\t"+(writeListTime/1000000)+" ms\t|");
		System.out.println("+-------------------------------+-----------------------+---------------+");
		//System.out.println("Full addElementTime:\t|\t "+addElementTime);
	}

}
