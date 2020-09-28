package jvm.ch1;

/**
 * 演示虚拟机栈OOM，默认大小为1M
 *
 * 场景：
 *     当不断调用方法的时候，会出现栈OOM。也就是递归调用。调用的方法太多。
 *
 *     方法的变量越多，栈帧越大，则OOM时deep深度越浅。
 *
 * VM参数：
 *     -Xss256k
 *
 *     java.lang.StackOverflowError
 */
public class StackOOM {

    private int deep = 0;

    public static void main(String[] args) {
        StackOOM oom = new StackOOM();

        try {
//            oom.recursion();
            oom.recursionBig();
            //注意这里不能用Exception,因为OOM是error，因此要用Throwable
            //如果用了Exception，下面的sout是不会打印的，因为不能捕捉error
//        } catch (Exception e){
        } catch (Throwable e){
            System.out.println("deep=" + oom.deep);
            e.printStackTrace();
        }
    }

    //deep=3291
    private void recursion(){
        deep++;
        recursion();
    }

    //deep=2339
    private void recursionBig(){
        deep++;
        Object o1 = new Object();
        Object o2 = new Object();
        Object o3 = new Object();
        Object o4 = new Object();
        Object o5 = new Object();
        Object o6 = new Object();
        recursionBig();
    }
}
