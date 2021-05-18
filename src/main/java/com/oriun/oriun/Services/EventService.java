package com.oriun.oriun.Services;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import com.oriun.oriun.Models.EventModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.oriun.oriun.Repositories.EventRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@Service
@Transactional
public class EventService {
    @Autowired
    
    EventRepository eventRepository;

    public ArrayList<EventModel> getEvents(){
        return (ArrayList<EventModel>)eventRepository.findAll();
    }
    public List<EventModel> getUserEvents(String user_name){
        return eventRepository.findUserEvents(user_name);
    }
    public EventModel saveEvent(EventModel event){
        if(event.getOTHER_SPORT()!=null){
            event.setOTHER_SPORT(FormatText(event.getOTHER_SPORT()));
        }
        return eventRepository.save(event);
    }
    public Optional<EventModel> getEventById(int event_id) {
        return eventRepository.findById(event_id);
    }
    //Update sin Query
    public EventModel updateEvent(int eventID,EventModel newevent) {
        Optional<EventModel> oldevent = eventRepository.findById(eventID);
        if(oldevent.isPresent()){
            eventRepository.delete(oldevent.get());
            EventModel updatedEvent = eventRepository.save(newevent);
            return updatedEvent;
        }else{
            return oldevent.get();
        }
    }
    public EventModel deleteEvent(EventModel event){
        eventRepository.delete(event);
        return event;
    }
    public List<EventModel> getOtherEvents(){
        return eventRepository.findByOthers();
    }
    public List<String> getOtherSports(){
        return eventRepository.findByOtherSports();
    }
    public Boolean existEvent(int id_eve){
        return eventRepository.existsById(id_eve);
    }
    public List<Object[]> getOtherSportsCount(){
        return eventRepository.findByOtherSportscount();
    }
    public List<Integer> getIdEventByOther(String other_sport){
        return eventRepository.findByOther_Sport(other_sport);
    }
    public ArrayList<EventModel> getEventVigentes(){
        return eventRepository.findCurrent();
    }
    public void updateEventSport(String sport_name){
        eventRepository.updateEventSport(sport_name);
    }
    public String creadorevento(int id_eve){
        return getEventById(id_eve).get().getUSER_NAME();
    }
    
    public void adiosEvent(int id_event){
        eventRepository.deleteEvent(id_event);
    }
    private String FormatText(String in){
        String out=in.toLowerCase();
        String M=String.valueOf((char)(out.charAt(0)-32));
        out=out.replaceFirst(String.valueOf(out.charAt(0)),M);
        return out;
    }
}
