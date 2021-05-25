package com.oriun.oriun.Websocket;

import java.util.List;

import com.oriun.oriun.Models.EventModel;
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
    public List<NotificationModel> notify(EventModel EVENT) throws Exception {
        List< NotificationModel> notifications = notificationService.getNotificationByEvent(EVENT.getID_EVENT());
        System.out.println(EVENT);
        return notifications;

    }

}