package com.banco.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;


/**
* @author Zathura Code Generator http://zathuracode.org/
* www.zathuracode.org
*
*/
@Entity
@Table(name = "tipoTransaccion", schema = "public")
public class TipoTransaccion implements java.io.Serializable {
    
	private static final long serialVersionUID = -5015701086526193616L;
	
	@Id
    private Long titrId;
    @NotEmpty
    @Size(max = 1)
    private String activo;
    @NotEmpty
    @Size(max = 255)
    private String nombre;
    private Set<Transaccion> transaccions = new HashSet<Transaccion>(0);

    public TipoTransaccion() {
    }

    public TipoTransaccion(Long titrId, String activo, String nombre,
        Set<Transaccion> transaccions) {
        this.titrId = titrId;
        this.activo = activo;
        this.nombre = nombre;
        this.transaccions = transaccions;
    }

    public Long getTitrId() {
        return this.titrId;
    }

    public void setTitrId(Long titrId) {
        this.titrId = titrId;
    }

    public String getActivo() {
        return this.activo;
    }

    public void setActivo(String activo) {
        this.activo = activo;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Set<Transaccion> getTransaccions() {
        return this.transaccions;
    }

    public void setTransaccions(Set<Transaccion> transaccions) {
        this.transaccions = transaccions;
    }
}
