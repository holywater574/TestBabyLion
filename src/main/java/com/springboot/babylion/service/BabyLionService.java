package com.springboot.babylion.service;

import com.springboot.babylion.data.dto.request.ChangeNameRequestDto;
import com.springboot.babylion.data.dto.request.RequestBabyLionDto;
import com.springboot.babylion.data.dto.response.ResponseBabyLionDto;

public interface BabyLionService {
    ResponseBabyLionDto getBabyLion(String email) throws Exception;

    ResponseBabyLionDto saveBabyLion(RequestBabyLionDto requestBabyLionDto);

    ResponseBabyLionDto changeBabyLionName(ChangeNameRequestDto changeNameRequestDto) throws Exception;

    void deleteBabyLion(String email) throws Exception;
}
