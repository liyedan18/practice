import com.ch4.config.Ch4Config;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class Ch4Test {

    @Test
    public void test01(){
        ApplicationContext app = new AnnotationConfigApplicationContext(Ch4Config.class);

        System.out.println("IOC创建完成...");
        app.getBean("person");
    }
}
