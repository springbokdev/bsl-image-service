package space.springbok.bslimageservice.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import space.springbok.bslimageservice.service.ImageService;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
class ImageControllerIT {

    @Autowired
    ImageController imageController;

    @Autowired
    WebApplicationContext wac;

    MockMvc mockMvc;
    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(wac)
                .build();
    }

    @Disabled
    @Test
    void testShow() throws Exception {

        mockMvc.perform(get("/image/show/thumbnail")
                        .queryParam("reference", "abcd.jpg"))
                .andExpect(status().isOk());
    }

    @Disabled
    @Test
    void testShowReferenceDoesNotExist() throws Exception {

        mockMvc.perform(get("/image/show/thumbnail")
                        .queryParam("reference", "bla-bla-abcd.jpg"))
                .andExpect(status().isNotFound());
    }



}