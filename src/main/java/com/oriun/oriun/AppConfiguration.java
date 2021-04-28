package com.oriun.oriun;
import com.oriun.oriun.Models.NotificationModel;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Sinks;

@Configuration
public class AppConfiguration {
     private static final String NOTIFICATIONS_API_ENDPOINT = "https://wise-brook-308119.ue.r.appspot.com/notifications";

    @Bean
    public WebClient webClient(){
        return WebClient.builder()
                    .baseUrl(NOTIFICATIONS_API_ENDPOINT)
                    .build();
    }

    @Bean
    public Sinks.Many<NotificationModel> sink(){
        return Sinks.many().replay().latest();
    }

    @Bean
    public Flux<NotificationModel> flux(Sinks.Many<NotificationModel> sink){
        return sink.asFlux();
    }

}
