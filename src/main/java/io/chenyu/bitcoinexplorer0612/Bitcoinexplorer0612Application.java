package io.chenyu.bitcoinexplorer0612;

import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.annotation.MapperScans;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication

@MapperScan("io.chenyu.bitcoinexplorer0612.dao")
@EnableFeignClients
public class Bitcoinexplorer0612Application {


    public static void main(String[] args) {
        SpringApplication.run(Bitcoinexplorer0612Application.class, args);
    }

}
