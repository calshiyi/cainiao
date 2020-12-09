package com.cainiao.kafka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
public class KafkaApplication {
    public static void main( String[] args ){
    	SpringApplication.run(KafkaApplication.class, args);
        System.out.println( ">>>>>>>>>>>>>>>cainiao kafka started!<<<<<<<<<<<<<<<<<<<<<" );
    }
}
