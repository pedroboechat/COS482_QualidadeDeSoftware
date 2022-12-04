package com.ufrj.cos482.service.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

/**
 * A DTO for the {@link com.ufrj.cos482.domain.JudicialProcedure} entity.
 */
public class JudicialProcedureDTO implements Serializable {

    private Long id;

    private String numeroDoProcesso;

    private String tribunal;

    private Boolean necessitaLaudo;

    private String laudista;

    private LocalDate dataDaVisita;

    private String endereco;

    private String linkLaudo;

    private Boolean laudoValido;

    private LocalDate protocoladoEm;

    private JudgeDTO judge;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumeroDoProcesso() {
        return numeroDoProcesso;
    }

    public void setNumeroDoProcesso(String numeroDoProcesso) {
        this.numeroDoProcesso = numeroDoProcesso;
    }

    public String getTribunal() {
        return tribunal;
    }

    public void setTribunal(String tribunal) {
        this.tribunal = tribunal;
    }

    public Boolean getNecessitaLaudo() {
        return necessitaLaudo;
    }

    public void setNecessitaLaudo(Boolean necessitaLaudo) {
        this.necessitaLaudo = necessitaLaudo;
    }

    public String getLaudista() {
        return laudista;
    }

    public void setLaudista(String laudista) {
        this.laudista = laudista;
    }

    public LocalDate getDataDaVisita() {
        return dataDaVisita;
    }

    public void setDataDaVisita(LocalDate dataDaVisita) {
        this.dataDaVisita = dataDaVisita;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getLinkLaudo() {
        return linkLaudo;
    }

    public void setLinkLaudo(String linkLaudo) {
        this.linkLaudo = linkLaudo;
    }

    public Boolean getLaudoValido() {
        return laudoValido;
    }

    public void setLaudoValido(Boolean laudoValido) {
        this.laudoValido = laudoValido;
    }

    public LocalDate getProtocoladoEm() {
        return protocoladoEm;
    }

    public void setProtocoladoEm(LocalDate protocoladoEm) {
        this.protocoladoEm = protocoladoEm;
    }

    public JudgeDTO getJudge() {
        return judge;
    }

    public void setJudge(JudgeDTO judge) {
        this.judge = judge;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof JudicialProcedureDTO)) {
            return false;
        }

        JudicialProcedureDTO judicialProcedureDTO = (JudicialProcedureDTO) o;
        if (this.id == null) {
            return false;
        }
        return Objects.equals(this.id, judicialProcedureDTO.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "JudicialProcedureDTO{" +
            "id=" + getId() +
            ", numeroDoProcesso='" + getNumeroDoProcesso() + "'" +
            ", tribunal='" + getTribunal() + "'" +
            ", necessitaLaudo='" + getNecessitaLaudo() + "'" +
            ", laudista='" + getLaudista() + "'" +
            ", dataDaVisita='" + getDataDaVisita() + "'" +
            ", endereco='" + getEndereco() + "'" +
            ", linkLaudo='" + getLinkLaudo() + "'" +
            ", laudoValido='" + getLaudoValido() + "'" +
            ", protocoladoEm='" + getProtocoladoEm() + "'" +
            ", judge=" + getJudge() +
            "}";
    }
}
