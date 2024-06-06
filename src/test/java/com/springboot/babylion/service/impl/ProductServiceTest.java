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

    private BabyLionRepository babyLionRepository = Mockito.mock(BabyLionRepository.class);
    private BabyLionServiceImpl babyLionService;

    @BeforeEach
    public void setUpTest() {
        babyLionService = new BabyLionServiceImpl(babyLionRepository);
    }


    @Test
    void getBabyLionTest() {
        // given
        BabyLion givenBabyLion = new BabyLion();
        givenBabyLion.setNumber("123L");
        givenBabyLion.setName("펜");
        givenBabyLion.setPrice(1000);
        givenBabyLion.setStock(1234);

        Mockito.when(babyLionRepository.findById(null))
                .thenReturn(Optional.of(givenBabyLion));

        // when
        ResponseBabyLionDto babyLionResponseDto = babyLionService.getBabyLion("test@example.com");

        // then
        Assertions.assertEquals(babyLionResponseDto.getNumber(), givenBabyLion.getNumber());
        Assertions.assertEquals(babyLionResponseDto.getName(), givenBabyLion.getName());
        Assertions.assertEquals(babyLionResponseDto.getPassword(), givenBabyLion.getPassword());
        Assertions.assertEquals(babyLionResponseDto.getProfile(), givenBabyLion.getProfile());
        Assertions.assertEquals(babyLionResponseDto.getEmail(), givenBabyLion.getEmail());

        verify(babyLionRepository).findById(null);
    }


    @Test
    void saveBabyLionTest() {
        // given
        Mockito.when(babyLionRepository.save(any(BabyLion.class)))
                .then(returnsFirstArg());

        // when
        ResponseBabyLionDto babyLionResponseDto = babyLionService.saveBabyLion(
                new BabyLionDto("펜","test@example.com", "010-1234-5678","cos1234"));

        // then
        Assertions.assertEquals(babyLionResponseDto.getName(), "펜");
        Assertions.assertEquals(babyLionResponseDto.getPassword(), "1234");
        Assertions.assertEquals(babyLionResponseDto.getEmail(), "test@example.com");
        Assertions.assertEquals(babyLionResponseDto.getNumber(), "cos1234");

        verify(babyLionRepository).save(any());
    }
}

