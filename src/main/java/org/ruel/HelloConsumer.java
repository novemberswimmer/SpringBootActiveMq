package org.ruel;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import javax.jms.Session;

import static org.ruel.ActiveMQConfig.HELLO_QUEUE;

@Component
public class HelloConsumer {

    private static Logger log = LoggerFactory.getLogger(HelloConsumer.class);

    @JmsListener(destination = HELLO_QUEUE)
    public void receiveMessage(@Payload Hello hello, @Headers MessageHeaders headers,
                               Message message, Session session){
        log.info("====================================================" + "\n" +
            "Headers =" + headers + "\n" +
            "Message =" + hello + "\n" +
            "Session =" + session);

    }
}
