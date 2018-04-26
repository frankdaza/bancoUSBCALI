package com.banco.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;


/**
* @author Zathura Code Generator http://zathuracode.org/
* www.zathuracode.org
*
*/
@Entity
@Table(name = "cuentaRegistrada", schema = "public")
public class CuentaRegistrada implements java.io.Serializable {

	private static final long serialVersionUID = -4551714861172678878L;

	@Id
    private Long cureId;
    @NotNull
    private Cliente cliente;
    @NotNull
    private Cuenta cuenta;

    public CuentaRegistrada() {
    }

    public CuentaRegistrada(Long cureId, Cliente cliente, Cuenta cuenta) {
        this.cureId = cureId;
        this.cliente = cliente;
        this.cuenta = cuenta;
    }

    public Long getCureId() {
        return this.cureId;
    }

    public void setCureId(Long cureId) {
        this.cureId = cureId;
    }

    public Cliente getCliente() {
        return this.cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Cuenta getCuenta() {
        return this.cuenta;
    }

    public void setCuenta(Cuenta cuenta) {
        this.cuenta = cuenta;
    }
}
