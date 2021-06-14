package com.alura.ProjetoAcelera.controller;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import javax.transaction.Transactional;
import java.net.URI;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@Transactional
public class UserControllerTestIT
{
        @Autowired
        private MockMvc mockMvc;
        @Test
        public void getAllUsersTest()
                throws Exception {
            URI uri = new URI("/users");

            mockMvc
                    .perform(MockMvcRequestBuilders
                            .get(uri))
                    .andExpect(MockMvcResultMatchers
                            .status()
                            .is(200));
        }

       @Test
        public void getUserTes()
                throws Exception {
            URI uri = new URI("/users/1");

            mockMvc
                    .perform(MockMvcRequestBuilders
                            .get(uri))
                    .andExpect(MockMvcResultMatchers
                            .status()
                            .is(200));
        }

       @Test
        public void registerUserTest()
                throws Exception {
            URI uri = new URI("/users");
            String json = "{\"name\":\"teste\",\"password\":\"12345\"}";

            mockMvc
                    .perform(MockMvcRequestBuilders
                            .post(uri)
                            .content(json)
                            .contentType(MediaType.APPLICATION_JSON))
                    .andExpect(MockMvcResultMatchers
                            .status()
                            .is(201));

        }

        @Test
        public void updateUserTest()
                throws Exception {
            URI uri = new URI("/users/1");
            String json = "{\"name\":\"teste\",\"password\":\"12345\"}";

            mockMvc
                    .perform(MockMvcRequestBuilders
                            .put(uri)
                            .content(json)
                            .contentType(MediaType.APPLICATION_JSON))
                    .andExpect(MockMvcResultMatchers
                            .status()
                            .is(200));
        }

        @Test
        public void deleteUserTest()
                throws Exception {
            URI uri = new URI("/users/1");

            mockMvc
                    .perform(MockMvcRequestBuilders
                            .delete(uri))
                    .andExpect(MockMvcResultMatchers
                            .status()
                            .is(200));
        }
}