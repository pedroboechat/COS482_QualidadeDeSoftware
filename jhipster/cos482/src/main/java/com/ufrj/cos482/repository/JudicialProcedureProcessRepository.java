package com.ufrj.cos482.repository;

import com.ufrj.cos482.domain.JudicialProcedureProcess;
import java.util.Optional;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data SQL repository for the JudicialProcedureProcess entity.
 */
@SuppressWarnings("unused")
@Repository
public interface JudicialProcedureProcessRepository extends JpaRepository<JudicialProcedureProcess, Long> {
    Optional<JudicialProcedureProcess> findByProcessInstanceId(Long processInstanceId);
}
