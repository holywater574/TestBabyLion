package com.springboot.babylion.data.entity;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString(callSuper = true)
@Table(name = "hobby")
public class Hobby {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String hobby;


    @OneToMany(mappedBy = "hobby", fetch = FetchType.EAGER)
    @ToString.Exclude
    private List<BabyLion> babyLionList = new ArrayList<>();

}