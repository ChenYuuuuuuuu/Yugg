package io.chenyu.bitcoinexplorer0612.scheduler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;


@Component
public class BitcoinSchuduler {
    private Logger logger = (Logger) LoggerFactory.getLogger(this.getClass());

    @Scheduled(fixedRate = 10*60*1000)
    public void syncData(){
        logger.info("sada");
    }
}
