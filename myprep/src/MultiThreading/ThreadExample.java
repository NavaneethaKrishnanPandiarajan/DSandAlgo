//$Id$
package MultiThreading;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class ThreadExample {
	
	public static void main(String [] args) throws Exception
	{
		ExecutorService executor = Executors.newFixedThreadPool(2); 
		
		Callable <String> callable1 = ()->{
			
			try {
				TimeUnit.SECONDS.sleep(1);
				return Thread.currentThread().getName();
			}
			catch (InterruptedException e) {
				throw new IllegalStateException("task interrupted", e);
			}

		};
		
		
		Callable <String> callable2 = ()->{
			
			try {
				TimeUnit.SECONDS.sleep(1);
				return Thread.currentThread().getName();
			}
			catch (InterruptedException e) {
				throw new IllegalStateException("task interrupted", e);
			}

		};
		
		Future<String> futureResult = executor.submit(callable1);
		
		Future<String> futureResult1 = executor.submit(callable2);
		
		System.out.println(futureResult.get());
		
		System.out.println(futureResult1.get());
		
		
	}
}
