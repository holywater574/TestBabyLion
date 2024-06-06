package com.springboot.babylion.data.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.springboot.babylion.data.entity.BabyLion;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;


@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
class ProductRepositoryTest {

    @Autowired
    private BabyLionRepository babyLionRepository;

    @Test
    void save() {
        // given
        BabyLion babyLion = new BabyLion();
        //객체를 데이터베이스에서 저장
        babyLion.setName("펜");
        babyLion.setPassword("cos1234");
        babyLion.setEmail("test@example.com");
        babyLion.setNumber("010-1234-5678");

        // when
        BabyLion savedBabylion = babyLionRepository.save(babyLion);
        //생성된 엔티티를 기반으로 save()메서드를 호출해서 테스트를 진행

        // then
        assertEquals(babyLion.getName(), savedBabylion.getName());
        assertEquals(babyLion.getPassword(), savedBabylion.getPassword());
        assertEquals(babyLion.getNumber(), savedBabylion.getNumber());
        //Given에서 생성한 엔티티 객체의 값이 일치하는지 assertEquals()메서드를 통해 검증
    }

}