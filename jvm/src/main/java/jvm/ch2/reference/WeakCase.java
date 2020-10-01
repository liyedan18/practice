package jvm.ch2.reference;

import java.lang.ref.WeakReference;

/**
 * 演示弱引用
 *
 * gc时，userWeak会被回收。
 * 也就是弱引用对象只能活到下一次gc前。
 *
 * VM参数：不需要
 */
public class WeakCase {

    public static void main(String[] args) {

        User user = new User(1, "jackie");
        WeakReference<User> userWeak = new WeakReference<>(user);
        user = null;    //确保user只有弱引用在用
        System.out.println("before gc :" + userWeak.get());

        System.gc();
        System.out.println("after gc :" + userWeak.get());

    }
}
