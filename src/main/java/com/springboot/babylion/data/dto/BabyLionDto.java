package com.springboot.babylion.data.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class BabyLionDto {

    private String name;

    private String email;

    private String number;

    private String password;

    private String profile;
}
