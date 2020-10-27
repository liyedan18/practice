import com.ch1.bean.Person;
import com.ch3.config.Ch3MainConfig;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;

public class Ch3Test {

    /**
     * 验证IOC容器中的两个bean是否是同一个bean
     */
    @Test
    public void test01(){

        ApplicationContext applicationContext =
                new AnnotationConfigApplicationContext(Ch3MainConfig.class);
        String[] beanNames = applicationContext.getBeanDefinitionNames();
        Arrays.stream(beanNames).forEach(System.out::println);

        //从容器中分别取两次，看是否相同
        Object bean1 = applicationContext.getBean("person");
        Object bean2 = applicationContext.getBean("person");
        System.out.println(bean1==bean2);
        //是同一个bean
    }
}
