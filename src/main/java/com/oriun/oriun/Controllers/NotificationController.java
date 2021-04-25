package com.oriun.oriun.Controllers;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.oriun.oriun.Models.NotificationModel;
import com.oriun.oriun.Models.User_eventModel;
import com.oriun.oriun.Models.User_sportsModel;
import com.oriun.oriun.Services.NotificationService;
import com.oriun.oriun.Services.User_sportsService;

@RestController
//@RequestMapping("/notifications")
public class NotificationController {
    @Autowired
    NotificationService notificationService;
    @Autowired
    User_sportsService user_sportsService;
    @GetMapping("/notifications")
    public ArrayList<NotificationModel> obtenerNotificaciones(){
        return notificationService.getNotifications();
    }
    
    @PostMapping("/notification")
    public NotificationModel guardarnotificacion(@RequestBody NotificationModel notification){
        return this.notificationService.saveNotification(notification);
    }

    @GetMapping("/sportnotifications")
    public List<NotificationModel> obtenerNotificacionesDeportes(@RequestParam("sport") String sport_name){
        List< NotificationModel> notifications = notificationService.getNotificationBySport(sport_name);
        /*ArrayList<NotificationModel> tmp = new ArrayList<NotificationModel>();
        for(int c=0;c<notifications.size();c++){
            int notifnum=notifications.get(c).getID_NOTIFICATION();
            Optional<NotificationModel> notif=notificationService.getNotificationById(notifnum);
            tmp.add(notif.get());
        }*/
        //return tmp;
        return notifications;
    }


    @GetMapping("/usernotifications")
    public List<NotificationModel> obtenerNotificacionesUsuarios(@RequestParam("user") String user_name){
        List<User_sportsModel> user_sports=user_sportsService.getUser_sports(user_name);
        List< NotificationModel> notifications = new ArrayList<NotificationModel>();
        for(int c=0;c<user_sports.size();c++){
            List< NotificationModel> temp = notificationService.getNotificationBySport(user_sports.get(c).getNAME_SPORT());
            notifications = Stream.concat(notifications.stream(), temp.stream()).collect(Collectors.toList());
        }  
        return notifications;
    }
    
}
