package com.ufrj.cos482.repository;

import com.ufrj.cos482.domain.JudicialProcedure;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data SQL repository for the JudicialProcedure entity.
 */
@SuppressWarnings("unused")
@Repository
public interface JudicialProcedureRepository extends JpaRepository<JudicialProcedure, Long> {}
