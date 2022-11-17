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
    private String NumeroDoProcesso;

    @Column(name = "tribunal")
    private String Tribunal;

    @Column(name = "juiz")
    private String Juiz;

    @Column(name = "necessita_laudo")
    private Boolean NecessitaLaudo;

    @Column(name = "laudista")
    private String Laudista;

    @Column(name = "data_da_visita")
    private LocalDate DataDaVisita;

    @Column(name = "endereco")
    private String Endereco;

    @Column(name = "link_laudo")
    private String LinkLaudo;

    @Column(name = "laudo_valido")
    private Boolean LaudoValido;

    @Column(name = "protocolado_em")
    private LocalDate ProtocoladoEm;

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
        return this.NumeroDoProcesso;
    }

    public JudicialProcedure NumeroDoProcesso(String NumeroDoProcesso) {
        this.NumeroDoProcesso = NumeroDoProcesso;
        return this;
    }

    public void setNumeroDoProcesso(String NumeroDoProcesso) {
        this.NumeroDoProcesso = NumeroDoProcesso;
    }

    public String getTribunal() {
        return this.Tribunal;
    }

    public JudicialProcedure Tribunal(String Tribunal) {
        this.Tribunal = Tribunal;
        return this;
    }

    public void setTribunal(String Tribunal) {
        this.Tribunal = Tribunal;
    }

    public String getJuiz() {
        return this.Juiz;
    }

    public JudicialProcedure Juiz(String Juiz) {
        this.Juiz = Juiz;
        return this;
    }

    public void setJuiz(String Juiz) {
        this.Juiz = Juiz;
    }

    public Boolean getNecessitaLaudo() {
        return this.NecessitaLaudo;
    }

    public JudicialProcedure NecessitaLaudo(Boolean NecessitaLaudo) {
        this.NecessitaLaudo = NecessitaLaudo;
        return this;
    }

    public void setNecessitaLaudo(Boolean NecessitaLaudo) {
        this.NecessitaLaudo = NecessitaLaudo;
    }

    public String getLaudista() {
        return this.Laudista;
    }

    public JudicialProcedure Laudista(String Laudista) {
        this.Laudista = Laudista;
        return this;
    }

    public void setLaudista(String Laudista) {
        this.Laudista = Laudista;
    }

    public LocalDate getDataDaVisita() {
        return this.DataDaVisita;
    }

    public JudicialProcedure DataDaVisita(LocalDate DataDaVisita) {
        this.DataDaVisita = DataDaVisita;
        return this;
    }

    public void setDataDaVisita(LocalDate DataDaVisita) {
        this.DataDaVisita = DataDaVisita;
    }

    public String getEndereco() {
        return this.Endereco;
    }

    public JudicialProcedure Endereco(String Endereco) {
        this.Endereco = Endereco;
        return this;
    }

    public void setEndereco(String Endereco) {
        this.Endereco = Endereco;
    }

    public String getLinkLaudo() {
        return this.LinkLaudo;
    }

    public JudicialProcedure LinkLaudo(String LinkLaudo) {
        this.LinkLaudo = LinkLaudo;
        return this;
    }

    public void setLinkLaudo(String LinkLaudo) {
        this.LinkLaudo = LinkLaudo;
    }

    public Boolean getLaudoValido() {
        return this.LaudoValido;
    }

    public JudicialProcedure LaudoValido(Boolean LaudoValido) {
        this.LaudoValido = LaudoValido;
        return this;
    }

    public void setLaudoValido(Boolean LaudoValido) {
        this.LaudoValido = LaudoValido;
    }

    public LocalDate getProtocoladoEm() {
        return this.ProtocoladoEm;
    }

    public JudicialProcedure ProtocoladoEm(LocalDate ProtocoladoEm) {
        this.ProtocoladoEm = ProtocoladoEm;
        return this;
    }

    public void setProtocoladoEm(LocalDate ProtocoladoEm) {
        this.ProtocoladoEm = ProtocoladoEm;
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
