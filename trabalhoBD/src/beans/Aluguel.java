/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author ismae
 */
@Entity
@Table(name = "aluguel", catalog = "condominio", schema = "")
@NamedQueries({
    @NamedQuery(name = "Aluguel.findAll", query = "SELECT a FROM Aluguel a")
    , @NamedQuery(name = "Aluguel.findById", query = "SELECT a FROM Aluguel a WHERE a.id = :id")
    , @NamedQuery(name = "Aluguel.findByIdApartamento", query = "SELECT a FROM Aluguel a WHERE a.idApartamento = :idApartamento")
    , @NamedQuery(name = "Aluguel.findByIdContrato", query = "SELECT a FROM Aluguel a WHERE a.idContrato = :idContrato")})
public class Aluguel implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "id_apartamento")
    private Integer idApartamento;
    @Column(name = "id_contrato")
    private Integer idContrato;
    @JoinColumn(name = "id_contrato", referencedColumnName = "id", updatable = false, insertable = false)
    @ManyToOne
    private Contrato idContrato2;

    public Aluguel() {
    }

    public Aluguel(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        Integer oldId = this.id;
        this.id = id;
        changeSupport.firePropertyChange("id", oldId, id);
    }

    public Integer getIdApartamento() {
        return idApartamento;
    }

    public void setIdApartamento(Integer idApartamento) {
        Integer oldIdApartamento = this.idApartamento;
        this.idApartamento = idApartamento;
        changeSupport.firePropertyChange("idApartamento", oldIdApartamento, idApartamento);
    }

    public Integer getIdContrato() {
        return idContrato;
    }

    public void setIdContrato(Integer idContrato) {
        Integer oldIdContrato = this.idContrato;
        this.idContrato = idContrato;
        changeSupport.firePropertyChange("idContrato", oldIdContrato, idContrato);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Aluguel)) {
            return false;
        }
        Aluguel other = (Aluguel) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "form.Aluguel[ id=" + id + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }

    public Contrato getIdContrato2() {
        return idContrato2;
    }

    public void setIdContrato2(Contrato idContrato2) {
        Contrato oldIdContrato2 = this.idContrato2;
        this.idContrato2 = idContrato2;
        changeSupport.firePropertyChange("idContrato2", oldIdContrato2, idContrato2);
    }
    
}
