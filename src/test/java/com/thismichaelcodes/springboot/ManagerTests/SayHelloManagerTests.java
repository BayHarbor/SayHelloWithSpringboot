package com.thismichaelcodes.springboot.ManagerTests;

import com.thismichaelcodes.springboot.managers.SayHelloManager;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SayHelloManagerTests {
    @Autowired
    SayHelloManager sayHelloManager;

    @Test
    public void testGenerateGreeting(){
//        Calendar c = Mockito.mock(Calendar.class);
//        when(c.get(Calendar.HOUR_OF_DAY)).thenReturn(2);

        String response = sayHelloManager.generateGreeting("tester");

        assertTrue(response.startsWith("Good "));
        assertTrue(response.endsWith("TESTER!"));
    }

}
