import ohter.Business;
import ohter.Count;
import thread.MyThread;
import thread.MyThreadRunnable;
import thread.ThreadA;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Main {

    public static int data = 0;
    public static Map<Thread, Integer> map = new HashMap<>();
    public static ThreadLocal<ThreadLocalTest> threadLocal = new ThreadLocal<>();
    public static void main(String[] args) {
        for(int i = 0; i < 2; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    int data = new Random().nextInt();
                    map.put(Thread.currentThread(), data);
//                    ThreadLocalTest threadLocalTest = new ThreadLocalTest();
//                    threadLocalTest.setAge(data);
//                    threadLocalTest.setName(Thread.currentThread().getName() + "name" + data);
//                    threadLocal.set(threadLocalTest);
                    ThreadLocalTest threadLocalTest = ThreadLocalTest.getThreadInstance();
                    threadLocalTest.setName(Thread.currentThread().getName() + "name" + data);
                    threadLocalTest.setAge(data);
                    new A().get();
                    new B().get();
                }
            }).start();
        }
    }
    static class A{
        public void get(){
            int data = map.get(Thread.currentThread());
            ThreadLocalTest t = ThreadLocalTest.getThreadInstance();
            System.out.println("name:" + t.getName() + ";---age:" + t.getAge());
            System.out.println(Thread.currentThread().getName() + " data = " + data);
        }
    }

    static class B{
        public void get(){
            int data = map.get(Thread.currentThread());
            System.out.println(Thread.currentThread().getName() + " data = " + data);
        }
    }
}

class ThreadLocalTest {
    private ThreadLocalTest(){}

    public static ThreadLocalTest getThreadInstance() {
        if(t.get() == null){
            ThreadLocalTest threadLocalTest = new ThreadLocalTest();
            t.set(threadLocalTest);
        }
        return t.get();
    }
    public static ThreadLocal<ThreadLocalTest> t = new ThreadLocal<>();
    private String name;
    private Integer age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}