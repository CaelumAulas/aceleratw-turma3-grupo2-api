package com.alura.ProjetoAcelera.controller;

import java.net.URI;
import java.net.URISyntaxException;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;


@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@Transactional
@ActiveProfiles("test")
public class VehicleControllerTest {

	  @Autowired
      private MockMvc mockMvc;

    private URI uri;
    private String json;

    public void initializeURI(String id) throws URISyntaxException {
        this.uri = new URI("/vehicle/".concat(id));
    }
    public void initializeContent(){
        this.json =  "{ \"idVehicle\":20 , \"nameBrand\":\"Volkswagen\", \"model\":\"teste\",\"years\":2020 ,\"price\":10000.00 }";
    }



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
         initializeURI("1");

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

         initializeURI("");
         initializeContent();
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

          initializeURI("1");
          initializeContent();

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

          initializeURI("1");
          mockMvc
                  .perform(MockMvcRequestBuilders
                          .delete(uri))
                  .andExpect(MockMvcResultMatchers
                          .status()
                          .is(200));
      }
}
