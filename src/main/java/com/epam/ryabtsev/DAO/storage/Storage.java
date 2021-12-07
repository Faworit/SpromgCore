package com.epam.ryabtsev.DAO.storage;

import com.epam.ryabtsev.model.Event;
import com.epam.ryabtsev.model.Ticket;
import com.epam.ryabtsev.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Storage {
    @Autowired
    private Map<Long, User> users;
    @Autowired
    private Map<Long, Event> events;
    @Autowired
    private Map<Long, Ticket> tickets;

    public Storage(Map<Long, User> users, Map<Long, Event> events, Map<Long, Ticket> tickets) {
        this.users = users;
        this.events = events;
        this.tickets = tickets;
    }

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
