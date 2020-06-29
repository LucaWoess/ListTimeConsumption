import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;

public class WoessListMain 
{
	final static int RUNS = 1000000;

	public static void main(String[] args) {
		outputTable();
		outputTableIntoTextFile();
	}
	
	public static long[] measureTimesLinkedList() {
		long addElementLastPlaceTime = 0;
		long addElementFirstPlaceTime = 0;
		long addElementSpecificPlaceTime = 0;
		long deleteElementLastPlaceTime = 0;
		long deleteElementFirstPlaceTime = 0;
		long deleteSpecificElementTime = 0;
		long swapElementTime = 0;
		long lengthTime = 0;
		
		for(int i=1;i<=RUNS;i++) {
			LinkedList<Integer> linkedList = new LinkedList<Integer>();
			linkedList.add(5);
			linkedList.add(7);
			linkedList.add(8);
			linkedList.add(9);
			long start = 0;
			long finish = 0;
			
			start = System.nanoTime();
			linkedList.add(9);
			finish = System.nanoTime();
			addElementLastPlaceTime+= finish - start;
			
			start = System.nanoTime();
			linkedList.addFirst(4);
			finish = System.nanoTime();
			addElementFirstPlaceTime+= finish - start;
			
			start = System.nanoTime();
			linkedList.add(2, 6);
			finish = System.nanoTime();
			addElementSpecificPlaceTime+= finish - start;
			
			start = System.nanoTime();
			linkedList.removeLast();
			finish = System.nanoTime();
			deleteElementLastPlaceTime+= finish - start;
			
			start = System.nanoTime();
			linkedList.removeFirst();
			finish = System.nanoTime();
			deleteElementFirstPlaceTime+= finish - start;
			
			start = System.nanoTime();
			linkedList.remove(1);
			finish = System.nanoTime();
			deleteSpecificElementTime+= finish - start;
			
			start = System.nanoTime();
			Collections.swap(linkedList,1,2);
			finish = System.nanoTime();
			swapElementTime+= finish - start;

			start = System.nanoTime();
			linkedList.size();
			finish = System.nanoTime();
			lengthTime+= finish - start;	
		}
		
		long[] timesLinkedList = new long[] {addElementLastPlaceTime, addElementFirstPlaceTime, addElementSpecificPlaceTime, deleteElementLastPlaceTime, deleteElementFirstPlaceTime, deleteSpecificElementTime, swapElementTime, lengthTime};
		return timesLinkedList;
	}
	
