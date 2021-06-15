package com.alura.ProjetoAcelera.controller;

import java.net.URI;
import java.net.URISyntaxException;

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


@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@Transactional
public class BrandControllerTestIT {

    @Autowired
    private MockMvc mockMvc;

    private URI uri;
    private String json;

    public void initializeURI(String id) throws URISyntaxException {
        this.uri = new URI("/brands/".concat(id));
    }
    public void initializeContent(){
        this.json = "{\"name\":\"teste\"}";
    }

    @Test
    public void getAllBrandsWithoutParameterNameTest()
            throws Exception {
        initializeURI("");

        mockMvc
                .perform(MockMvcRequestBuilders
                        .get(uri))
                .andExpect(MockMvcResultMatchers
                        .status()
                        .is(200));
    }

    @Test
    public void getBrandTest()
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
    public void doesntGetBrandTest()
            throws Exception {
        initializeURI("100000");

        mockMvc
                .perform(MockMvcRequestBuilders
                        .get(uri))
                .andExpect(MockMvcResultMatchers
                        .status()
                        .is(404));
    }

    @Test
    public void registerBrandTest()
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
    public void updateBrandTest()
            throws Exception {
        initializeURI("3");
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
    public void doesntUpdateBrandTest()
            throws Exception {
        initializeURI("1000000000");
        initializeContent();

        mockMvc
                .perform(MockMvcRequestBuilders
                        .put(uri)
                        .content(json)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers
                        .status()
                        .is(404));
    }

    @Test
    public void deleteBrandTest()
            throws Exception {
        initializeURI("3");

        mockMvc
                .perform(MockMvcRequestBuilders
                        .delete(uri))
                .andExpect(MockMvcResultMatchers
                        .status()
                        .is(200));
    }

    @Test
    public void doesntDeleteBrandTest()
            throws Exception {
        initializeURI("10000000");

        mockMvc
                .perform(MockMvcRequestBuilders
                        .delete(uri))
                .andExpect(MockMvcResultMatchers
                        .status()
                        .is(404));
    }
}
