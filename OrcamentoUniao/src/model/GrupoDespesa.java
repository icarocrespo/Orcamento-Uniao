/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author icaro
 */
@Entity
@Table(name = "grupo_despesa")
@NamedQueries({
    @NamedQuery(name = "GrupoDespesa.findAll", query = "SELECT g FROM GrupoDespesa g")
    , @NamedQuery(name = "GrupoDespesa.findByIdGrupoDespesa", query = "SELECT g FROM GrupoDespesa g WHERE g.idGrupoDespesa = :idGrupoDespesa")
    , @NamedQuery(name = "GrupoDespesa.findByNomeGrupoDespesa", query = "SELECT g FROM GrupoDespesa g WHERE g.nomeGrupoDespesa = :nomeGrupoDespesa")})
public class GrupoDespesa implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_grupo_despesa")
    private Integer idGrupoDespesa;
    @Basic(optional = false)
    @Column(name = "nome_grupo_despesa")
    private String nomeGrupoDespesa;
    @JoinColumn(name = "id_categoria_economica", referencedColumnName = "id_categoria_economica")
    @ManyToOne(optional = false)
    private CategoriaEconomica idCategoriaEconomica;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idGrupoDespesa")
    private List<ElementoDespesa> elementoDespesaList;

    public GrupoDespesa() {
    }

    public GrupoDespesa(Integer idGrupoDespesa) {
        this.idGrupoDespesa = idGrupoDespesa;
    }

    public GrupoDespesa(Integer idGrupoDespesa, String nomeGrupoDespesa) {
        this.idGrupoDespesa = idGrupoDespesa;
        this.nomeGrupoDespesa = nomeGrupoDespesa;
    }

    public Integer getIdGrupoDespesa() {
        return idGrupoDespesa;
    }

    public void setIdGrupoDespesa(Integer idGrupoDespesa) {
        this.idGrupoDespesa = idGrupoDespesa;
    }

    public String getNomeGrupoDespesa() {
        return nomeGrupoDespesa;
    }

    public void setNomeGrupoDespesa(String nomeGrupoDespesa) {
        this.nomeGrupoDespesa = nomeGrupoDespesa;
    }

    public CategoriaEconomica getIdCategoriaEconomica() {
        return idCategoriaEconomica;
    }

    public void setIdCategoriaEconomica(CategoriaEconomica idCategoriaEconomica) {
        this.idCategoriaEconomica = idCategoriaEconomica;
    }

    public List<ElementoDespesa> getElementoDespesaList() {
        return elementoDespesaList;
    }

    public void setElementoDespesaList(List<ElementoDespesa> elementoDespesaList) {
        this.elementoDespesaList = elementoDespesaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idGrupoDespesa != null ? idGrupoDespesa.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GrupoDespesa)) {
            return false;
        }
        GrupoDespesa other = (GrupoDespesa) object;
        if ((this.idGrupoDespesa == null && other.idGrupoDespesa != null) || (this.idGrupoDespesa != null && !this.idGrupoDespesa.equals(other.idGrupoDespesa))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.GrupoDespesa[ idGrupoDespesa=" + idGrupoDespesa + " ]";
    }
    
}
