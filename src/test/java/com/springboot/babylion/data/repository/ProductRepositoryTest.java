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
    private BabyLionRepository productRepository;

    @Test
    void save() {
        // given
        BabyLion product = new BabyLion();
        //객체를 데이터베이스에서 저장
        product.setName("펜");
        product.setPassword("cos1234");
        product.setEmail("test@example.com");
        product.setNumber("010-1234-5678");

        // when
        BabyLion savedProduct = productRepository.save(product);
        //생성된 엔티티를 기반으로 save()메서드를 호출해서 테스트를 진행

        // then
        assertEquals(product.getName(), savedProduct.getName());
        assertEquals(product.getPrice(), savedProduct.getPrice());
        assertEquals(product.getStock(), savedProduct.getStock());
        //Given에서 생성한 엔티티 객체의 값이 일치하는지 assertEquals()메서드를 통해 검증
    }

}