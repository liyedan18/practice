package com.thread.ch3;

import java.util.concurrent.atomic.AtomicIntegerArray;

/**
 * AtomicIntegerArray的使用
 */
public class UseAtomicArray {

    private static int[] arr = {1,2,3};

    private static AtomicIntegerArray atomicArray = new AtomicIntegerArray(arr);

    public static void main(String[] args) {
        atomicArray.addAndGet(1, 666);
        System.out.println(atomicArray.get(1));
        System.out.println(arr[1]);

        System.out.println(atomicArray.get(0));
        System.out.println(arr[0]);
    }

}

