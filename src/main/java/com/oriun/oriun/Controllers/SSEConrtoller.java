package com.oriun.oriun.Controllers;
import com.oriun.oriun.Models.NotificationModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
public class SSEConrtoller {
    @Autowired
    private Flux<NotificationModel> flux;

    @GetMapping(value = "/push", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<NotificationModel> getPushNotif(){
        return flux;
    }
}
