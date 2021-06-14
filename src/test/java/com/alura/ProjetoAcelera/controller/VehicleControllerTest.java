package com.alura.ProjetoAcelera.controller;

import java.net.URI;

import javax.transaction.Transactional;

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


@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@Transactional
public class VehicleControllerTest {

	  @Autowired
      private MockMvc mockMvc;
      @Test
      public void getAllVehicleTest()
              throws Exception {
          URI uri = new URI("/vehicle");

          mockMvc
                  .perform(MockMvcRequestBuilders
                          .get(uri))
                  .andExpect(MockMvcResultMatchers
                          .status()
                          .is(200));
      }
      
     @Test
      public void getVehicleTest()
              throws Exception {
          URI uri = new URI("/vehicle/1");

          mockMvc
                  .perform(MockMvcRequestBuilders
                          .get(uri))
                  .andExpect(MockMvcResultMatchers
                          .status()
                          .is(200));
      }

     @Test
      public void registerVehicleTest()
              throws Exception {
          URI uri = new URI("/vehicle");
          String json = "{ \"idVehicle\":20 , \"nameBrand\":\"marca 1\", \"model\":\"teste\",\"years\":2020 ,\"price\":10000 }";

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
      public void updateVehicleTest()
              throws Exception {
          URI uri = new URI("/vehicle/1");
          String json = "{ \"nameBrand\":\"teste\",  \"model\":\"teste\",\"years\":2020 ,\"price\": 10000 }";

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
      public void deleteVehicleTest()
              throws Exception {
          URI uri = new URI("/vehicle/1");

          mockMvc
                  .perform(MockMvcRequestBuilders
                          .delete(uri))
                  .andExpect(MockMvcResultMatchers
                          .status()
                          .is(200));
      }
}
