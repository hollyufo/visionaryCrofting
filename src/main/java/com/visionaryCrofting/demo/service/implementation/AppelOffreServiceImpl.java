package com.visionaryCrofting.demo.service.implementation;

import com.visionaryCrofting.demo.entity.AppelOffre;
import com.visionaryCrofting.demo.repositories.AoRepository;
import com.visionaryCrofting.demo.service.AppelOffreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;

@Service
public class AppelOffreServiceImpl implements AppelOffreService {
    @Transactional

    @Override
    public int deleteByRef(String ref) {
        return aoRepository.deleteByRef(ref);
    }

    @Override
    public AppelOffre findByRef(String ref) {
        return aoRepository.findByRef(ref);
    }

    @Override
    public List<AppelOffre> findAll() {
        return aoRepository.findAll();
    }

    @Override
    public AppelOffre getOne(Long aLong) {
        return aoRepository.getOne(aLong);
    }

    @Override
    public AppelOffre save(AppelOffre appelOffre){
        if (this.findByRef(appelOffre.getRef()) != null) return null;
        return aoRepository.save(appelOffre);
    }

    @Override
    public AppelOffre update(AppelOffre appelOffre) {
        if (this.findByRef(appelOffre.getRef()) != null) return null;
        return aoRepository.save(appelOffre);
    }

    @Autowired
    AoRepository aoRepository;
}
