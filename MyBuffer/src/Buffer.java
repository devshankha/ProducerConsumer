import java.util.Arrays;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


public class Buffer {
	private int[] arr;
	private int top = -1;
	Lock lock;
	Condition waitForValue;
	Condition waitForpop;	
	Buffer(int s){
		arr = new int[s];
		lock = new ReentrantLock();	
		waitForValue = lock.newCondition();
		waitForpop = lock.newCondition();		
	}
	private boolean isEmpty(){
		return top == -1;
	}
	private boolean isFull(){
		return top == (arr.length-1);
	}
	public void push(int value){
		lock.lock();
		try {
			while (isFull())
				try {
					System.out.println("STACK IS FULL WAIT "+Arrays.toString(arr));
					waitForpop.await();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			System.out.println(Thread.currentThread().getName()+ "Pushing value "+value);
			arr[++top]= value;
			waitForValue.signal();
			
		}finally {
			lock.unlock();
			
		}
		
	}
	
	public int pop() {
		lock.lock();
		try {
			while (isEmpty())
				try {
					System.out.println("STACK IS EMPTY");
					waitForValue.await();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			int value = arr[top--];
			System.out.println(Thread.currentThread().getName()+ "Popping value "+value);
			waitForpop.signal();
			return value;
			
		}finally {
			
		}
		
	}	
	

}