	public static long[] measureTimesArray() {
		long addElementLastPlaceTime = 0;
		long addElementFirstPlaceTime = 0;
		long addElementSpecificPlaceTime = 0;
		long deleteElementLastPlaceTime = 0;
		long deleteElementFirstPlaceTime = 0;
		long deleteSpecificElementTime = 0;
		long swapElementTime = 0;
		long lengthTime = 0;
		
		for(int i=1;i<=RUNS;i++) {
			int[] array= new int[] {5,7,8,9};
			long start = 0;
			long finish = 0;
			
			start = System.nanoTime();
			array = Arrays.copyOf(array, array.length + 1);
		    array[array.length - 1] = 5;
			finish = System.nanoTime();
			addElementLastPlaceTime+= finish - start;
			
			start = System.nanoTime();
			array = Arrays.copyOf(array, array.length + 1);
			for(int k=array.length-1;k>0;k--) {
				array[k]=array[k-1];
			}
			array[0]=8;
			finish = System.nanoTime();
			addElementFirstPlaceTime+= finish - start;
			
			start = System.nanoTime();
			array = Arrays.copyOf(array, array.length + 1);
			for(int k=array.length-1;k>1;k--) {
				array[k]=array[k-1];
			}
			array[1]=8;
			finish = System.nanoTime();
			addElementSpecificPlaceTime+= finish - start;
			
			start = System.nanoTime();
			array = Arrays.copyOf(array, array.length - 1);	
			finish = System.nanoTime();
			deleteElementLastPlaceTime+= finish - start;
			
			start = System.nanoTime();
			int temp2 = array[array.length-1];
			array = Arrays.copyOf(array, array.length - 1);
			for(int k=0;k<array.length-1;k++) {
				array[k]=array[k+1];
			}
			array[array.length-1]=temp2;
			finish = System.nanoTime();
			deleteElementFirstPlaceTime+= finish - start;
			
			start = System.nanoTime();
			for(int k=1;k<array.length-1;k++) {
				array[k]=array[k+1];
			}
			array = Arrays.copyOf(array, array.length - 1);
			finish = System.nanoTime();
			deleteSpecificElementTime+= finish - start;
			
			start = System.nanoTime();
			int temp = array[1];
			array[1]=array[0];
			array[0]=temp;
			finish = System.nanoTime();
			swapElementTime+= finish - start;

			start = System.nanoTime();
			int length = array.length;
			finish = System.nanoTime();
			lengthTime+= finish - start;
		}

		long[] timesArray = new long[] {addElementLastPlaceTime, addElementFirstPlaceTime, addElementSpecificPlaceTime, deleteElementLastPlaceTime, deleteElementFirstPlaceTime, deleteSpecificElementTime, swapElementTime, lengthTime};
		return timesArray;
	}
	public static long[] measureTimesDoublyLinkedList() {
		long addElementLastPlaceTime = 0;
		long addElementFirstPlaceTime = 0;
		long addElementSpecificPlaceTime = 0;
		long deleteElementLastPlaceTime = 0;
		long deleteElementFirstPlaceTime = 0;
		long deleteSpecificElementTime = 0;
		long swapElementTime = 0;
		long lengthTime = 0;
		
		for(int i=1;i<=RUNS;i++) {
			List doublyLinkedList = new List(5);
			doublyLinkedList.addElementLastPlace(7);
			doublyLinkedList.addElementLastPlace(8);
			doublyLinkedList.addElementLastPlace(9);
			long start = 0;
			long finish = 0;
			
			start = System.nanoTime();
			doublyLinkedList.addElementLastPlace(4);
			finish = System.nanoTime();
			addElementLastPlaceTime+= finish - start;
			
			start = System.nanoTime();
			doublyLinkedList.addElementFirstPlace(4);
			finish = System.nanoTime();
			addElementFirstPlaceTime+= finish - start;
			
			start = System.nanoTime();
			doublyLinkedList.addElementSpecificPlace(2,4);
			finish = System.nanoTime();
			addElementSpecificPlaceTime+= finish - start;
			
			start = System.nanoTime();
			doublyLinkedList.deleteElementLastPlace();
			finish = System.nanoTime();
			deleteElementLastPlaceTime+= finish - start;
			
			start = System.nanoTime();
			doublyLinkedList.deleteElementFirstPlace();
			finish = System.nanoTime();
			deleteElementFirstPlaceTime+= finish - start;
			
			start = System.nanoTime();
			doublyLinkedList.deleteSpecificElement(2);
			finish = System.nanoTime();
			deleteSpecificElementTime+= finish - start;
			
			start = System.nanoTime();
			doublyLinkedList.swapElement(0,1);
			finish = System.nanoTime();
			swapElementTime+= finish - start;

			start = System.nanoTime();
			doublyLinkedList.length();
			finish = System.nanoTime();
			lengthTime+= finish - start;
		}
		
		long[] timesDoublyLinkedList = new long[] {addElementLastPlaceTime, addElementFirstPlaceTime, addElementSpecificPlaceTime, deleteElementLastPlaceTime, deleteElementFirstPlaceTime, deleteSpecificElementTime, swapElementTime, lengthTime};
		return timesDoublyLinkedList;
	}

	public static void outputTable() {
		long[] timesDoublyLinkedList = measureTimesDoublyLinkedList();
		long[] timesArray = measureTimesArray();
		long[] timesLinkedList = measureTimesLinkedList();
		
		System.out.println("+--------------------------------+-----------------------+---------------+--------------+");
		System.out.println("| Method (avg of "+RUNS+" runs)\t | Doubly Linked List\t | Linked List\t | Array\t|");
		System.out.println("+--------------------------------+-----------------------+---------------+--------------+");
		System.out.println("| addElementLastPlace\t\t | "+timesDoublyLinkedList[0]/RUNS+" ns\t\t | "+timesLinkedList[0]/RUNS+" ns\t | "+timesArray[0]/RUNS+" ns\t|");
		System.out.println("+--------------------------------+-----------------------+---------------+--------------+");
		System.out.println("| addElementFirsttPlace\t\t | "+timesDoublyLinkedList[1]/RUNS+" ns\t\t | "+timesLinkedList[1]/RUNS+" ns\t | "+timesArray[1]/RUNS+" ns\t|");
		System.out.println("+--------------------------------+-----------------------+---------------+--------------+");
		System.out.println("| addElementSpecifictPlace\t | "+timesDoublyLinkedList[2]/RUNS+" ns\t\t | "+timesLinkedList[2]/RUNS+" ns\t | "+timesArray[2]/RUNS+" ns\t|");
		System.out.println("+--------------------------------+-----------------------+---------------+--------------+");
		System.out.println("| deleteElementLastPlace\t | "+timesDoublyLinkedList[3]/RUNS+" ns\t\t | "+timesLinkedList[3]/RUNS+" ns\t | "+timesArray[3]/RUNS+" ns\t|");
		System.out.println("+--------------------------------+-----------------------+---------------+--------------+");
		System.out.println("| deleteElementFirstPlace\t | "+timesDoublyLinkedList[4]/RUNS+" ns\t\t | "+timesLinkedList[4]/RUNS+" ns\t | "+timesArray[4]/RUNS+" ns\t|");
		System.out.println("+--------------------------------+-----------------------+---------------+--------------+");
		System.out.println("| deleteElementSpecificPlace\t | "+timesDoublyLinkedList[5]/RUNS+" ns\t\t | "+timesLinkedList[5]/RUNS+" ns\t | "+timesArray[5]/RUNS+" ns\t|");
		System.out.println("+--------------------------------+-----------------------+---------------+--------------+");
		System.out.println("| swapElement\t\t\t | "+timesDoublyLinkedList[6]/RUNS+" ns\t\t | "+timesLinkedList[6]/RUNS+" ns\t | "+timesArray[6]/RUNS+" ns\t|");
		System.out.println("+--------------------------------+-----------------------+---------------+--------------+");
		System.out.println("| length\t\t\t | "+timesDoublyLinkedList[7]/RUNS+" ns\t\t | "+timesLinkedList[7]/RUNS+" ns\t | "+timesArray[7]/RUNS+" ns\t|");
		System.out.println("+--------------------------------+-----------------------+---------------+--------------+");
	}
	
