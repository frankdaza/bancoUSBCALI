package com.banco.dto.mapper;

import com.banco.model.Cuenta;
import com.banco.model.dto.CuentaDTO;

import java.util.List;


/**
* @author Zathura Code Generator http://zathuracode.org/
* www.zathuracode.org
*
*/
public interface ICuentaMapper {
    public CuentaDTO cuentaToCuentaDTO(Cuenta cuenta) throws Exception;

    public Cuenta cuentaDTOToCuenta(CuentaDTO cuentaDTO)
        throws Exception;

    public List<CuentaDTO> listCuentaToListCuentaDTO(List<Cuenta> cuentas)
        throws Exception;

    public List<Cuenta> listCuentaDTOToListCuenta(List<CuentaDTO> cuentaDTOs)
        throws Exception;
}
