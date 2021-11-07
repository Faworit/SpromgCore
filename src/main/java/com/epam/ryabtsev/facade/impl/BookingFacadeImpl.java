package com.epam.ryabtsev.facade.impl;

import com.epam.ryabtsev.facade.BookingFacade;
import com.epam.ryabtsev.model.Event;
import com.epam.ryabtsev.model.Ticket;
import com.epam.ryabtsev.model.User;
import com.epam.ryabtsev.service.EventService;
import com.epam.ryabtsev.service.TicketService;
import com.epam.ryabtsev.service.UserService;
import com.epam.ryabtsev.service.impl.UserServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;
import java.util.List;

public class BookingFacadeImpl implements BookingFacade {
    private ApplicationContext applicationContext = new ClassPathXmlApplicationContext("ApplicationContext.xml");
    private UserService userService = applicationContext.getBean(UserServiceImpl.class);
    private EventService eventService;
    private TicketService ticketService;

    @Override
    public Event getEventById(long eventId) {
        Event event = eventService.getEventById(eventId);

        return event;
    }

    @Override
    public List<Event> getEventsByTitle(String title, int pageSize, int pageNum) {
        List<Event> events = eventService.getEventsByTitle(title, pageSize, pageNum);
        return events;
    }

    @Override
    public List<Event> getEventsForDay(Date day, int pageSize, int pageNum) {
        List<Event> events = eventService.getEventsForDay(day, pageSize, pageNum);

        return events;
    }

    @Override
    public Event createEvent(Event event) {
        Event createdEvent = eventService.createEvent(event);
        return createdEvent;
    }

    @Override
    public Event updateEvent(Event event) {
        Event updatedEvent = eventService.updateEvent(event);

        return updatedEvent;
    }

    @Override
    public boolean deleteEvent(long eventId) {
        boolean result = eventService.deleteEvent(eventId);

        return result;
    }

    @Override
    public User getUserById(long userId) {
        User user = userService.getUserById(userId);

        return user;
    }

    @Override
    public User getUserByEmail(String email) {
        User user = userService.getUserByEmail(email);

        return user;
    }

    @Override
    public List<User> getUsersByName(String name, int pageSize, int pageNum) {
        List<User> users = userService.getUsersByName(name, pageSize, pageNum);

        return users;
    }

    @Override
    public User createUser(User user) {
        User createdUser = userService.createUser(user);

        return createdUser;
    }

    @Override
    public User updateUser(User user) {
        User updatedUser = userService.updateUser(user);

        return updatedUser;
    }

    @Override
    public boolean deleteUser(long userId) {
        boolean result = userService.deleteUser(userId);

        return result;
    }

    @Override
    public Ticket bookTicket(long userId, long eventId, int place, Ticket.Category category) {
        Ticket ticket = ticketService.bookTicket(userId, eventId, place, category);

        return ticket;
    }

    @Override
    public List<Ticket> getBookedTickets(User user, int pageSize, int pageNum) {
        List<Ticket> bookedTickets = ticketService.getBookedTickets(user, pageSize, pageNum);

        return bookedTickets;
    }

    @Override
    public List<Ticket> getBookedTickets(Event event, int pageSize, int pageNum) {
        List<Ticket> bookedTickets = ticketService.getBookedTickets(event, pageSize, pageNum);

        return bookedTickets;
    }

    @Override
    public boolean cancelTicket(long ticketId) {
        boolean result = ticketService.cancelTicket(ticketId);

        return result;
    }
}
