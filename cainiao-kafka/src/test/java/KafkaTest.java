import com.cainiao.kafka.producer.KafkaProducer;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @ClassName : KafkaTest
 * @Description : kafka测试
 * @Author : Cai
 * @Date: 2020/12/9
 */
public class KafkaTest extends BaseTest{
    @Autowired
    private KafkaProducer producer;

    @Test
    public void send(){
        producer.addMessage("123");
    }
}
