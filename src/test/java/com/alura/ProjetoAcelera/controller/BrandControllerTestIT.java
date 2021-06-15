package com.alura.ProjetoAcelera.controller;

import java.net.URI;

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

    @Test
    public void getAllBrandsWithoutParameterNameTest()
            throws Exception {
        URI uri = new URI("/brands");

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
        URI uri = new URI("/brands/1");

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
        URI uri = new URI("/brands/100000");

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
        URI uri = new URI("/brands");
        String json = "{\"name\":\"teste\"}";

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
        URI uri = new URI("/brands/3");
        String json = "{\"name\":\"teste\"}";

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
        URI uri = new URI("/brands/1000000");
        String json = "{\"name\":\"teste\"}";

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
        URI uri = new URI("/brands/3");

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
        URI uri = new URI("/brands/100000");

        mockMvc
                .perform(MockMvcRequestBuilders
                        .delete(uri))
                .andExpect(MockMvcResultMatchers
                        .status()
                        .is(404));
    }
}
