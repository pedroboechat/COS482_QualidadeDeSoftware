package com.ufrj.cos482.repository;

import com.ufrj.cos482.domain.Judge;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data SQL repository for the Judge entity.
 */
@SuppressWarnings("unused")
@Repository
public interface JudgeRepository extends JpaRepository<Judge, Long> {}
