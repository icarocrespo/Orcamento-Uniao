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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author icaro
 */
@Entity
@Table(name = "categoria_economica")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CategoriaEconomica.findAll", query = "SELECT c FROM CategoriaEconomica c")
    , @NamedQuery(name = "CategoriaEconomica.findByIdCategoriaEconomica", query = "SELECT c FROM CategoriaEconomica c WHERE c.idCategoriaEconomica = :idCategoriaEconomica")
    , @NamedQuery(name = "CategoriaEconomica.findByNomeCategoriaEconomica", query = "SELECT c FROM CategoriaEconomica c WHERE c.nomeCategoriaEconomica = :nomeCategoriaEconomica")})
public class CategoriaEconomica implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_categoria_economica")
    private Integer idCategoriaEconomica;
    @Basic(optional = false)
    @Column(name = "nome_categoria_economica")
    private String nomeCategoriaEconomica;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCategoriaEconomica")
    private List<GrupoDespesa> grupoDespesaList;
    @JoinColumn(name = "id_acao", referencedColumnName = "id_acao")
    @ManyToOne(optional = false)
    private Acao idAcao;

    public CategoriaEconomica() {
    }

    public CategoriaEconomica(Integer idCategoriaEconomica) {
        this.idCategoriaEconomica = idCategoriaEconomica;
    }

    public CategoriaEconomica(Integer idCategoriaEconomica, String nomeCategoriaEconomica) {
        this.idCategoriaEconomica = idCategoriaEconomica;
        this.nomeCategoriaEconomica = nomeCategoriaEconomica;
    }

    public Integer getIdCategoriaEconomica() {
        return idCategoriaEconomica;
    }

    public void setIdCategoriaEconomica(Integer idCategoriaEconomica) {
        this.idCategoriaEconomica = idCategoriaEconomica;
    }

    public String getNomeCategoriaEconomica() {
        return nomeCategoriaEconomica;
    }

    public void setNomeCategoriaEconomica(String nomeCategoriaEconomica) {
        this.nomeCategoriaEconomica = nomeCategoriaEconomica;
    }

    @XmlTransient
    public List<GrupoDespesa> getGrupoDespesaList() {
        return grupoDespesaList;
    }

    public void setGrupoDespesaList(List<GrupoDespesa> grupoDespesaList) {
        this.grupoDespesaList = grupoDespesaList;
    }

    public Acao getIdAcao() {
        return idAcao;
    }

    public void setIdAcao(Acao idAcao) {
        this.idAcao = idAcao;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCategoriaEconomica != null ? idCategoriaEconomica.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CategoriaEconomica)) {
            return false;
        }
        CategoriaEconomica other = (CategoriaEconomica) object;
        if ((this.idCategoriaEconomica == null && other.idCategoriaEconomica != null) || (this.idCategoriaEconomica != null && !this.idCategoriaEconomica.equals(other.idCategoriaEconomica))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.CategoriaEconomica[ idCategoriaEconomica=" + idCategoriaEconomica + " ]";
    }
    
}
