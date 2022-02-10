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
@Table(name = "funcao")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Funcao.findAll", query = "SELECT f FROM Funcao f")
    , @NamedQuery(name = "Funcao.findByIdFuncao", query = "SELECT f FROM Funcao f WHERE f.idFuncao = :idFuncao")
    , @NamedQuery(name = "Funcao.findByNomeFuncao", query = "SELECT f FROM Funcao f WHERE f.nomeFuncao = :nomeFuncao")})
public class Funcao implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_funcao")
    private Integer idFuncao;
    @Basic(optional = false)
    @Column(name = "nome_funcao")
    private String nomeFuncao;
    @JoinColumn(name = "id_unidade_orcamentaria", referencedColumnName = "id_unidade_orcamentaria")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private UnidadeOrcamentaria idUnidadeOrcamentaria;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idFuncao", fetch = FetchType.EAGER)
    private List<Subfuncao> subfuncaoList;

    public Funcao() {
    }

    public Funcao(Integer idFuncao) {
        this.idFuncao = idFuncao;
    }

    public Funcao(Integer idFuncao, String nomeFuncao) {
        this.idFuncao = idFuncao;
        this.nomeFuncao = nomeFuncao;
    }

    public Integer getIdFuncao() {
        return idFuncao;
    }

    public void setIdFuncao(Integer idFuncao) {
        this.idFuncao = idFuncao;
    }

    public String getNomeFuncao() {
        return nomeFuncao;
    }

    public void setNomeFuncao(String nomeFuncao) {
        this.nomeFuncao = nomeFuncao;
    }

    public UnidadeOrcamentaria getIdUnidadeOrcamentaria() {
        return idUnidadeOrcamentaria;
    }

    public void setIdUnidadeOrcamentaria(UnidadeOrcamentaria idUnidadeOrcamentaria) {
        this.idUnidadeOrcamentaria = idUnidadeOrcamentaria;
    }

    @XmlTransient
    public List<Subfuncao> getSubfuncaoList() {
        return subfuncaoList;
    }

    public void setSubfuncaoList(List<Subfuncao> subfuncaoList) {
        this.subfuncaoList = subfuncaoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idFuncao != null ? idFuncao.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Funcao)) {
            return false;
        }
        Funcao other = (Funcao) object;
        if ((this.idFuncao == null && other.idFuncao != null) || (this.idFuncao != null && !this.idFuncao.equals(other.idFuncao))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Funcao[ idFuncao=" + idFuncao + " ]";
    }
    
}
