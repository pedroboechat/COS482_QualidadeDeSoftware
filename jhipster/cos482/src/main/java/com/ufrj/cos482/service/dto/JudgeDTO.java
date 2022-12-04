package com.ufrj.cos482.service.dto;

import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the {@link com.ufrj.cos482.domain.Judge} entity.
 */
public class JudgeDTO implements Serializable {

    private Long id;

    private String name;

    private String cpf;

    private String oab;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getOab() {
        return oab;
    }

    public void setOab(String oab) {
        this.oab = oab;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof JudgeDTO)) {
            return false;
        }

        JudgeDTO judgeDTO = (JudgeDTO) o;
        if (this.id == null) {
            return false;
        }
        return Objects.equals(this.id, judgeDTO.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "JudgeDTO{" +
            "id=" + getId() +
            ", name='" + getName() + "'" +
            ", cpf='" + getCpf() + "'" +
            ", oab='" + getOab() + "'" +
            "}";
    }
}
