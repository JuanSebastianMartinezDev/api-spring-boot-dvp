package com.dvp.pruebaapispringboot.controllers;

import com.dvp.pruebaapispringboot.models.Ticket;
import com.dvp.pruebaapispringboot.services.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.Optional;

@RestController
@RequestMapping("/ticket")
public class TicketController {
    @Autowired
    TicketService tickerService;

    @GetMapping()
    public ArrayList<Ticket> getTickets(){
        return tickerService.getTickets();
    }

    @GetMapping( path = "/{id}")
    public Optional<Ticket> getTicketById(@PathVariable("id") Long id){
        return tickerService.getTicketById(id);
    }

    @PostMapping()
    public Ticket saveTicket(@RequestBody Ticket ticket){
        var created_at= ticket.getCreated_at();
        if(created_at==null){
            ticket.setCreated_at(new Date());
        }
        return tickerService.saveTicket(ticket);
    }

    @PostMapping(path = "/{id}")
    public String updateTicket(@RequestBody Ticket ticket,@PathVariable("id") Long id){
        var updated_at = ticket.getUpdated_at();
        if(updated_at == null){
            ticket.setUpdated_at(new Date());
        }
        Optional<Ticket> ticket_exist=tickerService.getTicketById(id);
        if(ticket_exist != null){
            boolean ok=tickerService.updateTicket(ticket);
            if(ok){
                return "Ticket actualizado con exito";
            }
        }else{
            return "No existe ticket por ID: "+id;
        }

        return "No se pudo actualizar el ticket";
    }

    @DeleteMapping( path = "/{id}")
    public String deleteTicketById(@PathVariable("id") Long id){
        boolean ok=this.tickerService.deleteTicket(id);
        if(ok){
            return "Se elimino correctamente el ticket";
        }else{
            return "Ups, el ticket con el id: "+id+" no pudo ser eliminado";
        }
    }

}
