package java8.optional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Optional常用使用示例
 */
public class OptionalTest {

    public static void main(String[] args) {

        // test1();
        // test2();
        // test3ThrowException();
        // test4();
        // test5();
        // test6();
        test7();
    }

    /**
     * 创建Optional实例
     */
    public static void test0(){
        // Optional<User> empty = Optional.empty();
        // System.out.println(empty.get());

        User user1 = new User(1,"tom");
        User user2 = new User();

        User u3 =null;
        Optional<User> opt = Optional.of(user2);
        System.out.println(opt.get());

        Optional<User> opt2 = Optional.ofNullable(user1);
        System.out.println(opt2.get());

        Optional<User> opt3 = Optional.of(u3);
        System.out.println(opt.get());

        Optional<User> opt4 = Optional.ofNullable(u3);
        System.out.println(opt4.get());
    }

    /**
     * 访问Optional对象的值
     */
    public static void test1(){
        String name = "111";
        // String name = null;
        Optional<String> opt = Optional.ofNullable(name);
        System.out.println(opt.isPresent());
        opt.ifPresent(System.out::println);
        opt.ifPresent(s -> System.out.println(s));
        System.out.println(opt.get());
    }

    /**
     * 返回默认值
     */
    public static void test2() {
        User u1 = null;
        User u2 = new User(20, "tom");
        User res = Optional.ofNullable(u1)
                .orElse(u2);
        System.out.println(res);

        //orElse
        User u3 = new User(30, "jack");
        User res3 = Optional.ofNullable(u3)
                .orElse(createNewUser());
        System.out.println(res3);

        //orElseGet
        User res4 = Optional.ofNullable(u1)
                .orElseGet(OptionalTest::createNewUser);
        System.out.println(res4);

        /**
         * orElse 和 orElseGet区别
         * 在执行较密集的调用时，比如调用 Web 服务或数据查询，这个差异会对性能产生重大影响。
         */
        System.out.println("orElse 和 orElseGet区别");
        //即使ofNullable不为空，orElse的内容也会执行
        User userElse = Optional.ofNullable(u2)
                .orElse(createNewUser());
        System.out.println(userElse);
        //ofNullable不为空，orElseGet的内容不会执行
        User userElseGet = Optional.ofNullable(u2)
                .orElseGet(() -> createNewUser());
        System.out.println(userElseGet);
    }

    private static User createNewUser(){
        System.out.println("create new user");
        return new User(50, "jason");
    }

    /**
     * 为空时抛出异常
     */
    public static void test3ThrowException(){
        User u1 = null;
        User res = Optional.ofNullable(u1)
                .orElseThrow(() -> new IllegalArgumentException("参数为空啦"));
    }

    /**
     * 转换值map
     * 与stream结合使用
     */
    public static void test4(){
        User u1 = new User(1, "jack");
        User u2 = null;
        String name = Optional.ofNullable(u1)
                .map(user -> user.getName())
                .orElse("nobody");
        System.out.println(name);

        String name1 = Optional.ofNullable(u1)
                // 这里必须要用Optional包装一层，flatMap与map的入参不同
                // .flatMap(user -> user.getName())
                .flatMap(user -> Optional.ofNullable(user.getName()))
                .orElse("nobody");
    }

    /**
     * 过滤值filter
     * 与stream结合使用
     */
    public static void test5(){
        User u1 = new User(2, "jack");
        User u3 = null;
        // User u2 = Optional.ofNullable(u3)
        //         .filter(user -> user.getName().contains("jack"))
        //         .get();
        // System.out.println(u2);

        Optional<User> jack = Optional.ofNullable(u3)
                .filter(user -> user.getName().contains("jack"));
        System.out.println(jack);

    }

    /**
     * Java9增强
     *
     * or()
     * ifPresentOrElse()
     * stream()
     */
    public static void test6(){
        User u1 = null;
        User u3 = createNewUser();
        User u2 = Optional.ofNullable(u1)
                .or(() -> Optional.of(createNewUser()))
                .get();
        System.out.println(u2);

        System.out.println("====ifPresentOrElse====");
        //consumer, Runnable
        Optional.ofNullable(u3)
                .ifPresentOrElse(user -> System.out.println("user==" + user),
                        () -> System.out.println("user not found"));

        System.out.println("====stream====");
        List<String> nameList = Optional.ofNullable(u3)
                .stream()
                .filter(user -> user.getName() != null)
                .map(User::getName)
                .collect(Collectors.toList());
        System.out.println(nameList);
    }

    /**
     * Optional与stream结合，构建流畅的API
     */
    public static void test7(){
        List<User> userList = new ArrayList<>();
        User u1 = userList.stream()
                .findFirst()
                .orElse(new User(30, "jerry"));
        System.out.println(u1);
    }

}

