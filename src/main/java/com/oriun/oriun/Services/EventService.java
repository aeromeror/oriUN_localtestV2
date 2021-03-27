package com.oriun.oriun.Services;
import java.util.ArrayList;

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
}
