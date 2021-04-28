package com.oriun.oriun.Websocket;

import java.util.List;

import com.oriun.oriun.Models.NotificationModel;
import com.oriun.oriun.Services.NotificationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;

@Controller
public class NotPushController {
  @Autowired
  NotificationService notificationService;
  /*@SendTo("/topic/greetings")
  public List<NotificationModel> greeting(String name) throws Exception {
    Thread.sleep(1000); // simulated delay
    
    return notificationService.;
  }*/

}