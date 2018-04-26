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
@Table(name = "tipoDocumento", schema = "public")
public class TipoDocumento implements java.io.Serializable {
    
	private static final long serialVersionUID = -2085764965729688224L;
	
	@Id
    private Long tdocId;
    @NotEmpty
    @Size(max = 1)
    private String activo;
    @NotEmpty
    @Size(max = 255)
    private String nombre;
    private Set<Cliente> clientes = new HashSet<Cliente>(0);

    public TipoDocumento() {
    }

    public TipoDocumento(Long tdocId, String activo, Set<Cliente> clientes,
        String nombre) {
        this.tdocId = tdocId;
        this.activo = activo;
        this.nombre = nombre;
        this.clientes = clientes;
    }

    public Long getTdocId() {
        return this.tdocId;
    }

    public void setTdocId(Long tdocId) {
        this.tdocId = tdocId;
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

    public Set<Cliente> getClientes() {
        return this.clientes;
    }

    public void setClientes(Set<Cliente> clientes) {
        this.clientes = clientes;
    }
}
