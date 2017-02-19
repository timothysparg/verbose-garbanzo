package coza.sparg.tim.conglomeration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.*;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.text.SimpleDateFormat;


/**
 * Created by tim on 2017/02/19.
 */
@Component
public class ScheduledTasks {

    private static final Logger log = LoggerFactory.getLogger(ScheduledTasks.class);
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @org.springframework.beans.factory.annotation.Value("${info.foo}")
    String value;

    @Scheduled(fixedRateString = "${scheduler.fixedRate}")
    public void reportCurrentTime() {

        Quote quote = restTemplate().getForObject(
                "http://gturnquist-quoters.cfapps.io/api/random", Quote.class);
        log.info(quote.toString());
        log.error(value);
    }
}