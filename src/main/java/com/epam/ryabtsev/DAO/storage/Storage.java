package com.epam.ryabtsev.DAO.storage;

import com.epam.ryabtsev.model.Event;
import com.epam.ryabtsev.model.Ticket;
import com.epam.ryabtsev.model.User;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@Scope("singleton")
public class Storage {

    private Map<Long, User> users;
    private Map<Long, Event> events;
    private Map<Long, Ticket> tickets;

    public Map<Long, User> getUsers() {
        return users;
    }

    public void setUsers(User user, Long id) {
        this.users.put(id, user);
    }

    public Map<Long, Event> getEvents() {
        return events;
    }

    public void setEvents(Long id, Event event) {
        this.events.put(id, event);
    }

    public Map<Long, Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(Long id, Ticket ticket) {
        this.tickets.put(id, ticket);
    }
}
