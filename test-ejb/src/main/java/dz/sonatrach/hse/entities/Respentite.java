/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dz.sonatrach.hse.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author pc
 */
@Entity
@Table(name = "RESPENTITE", catalog = "", schema = "HSEMS_DB")
@NamedQueries({
    @NamedQuery(name = "Respentite.findAll", query = "SELECT r FROM Respentite r")
    , @NamedQuery(name = "Respentite.findByIduser", query = "SELECT r FROM Respentite r WHERE r.iduser = :iduser")})
public class Respentite implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "IDUSER")
    private String iduser;
    @JoinColumn(name = "IDENTITE", referencedColumnName = "IDENTITE")
    @ManyToOne
    private Entite identite;
    @JoinColumn(name = "IDUSER", referencedColumnName = "IDUSER", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Utilisateur utilisateur;

    public Respentite() {
    }

    public Respentite(String iduser) {
        this.iduser = iduser;
    }

    public String getIduser() {
        return iduser;
    }

    public void setIduser(String iduser) {
        this.iduser = iduser;
    }

    public Entite getIdentite() {
        return identite;
    }

    public void setIdentite(Entite identite) {
        this.identite = identite;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iduser != null ? iduser.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Respentite)) {
            return false;
        }
        Respentite other = (Respentite) object;
        if ((this.iduser == null && other.iduser != null) || (this.iduser != null && !this.iduser.equals(other.iduser))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dz.sonatrach.hse.entities.Respentite[ iduser=" + iduser + " ]";
    }
    
}
