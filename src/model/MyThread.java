package model;

public class MyThread implements Runnable{

	private int sleep;
	private String text;
	private boolean stop;
	private Thread thread;
	private boolean pause;
	
	public MyThread(String name, int sleep) {
		thread = new Thread(this);
		this.sleep = sleep;
		this.text = name;
		thread.start();
	}

	@Override
	public void run() {
		while(!stop) {
			System.out.println(text);
			try {
				Thread.sleep(sleep);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			synchronized(text) {
				if(stop) {
					break;
				}
				while(pause) {
					try {
						wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}
	
	public synchronized void stop() {
		stop = true;
		notify();
	}
	
	public synchronized void pause() {
		pause = true;
	}
	
	public synchronized void reasume() {
		pause = false;
		notify();
	}
	
	public static void main(String[] args) {
		MyThread t1 = new MyThread("Hola", 1500);
		MyThread t2 = new MyThread("Mundo", 1500);
	}
}