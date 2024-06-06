package com.springboot.babylion.data.entity;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Table(name = "lion_group")
public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String groupName;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "group_id")
    private List<BabyLion> members = new ArrayList<>();
}
