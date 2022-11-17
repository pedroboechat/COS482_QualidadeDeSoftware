package com.ufrj.cos482.service.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

/**
 * A DTO for the {@link com.ufrj.cos482.domain.JudicialProcedure} entity.
 */
public class JudicialProcedureDTO implements Serializable {

    private Long id;

    private String NumeroDoProcesso;

    private String Tribunal;

    private String Juiz;

    private Boolean NecessitaLaudo;

    private String Laudista;

    private LocalDate DataDaVisita;

    private String Endereco;

    private String LinkLaudo;

    private Boolean LaudoValido;

    private LocalDate ProtocoladoEm;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumeroDoProcesso() {
        return NumeroDoProcesso;
    }

    public void setNumeroDoProcesso(String NumeroDoProcesso) {
        this.NumeroDoProcesso = NumeroDoProcesso;
    }

    public String getTribunal() {
        return Tribunal;
    }

    public void setTribunal(String Tribunal) {
        this.Tribunal = Tribunal;
    }

    public String getJuiz() {
        return Juiz;
    }

    public void setJuiz(String Juiz) {
        this.Juiz = Juiz;
    }

    public Boolean getNecessitaLaudo() {
        return NecessitaLaudo;
    }

    public void setNecessitaLaudo(Boolean NecessitaLaudo) {
        this.NecessitaLaudo = NecessitaLaudo;
    }

    public String getLaudista() {
        return Laudista;
    }

    public void setLaudista(String Laudista) {
        this.Laudista = Laudista;
    }

    public LocalDate getDataDaVisita() {
        return DataDaVisita;
    }

    public void setDataDaVisita(LocalDate DataDaVisita) {
        this.DataDaVisita = DataDaVisita;
    }

    public String getEndereco() {
        return Endereco;
    }

    public void setEndereco(String Endereco) {
        this.Endereco = Endereco;
    }

    public String getLinkLaudo() {
        return LinkLaudo;
    }

    public void setLinkLaudo(String LinkLaudo) {
        this.LinkLaudo = LinkLaudo;
    }

    public Boolean getLaudoValido() {
        return LaudoValido;
    }

    public void setLaudoValido(Boolean LaudoValido) {
        this.LaudoValido = LaudoValido;
    }

    public LocalDate getProtocoladoEm() {
        return ProtocoladoEm;
    }

    public void setProtocoladoEm(LocalDate ProtocoladoEm) {
        this.ProtocoladoEm = ProtocoladoEm;
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
            ", NumeroDoProcesso='" + getNumeroDoProcesso() + "'" +
            ", Tribunal='" + getTribunal() + "'" +
            ", Juiz='" + getJuiz() + "'" +
            ", NecessitaLaudo='" + getNecessitaLaudo() + "'" +
            ", Laudista='" + getLaudista() + "'" +
            ", DataDaVisita='" + getDataDaVisita() + "'" +
            ", Endereco='" + getEndereco() + "'" +
            ", LinkLaudo='" + getLinkLaudo() + "'" +
            ", LaudoValido='" + getLaudoValido() + "'" +
            ", ProtocoladoEm='" + getProtocoladoEm() + "'" +
            "}";
    }
}
