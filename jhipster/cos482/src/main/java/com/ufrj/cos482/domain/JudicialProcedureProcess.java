package com.ufrj.cos482.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import javax.persistence.*;
import org.akip.domain.ProcessInstance;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

/**
 * A JudicialProcedureProcess.
 */
@Entity
@Table(name = "judicial_procedure_process")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class JudicialProcedureProcess implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @ManyToOne
    @JsonIgnoreProperties(value = { "processDefinition" }, allowSetters = true)
    private ProcessInstance processInstance;

    @ManyToOne
    private JudicialProcedure judicialProcedure;

    // jhipster-needle-entity-add-field - JHipster will add fields here
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public JudicialProcedureProcess id(Long id) {
        this.id = id;
        return this;
    }

    public ProcessInstance getProcessInstance() {
        return this.processInstance;
    }

    public void setProcessInstance(ProcessInstance processInstance) {
        this.processInstance = processInstance;
    }

    public JudicialProcedureProcess processInstance(ProcessInstance processInstance) {
        this.setProcessInstance(processInstance);
        return this;
    }

    public JudicialProcedure getJudicialProcedure() {
        return this.judicialProcedure;
    }

    public void setJudicialProcedure(JudicialProcedure judicialProcedure) {
        this.judicialProcedure = judicialProcedure;
    }

    public JudicialProcedureProcess JudicialProcedure(JudicialProcedure judicialProcedure) {
        this.setJudicialProcedure(judicialProcedure);
        return this;
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof JudicialProcedureProcess)) {
            return false;
        }
        return id != null && id.equals(((JudicialProcedureProcess) o).id);
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "JudicialProcedureProcess{" +
            "id=" + getId() +
            "}";
    }
}
