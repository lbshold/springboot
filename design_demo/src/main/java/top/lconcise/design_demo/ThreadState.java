package top.lconcise.design_demo;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author: liusj
 * @date: 2022/4/6
 */
public class ThreadState {

    public static void main(String[] args) throws Exception {
        Thread t1 = new Thread(() ->{
            System.out.println("2:"+Thread.currentThread().getState());
            for (int i = 0;i < 3;i++){
                SleepHelp1.sleepseconds(1);
                System.out.print(i+" ");
            }
            System.out.println();
        });
        System.out.println("1:"+t1.getState());
        t1.start();
        t1.join();
        System.out.println("3:"+t1.getState());

        //=====================================================================
        Thread t2 = new Thread(()->{
            //阻塞  等着被叫醒  waiting
            LockSupport.park();
            System.out.println("t2 go on");
            SleepHelp1.sleepseconds(5);

        });
        t2.start();
        SleepHelp1.sleepseconds(1);
        System.out.println("4:"+t2.getState());

        //叫醒线程
        LockSupport.unpark(t2);
        SleepHelp1.sleepseconds(1);
        System.out.println("5:"+t2.getState());
        //=====================================================================

        final Object o = new Object();
        Thread t3 = new Thread(()->{
            synchronized (o){
                System.out.println("t3 得到了 锁 o");
            }
        });

        new Thread(()->{
            synchronized (o){
                SleepHelp1.sleepseconds(5);
            }
        }).start();

        SleepHelp1.sleepseconds(1);

        t3.start();

        SleepHelp1.sleepseconds(1);

        System.out.println("6:"+t3.getState());
        //===========================================================
        //juc的锁 盲等待， 不会进入 block 的状态，进入 waiting 状态
        final Lock lock = new ReentrantLock();
        Thread t4 = new Thread(()->{
            lock.lock();//省略掉 try ... finally
            System.out.println("t4 拿到了锁 o");
            lock.unlock();
        });

        new Thread(()->{
            lock.lock();
            SleepHelp1.sleepseconds(5);
            lock.unlock();
        }).start();

        SleepHelp1.sleepseconds(1);

        t4.start();

        SleepHelp1.sleepseconds(1);

        System.out.println("7:"+t4.getState());
        //=======================================================
        Thread t5 = new Thread(()->{
            LockSupport.park();
        });

        t5.start();

        SleepHelp1.sleepseconds(1);

        System.out.println("8:"+t5.getState());

        SleepHelp1.sleepseconds(1);

        LockSupport.unpark(t5);
    }

}

class SleepHelp1 {

    public static void sleepseconds(int seconds){
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}