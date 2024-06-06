package com.springboot.babylion.service;

import com.springboot.babylion.data.dto.SignDto.SignInResultDto;
import com.springboot.babylion.data.dto.SignDto.SignUpDto;
import com.springboot.babylion.data.dto.SignDto.SignUpResultDto;

public interface SignService {
    SignUpResultDto SignUp(SignUpDto signUpDto, String roles);
    SignInResultDto SignIn(String email, String password);
}