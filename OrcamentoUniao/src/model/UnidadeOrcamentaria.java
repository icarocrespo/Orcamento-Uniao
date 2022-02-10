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
@Table(name = "unidade_orcamentaria")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UnidadeOrcamentaria.findAll", query = "SELECT u FROM UnidadeOrcamentaria u")
    , @NamedQuery(name = "UnidadeOrcamentaria.findByIdUnidadeOrcamentaria", query = "SELECT u FROM UnidadeOrcamentaria u WHERE u.idUnidadeOrcamentaria = :idUnidadeOrcamentaria")
    , @NamedQuery(name = "UnidadeOrcamentaria.findByNomeUnidadeOrcamentaria", query = "SELECT u FROM UnidadeOrcamentaria u WHERE u.nomeUnidadeOrcamentaria = :nomeUnidadeOrcamentaria")})
public class UnidadeOrcamentaria implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_unidade_orcamentaria")
    private Integer idUnidadeOrcamentaria;
    @Basic(optional = false)
    @Column(name = "nome_unidade_orcamentaria")
    private String nomeUnidadeOrcamentaria;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUnidadeOrcamentaria", fetch = FetchType.EAGER)
    private List<Funcao> funcaoList;
    @JoinColumn(name = "id_orgao_subordinado", referencedColumnName = "id_orgao_subordinado")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private OrgaoSubordinado idOrgaoSubordinado;

    public UnidadeOrcamentaria() {
    }

    public UnidadeOrcamentaria(Integer idUnidadeOrcamentaria) {
        this.idUnidadeOrcamentaria = idUnidadeOrcamentaria;
    }

    public UnidadeOrcamentaria(Integer idUnidadeOrcamentaria, String nomeUnidadeOrcamentaria) {
        this.idUnidadeOrcamentaria = idUnidadeOrcamentaria;
        this.nomeUnidadeOrcamentaria = nomeUnidadeOrcamentaria;
    }

    public Integer getIdUnidadeOrcamentaria() {
        return idUnidadeOrcamentaria;
    }

    public void setIdUnidadeOrcamentaria(Integer idUnidadeOrcamentaria) {
        this.idUnidadeOrcamentaria = idUnidadeOrcamentaria;
    }

    public String getNomeUnidadeOrcamentaria() {
        return nomeUnidadeOrcamentaria;
    }

    public void setNomeUnidadeOrcamentaria(String nomeUnidadeOrcamentaria) {
        this.nomeUnidadeOrcamentaria = nomeUnidadeOrcamentaria;
    }

    @XmlTransient
    public List<Funcao> getFuncaoList() {
        return funcaoList;
    }

    public void setFuncaoList(List<Funcao> funcaoList) {
        this.funcaoList = funcaoList;
    }

    public OrgaoSubordinado getIdOrgaoSubordinado() {
        return idOrgaoSubordinado;
    }

    public void setIdOrgaoSubordinado(OrgaoSubordinado idOrgaoSubordinado) {
        this.idOrgaoSubordinado = idOrgaoSubordinado;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idUnidadeOrcamentaria != null ? idUnidadeOrcamentaria.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UnidadeOrcamentaria)) {
            return false;
        }
        UnidadeOrcamentaria other = (UnidadeOrcamentaria) object;
        if ((this.idUnidadeOrcamentaria == null && other.idUnidadeOrcamentaria != null) || (this.idUnidadeOrcamentaria != null && !this.idUnidadeOrcamentaria.equals(other.idUnidadeOrcamentaria))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.UnidadeOrcamentaria[ idUnidadeOrcamentaria=" + idUnidadeOrcamentaria + " ]";
    }
    
}
