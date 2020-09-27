package jvm.ch1;

import java.util.ArrayList;
import java.util.List;

/**
 * 演示两种堆OOM异常
 * VM参数：
 *    -Xms5m -Xmx5m -XX:+PrintGC
 */
public class OOM {

    public static void main(String[] args) {

        /**
         * java.lang.OutOfMemoryError: GC overhead limit exceeded
         * 一般是不停的分配对象（最大可能是在循环中），分配太多，把堆撑爆了
         */
/*        List<Object> list = new ArrayList<>();
        int i = 0;
        while (true){
            i++;
            if(i%10000 == 0){
                System.out.println("i=" + i);
            }
            list.add(new Object());
        }*/

        /**
         * java.lang.OutOfMemoryError: Java heap space
         * 一般是分配了巨型对象
         */
        String[] strings = new String[100000000];

    }
}
