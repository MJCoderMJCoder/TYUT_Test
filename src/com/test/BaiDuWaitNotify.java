package com.test;
/*
 * http://wenku.baidu.com/link?url=-rhVkpW1Pbl8__xWntScW4mSDfr7-wUm7ex-uxtD5OWjd8uZ5nXdVndHnpwk_HkSL_eXXAiJ1Y2y95zMrDRcU1jkTI362vM9YKT7qEy1zhG
 * http://wenku.baidu.com/link?url=-rhVkpW1Pbl8__xWntScW4mSDfr7-wUm7ex-uxtD5OWjd8uZ5nXdVndHnpwk_HkSL_eXXAiJ1Y2y95zMrDRcU1jkTI362vM9YKT7qEy1zhG
 * 
 * wait()和notify()一系列的方法，是属于对象的，不是属于线程的。它们用在线程同步时，synchronized语句块中。
 * 		在synchronized语句块中，同一个对象，一个线程在执行完这一块代码之前，另一个线程，如果传进来的是同一
 * 个object，是不能进入这个语句块的。也就是说，同一个对象是不能同时被两个线程用来进入synchronized中的。
 * 这就是线程同步。
 * 
 * 线程启动的顺序，和代码的先后顺序，理论上是没有关系的！
 * wait和notify是针对同一个object的，而非线程。我们这一篇都在讲对象锁，而不是线程。
 */

//顺便说一下，如果没有线程在wait，调用notify是不会有什么问题的，就像这样：
public class BaiDuWaitNotify {
	public static void main(String[] args) {
		final Object object = new Object();
		Thread t1 = new Thread() {
			public void run()
			{
				synchronized (object) {
					System.out.println("T1 start!");
					object.notify();
					System.out.println("T1 end!");
				}
			}
		};
		t1.start();
	}

}

/*
 * 运行结果
 * T1 start!
 * T1 end!
 * 
 * http://zhidao.baidu.com/link?url=TD7dUlq837hsc5E_rpUUMrDtzfVYffvbBdwHISAoyFV0xNfxtwrAI9pTbpaXR6g2Ir67gfkPobhnhU_CIF4yiK
 * http://zhidao.baidu.com/link?url=TD7dUlq837hsc5E_rpUUMrDtzfVYffvbBdwHISAoyFV0xNfxtwrAI9pTbpaXR6g2Ir67gfkPobhnhU_CIF4yiK
 * 需要注意的概念是：
 * 	◆调用obj的wait（）， notify（）方法前，必须获得obj锁，也就是必须写在synchronized（obj） {……} 代码段内。
 * 	◆调用obj.wait（）后，线程A就释放了obj的锁，否则线程B无法获得obj锁，也就无法在synchronized（obj） {……} 代码段内唤醒A.
 * 	◆当obj.wait（）方法返回后，线程A需要再次获得obj锁，才能继续执行。
 * 	◆如果A1，A2，A3都在obj.wait（），则B调用obj.notify（）只能唤醒A1，A2，A3中的一个（具体哪一个由JVM决定）。
 * 	◆obj.notifyAll（）则能全部唤醒A1，A2，A3，但是要继续执行obj.wait（）的下一条语句，必须获得obj锁，因此，A1，A2，A3只有一个有机会获得锁继续执行，例如A1，其余的需要等待A1释放obj锁之后才能继续执行。
 * 	◆当B调用obj.notify/notifyAll的时候，B正持有obj锁，因此，A1，A2，A3虽被唤醒，但是仍无法获得obj锁。直到B退出synchronized块，释放obj锁后，A1，A2，A3中的一个才有机会获得锁继续执行。
 */