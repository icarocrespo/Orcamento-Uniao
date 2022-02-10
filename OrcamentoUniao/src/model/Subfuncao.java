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
@Table(name = "subfuncao")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Subfuncao.findAll", query = "SELECT s FROM Subfuncao s")
    , @NamedQuery(name = "Subfuncao.findByIdSubfuncao", query = "SELECT s FROM Subfuncao s WHERE s.idSubfuncao = :idSubfuncao")
    , @NamedQuery(name = "Subfuncao.findByNomeSubfuncao", query = "SELECT s FROM Subfuncao s WHERE s.nomeSubfuncao = :nomeSubfuncao")})
public class Subfuncao implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_subfuncao")
    private Integer idSubfuncao;
    @Basic(optional = false)
    @Column(name = "nome_subfuncao")
    private String nomeSubfuncao;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idSubfuncao", fetch = FetchType.EAGER)
    private List<ProgramaOrcamentario> programaOrcamentarioList;
    @JoinColumn(name = "id_funcao", referencedColumnName = "id_funcao")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Funcao idFuncao;

    public Subfuncao() {
    }

    public Subfuncao(Integer idSubfuncao) {
        this.idSubfuncao = idSubfuncao;
    }

    public Subfuncao(Integer idSubfuncao, String nomeSubfuncao) {
        this.idSubfuncao = idSubfuncao;
        this.nomeSubfuncao = nomeSubfuncao;
    }

    public Integer getIdSubfuncao() {
        return idSubfuncao;
    }

    public void setIdSubfuncao(Integer idSubfuncao) {
        this.idSubfuncao = idSubfuncao;
    }

    public String getNomeSubfuncao() {
        return nomeSubfuncao;
    }

    public void setNomeSubfuncao(String nomeSubfuncao) {
        this.nomeSubfuncao = nomeSubfuncao;
    }

    @XmlTransient
    public List<ProgramaOrcamentario> getProgramaOrcamentarioList() {
        return programaOrcamentarioList;
    }

    public void setProgramaOrcamentarioList(List<ProgramaOrcamentario> programaOrcamentarioList) {
        this.programaOrcamentarioList = programaOrcamentarioList;
    }

    public Funcao getIdFuncao() {
        return idFuncao;
    }

    public void setIdFuncao(Funcao idFuncao) {
        this.idFuncao = idFuncao;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idSubfuncao != null ? idSubfuncao.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Subfuncao)) {
            return false;
        }
        Subfuncao other = (Subfuncao) object;
        if ((this.idSubfuncao == null && other.idSubfuncao != null) || (this.idSubfuncao != null && !this.idSubfuncao.equals(other.idSubfuncao))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Subfuncao[ idSubfuncao=" + idSubfuncao + " ]";
    }
    
}
