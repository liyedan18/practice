import com.ch12.config.Ch12Config;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Ch12Test {

    @Test
    public void test(){
        ApplicationContext app = new AnnotationConfigApplicationContext(Ch12Config.class);

        int i = 0;
    }
}
