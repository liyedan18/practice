import com.ch6.bean.Fish;
import com.ch6.config.Ch6Config;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;

public class Ch6Test {

    @Test
    public void test1(){
        ApplicationContext app = new AnnotationConfigApplicationContext(Ch6Config.class);

        String[] beanDefinitionNames = app.getBeanDefinitionNames();
        Arrays.stream(beanDefinitionNames).forEach(System.out::println);

        //查看Fish类是否存在
        Fish fish = app.getBean(Fish.class);
        System.out.println(fish);
    }

}
