/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.util;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author pc
 */
@Entity
@Table(name = "pedido")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pedido.findAll", query = "SELECT p FROM Pedido p")
    , @NamedQuery(name = "Pedido.findById", query = "SELECT p FROM Pedido p WHERE p.id = :id")
    , @NamedQuery(name = "Pedido.findByNombre", query = "SELECT p FROM Pedido p WHERE p.nombre = :nombre")
    , @NamedQuery(name = "Pedido.findByPrecio", query = "SELECT p FROM Pedido p WHERE p.precio = :precio")
    , @NamedQuery(name = "Pedido.findByStock", query = "SELECT p FROM Pedido p WHERE p.stock = :stock")
    , @NamedQuery(name = "Pedido.findByCantidadCompra", query = "SELECT p FROM Pedido p WHERE p.cantidadCompra = :cantidadCompra")
    , @NamedQuery(name = "Pedido.findByFecha", query = "SELECT p FROM Pedido p WHERE p.fecha = :fecha")})
public class Pedido implements Serializable {

    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "subtotal")
    private Float subtotal;
    @Column(name = "igv")
    private Float igv;
    @Column(name = "total")
    private Float total;

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Column(name = "precio")
    private double precio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Stock")
    private int stock;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cantidadCompra")
    private int cantidadCompra;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;

    public Pedido() {
    }

    public Pedido(Integer id) {
        this.id = id;
    }

    public Pedido(Integer id, String nombre, double precio, int stock, int cantidadCompra, Date fecha) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
        this.cantidadCompra = cantidadCompra;
        this.fecha = fecha;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getCantidadCompra() {
        return cantidadCompra;
    }

    public void setCantidadCompra(int cantidadCompra) {
        this.cantidadCompra = cantidadCompra;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
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
        if (!(object instanceof Pedido)) {
            return false;
        }
        Pedido other = (Pedido) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.util.Pedido[ id=" + id + " ]";
    }

    public double getSubtotal() {
        return cantidadCompra*precio;
    }

    public void setSubtotal(Float subtotal) {
        this.subtotal = subtotal;
    }

    public double getIgv() {
        return cantidadCompra*precio*0.18;
    }

    public void setIgv(Float igv) {
        this.igv = igv;
    }

    public double getTotal() {
        return cantidadCompra*precio*0.18 + cantidadCompra*precio;
    }

    public void setTotal(Float total) {
        this.total = total;
    }
    
}
