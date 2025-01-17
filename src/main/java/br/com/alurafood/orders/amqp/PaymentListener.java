package br.com.alurafood.orders.amqp;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class PaymentListener {
    @RabbitListener(queues = "payment.concluded")
    public void receiveMessage(Message message) {
        System.out.println("Message received: " + message.toString());
    }
}
