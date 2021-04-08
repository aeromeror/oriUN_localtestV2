package com.oriun.oriun.Services;
import java.util.ArrayList;
import java.util.Optional;

import javax.transaction.Transactional;

import com.oriun.oriun.Models.NotificationModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.oriun.oriun.Repositories.NotificationRepository;

@Service
@Transactional
public class NotificationService {
    @Autowired
    
    NotificationRepository notificationRepository;
    
    public ArrayList<NotificationModel> getNotifications(){
        return (ArrayList<NotificationModel>)notificationRepository.findAll();
    }
    
    public NotificationModel saveNotification(NotificationModel notification){
        return notificationRepository.save(notification);
    }
    
    public Optional<NotificationModel> getNotificationById(int id_notification) {
        return notificationRepository.findById(id_notification);
    }
    
    public NotificationModel updateNotification(int id_notification,NotificationModel newnotif) {
        Optional<NotificationModel> oldnotif = notificationRepository.findById(id_notification);
        if(oldnotif.isPresent()){
            notificationRepository.delete(oldnotif.get());
            NotificationModel updatedNotification = notificationRepository.save(newnotif);
            return updatedNotification;
        }else{
            return oldnotif.get();
        }
    }
    
    public NotificationModel deleteNotification(NotificationModel notification){
        notificationRepository.delete(notification);
        return notification;
    }
}
