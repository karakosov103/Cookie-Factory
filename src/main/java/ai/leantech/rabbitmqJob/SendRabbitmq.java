package ai.leantech.rabbitmqJob;

import org.hibernate.Session;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaBuilder;

@Component
public class SendRabbitmq {
private final RabbitTemplate rabbitTemplate;

    public SendRabbitmq(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @Scheduled(fixedDelay = 100000L)
    public void sendMessage(){
        rabbitTemplate.convertAndSend("BatchCookie", "hh");


    }


}
