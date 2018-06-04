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
@Table(name = "apartamento", catalog = "condominio", schema = "")
@NamedQueries({
    @NamedQuery(name = "Apartamento.findAll", query = "SELECT a FROM Apartamento a")
    , @NamedQuery(name = "Apartamento.findById", query = "SELECT a FROM Apartamento a WHERE a.id = :id")
    , @NamedQuery(name = "Apartamento.findByQtdQuarto", query = "SELECT a FROM Apartamento a WHERE a.qtdQuarto = :qtdQuarto")
    , @NamedQuery(name = "Apartamento.findByEstado", query = "SELECT a FROM Apartamento a WHERE a.estado = :estado")
    , @NamedQuery(name = "Apartamento.findByIdCondominio", query = "SELECT a FROM Apartamento a WHERE a.idCondominio = :idCondominio")})
public class Apartamento implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "qtd_quarto")
    private Integer qtdQuarto;
    @Column(name = "estado")
    private String estado;
    @Column(name = "id_condominio")
    private Integer idCondominio;

    public Apartamento() {
    }

    public Apartamento(Integer id) {
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

    public Integer getQtdQuarto() {
        return qtdQuarto;
    }

    public void setQtdQuarto(Integer qtdQuarto) {
        Integer oldQtdQuarto = this.qtdQuarto;
        this.qtdQuarto = qtdQuarto;
        changeSupport.firePropertyChange("qtdQuarto", oldQtdQuarto, qtdQuarto);
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        String oldEstado = this.estado;
        this.estado = estado;
        changeSupport.firePropertyChange("estado", oldEstado, estado);
    }

    public Integer getIdCondominio() {
        return idCondominio;
    }

    public void setIdCondominio(Integer idCondominio) {
        Integer oldIdCondominio = this.idCondominio;
        this.idCondominio = idCondominio;
        changeSupport.firePropertyChange("idCondominio", oldIdCondominio, idCondominio);
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
        if (!(object instanceof Apartamento)) {
            return false;
        }
        Apartamento other = (Apartamento) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "form.Apartamento[ id=" + id + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
