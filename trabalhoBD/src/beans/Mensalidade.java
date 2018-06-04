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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author ismae
 */
@Entity
@Table(name = "mensalidade", catalog = "condominio", schema = "")
@NamedQueries({
    @NamedQuery(name = "Mensalidade.findAll", query = "SELECT m FROM Mensalidade m")
    , @NamedQuery(name = "Mensalidade.findById", query = "SELECT m FROM Mensalidade m WHERE m.id = :id")
    , @NamedQuery(name = "Mensalidade.findByIdAluguel", query = "SELECT m FROM Mensalidade m WHERE m.idAluguel = :idAluguel")
    , @NamedQuery(name = "Mensalidade.findByValor", query = "SELECT m FROM Mensalidade m WHERE m.valor = :valor")
    , @NamedQuery(name = "Mensalidade.findByStatus", query = "SELECT m FROM Mensalidade m WHERE m.status = :status")
    , @NamedQuery(name = "Mensalidade.findByMes", query = "SELECT m FROM Mensalidade m WHERE m.mes = :mes")})
public class Mensalidade implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "id_aluguel")
    private Integer idAluguel;
    @Column(name = "valor")
    private Integer valor;
    @Column(name = "status")
    private String status;
    @Column(name = "mes")
    private String mes;

    public Mensalidade() {
    }

    public Mensalidade(Integer id) {
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

    public Integer getIdAluguel() {
        return idAluguel;
    }

    public void setIdAluguel(Integer idAluguel) {
        Integer oldIdAluguel = this.idAluguel;
        this.idAluguel = idAluguel;
        changeSupport.firePropertyChange("idAluguel", oldIdAluguel, idAluguel);
    }

    public Integer getValor() {
        return valor;
    }

    public void setValor(Integer valor) {
        Integer oldValor = this.valor;
        this.valor = valor;
        changeSupport.firePropertyChange("valor", oldValor, valor);
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        String oldStatus = this.status;
        this.status = status;
        changeSupport.firePropertyChange("status", oldStatus, status);
    }

    public String getMes() {
        return mes;
    }

    public void setMes(String mes) {
        String oldMes = this.mes;
        this.mes = mes;
        changeSupport.firePropertyChange("mes", oldMes, mes);
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
        if (!(object instanceof Mensalidade)) {
            return false;
        }
        Mensalidade other = (Mensalidade) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "form.Mensalidade[ id=" + id + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
