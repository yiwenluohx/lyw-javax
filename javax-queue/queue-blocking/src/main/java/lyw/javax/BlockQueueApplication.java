package lyw.javax;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * @Author: luohx
 * @Description: 阻塞队列实践
 * @Date: 2021/1/15 13:45
 */
@SpringBootApplication
@MapperScan("lyw.javax.dao")
public class BlockQueueApplication {

    public static void main(String[] args) {
        SpringApplication.run(BlockQueueApplication.class, args);
    }

    @Autowired
    private RestTemplateBuilder builder;

    /**
     * 使用RestTemplateBuilder来实例化RestTemplate对象，spring默认已经注入了RestTemplateBuilder实例
     *
     * @return
     */
    @Bean
    public RestTemplate restTemplate() {
        return builder.build();
    }
}
