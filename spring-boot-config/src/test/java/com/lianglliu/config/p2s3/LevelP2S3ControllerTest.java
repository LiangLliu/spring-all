package com.lianglliu.config.p2s3;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@SpringBootTest
@AutoConfigureMockMvc
class LevelControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void should_return_basic_when_level_number_less_1() throws Exception {
        String result = mockMvc.perform(get("/level/p2s3")).andReturn().getResponse().getContentAsString();
        assertEquals("basic", result);
    }

}

@ActiveProfiles("l1")
@SpringBootTest
@AutoConfigureMockMvc
class LevelIs1Test {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void should_return_advanced_when_level_is_1() throws Exception {
        String result = mockMvc.perform(get("/level/p2s3")).andReturn().getResponse().getContentAsString();
        assertEquals("advanced", result);
    }

}


@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("l5")
class LevelIs5Test {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void should_return_advanced_when_level_is_more_than_1() throws Exception {
        String result = mockMvc.perform(get("/level/p2s3")).andReturn().getResponse().getContentAsString();
        assertEquals("advanced", result);
    }

}