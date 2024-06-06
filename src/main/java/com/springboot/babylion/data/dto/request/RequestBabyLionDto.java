package com.springboot.babylion.data.dto.request;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class RequestBabyLionDto {

    private String name;

    private String email;

    private String number;

    private String password;

    private String profile;
}