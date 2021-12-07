package com.epam.ryabtsev.DAO.impl;

import com.epam.ryabtsev.DAO.TicketDAO;
import com.epam.ryabtsev.DAO.storage.Storage;
import com.epam.ryabtsev.model.Event;
import com.epam.ryabtsev.model.Ticket;
import com.epam.ryabtsev.model.User;
import com.epam.ryabtsev.model.impl.TicketImpl;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TicketDAOImpl implements TicketDAO {
    private Storage storage;

    public TicketDAOImpl(Storage storage) {
        this.storage = storage;
    }

    @Override
    public Ticket bookTicket(long userId, long eventId, int place, Ticket.Category category) {
        return storage.bookTicket(userId, eventId, place, category);
    }

    @Override
    public List<Ticket> getBookedTickets(User user, int pageSize, int pageNum) {
        return storage.getBookedTickets(user, pageSize, pageNum);
    }

    @Override
    public List<Ticket> getBookedTickets(Event event, int pageSize, int pageNum) {
        return storage.getBookedTickets(event, pageSize, pageNum);
    }

    @Override
    public boolean cancelTicket(long ticketId) {
        return storage.cancelTicket(ticketId);
    }
}
