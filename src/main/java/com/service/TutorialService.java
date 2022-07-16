package com.service;

import com.model.Tutorial;

import java.util.List;


public interface TutorialService {

    Tutorial findById(Long id);
    void clearCache(Long id);
    List<Tutorial> findAll();
    void clearAllCache();

}
