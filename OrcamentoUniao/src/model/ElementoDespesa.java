/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author icaro
 */
@Entity
@Table(name = "elemento_despesa")
@NamedQueries({
    @NamedQuery(name = "ElementoDespesa.findAll", query = "SELECT e FROM ElementoDespesa e")
    , @NamedQuery(name = "ElementoDespesa.findByIdElementoDespesa", query = "SELECT e FROM ElementoDespesa e WHERE e.idElementoDespesa = :idElementoDespesa")
    , @NamedQuery(name = "ElementoDespesa.findByNomeElementoDespesa", query = "SELECT e FROM ElementoDespesa e WHERE e.nomeElementoDespesa = :nomeElementoDespesa")
    , @NamedQuery(name = "ElementoDespesa.findByOrcamentoInicial", query = "SELECT e FROM ElementoDespesa e WHERE e.orcamentoInicial = :orcamentoInicial")
    , @NamedQuery(name = "ElementoDespesa.findByOrcamentoAtualizado", query = "SELECT e FROM ElementoDespesa e WHERE e.orcamentoAtualizado = :orcamentoAtualizado")
    , @NamedQuery(name = "ElementoDespesa.findByOrcamentoEmpenhado", query = "SELECT e FROM ElementoDespesa e WHERE e.orcamentoEmpenhado = :orcamentoEmpenhado")
    , @NamedQuery(name = "ElementoDespesa.findByOrcamentoRealizado", query = "SELECT e FROM ElementoDespesa e WHERE e.orcamentoRealizado = :orcamentoRealizado")})
public class ElementoDespesa implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_elemento_despesa")
    private Integer idElementoDespesa;
    @Basic(optional = false)
    @Column(name = "nome_elemento_despesa")
    private String nomeElementoDespesa;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "orcamento_inicial")
    private BigDecimal orcamentoInicial;
    @Basic(optional = false)
    @Column(name = "orcamento_atualizado")
    private BigDecimal orcamentoAtualizado;
    @Basic(optional = false)
    @Column(name = "orcamento_empenhado")
    private BigDecimal orcamentoEmpenhado;
    @Basic(optional = false)
    @Column(name = "orcamento_realizado")
    private BigDecimal orcamentoRealizado;
    @JoinColumn(name = "id_grupo_despesa", referencedColumnName = "id_grupo_despesa")
    @ManyToOne(optional = false)
    private GrupoDespesa idGrupoDespesa;

    public ElementoDespesa() {
    }

    public ElementoDespesa(Integer idElementoDespesa) {
        this.idElementoDespesa = idElementoDespesa;
    }

    public ElementoDespesa(Integer idElementoDespesa, String nomeElementoDespesa, BigDecimal orcamentoInicial, BigDecimal orcamentoAtualizado, BigDecimal orcamentoEmpenhado, BigDecimal orcamentoRealizado) {
        this.idElementoDespesa = idElementoDespesa;
        this.nomeElementoDespesa = nomeElementoDespesa;
        this.orcamentoInicial = orcamentoInicial;
        this.orcamentoAtualizado = orcamentoAtualizado;
        this.orcamentoEmpenhado = orcamentoEmpenhado;
        this.orcamentoRealizado = orcamentoRealizado;
    }

    public Integer getIdElementoDespesa() {
        return idElementoDespesa;
    }

    public void setIdElementoDespesa(Integer idElementoDespesa) {
        this.idElementoDespesa = idElementoDespesa;
    }

    public String getNomeElementoDespesa() {
        return nomeElementoDespesa;
    }

    public void setNomeElementoDespesa(String nomeElementoDespesa) {
        this.nomeElementoDespesa = nomeElementoDespesa;
    }

    public BigDecimal getOrcamentoInicial() {
        return orcamentoInicial;
    }

    public void setOrcamentoInicial(BigDecimal orcamentoInicial) {
        this.orcamentoInicial = orcamentoInicial;
    }

    public BigDecimal getOrcamentoAtualizado() {
        return orcamentoAtualizado;
    }

    public void setOrcamentoAtualizado(BigDecimal orcamentoAtualizado) {
        this.orcamentoAtualizado = orcamentoAtualizado;
    }

    public BigDecimal getOrcamentoEmpenhado() {
        return orcamentoEmpenhado;
    }

    public void setOrcamentoEmpenhado(BigDecimal orcamentoEmpenhado) {
        this.orcamentoEmpenhado = orcamentoEmpenhado;
    }

    public BigDecimal getOrcamentoRealizado() {
        return orcamentoRealizado;
    }

    public void setOrcamentoRealizado(BigDecimal orcamentoRealizado) {
        this.orcamentoRealizado = orcamentoRealizado;
    }

    public GrupoDespesa getIdGrupoDespesa() {
        return idGrupoDespesa;
    }

    public void setIdGrupoDespesa(GrupoDespesa idGrupoDespesa) {
        this.idGrupoDespesa = idGrupoDespesa;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idElementoDespesa != null ? idElementoDespesa.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ElementoDespesa)) {
            return false;
        }
        ElementoDespesa other = (ElementoDespesa) object;
        if ((this.idElementoDespesa == null && other.idElementoDespesa != null) || (this.idElementoDespesa != null && !this.idElementoDespesa.equals(other.idElementoDespesa))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.ElementoDespesa[ idElementoDespesa=" + idElementoDespesa + " ]";
    }
    
}