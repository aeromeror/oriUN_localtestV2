package com.oriun.oriun.Controllers;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.oriun.oriun.Models.NotificationModel;
import com.oriun.oriun.Models.User_eventModel;
import com.oriun.oriun.Services.NotificationService;

@RestController
//@RequestMapping("/notifications")
public class NotificationController {
    @Autowired
    NotificationService notificationService;
    
    @GetMapping("/notifications")
    public ArrayList<NotificationModel> obtenerNotificaciones(){
        return notificationService.getNotifications();
    }
    
    @PostMapping("/notification")
    public NotificationModel guardarnotificacion(@RequestBody NotificationModel notification){
        return this.notificationService.saveNotification(notification);
    }

    @GetMapping("/sportnotifications")
    public List<NotificationModel> obtenerNotificacionesUsuarios(@RequestParam("sport") String sport_name){
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


    
}
