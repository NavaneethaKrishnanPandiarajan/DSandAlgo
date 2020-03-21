//$Id$
package coding;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;



public class ThreadDeadlock {

	 
    public static void main(String[] args) throws InterruptedException {
        Object obj1 = new Object();
        Object obj2 = new Object();
        Object obj3 = new Object();
    
        Thread t1 = new Thread(new SyncThread(obj1, obj2), "t1");
        Thread t2 = new Thread(new SyncThread(obj2, obj3), "t2");
        Thread t3 = new Thread(new SyncThread(obj3, obj1), "t3");
        
        t1.start();
        Thread.sleep(5000);
        t2.start();
        Thread.sleep(5000);
        t3.start();
        
        
        DeadLockMonitor mon = new DeadLockMonitor();
        mon.start();
    }

}

class SyncThread implements Runnable{
    private Object obj1;
    private Object obj2;

    public SyncThread(Object o1, Object o2){
        this.obj1=o1;
        this.obj2=o2;
    }
    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        System.out.println(name + " acquiring lock on "+obj1);
        synchronized (obj1) {
         System.out.println(name + " acquired lock on "+obj1);
         work();
         System.out.println(name + " acquiring lock on "+obj2);
         synchronized (obj2) {
            System.out.println(name + " acquired lock on "+obj2);
            work();
        }
         System.out.println(name + " released lock on "+obj2);
        }
        System.out.println(name + " released lock on "+obj1);
        System.out.println(name + " finished execution.");
    }
    private void work() {
        try {
            Thread.sleep(30000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}


class DeadLockMonitor extends Thread
{
	private ThreadMXBean threadMgr = ManagementFactory.getThreadMXBean();

	/**
	 * Checks periodically for deadlocks and reports them.
	 */
	public void run() 
	{
		while (true) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			long[] threads = threadMgr.findDeadlockedThreads();
			if (threads != null) 
			{  // found a deadlock
				System.out.println("\n ============================= Deadlock =============================");
				ThreadInfo[] threadInfos = threadMgr.getThreadInfo(threads, true, true);
				for (int i = 0; i < threadInfos.length; i++) {
					ThreadInfo threadInfo = threadInfos[i];
					System.out.println(threadInfo);
				}
				System.out.println("=====================================================================");
				//System.exit(0);
			}
		}
	}
}

