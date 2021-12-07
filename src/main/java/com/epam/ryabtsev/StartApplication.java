package com.epam.ryabtsev;

import com.epam.ryabtsev.facade.impl.BookingFacadeImpl;
import com.epam.ryabtsev.model.impl.UserImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class StartApplication {

    public static void main(String[] args) throws ParseException {

        AbstractApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        BookingFacadeImpl bookingFacade = (BookingFacadeImpl) context.getBean("bookingFacadeimpl");
        bookingFacade.createUser(new UserImpl(1, "test", "test"));
    }
}
