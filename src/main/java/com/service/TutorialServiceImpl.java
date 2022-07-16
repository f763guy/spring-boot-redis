package com.service;

import com.repository.TutorialRepository;
import com.model.Tutorial;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@CacheConfig(cacheNames = "tutorialService")
public class TutorialServiceImpl implements TutorialService{

    private TutorialRepository tutorialRepository;

    public TutorialServiceImpl(TutorialRepository tutorialRepository) {
        this.tutorialRepository = tutorialRepository;
    }

    @Override
    @Cacheable(value="tutorial", key ="#p0")
    @Transactional(readOnly = true)
    public Tutorial findById(Long id) {
        Optional<Tutorial> _Tutorial= tutorialRepository.findById(id);
        System.out.println("從關聯式資料庫查詢.....");
        return _Tutorial.orElse(null);
    }

    @Override
    @CacheEvict(value="tutorial", key ="#p0")
    public void clearCache(Long id) {

    }


    @Override
    @Cacheable(value = "findAll", keyGenerator = "wiselyKeyGenerator")
    @Transactional(readOnly = true)
    public List<Tutorial> findAll() {
        System.out.println("從關聯式資料庫查詢.....");
        return tutorialRepository.getAll();
    }

    @Override
    @CacheEvict(value = "findAll",allEntries=true)
    public void clearAllCache() {

    }
}
