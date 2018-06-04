/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author ismae
 */
@Entity
@Table(name = "contrato", catalog = "condominio", schema = "")
@NamedQueries({
    @NamedQuery(name = "Contrato.findAll", query = "SELECT c FROM Contrato c")
    , @NamedQuery(name = "Contrato.findById", query = "SELECT c FROM Contrato c WHERE c.id = :id")
    , @NamedQuery(name = "Contrato.findByDataInicio", query = "SELECT c FROM Contrato c WHERE c.dataInicio = :dataInicio")
    , @NamedQuery(name = "Contrato.findByDataFim", query = "SELECT c FROM Contrato c WHERE c.dataFim = :dataFim")
    , @NamedQuery(name = "Contrato.findByIdLocatario", query = "SELECT c FROM Contrato c WHERE c.idLocatario = :idLocatario")
    , @NamedQuery(name = "Contrato.findByIdLocador", query = "SELECT c FROM Contrato c WHERE c.idLocador = :idLocador")
    , @NamedQuery(name = "Contrato.findByStatus", query = "SELECT c FROM Contrato c WHERE c.status = :status")})
public class Contrato implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "data_inicio")
    private String dataInicio;
    @Column(name = "data_fim")
    private String dataFim;
    @Column(name = "id_locatario")
    private Integer idLocatario;
    @Column(name = "id_locador")
    private Integer idLocador;
    @Column(name = "status")
    private String status;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idContrato2")
    private Collection<Aluguel> aluguelCollection;

    public Contrato() {
    }

    public Contrato(Integer id) {
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

    public String getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(String dataInicio) {
        String oldDataInicio = this.dataInicio;
        this.dataInicio = dataInicio;
        changeSupport.firePropertyChange("dataInicio", oldDataInicio, dataInicio);
    }

    public String getDataFim() {
        return dataFim;
    }

    public void setDataFim(String dataFim) {
        String oldDataFim = this.dataFim;
        this.dataFim = dataFim;
        changeSupport.firePropertyChange("dataFim", oldDataFim, dataFim);
    }

    public Integer getIdLocatario() {
        return idLocatario;
    }

    public void setIdLocatario(Integer idLocatario) {
        Integer oldIdLocatario = this.idLocatario;
        this.idLocatario = idLocatario;
        changeSupport.firePropertyChange("idLocatario", oldIdLocatario, idLocatario);
    }

    public Integer getIdLocador() {
        return idLocador;
    }

    public void setIdLocador(Integer idLocador) {
        Integer oldIdLocador = this.idLocador;
        this.idLocador = idLocador;
        changeSupport.firePropertyChange("idLocador", oldIdLocador, idLocador);
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        String oldStatus = this.status;
        this.status = status;
        changeSupport.firePropertyChange("status", oldStatus, status);
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
        if (!(object instanceof Contrato)) {
            return false;
        }
        Contrato other = (Contrato) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "form.Contrato[ id=" + id + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }

    public Collection<Aluguel> getAluguelCollection() {
        return aluguelCollection;
    }

    public void setAluguelCollection(Collection<Aluguel> aluguelCollection) {
        this.aluguelCollection = aluguelCollection;
    }
    
}
