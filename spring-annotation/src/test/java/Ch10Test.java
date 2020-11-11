import com.ch10.aop.Calculator;
import com.ch10.config.Ch10Config;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Ch10Test {

    @Test
    public void test(){
        ApplicationContext app = new AnnotationConfigApplicationContext(Ch10Config.class);

        // Calculator cal = new Calculator();   //必须要从容器中获取bean才能执行aop
        Calculator cal = app.getBean(Calculator.class);

        int res = cal.div(2, 1);
        // int res = cal.div(2, 0);

        System.out.println(res);

    }
}
