package ElsePoint;

/**
 * 双重校验锁实现对象单例（线程安全）
 */
public class SingletonDemo {
    private volatile static SingletonDemo instance;//使用volatile关键字

    public static SingletonDemo getInstance() {
        //􏵼􏿛􏿜􏸎􏲔􏹯􏿞􏲜􏲝􏱞􏲚􏳺􏻢􏿻􏺝􏱞􏲚􏻂􏳺􏲗􏻏􏼏􏾙􏰈􏰆􏿥先判断对象是否已经实例过，没有实例化过才进入加锁代码
        if (instance == null) {//第7行
            //􏾘类对象加锁
            synchronized (SingletonDemo.class) {
                if (instance == null) {
                    instance = new SingletonDemo();//第10行
                }
            }
        }
        return instance;
    }
}
