package com.thismichaelcodes.springboot.managers;

import org.springframework.stereotype.Component;
import java.util.Calendar;

@Component
public class SayHelloManager {
    public Calendar cal = Calendar.getInstance();

    public String generateGreeting(String name) {
        int hour = cal.get(Calendar.HOUR_OF_DAY);
        String greeting = "Good Morning ";

        if(hour > 19){
            greeting = "Good Night ";
        }
        else if (hour > 12) {
            greeting = "Good Afternoon ";
        }

        return greeting + name.toUpperCase() + "!";
    }
}
