package com.oriun.oriun.Services;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;

import com.oriun.oriun.Models.NotificationModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.oriun.oriun.Repositories.NotificationRepository;
import java.time.LocalDate;
import java.sql.Date;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Sinks;



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

    
    public List<NotificationModel> getNotificationBySport(String namesport) {
        return notificationRepository.findByNAME_SPORT(namesport);
    }

    public List<NotificationModel> getNotificationByDate(Date date) {
        return notificationRepository.findByNOTIFICATION_DATE(date);
    }
    
    public List<NotificationModel> getNotificationByActive(Date date) {
        return notificationRepository.findByAVTIVE_DATE(date);
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
    
    
    //TEST PUSH NOTIFICATIONS
    @Autowired
    private WebClient webClient;

    @Autowired
    private Sinks.Many<NotificationModel> sink;

    @Scheduled(fixedRate = 3000)
    public void publish(){
        this.webClient
                .get()
                .retrieve()
                .bodyToMono(NotificationModel.class)
                .subscribe(this.sink::tryEmitNext);
    }
}