	public static void outputTableIntoTextFile() {
		final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd_HH.mm");
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		
		PrintWriter text;
		try {
			long[] timesDoublyLinkedList = measureTimesDoublyLinkedList();
			long[] timesArray = measureTimesArray();
			long[] timesLinkedList = measureTimesLinkedList();
			
			text = new PrintWriter(new BufferedWriter(new FileWriter("Woess_Zeitenvergleich_"+ dateFormat.format(timestamp) +".txt")));
			
			text.println("+--------------------------------+-----------------------+---------------+--------------+");
			text.println("| Method (avg of "+RUNS+" runs)\t | Doubly Linked List\t | Linked List\t | Array\t|");
			text.println("+--------------------------------+-----------------------+---------------+--------------+");
			text.println("| addElementLastPlace\t\t | "+timesDoublyLinkedList[0]/RUNS+" ns\t\t | "+timesLinkedList[0]/RUNS+" ns\t | "+timesArray[0]/RUNS+" ns\t|");
			text.println("+--------------------------------+-----------------------+---------------+--------------+");
			text.println("| addElementFirsttPlace\t\t | "+timesDoublyLinkedList[1]/RUNS+" ns\t\t | "+timesLinkedList[1]/RUNS+" ns\t | "+timesArray[1]/RUNS+" ns\t|");
			text.println("+--------------------------------+-----------------------+---------------+--------------+");
			text.println("| addElementSpecifictPlace\t | "+timesDoublyLinkedList[2]/RUNS+" ns\t\t | "+timesLinkedList[2]/RUNS+" ns\t | "+timesArray[2]/RUNS+" ns\t|");
			text.println("+--------------------------------+-----------------------+---------------+--------------+");
			text.println("| deleteElementLastPlace\t | "+timesDoublyLinkedList[3]/RUNS+" ns\t\t | "+timesLinkedList[3]/RUNS+" ns\t | "+timesArray[3]/RUNS+" ns\t|");
			text.println("+--------------------------------+-----------------------+---------------+--------------+");
			text.println("| deleteElementFirstPlace\t | "+timesDoublyLinkedList[4]/RUNS+" ns\t\t | "+timesLinkedList[4]/RUNS+" ns\t | "+timesArray[4]/RUNS+" ns\t|");
			text.println("+--------------------------------+-----------------------+---------------+--------------+");
			text.println("| deleteElementSpecificPlace\t | "+timesDoublyLinkedList[5]/RUNS+" ns\t\t | "+timesLinkedList[5]/RUNS+" ns\t | "+timesArray[5]/RUNS+" ns\t|");
			text.println("+--------------------------------+-----------------------+---------------+--------------+");
			text.println("| swapElement\t\t\t | "+timesDoublyLinkedList[6]/RUNS+" ns\t\t | "+timesLinkedList[6]/RUNS+" ns\t | "+timesArray[6]/RUNS+" ns\t|");
			text.println("+--------------------------------+-----------------------+---------------+--------------+");
			text.println("| length\t\t\t | "+timesDoublyLinkedList[7]/RUNS+" ns\t\t | "+timesLinkedList[7]/RUNS+" ns\t | "+timesArray[7]/RUNS+" ns\t|");
			text.println("+--------------------------------+-----------------------+---------------+--------------+");
			text.flush();
			text.close();
		}
		catch(IOException e) {
			System.out.println(e);
		}
	}
}
