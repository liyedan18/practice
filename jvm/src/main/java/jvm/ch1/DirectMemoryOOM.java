package jvm.ch1;

import java.nio.ByteBuffer;

/**
 * 演示直接内存OOM
 *
 * 直接内存默认大小与堆大小相同。直接内存只受本机总内存大小限制。
 *
 * 场景：
 *     申请的直接内存大于虚拟机设置的直接内存大小
 *
 * VM参数：
 *     -Xmx10m -XX:MaxDirectMemorySize=10m
 *
 *     java.lang.OutOfMemoryError: Direct buffer memory
 */
public class DirectMemoryOOM {

    public static void main(String[] args) {
        //申请15m直接内存
        ByteBuffer buffer = ByteBuffer.allocateDirect(1024*1024*15);
    }
}
