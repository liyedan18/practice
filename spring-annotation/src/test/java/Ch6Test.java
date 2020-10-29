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

    /**
     * 测试MyFactoryBean的返回类型
     * 看Monkey是否被注册到容器中
     */
    @Test
    public void testFactoryBean(){
        ApplicationContext app = new AnnotationConfigApplicationContext(Ch6Config.class);

        Object o = app.getBean("myFactoryBean");
        //class com.ch6.bean.Monkey
        System.out.println(o.getClass());

        Object o1 = app.getBean("&myFactoryBean");
        // class com.ch6.config.MyFactoryBean
        System.out.println(o1.getClass());
    }

}
