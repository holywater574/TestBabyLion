package com.springboot.babylion.data.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "babylion_detail")
@Getter
@Setter
@NoArgsConstructor
@ToString(callSuper = true)
//@EqualsAndHashCode(callSuper = true)
public class BabyLionDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;

    @OneToOne
    @JoinColumn(name = "babylion_id")
    private BabyLion babylion;

}