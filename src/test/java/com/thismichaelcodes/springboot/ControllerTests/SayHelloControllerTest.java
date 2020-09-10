package com.thismichaelcodes.springboot.ControllerTests;

import static org.hamcrest.Matchers.equalTo;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.thismichaelcodes.springboot.managers.SayHelloManager;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.mockito.Mockito.when;


import java.util.Calendar;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class SayHelloControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    SayHelloManager sayHelloManager;

    @Test
    public void getGreeting() throws Exception {
        // This test ensures that the controller returns exactly what comes back from the manager.
        String name = "Tester";
        when(sayHelloManager.generateGreeting(any())).thenReturn("Good Morning " + name.toUpperCase() + "!");

        mvc.perform(MockMvcRequestBuilders.get("/" + name).accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("Good Morning TESTER!")));
    }
}
