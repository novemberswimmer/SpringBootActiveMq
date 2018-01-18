package org.ruel;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import static org.ruel.ActiveMQConfig.HELLO_QUEUE;

@Service
public class HelloSender {
    private static Logger log = LoggerFactory.getLogger(HelloSender.class);

    @Autowired
    private JmsTemplate jmsTemplate;

    public void send(Hello helloMessage){
        log.info("Sending with convertAndSend() to queue <" + helloMessage + ">");
        jmsTemplate.convertAndSend(HELLO_QUEUE, helloMessage);
    }
}
