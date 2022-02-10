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
@Table(name = "programa_orcamentario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProgramaOrcamentario.findAll", query = "SELECT p FROM ProgramaOrcamentario p")
    , @NamedQuery(name = "ProgramaOrcamentario.findByIdProgramaOrcamentario", query = "SELECT p FROM ProgramaOrcamentario p WHERE p.idProgramaOrcamentario = :idProgramaOrcamentario")
    , @NamedQuery(name = "ProgramaOrcamentario.findByNomeProgramaOrcamentario", query = "SELECT p FROM ProgramaOrcamentario p WHERE p.nomeProgramaOrcamentario = :nomeProgramaOrcamentario")})
public class ProgramaOrcamentario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_programa_orcamentario")
    private Integer idProgramaOrcamentario;
    @Basic(optional = false)
    @Column(name = "nome_programa_orcamentario")
    private String nomeProgramaOrcamentario;
    @JoinColumn(name = "id_subfuncao", referencedColumnName = "id_subfuncao")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Subfuncao idSubfuncao;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idProgramaOrcamentario", fetch = FetchType.EAGER)
    private List<Acao> acaoList;

    public ProgramaOrcamentario() {
    }

    public ProgramaOrcamentario(Integer idProgramaOrcamentario) {
        this.idProgramaOrcamentario = idProgramaOrcamentario;
    }

    public ProgramaOrcamentario(Integer idProgramaOrcamentario, String nomeProgramaOrcamentario) {
        this.idProgramaOrcamentario = idProgramaOrcamentario;
        this.nomeProgramaOrcamentario = nomeProgramaOrcamentario;
    }

    public Integer getIdProgramaOrcamentario() {
        return idProgramaOrcamentario;
    }

    public void setIdProgramaOrcamentario(Integer idProgramaOrcamentario) {
        this.idProgramaOrcamentario = idProgramaOrcamentario;
    }

    public String getNomeProgramaOrcamentario() {
        return nomeProgramaOrcamentario;
    }

    public void setNomeProgramaOrcamentario(String nomeProgramaOrcamentario) {
        this.nomeProgramaOrcamentario = nomeProgramaOrcamentario;
    }

    public Subfuncao getIdSubfuncao() {
        return idSubfuncao;
    }

    public void setIdSubfuncao(Subfuncao idSubfuncao) {
        this.idSubfuncao = idSubfuncao;
    }

    @XmlTransient
    public List<Acao> getAcaoList() {
        return acaoList;
    }

    public void setAcaoList(List<Acao> acaoList) {
        this.acaoList = acaoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idProgramaOrcamentario != null ? idProgramaOrcamentario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProgramaOrcamentario)) {
            return false;
        }
        ProgramaOrcamentario other = (ProgramaOrcamentario) object;
        if ((this.idProgramaOrcamentario == null && other.idProgramaOrcamentario != null) || (this.idProgramaOrcamentario != null && !this.idProgramaOrcamentario.equals(other.idProgramaOrcamentario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.ProgramaOrcamentario[ idProgramaOrcamentario=" + idProgramaOrcamentario + " ]";
    }
    
}
