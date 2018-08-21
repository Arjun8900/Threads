
public class Thread_odd_even {
	public static void main(String[] args) {
		OddEven o1=new OddEven(0);
		OddEven o2=new OddEven(1);
		Thread t1=new Thread(o1);
		Thread t2=new Thread(o2);
		t1.start();
		t2.start();
	}
}
class OddEven implements Runnable{
	static int x=1;
	static Object lock=new Object();
	int y;
	OddEven(int y){
		this.y=y;
	}
	public void run() {
		
		while(x<10) {
			synchronized  (lock){
				if(x%2==y) {
					try {
						lock.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				System.out.println(Thread.currentThread().getName()+" "+x);
				x++;
				lock.notify();
			}
		}
	}
}