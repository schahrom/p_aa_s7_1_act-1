package app.services;

import app.entities.Flight;
import app.entities.Ticket;
import app.repositories.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Class TicketServiceImpl with CRUD methods for Ticket
 *
 * @author Darya Shonoeva
 */

@Service
public class TicketServiceImpl implements TicketService {


    private final TicketRepository ticketRepository;

    private final FlightRepository flightRepository;

    @Autowired
    public TicketServiceImpl(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    @Override
    public void saveTicket(Ticket ticket) {

        ticketRepository.save(ticket);
    }

    @Override
    public List<Ticket> getAllTickets() {

        return ticketRepository.findAll();
    }

    @Override
    public Ticket getTicket(Long id) {

        return ticketRepository.getById(id);
    }

    @Override
    public void deleteTicket(Long id) {

        ticketRepository.deleteById(id);
    }

    @Override
    public void editTicket(Ticket ticket) {

        ticketRepository.save(ticket);
    }

    @Override
    public void deleteAllTickets() {

        ticketRepository.deleteAll();
    }

    @Override
    public List<Ticket> findAllTicketsByFlightId(Long id) {

        Flight flight = flightRepository.getById(id);
        return ticketRepository.findAllTicketByFlight(flight);
    }
}
