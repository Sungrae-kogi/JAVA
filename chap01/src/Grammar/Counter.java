package Grammar;

class Updater{
	public void update(Counter counter) {
		counter.count++;
	}
}


public class Counter {
	int count =0;
	public static void main(String[] args) {
		Counter myCounter = new Counter();
		System.out.println("before Updater: "+myCounter.count);
		
		Updater myUpdater = new Updater();
		myUpdater.update(myCounter);
		System.out.println("after Updater: "+myCounter.count);
	}
}
