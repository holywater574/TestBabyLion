package com.springboot.babylion.controller;

import com.google.gson.Gson;
import com.springboot.babylion.data.dto.BabyLionDto;
import com.springboot.babylion.data.dto.response.ResponseBabyLionDto;
import com.springboot.babylion.service.impl.BabyLionServiceImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(BabyLionController.class)
class ProductControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    BabyLionServiceImpl productService;

    @Test
    @DisplayName("MockMvc를 통한 Product 데이터 가져오기 테스트")
    void getProductTest() throws Exception {
        given(productService.getBabyLion("test@example.com")).willReturn(
                new ResponseBabyLionDto(null, "pen","test@example.com", "010-1234-5678","cos1234","good"));

        String productId = "123";

        mockMvc.perform( //mocMvc: 컨트롤러의 API를 테스트하기 위해 사용된 객체
                        get("/product?number=" + productId))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.pid").exists())
                .andExpect(jsonPath(
                        "$.number").exists()) // json path의 depth가 깊어지면 .을 추가하여 탐색할 수 있음 (ex : $.productId.productIdName)
                .andExpect(jsonPath("$.name").exists())
                .andExpect(jsonPath("$.email").exists())
                .andExpect(jsonPath("$.password").exists())
                .andExpect(jsonPath("$.profile").exists())
                .andDo(print());

        verify(productService).getBabyLion("test@example.com");
    }
    @Test
    @DisplayName("Product 데이터 생성 테스트")
    void createProductTest() throws Exception {
        //Mock 객체에서 특정 메소드가 실행되는 경우 실제 Return을 줄 수 없기 때문에 아래와 같이 가정 사항을 만들어줌
        given(productService.saveBabyLion(new BabyLionDto("pen","test@example.com", "010-1234-5678","cos1234")))
                .willReturn(new ResponseBabyLionDto(null, "pen","test@example.com", "010-1234-5678","cos1234","good"));

        BabyLionDto productDto = BabyLionDto.builder()
                .name("pen")
                .email("test@example.com")
                .number("010-1234-5678")
                .password("cos1234")
                .build();

        Gson gson = new Gson();
        String content = gson.toJson(BabyLionDto);

        mockMvc.perform(
                        post("/product")
                                .content(content)
                                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.number").exists())
                .andExpect(jsonPath("$.name").exists())
                .andExpect(jsonPath("$.password").exists())
                .andExpect(jsonPath("$.profile").exists())
                .andExpect(jsonPath("$.email").exists())
                .andDo(print());

        verify(productService).saveBabyLion(new BabyLionDto("pen","test@example.com", "010-1234-5678","cos1234"));
    }
}

