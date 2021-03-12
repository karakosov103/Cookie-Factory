package ai.leantech.config;

import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitmqConfig {
    @Bean
        AmqpAdmin rabbitAdmin(RabbitTemplate rabbitTemplate){
            RabbitAdmin rabbitAdmin = new RabbitAdmin(rabbitTemplate);
            rabbitAdmin.declareQueue(new Queue("Batch"));
            return rabbitAdmin;
        }
}
