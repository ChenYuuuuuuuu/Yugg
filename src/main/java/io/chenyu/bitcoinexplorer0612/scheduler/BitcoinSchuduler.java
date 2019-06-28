package io.chenyu.bitcoinexplorer0612.scheduler;

import com.github.pagehelper.PageHelper;
import io.chenyu.bitcoinexplorer0612.controller.Bitontroller;
import io.chenyu.bitcoinexplorer0612.controller.TransactionController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;


@Component
public class BitcoinSchuduler {
    private Logger logger = (Logger) LoggerFactory.getLogger(this.getClass());

    @Scheduled(fixedRate = 10*60*1000)
    public void syncData(){
        logger.info("sada");
    }
}
