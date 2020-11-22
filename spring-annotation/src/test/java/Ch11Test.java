import com.ch11.config.Ch11Config;
import com.ch11.service.OrderService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Ch11Test {

    @Test
    public void test(){
        ApplicationContext app = new AnnotationConfigApplicationContext(Ch11Config.class);

        OrderService orderService = app.getBean(OrderService.class);
        orderService.addOrder();

    }
}
