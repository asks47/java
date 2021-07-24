package example.exchanger;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicBoolean;

public class Exchange {
	
	private boolean waiting = false;

	public boolean ExchangeElement(boolean isProducer, Object lock) {
		Thread t = Thread.currentThread();
		System.out.println("Thread name "+t.getName());
	synchronized(lock) {
		if(isProducer) {
			System.out.println("Producer is waiting");
			isProducer = false;
		}else {
			System.out.println("Producer is waiting");
			isProducer = true;
		}
		
		lock.notify();
		System.out.println("Exchange completed.");
	}
		
		return isProducer;
	}
	
	 public boolean  WaitForExchange(boolean isProducer,Object lock) {
		Thread t = Thread.currentThread();
		System.out.println("Thread name "+t.getName());
		synchronized(lock) {			
			if(isProducer) {
				System.out.println("Producer is going to wait...");
				try {
					waiting = false;
					lock.wait();
					
				} catch (InterruptedException e) {
					
					e.printStackTrace();
				}
				isProducer = false;
			}else {
				System.out.println("Consumer is going to wait...");
				try {
					waiting = false;
					lock.wait();
					
				} catch (InterruptedException e) {
					
					e.printStackTrace();
				}
				isProducer = true;
			}
		}
		
		
		return isProducer;
	}
		
	/*
	 * public synchronized boolean getWaitingFlag() { return waiting; } private void
	 * setWaitingFlag(boolean flag) { waiting = flag; }
	 */
}
