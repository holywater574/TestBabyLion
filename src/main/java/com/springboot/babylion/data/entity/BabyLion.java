package com.springboot.babylion.data.entity;


import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.Contact;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@Entity
@Table
public class BabyLion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pid;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false, unique = true)
    private String number;

    @Column(nullable = false)
    private String password;

    @Column
    private String profile;

    @Column
    private LocalDateTime createAt;

    @Column
    private LocalDateTime updatedAt;

    @Column(nullable = false)
    private Integer price;

    @Column(nullable = false)
    private Integer stock;

    @OneToOne(mappedBy = "babylion")
    @ToString.Exclude
    private BabyLionDetail babyLionDetail;

    @ManyToOne
    @JoinColumn(name = "hobby_id")
    @ToString.Exclude
    private Hobby hobby;


}
