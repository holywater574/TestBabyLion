package com.springboot.babylion.data.dto.response;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class ResponseBabyLionDto {
    private Long pid;

    private String name;

    private String email;

    private String number;

    private String password;

    private String profile;
}