package org.ruel;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.concurrent.TimeUnit;

@SpringBootApplication
public class Run implements ApplicationRunner{

    private static Logger log = LoggerFactory.getLogger(Run.class);

    @Autowired
    private HelloSender helloSender;

    @Override
    public void run(ApplicationArguments applicationArguments) throws Exception {
        log.info("Spring Boot Embedded ActiveMQ Configuration Example");

        for (int i = 0; i < 5; i++){
            Hello myMessage = new Hello(i + " World");
            helloSender.send(myMessage);
        }

        log.info("Waiting for all ActiveMQ JMS Messages to be consumed");
        TimeUnit.SECONDS.sleep(3);
        System.exit(-1);
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(Run.class, args);
    }
}
