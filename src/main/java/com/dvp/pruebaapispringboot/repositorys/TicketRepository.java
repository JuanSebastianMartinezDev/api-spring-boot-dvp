package com.dvp.pruebaapispringboot.repositorys;

import com.dvp.pruebaapispringboot.models.Ticket;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TicketRepository extends CrudRepository<Ticket, Long> {

}
