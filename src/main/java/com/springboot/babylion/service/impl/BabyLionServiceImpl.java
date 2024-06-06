package com.springboot.babylion.service.impl;

import com.springboot.babylion.data.dao.BabyLionDAO;
import com.springboot.babylion.data.dto.request.ChangeNameRequestDto;
import com.springboot.babylion.data.dto.request.RequestBabyLionDto;
import com.springboot.babylion.data.dto.response.ResponseBabyLionDto;
import com.springboot.babylion.data.entity.BabyLion;
import com.springboot.babylion.service.BabyLionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class BabyLionServiceImpl implements BabyLionService {

    private final BabyLionDAO babyLionDAO;

    @Autowired
    public BabyLionServiceImpl(BabyLionDAO babyLionDAO) {
        this.babyLionDAO = babyLionDAO;
    }

    @Override
    public ResponseBabyLionDto getBabyLion(String email) throws Exception {
        BabyLion babyLion = babyLionDAO.selectLion(email);

        ResponseBabyLionDto responseBabyLionDto = new ResponseBabyLionDto();
        responseBabyLionDto.setPid(babyLion.getPid());
        responseBabyLionDto.setName(babyLion.getName());
        responseBabyLionDto.setEmail(babyLion.getEmail());
        responseBabyLionDto.setNumber(babyLion.getNumber());
        responseBabyLionDto.setProfile(babyLion.getProfile());
        responseBabyLionDto.setPassword(babyLion.getPassword());

        return responseBabyLionDto;
    }

    @Override
    public ResponseBabyLionDto saveBabyLion(RequestBabyLionDto requestBabyLionDto) {
        BabyLion babyLion = new BabyLion();
        babyLion.setName(requestBabyLionDto.getName());
        babyLion.setEmail(requestBabyLionDto.getEmail());
        babyLion.setNumber(requestBabyLionDto.getNumber());
        babyLion.setProfile(requestBabyLionDto.getProfile());
        babyLion.setPassword(requestBabyLionDto.getPassword());
        babyLion.setCreateAt(LocalDateTime.now());
        babyLion.setUpdatedAt(LocalDateTime.now());

        BabyLion savedLion = babyLionDAO.insertLion(babyLion);

        ResponseBabyLionDto responseBabyLionDto = new ResponseBabyLionDto();
        responseBabyLionDto.setPid(savedLion.getPid());
        responseBabyLionDto.setEmail(savedLion.getEmail());
        responseBabyLionDto.setName(savedLion.getName());
        responseBabyLionDto.setNumber(savedLion.getNumber());
        responseBabyLionDto.setProfile(savedLion.getProfile());
        responseBabyLionDto.setPassword(savedLion.getPassword());

        return responseBabyLionDto;
    }

    @Override
    public ResponseBabyLionDto changeBabyLionName(ChangeNameRequestDto changeNameRequestDto) throws Exception {
        BabyLion findBabyLion = babyLionDAO.updateLionName(changeNameRequestDto.getEmail(), changeNameRequestDto.getName());

        ResponseBabyLionDto responseBabyLionDto = new ResponseBabyLionDto();
        responseBabyLionDto.setPid(findBabyLion.getPid());
        responseBabyLionDto.setName(findBabyLion.getName());
        responseBabyLionDto.setEmail(findBabyLion.getEmail());
        responseBabyLionDto.setNumber(findBabyLion.getNumber());
        responseBabyLionDto.setPassword(findBabyLion.getPassword());
        responseBabyLionDto.setProfile(findBabyLion.getProfile());

        return responseBabyLionDto;
    }

    @Override
    public void deleteBabyLion(String email) throws Exception {
        babyLionDAO.deleteLion(email);
    }
}