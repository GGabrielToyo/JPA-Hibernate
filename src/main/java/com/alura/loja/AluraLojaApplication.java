package com.alura.loja;

import ch.qos.logback.core.encoder.JsonEscapeUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AluraLojaApplication {

    public static void main(String[] args) {
        SpringApplication.run(AluraLojaApplication.class, args);
        System.out.println("Iniciando aplicação de treinamento para JPA + Hibernate");
    }

}
