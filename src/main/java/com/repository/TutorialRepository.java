package com.repository;

import com.model.Tutorial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface TutorialRepository extends JpaRepository<Tutorial, Long> {

    @Query(value = "SELECT id,title,description,published FROM tutorials",nativeQuery = true)
    List<Tutorial> getAll();

}
