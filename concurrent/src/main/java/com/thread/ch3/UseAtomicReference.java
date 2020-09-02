package com.thread.ch3;

import java.util.concurrent.atomic.AtomicReference;

/**
 * 引用类型的原子操作类
 * AtomicReference
 */
public class UseAtomicReference {

    private static AtomicReference<User> userAR = new AtomicReference<>();

    public static void main(String[] args) {

        User oldUser = new User(10, "cake");
        userAR.set(oldUser);

        User newUser = new User(20, "apple");
        userAR.compareAndSet(oldUser, newUser);

        System.out.println(userAR.get().getId());
        System.out.println(userAR.get().getName());

        System.out.println(oldUser.getId());
        System.out.println(oldUser.getName());
    }

    static class User{

        private int id;
        private String name;

        public User(int id, String name){
            this.id = id;
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
