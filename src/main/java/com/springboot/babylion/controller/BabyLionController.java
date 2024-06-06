package com.springboot.babylion.controller;

import com.springboot.babylion.data.dto.request.ChangeNameRequestDto;
import com.springboot.babylion.data.dto.request.RequestBabyLionDto;
import com.springboot.babylion.data.dto.response.ResponseBabyLionDto;
import com.springboot.babylion.service.BabyLionService;
import io.swagger.annotations.ApiImplicitParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/baby-lion")
public class BabyLionController {
    private final BabyLionService babyLionService;


    @Autowired
    public BabyLionController(BabyLionService babyLionService) {
        this.babyLionService = babyLionService;
    }

    @GetMapping("/get")
    public ResponseEntity<ResponseBabyLionDto> getBabyLion(@RequestParam String email) throws Exception {
        ResponseBabyLionDto responseBabyLionDto = babyLionService.getBabyLion(email);

        return ResponseEntity.status(HttpStatus.OK).body(responseBabyLionDto);
    }
    @ApiImplicitParam(name = "X-AUTH-TOKEN",value="로그인 성공 후 발급 받은 access_token", required = true, dataType ="String",paramType = "header")
    @PostMapping("/post")
    public ResponseEntity<ResponseBabyLionDto> createBabyLion(@RequestBody RequestBabyLionDto requestBabyLionDto){
        ResponseBabyLionDto responseBabyLionDto = babyLionService.saveBabyLion(requestBabyLionDto);

        return ResponseEntity.status(HttpStatus.OK).body(responseBabyLionDto);
    }
    @ApiImplicitParam(name = "X-AUTH-TOKEN",value="로그인 성공 후 발급 받은 access_token", required = true, dataType ="String",paramType = "header")
    @PutMapping("/put")
    public ResponseEntity<ResponseBabyLionDto> changeBabyLionName(@RequestBody ChangeNameRequestDto changeNameRequestDto) throws Exception {
        ResponseBabyLionDto responseBabyLionDto = babyLionService.changeBabyLionName(changeNameRequestDto);

        return ResponseEntity.status(HttpStatus.OK).body(responseBabyLionDto);
    }
    @ApiImplicitParam(name = "X-AUTH-TOKEN",value="로그인 성공 후 발급 받은 access_token", required = true, dataType ="String",paramType = "header")
    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteBabyLion(String email) throws Exception {
        babyLionService.deleteBabyLion(email);

        return ResponseEntity.status(HttpStatus.OK).body("정상적으로 삭제되었습니다.");
    }
}