package com.zy.thread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.Semaphore;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadsTest {
public static void main(String[] args) {
	final CountDownLatch countDownLatch = new CountDownLatch(2);
	new Thread() {
		@Override
		public void run() {
			System.out.println("Thread1--------------------------------------------");
			try {
				Thread.sleep(2000);
				countDownLatch.countDown();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}.start();
	
	new Thread() {
		@Override
		public void run() {
			System.out.println("Thread2--------------------------------------------");
			try {
				Thread.sleep(2000);
				countDownLatch.countDown();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}.start();
	try {
		System.out.println("线程已启动");
		countDownLatch.await();
		System.out.println("线程执行完毕");
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	CyclicBarrier cyclicBarrier = new CyclicBarrier(2);
	new Thread() {
		@Override
		public void run() {
			try {
				Thread.sleep(1000);
				System.out.println("thread3------------------" + " 进入等待");
				cyclicBarrier.await();
			} catch (InterruptedException | BrokenBarrierException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("thread3执行完毕");
		}
	}.start();
	new Thread() {
		@Override
		public void run() {
			try {
				Thread.sleep(1000);
				System.out.println("thread4------------------" + " 进入等待");
				cyclicBarrier.await();
				System.out.println("thread4继续执行");
				Thread.sleep(5000);
			} catch (InterruptedException | BrokenBarrierException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("thread4执行完毕");
		}
	}.start();
	
	Semaphore semaphore = new Semaphore(2);
	for(int i = 0; i < 10; i++) {
		new Thread() {
			@Override
			public void run() {
				try {
					semaphore.acquire();
					System.out.println(Thread.currentThread().getName()+"正在执行");
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} finally {
					semaphore.release();
				}
				System.out.println(Thread.currentThread().getName()+"执行完毕");
				
			}
		}.start();
	}
	ArrayBlockingQueue arrayBlockingQueue = new ArrayBlockingQueue<>(10);
	ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(3, 5, 1, TimeUnit.SECONDS, arrayBlockingQueue);
	Test1 task = new Test1();
	FutureTask<Integer> future  = new FutureTask<Integer>(task);
	//ExecutorService executorService = Executors.newCachedThreadPool();
	
	//executorService.submit(future);
	threadPoolExecutor.submit(future);
	threadPoolExecutor.shutdown();
	try {
		System.out.println("执行结果是："+future.get());
	} catch (InterruptedException | ExecutionException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
}

class Test implements Runnable{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}
	
}

class Test1 implements Callable{

	@Override
	public Integer call() throws Exception {
		// TODO Auto-generated method stub
		return (3+5);
	}
	
}
