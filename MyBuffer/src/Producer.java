
public class Producer implements Runnable{
	Buffer buffer;
	public Producer(Buffer b){
		buffer = b;		
	}
	@Override
	public void run() {
		int i = 0;
		while (true){
			buffer.push(i++);
			try {
				Thread.sleep((long) (Math.random() * 1000));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	}

}
