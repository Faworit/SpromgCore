package com.epam.ryabtsev.DAO.impl;

import com.epam.ryabtsev.DAO.storage.Storage;
import com.epam.ryabtsev.model.Event;
import com.epam.ryabtsev.model.Ticket;
import com.epam.ryabtsev.model.User;
import com.epam.ryabtsev.model.impl.EventImpl;
import com.epam.ryabtsev.model.impl.TicketImpl;
import com.epam.ryabtsev.model.impl.UserImpl;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class StorageMock {


    /*@Override
    public void init() {
        this.users = new ConcurrentHashMap<>();
        this.events = new ConcurrentHashMap<>();
        this.tickets = new ConcurrentHashMap<>();
        this.users.put(1L, new UserImpl(1, "Ivan", "Ivan@mail.ru"));
        this.users.put(2L, new UserImpl(2, "Ivan2", "Ivan2@mail.ru"));
        this.users.put(3L, new UserImpl(3, "Ivan3", "Ivan3@mail.ru"));
        this.users.put(4L, new UserImpl(4, "Ivan4", "Ivan4@mail.ru"));
        this.events.put(1L, new EventImpl(1, "test", new Date()));
        this.events.put(2L, new EventImpl(2, "test2", new Date()));
        this.events.put(3L, new EventImpl(3, "test3", new Date()));
        this.events.put(4L, new EventImpl(4, "test4", new Date()));
        this.tickets.put(1L, new TicketImpl(1, 1, 1, Ticket.Category.STANDARD, 1));
        this.tickets.put(2L, new TicketImpl(2, 2, 2, Ticket.Category.STANDARD, 2));
        this.tickets.put(3L, new TicketImpl(3, 3, 3, Ticket.Category.STANDARD, 3));
        this.tickets.put(4L, new TicketImpl(4, 4, 4, Ticket.Category.STANDARD, 4));
    }*/

    public void fillEventStorage(Storage storage) {
        storage.setEvents(1L, new EventImpl(1, "test", new GregorianCalendar(2014, Calendar.FEBRUARY, 11).getTime()));
        storage.setEvents(2L, new EventImpl(2, "test2", new GregorianCalendar(2015, Calendar.FEBRUARY, 11).getTime()));
        storage.setEvents(3L, new EventImpl(3, "test3", new GregorianCalendar(2016, Calendar.FEBRUARY, 11).getTime()));
        storage.setEvents(4L, new EventImpl(4, "test4", new GregorianCalendar(2021, Calendar.FEBRUARY, 11).getTime()));
    }
}
