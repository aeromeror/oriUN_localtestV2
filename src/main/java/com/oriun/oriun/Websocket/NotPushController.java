package com.oriun.oriun.Websocket;

import java.util.List;

import com.oriun.oriun.Models.NotificationModel;
import com.oriun.oriun.Models.SportModel;
import com.oriun.oriun.Services.NotificationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class NotPushController {
  @Autowired
  NotificationService notificationService;
  
  @MessageMapping("/eventCreated")
    @SendTo("/topic/notifications")
    public List<NotificationModel> notify(SportModel NAME_SPORT) throws Exception {
        List< NotificationModel> notifications = notificationService.getNotificationBySport(NAME_SPORT.getNAME_SPORT());
        System.out.println(NAME_SPORT);
        return notifications;

    }

}