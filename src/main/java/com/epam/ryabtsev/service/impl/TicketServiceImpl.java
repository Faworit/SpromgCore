package com.epam.ryabtsev.service.impl;

import com.epam.ryabtsev.DAO.TicketDAO;
import com.epam.ryabtsev.DAO.storage.Storage;
import com.epam.ryabtsev.model.Event;
import com.epam.ryabtsev.model.Ticket;
import com.epam.ryabtsev.model.User;
import com.epam.ryabtsev.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

public class TicketServiceImpl implements TicketService {
    @Autowired
    private TicketDAO ticketDAO;
    private Storage ticketStorage;

    public TicketServiceImpl(TicketDAO ticketDAO, Storage ticketStorage) {
        this.ticketDAO = ticketDAO;
        this.ticketStorage = ticketStorage;
    }

    @Override
    public Ticket bookTicket(long userId, long eventId, int place, Ticket.Category category) {
        return ticketDAO.bookTicket(userId, eventId, place, category);
    }

    @Override
    public List<Ticket> getBookedTickets(User user, int pageSize, int pageNum) {
        return ticketDAO.getBookedTickets(user, pageSize, pageNum);
    }

    @Override
    public List<Ticket> getBookedTickets(Event event, int pageSize, int pageNum) {
        return ticketDAO.getBookedTickets(event, pageSize, pageNum);
    }

    @Override
    public boolean cancelTicket(long ticketId) {
        return ticketDAO.cancelTicket(ticketId);
    }
}
