package jvm.ch2.reference;

import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.List;

/**
 * 演示软引用
 *
 * gc时，userSoft不一定会回收
 * 在系统发生OOM前，软引用对象会被回收
 *
 * VM参数：-Xms10m -Xmx10m -XX:+PrintGC
 */
public class SoftCase {

    public static void main(String[] args) {

        User user = new User(1, "jackie");
        SoftReference<User> userSoft = new SoftReference<>(user);
        user = null;  //保证user实例只有软引用在引用对象
        System.out.println("before gc: " + userSoft.get());

        System.gc();   //演示gc时，userSoft不一定会回收
        System.out.println("after gc: " + userSoft.get());

        List<byte[]> list = new ArrayList<>();
        try {
            //没有发生OOM之前，userSoft一直存在
            for (int i = 0; i < 1000; i++) {
                System.out.println("====" + userSoft.get());
                list.add(new byte[1024*1024*1]);
            }
        } catch (Throwable e) {
            //发生OOM后，userSoft已经被回收
            System.out.println("Throwable ++++ " + userSoft.get());
            e.printStackTrace();
        }

    }
}
