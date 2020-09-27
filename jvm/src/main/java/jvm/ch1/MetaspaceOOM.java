package jvm.ch1;

import java.util.ArrayList;
import java.util.List;

/**
 * 演示元空间OOM异常
 * VM参数：
 *    -XX:MaxMetaspaceSize=2m
 */
public class MetaspaceOOM {

    public static void main(String[] args) {

        /**
         * Error occurred during initialization of VM
         * OutOfMemoryError: Metaspace
         *
         * 分配的元空间太小了，以至于虚拟机都不能正常运行
         */
        List<Object> list = new ArrayList<>();
        int i = 0;
        while (true){
            i++;
            if(i%10000 == 0){
                System.out.println("i=" + i);
            }
            list.add(new Object());
        }

    }
}
