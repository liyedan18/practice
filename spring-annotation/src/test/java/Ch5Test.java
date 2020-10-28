import com.ch1.bean.Person;
import com.ch5.config.Ch5Config;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.Environment;

import java.util.Arrays;
import java.util.Map;

public class Ch5Test {

    /**
     * 打印IOC容器中所有的person实例名
     *
     * 不加@Conditional
     */
    @Test
    public void test1(){

        ApplicationContext app = new AnnotationConfigApplicationContext(Ch5Config.class);
        //先去容器中拿到所有的Person定义，看容器中有几个bean
        String[] beanNamesForType = app.getBeanNamesForType(Person.class);
        Arrays.stream(beanNamesForType).forEach(System.out::println);

        //把所有对象和id放到map中
        Map<String, Person> beansOfType = app.getBeansOfType(Person.class);
        System.out.println(beansOfType);
    }

    /**
     * 测试@Conditional
     *
     * 在linux环境下，给容器中注册tom的bean(改变虚拟机参数-Dos.name=linux)
     * 在windows环境下添加jason
     */
    @Test
    public void test2(){

        ApplicationContext app = new AnnotationConfigApplicationContext(Ch5Config.class);
        //获取IOC容器环境
        Environment environment = app.getEnvironment();
        System.out.println(environment.getProperty("os.name"));
    }

}
