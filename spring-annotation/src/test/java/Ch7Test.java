import com.ch7.config.Ch7Config;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 演示bean的生命周期
 */
public class Ch7Test {

    @Test
    public void test(){

        AnnotationConfigApplicationContext app =
                new AnnotationConfigApplicationContext(Ch7Config.class);

        System.out.println("IOC容器初始化完成...");

        //多实例模式下，只有在获取bean的时候才初始化
        app.getBean("bike");

        //单实例模式下，关闭容器，即销毁 bean。多实例不会销毁bean。
        app.close();
        System.out.println("IOC容器关闭...");

    }
}
