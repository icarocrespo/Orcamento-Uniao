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
@Table(name = "acao")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Acao.findAll", query = "SELECT a FROM Acao a")
    , @NamedQuery(name = "Acao.findByIdAcao", query = "SELECT a FROM Acao a WHERE a.idAcao = :idAcao")
    , @NamedQuery(name = "Acao.findByNomeAcao", query = "SELECT a FROM Acao a WHERE a.nomeAcao = :nomeAcao")})
public class Acao implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_acao")
    private String idAcao;
    @Basic(optional = false)
    @Column(name = "nome_acao")
    private String nomeAcao;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idAcao", fetch = FetchType.EAGER)
    private List<CategoriaEconomica> categoriaEconomicaList;
    @JoinColumn(name = "id_programa_orcamentario", referencedColumnName = "id_programa_orcamentario")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private ProgramaOrcamentario idProgramaOrcamentario;

    public Acao() {
    }

    public Acao(String idAcao) {
        this.idAcao = idAcao;
    }

    public Acao(String idAcao, String nomeAcao) {
        this.idAcao = idAcao;
        this.nomeAcao = nomeAcao;
    }

    public String getIdAcao() {
        return idAcao;
    }

    public void setIdAcao(String idAcao) {
        this.idAcao = idAcao;
    }

    public String getNomeAcao() {
        return nomeAcao;
    }

    public void setNomeAcao(String nomeAcao) {
        this.nomeAcao = nomeAcao;
    }

    @XmlTransient
    public List<CategoriaEconomica> getCategoriaEconomicaList() {
        return categoriaEconomicaList;
    }

    public void setCategoriaEconomicaList(List<CategoriaEconomica> categoriaEconomicaList) {
        this.categoriaEconomicaList = categoriaEconomicaList;
    }

    public ProgramaOrcamentario getIdProgramaOrcamentario() {
        return idProgramaOrcamentario;
    }

    public void setIdProgramaOrcamentario(ProgramaOrcamentario idProgramaOrcamentario) {
        this.idProgramaOrcamentario = idProgramaOrcamentario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAcao != null ? idAcao.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Acao)) {
            return false;
        }
        Acao other = (Acao) object;
        if ((this.idAcao == null && other.idAcao != null) || (this.idAcao != null && !this.idAcao.equals(other.idAcao))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Acao[ idAcao=" + idAcao + " ]";
    }
    
}
