package com.epam.ryabtsev.DAO.storage;

import com.epam.ryabtsev.model.Event;
import com.epam.ryabtsev.model.Ticket;
import com.epam.ryabtsev.model.User;
import com.epam.ryabtsev.model.impl.TicketImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

public class Storage {

    private Map<Long, User> users = new HashMap<>();

    private Map<Long, Event> events = new HashMap<>();

    private Map<Long, Ticket> tickets = new HashMap<>();

    public Storage() {

    }

    public User getUserById(long userId) {
        return users.get(userId);
    }

    public User getUserByEmail(String email) {
        List<User> user = users.entrySet()
                .stream()
                .map(Map.Entry::getValue)
                .filter(((p)-> p.getEmail().equals(email)))
                .collect(Collectors.toList());
        System.out.println(user.get(0));
        return user.get(0);
    }

    public List<User> getUsersByName(String name, int pageSize, int pageNum) {
        List<User> user = users.entrySet()
                .stream()
                .map(Map.Entry::getValue)
                .filter(((p)-> p.getName().equals(name)))
                .collect(Collectors.toList());
        System.out.println(user.get(0));
        return user;
    }

    public User createUser(User user) {
        long max = users.keySet().stream().max(Long::compareTo).orElse(0L);
        var key = max + 1;
        user.setId(key);
        users.put(key, user);
        return user;
    }

    public User updateUser(User user) {
        long key = user.getId();
        users.put(key, user);
        return user;
    }

    public boolean deleteUser(long userId) {
        boolean deleteResult = false;
        users.remove(userId);
        if (users.get(userId) == null) {
            deleteResult = true;
        }

        return deleteResult;
    }

    public Event getEventById(long eventId) {
        return events.get(eventId);
    }

    public List<Event> getEventsByTitle(String title, int pageSize, int pageNum) {
        List<Event> event = events.entrySet()
                .stream()
                .map(Map.Entry::getValue)
                .filter(p-> p.getTitle().equals(title))
                .collect(Collectors.toList());
        System.out.println(event.get(0));
        return event;
    }

    public List<Event> getEventsForDay(Date day, int pageSize, int pageNum) {
        List<Event> event = events.entrySet()
                .stream()
                .map(Map.Entry::getValue)
                .filter(p-> p.getDate().equals(day))
                .collect(Collectors.toList());
        System.out.println(event.get(0));

        return event;
    }

    public Event createEvent(Event event) {
        long max = events.keySet().stream().max(Long::compareTo).orElse(0L);
        var key = max + 1;
        event.setId(key);
        events.put(key, event);
        return event;
    }


    public Event updateEvent(Event event) {
        long key = event.getId();
        events.put(key, event);
        return event;
    }

    public boolean deleteEvent(long eventId) {
        boolean deleteResult = false;
        events.remove(eventId);
        if (events.get(eventId) == null) {
            deleteResult = true;
        }

        return deleteResult;
    }

    public Ticket bookTicket(long userId, long eventId, int place, Ticket.Category category) {
        long max = tickets.keySet().stream().max(Long::compareTo).orElse(0L);
        var key = max + 1;
        Ticket ticket = new TicketImpl(key, eventId, userId, category, place);
        tickets.put(key, ticket);

        return ticket;
    }

    public List<Ticket> getBookedTickets(User user, int pageSize, int pageNum) {
        List<Ticket> ticket = tickets.entrySet()
                .stream()
                .map(Map.Entry::getValue)
                .filter(p-> p.getUserId() == user.getId())
                .collect(Collectors.toList());
        System.out.println(ticket.get(0));
        return ticket;
    }

    public List<Ticket> getBookedTickets(Event event, int pageSize, int pageNum) {
        List<Ticket> ticket = tickets.entrySet()
                .stream()
                .map(Map.Entry::getValue)
                .filter(p-> p.getEventId() == event.getId())
                .collect(Collectors.toList());
        System.out.println(ticket.get(0));
        return ticket;
    }

    public boolean cancelTicket(long ticketId) {
        boolean deleteResult = false;
        tickets.remove(ticketId);
        if (tickets.get(ticketId) == null) {
            deleteResult = true;
        }

        return deleteResult;
    }
}
