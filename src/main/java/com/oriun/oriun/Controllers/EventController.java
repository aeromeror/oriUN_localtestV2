package com.oriun.oriun.Controllers;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.oriun.oriun.Models.EventModel;
import com.oriun.oriun.Models.User_eventModel;
import com.oriun.oriun.Services.EventService;
import com.oriun.oriun.Services.User_eventService;
@RestController
//@RequestMapping("/sports")
public class EventController {
    @Autowired
    EventService eventService;
    @Autowired
    User_eventService user_eventService;
    @GetMapping("/events")
    public ArrayList<EventModel> obtenerEventos(){
        return eventService.getEvents();
    }
    
    @PostMapping("/event")
    public EventModel guardarevento(@RequestBody EventModel event){
        User_eventModel asistencia= new User_eventModel();
        EventModel ev= eventService.saveEvent(event);
        asistencia.setID_EVENT(event.getID_EVENT());
        asistencia.setUSER_NAME(event.getUSER_NAME());
        user_eventService.saveUser_event(asistencia);
        return ev;
    }

    @GetMapping("/userevents")
    public ArrayList<EventModel> obtenerEventosporusuario(@RequestParam("user") String user_name){
        List< User_eventModel> events = user_eventService.getUser_event(user_name);
        ArrayList<EventModel> userevents=new ArrayList<EventModel>();
        for(int c=0;c<events.size();c++){
            int numevent=events.get(c).getID_EVENT();
            Optional<EventModel> event=eventService.getEventById(numevent);
            userevents.add(event.get());
        }
        return userevents;
    }
    //falta borrar las notificaciones que crea el evento
    @DeleteMapping("/event")
    public EventModel borrarevento(@RequestParam("event") int event_id){
        ArrayList<User_eventModel> usev=user_eventService.getallUser_events();
        for(int c=0;c<usev.size();c++){
            User_eventModel ev=usev.get(c);
            if(ev.getID_EVENT()==event_id){
                user_eventService.deleteUserEvent(ev);
            }
        }
        Optional<EventModel> ev = eventService.getEventById(event_id);
        if(ev.isPresent()){
            eventService.deleteEvent(ev.get());
            return ev.get();
        }else{
            return null;
        }
    }
}