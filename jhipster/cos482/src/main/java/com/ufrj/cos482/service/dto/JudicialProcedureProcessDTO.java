package com.ufrj.cos482.service.dto;

import java.io.Serializable;
import java.util.Objects;
import org.akip.service.dto.ProcessInstanceDTO;

/**
 * A DTO for the {@link com.ufrj.cos482.domain.JudicialProcedureProcess} entity.
 */
public class JudicialProcedureProcessDTO implements Serializable {

    private Long id;

    private ProcessInstanceDTO processInstance;

    private JudicialProcedureDTO judicialProcedure;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ProcessInstanceDTO getProcessInstance() {
        return processInstance;
    }

    public void setProcessInstance(ProcessInstanceDTO processInstance) {
        this.processInstance = processInstance;
    }

    public JudicialProcedureDTO getJudicialProcedure() {
        return judicialProcedure;
    }

    public void setJudicialProcedure(JudicialProcedureDTO judicialProcedure) {
        this.judicialProcedure = judicialProcedure;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof JudicialProcedureProcessDTO)) {
            return false;
        }

        JudicialProcedureProcessDTO judicialProcedureProcessDTO = (JudicialProcedureProcessDTO) o;
        if (this.id == null) {
            return false;
        }
        return Objects.equals(this.id, judicialProcedureProcessDTO.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "JudicialProcedureProcessDTO{" +
            "id=" + getId() +
            ", processInstance=" + getProcessInstance() +
            ", judicialProcedure=" + getJudicialProcedure() +
            "}";
    }
}
