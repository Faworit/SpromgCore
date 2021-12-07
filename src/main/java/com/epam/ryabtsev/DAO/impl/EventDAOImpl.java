package com.epam.ryabtsev.DAO.impl;

import com.epam.ryabtsev.DAO.EventDAO;
import com.epam.ryabtsev.DAO.storage.Storage;
import com.epam.ryabtsev.model.Event;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class EventDAOImpl implements EventDAO {

    private Storage storage;

    public EventDAOImpl(Storage storage) {
        this.storage = storage;
    }

    @Override
    public Event getEventById(long eventId) {
        return storage.getEventById(eventId);
    }

    @Override
    public List<Event> getEventsByTitle(String title, int pageSize, int pageNum) {
        return storage.getEventsByTitle(title, pageSize, pageNum);
    }

    @Override
    public List<Event> getEventsForDay(Date day, int pageSize, int pageNum) {
        return storage.getEventsForDay(day, pageSize, pageNum);
    }

    @Override
    public Event createEvent(Event event) {
        return storage.createEvent(event);
    }

    @Override
    public Event updateEvent(Event event) {
        return storage.updateEvent(event);
    }

    @Override
    public boolean deleteEvent(long eventId) {
        return storage.deleteEvent(eventId);
    }
}
