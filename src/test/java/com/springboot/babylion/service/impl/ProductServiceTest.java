package com.springboot.babylion.service.impl;

import static org.mockito.AdditionalAnswers.returnsFirstArg;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;

import java.util.Optional;

import com.springboot.babylion.data.dto.BabyLionDto;
import com.springboot.babylion.data.dto.response.ResponseBabyLionDto;
import com.springboot.babylion.data.entity.BabyLion;
import com.springboot.babylion.data.repository.BabyLionRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class ProductServiceTest {

    private BabyLionRepository productRepository = Mockito.mock(BabyLionRepository.class);
    private BabyLionServiceImpl productService;

    @BeforeEach
    public void setUpTest() {
        productService = new BabyLionServiceImpl(productRepository);
    }


    @Test
    void getProductTest() {
        // given
        BabyLion givenProduct = new BabyLion();
        givenProduct.setNumber("123L");
        givenProduct.setName("펜");
        givenProduct.setPrice(1000);
        givenProduct.setStock(1234);

        Mockito.when(productRepository.findById(123L))
                .thenReturn(Optional.of(givenProduct));

        // when
        ResponseBabyLionDto productResponseDto = productService.getBabyLion("test@example.com");

        // then
        Assertions.assertEquals(productResponseDto.getNumber(), givenProduct.getNumber());
        Assertions.assertEquals(productResponseDto.getName(), givenProduct.getName());
        Assertions.assertEquals(productResponseDto.getPassword(), givenProduct.getPassword());
        Assertions.assertEquals(productResponseDto.getProfile(), givenProduct.getProfile());
        Assertions.assertEquals(productResponseDto.getEmail(), givenProduct.getEmail());

        verify(productRepository).findById(123L);
    }


    @Test
    void saveProductTest() {
        // given
        Mockito.when(productRepository.save(any(BabyLion.class)))
                .then(returnsFirstArg());

        // when
        ResponseBabyLionDto productResponseDto = productService.saveBabyLion(
                new BabyLionDto("펜","test@example.com", "010-1234-5678","cos1234"));

        // then
        Assertions.assertEquals(productResponseDto.getName(), "펜");
        Assertions.assertEquals(productResponseDto.getPassword(), "1234");
        Assertions.assertEquals(productResponseDto.getEmail(), "test@example.com");
        Assertions.assertEquals(productResponseDto.getNumber(), "cos1234");

        verify(productRepository).save(any());
    }
}

