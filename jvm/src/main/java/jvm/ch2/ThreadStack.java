package jvm.ch2;

import java.util.Map;

/**
 * 演示Thread.getAllStackTraces()获取线程堆栈信息
 */
public class ThreadStack {

    public static void main(String[] args) {
        Map<Thread, StackTraceElement[]> map =Thread.getAllStackTraces();
        map.forEach((key, val) ->{
            Thread t = key;
            System.out.println(t.getName() + "-" +t.getId());
            for (StackTraceElement element : val) {
                System.out.println(element);
            }
            System.out.println("========");
        });
    }
}
