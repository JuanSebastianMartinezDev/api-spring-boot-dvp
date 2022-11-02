package com.dvp.pruebaapispringboot.services;

import com.dvp.pruebaapispringboot.models.Ticket;
import com.dvp.pruebaapispringboot.repositorys.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class TicketService {
    @Autowired
    TicketRepository ticketRepository;


    public ArrayList<Ticket> getTickets(){
        return (ArrayList<Ticket>) ticketRepository.findAll();
    }

    public Optional<Ticket> getTicketById(Long id){
        return  ticketRepository.findById(id);
    }
    public Ticket saveTicket(Ticket ticket){
        return ticketRepository.save(ticket);
    }

    public boolean updateTicket(Ticket ticket){
        try{
            ticketRepository.save(ticket);
            return true;
        }catch (Exception error){
            return false;
        }
    }
    public boolean deleteTicket(Long id){
        try{
            ticketRepository.deleteById(id);
            return true;
        }catch (Exception error){
            return false;
        }
    }
}
