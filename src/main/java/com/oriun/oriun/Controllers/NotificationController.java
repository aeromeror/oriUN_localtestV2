package com.oriun.oriun.Controllers;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.oriun.oriun.Models.NotificationModel;
import com.oriun.oriun.Models.User_eventModel;
import com.oriun.oriun.Models.User_sportsModel;
import com.oriun.oriun.Services.NotificationService;
import com.oriun.oriun.Services.User_sportsService;
import java.text.SimpleDateFormat;
import java.time.LocalDate;

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
        List< NotificationModel> notifications = notificationService.getNotificationByUser(user_name);
        return notifications;
    }

    @GetMapping("/datenotifications")
    public List<NotificationModel> obtenerNotificacionesFecha(@RequestParam("notification_date") Date notification_date){  
        //LocalDate localDate = LocalDate.parse(notification_date);
        List< NotificationModel> notifications = notificationService.getNotificationByDate(notification_date);
        return notifications;
    }
    
    @GetMapping("/activenotifications")
    public List<NotificationModel> obtenerNotificacionesActivas(@RequestParam("notification_date") Date notification_date){  
        //LocalDate localDate = LocalDate.parse(notification_date);
        List< NotificationModel> notifications = notificationService.getNotificationByActive(notification_date);
        return notifications;
    }
    
}
