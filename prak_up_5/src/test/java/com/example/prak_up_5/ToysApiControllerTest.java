package com.example.prak_up_5;


import com.example.prak_up_5.controller.ToyApiController;
import com.example.prak_up_5.model.ToyModel;
import com.example.prak_up_5.service.ToyService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@WebMvcTest(ToyApiController.class)
public class ToysApiControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ToyService toyService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testCreateToy() throws Exception {
        // Создаем модель игрушки
        ToyModel toy = new ToyModel();
        toy.setId(4L);
        toy.setName("Машинка");
        toy.setDescription("Машинка на пульте управления");
        toy.setPrice(543.0);
        toy.setCategory("Игрушки");

        // Мокаем вызов сервиса для создания игрушки
        when(toyService.createToy(any(ToyModel.class))).thenReturn(toy);

        // Исправляем запрос с корректными данными для игрушки
        mockMvc.perform(post("/v1/api/toys")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"name\":\"Машинка\",\"description\":\"Машинка на пульте управления\",\"price\":543.0,\"category\":\"Игрушки\"}"))
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("$.name").value("Машинка"))
                .andExpect(jsonPath("$.description").value("Машинка на пульте управления"))
                .andExpect(jsonPath("$.price").value(543.0))
                .andExpect(jsonPath("$.category").value("Игрушки"));
    }
}
