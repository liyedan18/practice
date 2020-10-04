package jvm.ch2;

import jvm.util.ThreadSleep;

/**
 * 演示jinfo命令的使用——可以用命令方式修改VM的参数
 *
 * java8
 *
 * VM参数：
 *     -Xms20m -Xmx20m -Xmn2m -XX:+PrintGC
 *
 *     上面vm参数只打印GC的基本信息
 *
 * 用jinfo命令添加、取消打印GC的详细信息
 *     先jps -v 找到jinfoTest的java进程19136
 *     然后添加： jinfo -flag +PrintGCDetails 19136
 *
 */
public class JinfoTest {

    public static void main(String[] args) {
        while(true){
            byte[] b = null;
            for (int i = 0; i < 10; i++) {
                b = new byte[1*1024*1024];
            }

            ThreadSleep.sleepMs(5000);
        }
    }
}
