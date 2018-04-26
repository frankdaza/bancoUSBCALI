package com.banco.dto.mapper;

import com.banco.model.CuentaRegistrada;
import com.banco.model.dto.CuentaRegistradaDTO;

import java.util.List;


/**
* @author Zathura Code Generator http://zathuracode.org/
* www.zathuracode.org
*
*/
public interface ICuentaRegistradaMapper {
    public CuentaRegistradaDTO cuentaRegistradaToCuentaRegistradaDTO(
        CuentaRegistrada cuentaRegistrada) throws Exception;

    public CuentaRegistrada cuentaRegistradaDTOToCuentaRegistrada(
        CuentaRegistradaDTO cuentaRegistradaDTO) throws Exception;

    public List<CuentaRegistradaDTO> listCuentaRegistradaToListCuentaRegistradaDTO(
        List<CuentaRegistrada> cuentaRegistradas) throws Exception;

    public List<CuentaRegistrada> listCuentaRegistradaDTOToListCuentaRegistrada(
        List<CuentaRegistradaDTO> cuentaRegistradaDTOs)
        throws Exception;
}
