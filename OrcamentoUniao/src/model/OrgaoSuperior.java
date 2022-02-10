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
@Table(name = "orgao_superior")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OrgaoSuperior.findAll", query = "SELECT o FROM OrgaoSuperior o")
    , @NamedQuery(name = "OrgaoSuperior.findByIdOrgaoSuperior", query = "SELECT o FROM OrgaoSuperior o WHERE o.idOrgaoSuperior = :idOrgaoSuperior")
    , @NamedQuery(name = "OrgaoSuperior.findByNomeOrgaoSuperior", query = "SELECT o FROM OrgaoSuperior o WHERE o.nomeOrgaoSuperior = :nomeOrgaoSuperior")
    , @NamedQuery(name = "OrgaoSuperior.findByExercicio", query = "SELECT o FROM OrgaoSuperior o WHERE o.exercicio = :exercicio")})
public class OrgaoSuperior implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_orgao_superior")
    private Integer idOrgaoSuperior;
    @Basic(optional = false)
    @Column(name = "nome_orgao_superior")
    private String nomeOrgaoSuperior;
    @Basic(optional = false)
    @Column(name = "exercicio")
    private int exercicio;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idOrgaoSuperior", fetch = FetchType.EAGER)
    private List<OrgaoSubordinado> orgaoSubordinadoList;

    public OrgaoSuperior() {
    }

    public OrgaoSuperior(Integer idOrgaoSuperior) {
        this.idOrgaoSuperior = idOrgaoSuperior;
    }

    public OrgaoSuperior(Integer idOrgaoSuperior, String nomeOrgaoSuperior, int exercicio) {
        this.idOrgaoSuperior = idOrgaoSuperior;
        this.nomeOrgaoSuperior = nomeOrgaoSuperior;
        this.exercicio = exercicio;
    }

    public Integer getIdOrgaoSuperior() {
        return idOrgaoSuperior;
    }

    public void setIdOrgaoSuperior(Integer idOrgaoSuperior) {
        this.idOrgaoSuperior = idOrgaoSuperior;
    }

    public String getNomeOrgaoSuperior() {
        return nomeOrgaoSuperior;
    }

    public void setNomeOrgaoSuperior(String nomeOrgaoSuperior) {
        this.nomeOrgaoSuperior = nomeOrgaoSuperior;
    }

    public int getExercicio() {
        return exercicio;
    }

    public void setExercicio(int exercicio) {
        this.exercicio = exercicio;
    }

    @XmlTransient
    public List<OrgaoSubordinado> getOrgaoSubordinadoList() {
        return orgaoSubordinadoList;
    }

    public void setOrgaoSubordinadoList(List<OrgaoSubordinado> orgaoSubordinadoList) {
        this.orgaoSubordinadoList = orgaoSubordinadoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idOrgaoSuperior != null ? idOrgaoSuperior.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OrgaoSuperior)) {
            return false;
        }
        OrgaoSuperior other = (OrgaoSuperior) object;
        if ((this.idOrgaoSuperior == null && other.idOrgaoSuperior != null) || (this.idOrgaoSuperior != null && !this.idOrgaoSuperior.equals(other.idOrgaoSuperior))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.OrgaoSuperior[ idOrgaoSuperior=" + idOrgaoSuperior + " ]";
    }
    
}
