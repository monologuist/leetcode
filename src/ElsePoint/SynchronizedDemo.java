package ElsePoint;

public class SynchronizedDemo {
    /**
     * 修饰实例方法，对当前实例对象this加锁
     * 进入同步代码前要获得当前对象实例的锁
     */
    public synchronized void instanceLock(){
        //code
    }

    /**
     * 修饰静态方法，对当前类的Class对象加锁
     */
    public static synchronized void classLock(){
        //code
    }

    /**
     * 修饰代码块，指定一个加锁的对象，给对象加锁
     */
    public void blockLock(){
        Object o = new Object();
        synchronized (o){
            //code
        }
    }
}
