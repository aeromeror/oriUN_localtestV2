package com.oriun.oriun.Controllers;
import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;

import com.oriun.oriun.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import com.oriun.oriun.Models.EventModel;
import com.oriun.oriun.Models.NotificationModel;
import com.oriun.oriun.Models.SportModel;
import com.oriun.oriun.Models.User_eventModel;
import com.oriun.oriun.Services.EventService;
import com.oriun.oriun.Services.NotificationService;
import com.oriun.oriun.Services.SportService;
import com.oriun.oriun.Services.User_eventService;
@RestController
//@RequestMapping("/sports")
public class EventController {
    @Autowired
    EventService eventService;
    @Autowired
    User_eventService user_eventService;
    @Autowired
    NotificationService notificationService;
    @Autowired
    UserService userService;

    @GetMapping("/eventsall")
    public ArrayList<EventModel> obtenerallEventos(){
        return eventService.getEvents();
    }

    @GetMapping("/events")
    public ArrayList<EventModel> obtenerEventosVigentes(@RequestParam("init") int init,@RequestParam("size")int size){
        /*java.util.Date d1 = new java.util.Date();
        java.sql.Date sqlDate = new java.sql.Date(d1.getTime());
        ArrayList<EventModel> ev=eventService.getEvents();
        EventModel etemp=new EventModel();
        for (int i = 0; i < ev.size(); i++) {
            etemp=ev.get(i);
            //if(etemp.getEVENT_FINISH_HOUR().before(sqlDate)){
            //    borrarevento(etemp.getID_EVENT());
            //    ev.remove(i);
            //    i--;
            //}
            //else
            if(etemp.getEVENT_INIT().before(sqlDate)){
                ev.remove(i);
                //System.out.println("Evento ya iniciado: "+etemp.getEVENT_TITLE());
                i--;
            }
        }
        return ev;*/
        return eventService.getEventVigentes(init, size);
    }
    @GetMapping("/nevents")
    public long nEventos(){
        return eventService.Nevents();
    }
    @PostMapping("/event")
    public EventModel guardarevento(@RequestBody EventModel event){
        if(eventService.Eventovalido(event.getNAME_SPORT(),event.getUSER_NAME(),event.getNAME_LOC_SPORT())){
            if(event.getEVENT_DESCRIPTION()!=null && event.getEVENT_TITLE()!=null  && event.getEVENT_INIT()!=null  && event.getEVENT_END()!=null  && event.getEVENT_INIT_HOUR()!=null && event.getEVENT_FINISH_HOUR()!=null){
                java.util.Date d1 = new java.util.Date();
                java.sql.Date sqlDate = new java.sql.Date(d1.getTime());
                event.setCREATION_DATE(sqlDate);
                System.out.println(sqlDate);
                User_eventModel asistencia= new User_eventModel();
                EventModel ev= eventService.saveEvent(event);
                asistencia.setID_EVENT(ev.getID_EVENT());
                asistencia.setUSER_NAME(ev.getUSER_NAME());
                user_eventService.saveUser_event(asistencia);
                NotificationModel notification = new NotificationModel();
                notification.setNAME_SPORT(ev.getNAME_SPORT());
                notification.setID_EVENT(ev.getID_EVENT());
                notification.setNOTIFICATION_DATE(ev.getEVENT_INIT());
                notification.setTIME_NOTIFICATION(ev.getEVENT_INIT_HOUR());
                notification.setEXPIRATION_TIME(ev.getEVENT_FINISH_HOUR());
                notification.setNOTIFICATION_DESCRIPTION("A brand new event is coming : "+ev.getEVENT_TITLE());
                notificationService.saveNotification(notification);
                return ev;
            }
        }
        return null;
    }
    @PutMapping("/updevent")
    public ResponseEntity actualizarevento(@RequestBody EventModel event){
        if(event.getID_EVENT()!=null && event.getNAME_SPORT()!=null && event.getNAME_LOC_SPORT()!=null && event.getEVENT_DESCRIPTION()!=null && event.getEVENT_TITLE()!=null  && event.getEVENT_INIT()!=null  && event.getEVENT_END()!=null  && event.getEVENT_INIT_HOUR()!=null && event.getEVENT_FINISH_HOUR()!=null){
            return eventService.updateEvent(event);
        }
        return new ResponseEntity<>("Rellene todos los campos obligatorios",
                HttpStatus.BAD_REQUEST );
    }

    /*@GetMapping("/userevents")
    public ArrayList<EventModel> obtenerEventosporusuario(@RequestParam("user") String user_name){
        List< User_eventModel> events = user_eventService.getUser_event(user_name);
        ArrayList<EventModel> userevents=new ArrayList<EventModel>();
        for(int c=0;c<events.size();c++){
            int numevent=events.get(c).getID_EVENT();
            Optional<EventModel> event=eventService.getEventById(numevent);
            userevents.add(event.get());
        }
        return userevents;
    }*/

