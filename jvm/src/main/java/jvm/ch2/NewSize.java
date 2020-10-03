package jvm.ch2;

/**
 * 演示不同新生代配置，GC的不同
 *
 * Java8
 *
 * VM参数：
 *    -Xms20m -Xmx20m -XX:+PrintGCDetails -Xmn2m -XX:SurvivorRatio=2
 *
 *    -Xms20m -Xmx20m -XX:+PrintGCDetails -Xmn7m -XX:SurvivorRatio=2
 *
 *    -Xms20m -Xmx20m -XX:+PrintGCDetails -Xmn15m -XX:SurvivorRatio=8
 *
 *    -Xms20m -Xmx20m -XX:+PrintGCDetails -XX:NewRatio=2
 *
 */
public class NewSize {

    public static void main(String[] args) {
        //1M大小
        int cap = 1 * 1024 * 1024;
//        for (int i = 0; i < 10; i++) {
//            byte[] b1 = new byte[cap];
//        }
        byte[] b0 = new byte[cap];
        byte[] b1 = new byte[cap];
        byte[] b2 = new byte[cap];
        byte[] b3 = new byte[cap];
        byte[] b4 = new byte[cap];
        byte[] b5 = new byte[cap];
        byte[] b6 = new byte[cap];
        byte[] b7 = new byte[cap];
        byte[] b8 = new byte[cap];
        byte[] b9 = new byte[cap];

    }
}
