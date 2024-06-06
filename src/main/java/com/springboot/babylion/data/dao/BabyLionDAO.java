package com.springboot.babylion.data.dao;

import com.springboot.babylion.data.entity.BabyLion;

public interface BabyLionDAO {
    BabyLion insertLion(BabyLion babyLion);

    BabyLion selectLion(String email) throws Exception;

    BabyLion updateLionName(String email, String name) throws Exception;

    void deleteLion(String email) throws Exception;
}
