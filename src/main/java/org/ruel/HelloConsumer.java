package org.ruel;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import javax.jms.Session;

import static org.ruel.ActiveMQConfig.ORDER_QUEUE;

@Component
public class HelloConsumer {

    private static Logger log = LoggerFactory.getLogger(HelloConsumer.class);

    @JmsListener(destination = ORDER_QUEUE)
    public void receiveMessage(@Payload Hello hello, @Header MessageHeaders headers,
                               Message message, Session session){
        log.info("received <" + hello + ">");

        log.info("- - - - - - - - - - - - - - - - - - - - - - - -");
        log.info("######          Message Details           #####");
        log.info("- - - - - - - - - - - - - - - - - - - - - - - -");
        log.info("headers: " + headers);
        log.info("message: " + message);
        log.info("session: " + session);
        log.info("- - - - - - - - - - - - - - - - - - - - - - - -");
    }
}