    @GetMapping("/dateevents")
    public List<Object> obtenerEventosFecha(@RequestParam("date") Date date){
        List< Object> userevents = eventService.getDateEvents(date);
        return userevents;
    }

    @GetMapping("/weekevents")
    public List<Object> obtenerEventosSemana(@RequestParam("date") Date date){
        int days = 4;
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.DATE, days);
        java.sql.Date weekDate = new Date(c.getTimeInMillis());
        List< Object> userevents = eventService.getWeekEvents(date,weekDate);
        return userevents;
    }

    @GetMapping("/userevents")
    public List<EventModel> obtenerEventosUsuario(@RequestParam("user") String user_name){
        List< EventModel> userevents = eventService.getUserEvents(user_name);
        return userevents;
    }

    @GetMapping("/others")
    public List<EventModel> obtenerOthers(){
        return eventService.getOtherEvents();
    }

    @GetMapping("/otherscount")
    public List<Object[]> obtenerOthersCount(){
        //ArrayList<SportModel> sports = sportService.getSports();
        //List<Object[]> othersports=eventService.getOtherSportsCount();
        return eventService.getOtherSportsCount();
    }
    @GetMapping("/othersports")
    public List<String> obtenerOtherSports(){
        return eventService.getOtherSports();
    }
    //Borrar llamado ya existe con una mejor implementacion↓
    /*@DeleteMapping("/event")
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
    }*/
    @PostMapping("/asistirevent")
    public ResponseEntity asistirevento(@RequestParam("id_user") String username,@RequestParam("id_event") int id_eve){
        if(eventService.existEvent(id_eve) && userService.existUser(username)){
            User_eventModel asistencia= new User_eventModel();
            Optional<EventModel> oem=eventService.getEventById(id_eve);
            double ec=oem.get().getCAPACITY();
            double len_asis_event=user_eventService.getUser_eventbyEvent(id_eve).size();
            if(len_asis_event<ec && !user_eventService.UserinEvent(id_eve,username)){
                asistencia.setID_EVENT(id_eve);
                asistencia.setUSER_NAME(username);
                user_eventService.saveUser_event(asistencia);
                return new ResponseEntity<>(username+" ahora asiste a "+oem.get().getEVENT_TITLE(),
                        HttpStatus.OK );
            }
            return new ResponseEntity<>("Limite de asistencia",
                    HttpStatus.INSUFFICIENT_STORAGE );
        }
        return new ResponseEntity<>("Usuario o evento no existentes",
                HttpStatus.BAD_REQUEST );
    }
    @DeleteMapping("/LeaveEvent")
    public ResponseEntity abandonarevento(@RequestParam("id_user") String username, @RequestParam("id_event") int id_eve){
        if(eventService.existEvent(id_eve) && userService.existUser(username)){
            if(user_eventService.UserinEvent(id_eve,username)){
                if(!eventService.creadorevento(id_eve).equals(username)){
                    User_eventModel asistencia= new User_eventModel();
                    asistencia.setID_EVENT(id_eve);
                    asistencia.setUSER_NAME(username);
                    return user_eventService.deleteUserEvent(asistencia);
                }
                else{
                    return new ResponseEntity<>("El creador("+eventService.creadorevento(id_eve)+") no puede abandonar el evento",
                            HttpStatus.BAD_REQUEST );
                }
            }
            else{
                return new ResponseEntity<>("Usuario no se encuentra en el evento",
                        HttpStatus.I_AM_A_TEAPOT );
            }
        }
        return new ResponseEntity<>("Evento o Usuario inexistentes",
                HttpStatus.NOT_FOUND );
    }
    @DeleteMapping("/NoEvent")
    public void borrarEvento(@RequestParam("id_event") int id_event){
        eventService.adiosEvent(id_event);
    }
    @GetMapping("/simievent")
    public ResponseEntity simievento(@RequestParam("location") String loc,@RequestParam("sport") String sport,@RequestParam("datei") Date datei,@RequestParam("timei") Time timei,@RequestParam("datee") Date datee,@RequestParam("timee") Time timee){
        if(eventService.EventosSimi(loc,sport,datei,timei,datee,timee))return new ResponseEntity<>("Evento sin conflictos",
                HttpStatus.OK );
        else return new ResponseEntity<>("Ya hay uno o mas eventos del mismo deporte, en la misma ubicacion, a la misma hora y dia indicado",
                HttpStatus.CONFLICT );
    }

}