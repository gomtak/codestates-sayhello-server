package com.codestateswebflux.controller;

import com.codestateswebflux.entity.Chats;
import com.codestateswebflux.service.WebfluxService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.servlet.mvc.Controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@ExtendWith(SpringExtension.class)
@AutoConfigureMockMvc
class WebfluxControllerTest {

    @Autowired
    MockMvc mockMvc;

    /**
     * * (Request)
     * GET localhost:8080/hello?name=$name
     **/
    @Test
    void 웹플럭스겟테스트() throws Exception {
        mockMvc.perform(get("/api/chats"))
                .andExpect(status().isOk())
                .andDo(print());
    }
    /**
     * (Response)
     * application/json
     * {"to":$name,"message":"hello":$name"}
     **/
}