package com.epam.ryabtsev.DAO.impl;

import com.epam.ryabtsev.DAO.EventDAO;
import com.epam.ryabtsev.model.Event;

import java.util.Date;
import java.util.List;

public class EventDAOImpl implements EventDAO {
    @Override
    public Event getEventById(long eventId) {
        return null;
    }

    @Override
    public List<Event> getEventsByTitle(String title, int pageSize, int pageNum) {
        return null;
    }

    @Override
    public List<Event> getEventsForDay(Date day, int pageSize, int pageNum) {
        return null;
    }

    @Override
    public Event createEvent(Event event) {
        return null;
    }

    @Override
    public Event updateEvent(Event event) {
        return null;
    }

    @Override
    public boolean deleteEvent(long eventId) {
        return false;
    }
}
