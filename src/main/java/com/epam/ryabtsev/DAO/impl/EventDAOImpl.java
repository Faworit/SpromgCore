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
    @Autowired
    Storage storage;


    private Map<Long, Event> events = storage.getEvents();

    @Override
    public Event getEventById(long eventId) {

        return events.get(eventId);
    }

    @Override
    public List<Event> getEventsByTitle(String title, int pageSize, int pageNum) {
        List<Event> event = events.entrySet()
                .stream()
                .map(Map.Entry::getValue)
                .filter(p-> p.getTitle().equals(title))
                .collect(Collectors.toList());
        System.out.println(event.get(0));
        return event;
    }

    @Override
    public List<Event> getEventsForDay(Date day, int pageSize, int pageNum) {
        List<Event> event = events.entrySet()
                .stream()
                .map(Map.Entry::getValue)
                .filter(p-> p.getDate().equals(day))
                .collect(Collectors.toList());
        System.out.println(event.get(0));

        return event;
    }

    @Override
    public Event createEvent(Event event) {
        long max = events.keySet().stream().max(Long::compareTo).orElse(0L);
        var key = max + 1;
        event.setId(key);
        events.put(key, event);
        return event;
    }

    @Override
    public Event updateEvent(Event event) {
        long key = event.getId();
        events.put(key, event);
        return event;
    }

    @Override
    public boolean deleteEvent(long eventId) {
        boolean deleteResult = false;
        events.remove(eventId);
        if (events.get(eventId) == null) {
            deleteResult = true;
        }

        return deleteResult;
    }
}
