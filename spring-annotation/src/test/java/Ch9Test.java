import com.ch9.config.Ch9Config;
import com.ch9.repo.TestDao;
import com.ch9.service.TestService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Ch9Test {

    /**
     * 比较@AutoWired获取和直接从容器中获取的TestDao是否是同一个
     * （这里TestDao不用toString，config使用@Bean）
     *
     * 两个dao地址相同，是同一个
     *
     * 默认先按type找，如果有多个，则按照name找，如果还有多个或找不到，则抛出异常
     */
    @Test
    public void test(){
        ApplicationContext app = new AnnotationConfigApplicationContext(Ch9Config.class);

        TestService testService = app.getBean(TestService.class);
        testService.print();

        /**
         * 这里默认选取的@Repository注解标明的类，不是config中配置的类
         */
        TestDao testDao2 = app.getBean(TestDao.class);  //相当于按照beanid=testDao去找
        System.out.println("test..." + testDao2);

        //这里与上面app.getBean(TestDao.class)相同
        TestDao testDao3 = (TestDao) app.getBean("testDao");
        System.out.println("test..." + testDao3);
    }

    /**
     * 验证@AutoWired获取的bean是@Repository还是config中@Bean注入的bean
     *
     * TestDao类加入flag和toString
     * config使用@Bean("testDao3")
     *
     * 如果是@Repository,则结果flag=1
     * 是@Bean注入的，则flag=2
     *
     * 是@Repository中标明的
     */
    @Test
    public void test2(){
        ApplicationContext app = new AnnotationConfigApplicationContext(Ch9Config.class);

        TestService testService = app.getBean(TestService.class);
        testService.print();

    }

}
