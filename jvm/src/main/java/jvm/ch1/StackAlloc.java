package jvm.ch1;

/**
 * jvm练习——在栈上分配对象
 *
 * 需要设置虚拟机参数：
 * -server -Xms10m -Xmx10m -XX:+DoEscapeAnalysis -XX:+PrintGC -XX:+EliminateAllocations -XX:-UseTLAB
 *
 */
public class StackAlloc {

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        for (int i = 0; i < 100000000; i++) {
            alloc();
        }
        System.out.println("Time = " + (System.currentTimeMillis() - start) + "ms");
    }

    public static class User{
        public int id = 0;
        public String name = "";

        public User(){
        }
    }

    public static User alloc(){
        User user = new User();
        user.id = 1;
        user.name = "join";
        return user;
    }

}
