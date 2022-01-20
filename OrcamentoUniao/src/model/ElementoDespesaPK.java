/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author icaro
 */
@Embeddable
public class ElementoDespesaPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "id_elemento_despesa")
    private int idElementoDespesa;
    @Basic(optional = false)
    @Column(name = "id_grupo_despesa")
    private int idGrupoDespesa;

    public ElementoDespesaPK() {
    }

    public ElementoDespesaPK(int idElementoDespesa, int idGrupoDespesa) {
        this.idElementoDespesa = idElementoDespesa;
        this.idGrupoDespesa = idGrupoDespesa;
    }

    public int getIdElementoDespesa() {
        return idElementoDespesa;
    }

    public void setIdElementoDespesa(int idElementoDespesa) {
        this.idElementoDespesa = idElementoDespesa;
    }

    public int getIdGrupoDespesa() {
        return idGrupoDespesa;
    }

    public void setIdGrupoDespesa(int idGrupoDespesa) {
        this.idGrupoDespesa = idGrupoDespesa;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idElementoDespesa;
        hash += (int) idGrupoDespesa;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ElementoDespesaPK)) {
            return false;
        }
        ElementoDespesaPK other = (ElementoDespesaPK) object;
        if (this.idElementoDespesa != other.idElementoDespesa) {
            return false;
        }
        if (this.idGrupoDespesa != other.idGrupoDespesa) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.ElementoDespesaPK[ idElementoDespesa=" + idElementoDespesa + ", idGrupoDespesa=" + idGrupoDespesa + " ]";
    }
    
}
