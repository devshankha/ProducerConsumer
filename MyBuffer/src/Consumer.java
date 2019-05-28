
public class Consumer implements Runnable{
	Buffer buffer;
	public Consumer(Buffer b){
		buffer = b;		
	}
	@Override
	public void run() {		
		while (true){
			buffer.pop();
		/*	try {
				Thread.sleep((long)(Math.random()*1000));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/
			
		}
		
	}

}
