package com.thismichaelcodes.springboot.ManagerTests;

import com.thismichaelcodes.springboot.managers.SayHelloManager;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.Calendar;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SayHelloManagerTests {

    @Autowired
    private SayHelloManager sayHelloManager;

    @Test
    public void testGenerateGreeting(){
        Calendar c = Mockito.mock(Calendar.class);
        when(c.get(Calendar.HOUR_OF_DAY)).thenReturn(22);
        sayHelloManager.cal = c;

        String response = sayHelloManager.generateGreeting("tester");

        assertTrue(response.equals("Good Night TESTER!"));
    }

}
