
public class Coordinator {
	public static void main(String[] args) {
		Buffer b = new Buffer(10);
		Thread producer = new Thread(new Producer(b));
		Thread consumer = new Thread(new Consumer(b));
		consumer.start();
		producer.start();
		
	}

}
