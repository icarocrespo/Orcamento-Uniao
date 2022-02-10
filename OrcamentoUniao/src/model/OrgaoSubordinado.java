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
import javax.persistence.FetchType;
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
@Table(name = "orgao_subordinado")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OrgaoSubordinado.findAll", query = "SELECT o FROM OrgaoSubordinado o")
    , @NamedQuery(name = "OrgaoSubordinado.findByIdOrgaoSubordinado", query = "SELECT o FROM OrgaoSubordinado o WHERE o.idOrgaoSubordinado = :idOrgaoSubordinado")
    , @NamedQuery(name = "OrgaoSubordinado.findByNomeOrgaoSubordinado", query = "SELECT o FROM OrgaoSubordinado o WHERE o.nomeOrgaoSubordinado = :nomeOrgaoSubordinado")})
public class OrgaoSubordinado implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_orgao_subordinado")
    private Integer idOrgaoSubordinado;
    @Basic(optional = false)
    @Column(name = "nome_orgao_subordinado")
    private String nomeOrgaoSubordinado;
    @JoinColumn(name = "id_orgao_superior", referencedColumnName = "id_orgao_superior")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private OrgaoSuperior idOrgaoSuperior;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idOrgaoSubordinado", fetch = FetchType.EAGER)
    private List<UnidadeOrcamentaria> unidadeOrcamentariaList;

    public OrgaoSubordinado() {
    }

    public OrgaoSubordinado(Integer idOrgaoSubordinado) {
        this.idOrgaoSubordinado = idOrgaoSubordinado;
    }

    public OrgaoSubordinado(Integer idOrgaoSubordinado, String nomeOrgaoSubordinado) {
        this.idOrgaoSubordinado = idOrgaoSubordinado;
        this.nomeOrgaoSubordinado = nomeOrgaoSubordinado;
    }

    public Integer getIdOrgaoSubordinado() {
        return idOrgaoSubordinado;
    }

    public void setIdOrgaoSubordinado(Integer idOrgaoSubordinado) {
        this.idOrgaoSubordinado = idOrgaoSubordinado;
    }

    public String getNomeOrgaoSubordinado() {
        return nomeOrgaoSubordinado;
    }

    public void setNomeOrgaoSubordinado(String nomeOrgaoSubordinado) {
        this.nomeOrgaoSubordinado = nomeOrgaoSubordinado;
    }

    public OrgaoSuperior getIdOrgaoSuperior() {
        return idOrgaoSuperior;
    }

    public void setIdOrgaoSuperior(OrgaoSuperior idOrgaoSuperior) {
        this.idOrgaoSuperior = idOrgaoSuperior;
    }

    @XmlTransient
    public List<UnidadeOrcamentaria> getUnidadeOrcamentariaList() {
        return unidadeOrcamentariaList;
    }

    public void setUnidadeOrcamentariaList(List<UnidadeOrcamentaria> unidadeOrcamentariaList) {
        this.unidadeOrcamentariaList = unidadeOrcamentariaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idOrgaoSubordinado != null ? idOrgaoSubordinado.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OrgaoSubordinado)) {
            return false;
        }
        OrgaoSubordinado other = (OrgaoSubordinado) object;
        if ((this.idOrgaoSubordinado == null && other.idOrgaoSubordinado != null) || (this.idOrgaoSubordinado != null && !this.idOrgaoSubordinado.equals(other.idOrgaoSubordinado))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.OrgaoSubordinado[ idOrgaoSubordinado=" + idOrgaoSubordinado + " ]";
    }
    
}
