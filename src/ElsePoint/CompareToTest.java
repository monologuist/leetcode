package ElsePoint;

import java.util.Set;
import java.util.TreeMap;

/**
 * CompareToTest对象没有实现Comparable接口，所以必须实现，这样才不会出错，
 * 才可以使得TreeMap中的数据按顺序排列
 * 而像String类、Integer类等都已经实现了Comparable接口，所以不用另外实现
 */
public class CompareToTest implements Comparable<CompareToTest>{
    private String name;
    private int age;

    public CompareToTest(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    /**
     * TODO 重写compareTo方法实现按年龄排序
     * @param o
     * @return
     */
    @Override
    public int compareTo(CompareToTest o) {
        // TODO Auto-generated method stub
        if (this.age > o.getAge()) {
            return 1;
        } else if (this.age < o.getAge()) {
            return -1;
        }
        return age;
    }

    public static void main(String[] args) {
        TreeMap<CompareToTest, String> pdata = new TreeMap<CompareToTest, String>();
        pdata.put(new CompareToTest("􏲩􏽚张三", 30), "zhangsan");
        pdata.put(new CompareToTest("􏲪􏹿李四", 20), "lisi");
        pdata.put(new CompareToTest("􏲫􏲬王五", 10), "wangwu");
        pdata.put(new CompareToTest("􏳷􏲭小红", 5), "xiaohong");
        // 􏱆􏼞得到key􏰇的值的同时得到􏳽􏰇􏼘􏳖􏱆􏼞key􏿤􏸎􏲮􏰇􏳽所对应的值
        Set<CompareToTest> keys = pdata.keySet();
        for (CompareToTest key : keys) {
            System.out.println(key.getAge() + "-" + key.getName()); }
    }

}
