package com.ufrj.cos482.domain;

import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.*;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

/**
 * A JudicialProcedure.
 */
@Entity
@Table(name = "judicial_procedure")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class JudicialProcedure implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @Column(name = "numero_do_processo")
    private String numeroDoProcesso;

    @Column(name = "tribunal")
    private String tribunal;

    @Column(name = "necessita_laudo")
    private Boolean necessitaLaudo;

    @Column(name = "laudista")
    private String laudista;

    @Column(name = "data_da_visita")
    private LocalDate dataDaVisita;

    @Column(name = "endereco")
    private String endereco;

    @Column(name = "link_laudo")
    private String linkLaudo;

    @Column(name = "laudo_valido")
    private Boolean laudoValido;

    @Column(name = "protocolado_em")
    private LocalDate protocoladoEm;

    @ManyToOne
    private Judge judge;

    // jhipster-needle-entity-add-field - JHipster will add fields here
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public JudicialProcedure id(Long id) {
        this.id = id;
        return this;
    }

    public String getNumeroDoProcesso() {
        return this.numeroDoProcesso;
    }

    public JudicialProcedure numeroDoProcesso(String numeroDoProcesso) {
        this.numeroDoProcesso = numeroDoProcesso;
        return this;
    }

    public void setNumeroDoProcesso(String numeroDoProcesso) {
        this.numeroDoProcesso = numeroDoProcesso;
    }

    public String getTribunal() {
        return this.tribunal;
    }

    public JudicialProcedure tribunal(String tribunal) {
        this.tribunal = tribunal;
        return this;
    }

    public void setTribunal(String tribunal) {
        this.tribunal = tribunal;
    }

    public Boolean getNecessitaLaudo() {
        return this.necessitaLaudo;
    }

    public JudicialProcedure necessitaLaudo(Boolean necessitaLaudo) {
        this.necessitaLaudo = necessitaLaudo;
        return this;
    }

    public void setNecessitaLaudo(Boolean necessitaLaudo) {
        this.necessitaLaudo = necessitaLaudo;
    }

    public String getLaudista() {
        return this.laudista;
    }

    public JudicialProcedure laudista(String laudista) {
        this.laudista = laudista;
        return this;
    }

    public void setLaudista(String laudista) {
        this.laudista = laudista;
    }

    public LocalDate getDataDaVisita() {
        return this.dataDaVisita;
    }

    public JudicialProcedure dataDaVisita(LocalDate dataDaVisita) {
        this.dataDaVisita = dataDaVisita;
        return this;
    }

    public void setDataDaVisita(LocalDate dataDaVisita) {
        this.dataDaVisita = dataDaVisita;
    }

    public String getEndereco() {
        return this.endereco;
    }

    public JudicialProcedure endereco(String endereco) {
        this.endereco = endereco;
        return this;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getLinkLaudo() {
        return this.linkLaudo;
    }

    public JudicialProcedure linkLaudo(String linkLaudo) {
        this.linkLaudo = linkLaudo;
        return this;
    }

    public void setLinkLaudo(String linkLaudo) {
        this.linkLaudo = linkLaudo;
    }

    public Boolean getLaudoValido() {
        return this.laudoValido;
    }

    public JudicialProcedure laudoValido(Boolean laudoValido) {
        this.laudoValido = laudoValido;
        return this;
    }

    public void setLaudoValido(Boolean laudoValido) {
        this.laudoValido = laudoValido;
    }

    public LocalDate getProtocoladoEm() {
        return this.protocoladoEm;
    }

    public JudicialProcedure protocoladoEm(LocalDate protocoladoEm) {
        this.protocoladoEm = protocoladoEm;
        return this;
    }

    public void setProtocoladoEm(LocalDate protocoladoEm) {
        this.protocoladoEm = protocoladoEm;
    }

    public Judge getJudge() {
        return this.judge;
    }

    public JudicialProcedure judge(Judge judge) {
        this.setJudge(judge);
        return this;
    }

    public void setJudge(Judge judge) {
        this.judge = judge;
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof JudicialProcedure)) {
            return false;
        }
        return id != null && id.equals(((JudicialProcedure) o).id);
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "JudicialProcedure{" +
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
            "}";
    }
}
