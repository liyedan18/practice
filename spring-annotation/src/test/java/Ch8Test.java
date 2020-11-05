import com.ch8.bean.Bird;
import com.ch8.config.Ch8Config;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;

public class Ch8Test {

    @Test
    public void test() {
        ApplicationContext app = new AnnotationConfigApplicationContext(Ch8Config.class);

        //从容器中获取所有bean
        String[] beanNames = app.getBeanDefinitionNames();
        Arrays.stream(beanNames).forEach(System.out::println);

        //获取bird对象
        Bird bird = (Bird) app.getBean("bird");
        System.out.println(bird);
    }
}
