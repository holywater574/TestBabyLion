package com.springboot.babylion.data.repository;

import com.springboot.babylion.data.entity.BabyLion;
import com.springboot.babylion.data.entity.Hobby;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;
import java.util.List;


@SpringBootTest
class HobbyRepositoryTest {

    @Autowired
    BabyLionRepository babyLionRepository;

    @Autowired
    HobbyRepository hobbyRepository;

    @Test
    void relationshipTest1() {

        Hobby hobby = new Hobby();
        hobby.setHobby("알고리즘 문제풀이");

        hobby = hobbyRepository.save(hobby); // 저장 후 ID를 가져옴

        BabyLion babyLion = new BabyLion();
        babyLion.setName("최멋사");
        babyLion.setEmail("babylion@likelion.orgg");
        babyLion.setNumber("010-1234-5678");
        babyLion.setPassword("1234");
        babyLion.setProfile("pic");
        babyLion.setHobby(hobby); // Hobby 엔티티의 ID 설정

        babyLionRepository.save(babyLion);

        System.out.println(
                "babylion : " + babyLionRepository.findById(babyLion.getPid()).orElseThrow(RuntimeException::new));

        System.out.println("hobby : " + babyLionRepository.findById(babyLion.getPid()).orElseThrow(RuntimeException::new).getHobby());
    }

    @Test
    void relationshipTest() {
        // 테스트 데이터 생성
        Hobby hobby = new Hobby();
        hobby.setHobby("운동");

        hobbyRepository.save(hobby);

        BabyLion babyLion1 = new BabyLion();
        babyLion1.setName("김멋사");
        babyLion1.setEmail("babylions@likelion.org");
        babyLion1.setNumber("010-1234-5670");
        babyLion1.setPassword("12345");
        babyLion1.setProfile("pic0");
        babyLion1.setHobby(hobby);


        BabyLion babyLion2 = new BabyLion();
        babyLion2.setName("이멋사");
        babyLion2.setEmail("lion@likelion.org");
        babyLion2.setNumber("010-1111-1111");
        babyLion2.setPassword("0987");
        babyLion2.setProfile("pic1");
        babyLion2.setHobby(hobby);

        BabyLion babyLion3 = new BabyLion();
        babyLion3.setName("장멋사");
        babyLion3.setEmail("babylion@likelion.org");
        babyLion3.setNumber("010-0987-6543");
        babyLion3.setPassword("4567");
        babyLion3.setProfile("pic2");
        babyLion3.setHobby(hobby);

        babyLionRepository.save(babyLion1);
        babyLionRepository.save(babyLion2);
        babyLionRepository.save(babyLion3);

        System.out.println("check 1");

        List<BabyLion> babyLions = hobbyRepository.findById(hobby.getId()).get()
                .getBabyLionList();

        for (BabyLion babyLion : babyLions) {
            System.out.println(babyLion);
        }

    }

}
