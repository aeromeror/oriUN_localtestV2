package com.oriun.oriun.Services;
import java.util.ArrayList;
import java.util.Optional;

import javax.transaction.Transactional;

import com.oriun.oriun.Models.EventModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.oriun.oriun.Repositories.EventRepository;

@Service
@Transactional
public class EventService {
    @Autowired
    
    EventRepository eventRepository;

    public ArrayList<EventModel> getEvents(){
        return (ArrayList<EventModel>)eventRepository.findAll();
    }
    public EventModel saveEvent(EventModel event){
        return eventRepository.save(event);
    }
    public Optional<EventModel> getEventById(int event_id) {
        return eventRepository.findById(event_id);
    }
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
}
