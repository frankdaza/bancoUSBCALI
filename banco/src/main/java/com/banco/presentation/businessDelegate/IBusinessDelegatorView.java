package com.banco.presentation.businessDelegate;

import java.util.List;

import com.banco.model.Cliente;
import com.banco.model.Cuenta;
import com.banco.model.CuentaRegistrada;
import com.banco.model.TipoDocumento;
import com.banco.model.TipoTransaccion;
import com.banco.model.TipoUsuario;
import com.banco.model.Transaccion;
import com.banco.model.Usuario;
import com.banco.model.dto.ClienteDTO;
import com.banco.model.dto.CuentaDTO;
import com.banco.model.dto.CuentaRegistradaDTO;
import com.banco.model.dto.RespuestaDTO;
import com.banco.model.dto.TipoDocumentoDTO;
import com.banco.model.dto.TipoTransaccionDTO;
import com.banco.model.dto.TipoUsuarioDTO;
import com.banco.model.dto.TransaccionDTO;
import com.banco.model.dto.UsuarioDTO;


/**
* @author Zathura Code Generator http://zathuracode.org/
* www.zathuracode.org
*
*/
public interface IBusinessDelegatorView {
    public List<Cuenta> getCuenta() throws Exception;

    public void saveCuenta(Cuenta entity) throws Exception;

    public void deleteCuenta(Cuenta entity) throws Exception;

    public void updateCuenta(Cuenta entity) throws Exception;

    public Cuenta getCuenta(String cuenId) throws Exception;

    public List<Cuenta> findByCriteriaInCuenta(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<Cuenta> findPageCuenta(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception;

    public Long findTotalNumberCuenta() throws Exception;

    public List<CuentaDTO> getDataCuenta() throws Exception;

    public void validateCuenta(Cuenta cuenta) throws Exception;

    public List<CuentaRegistrada> getCuentaRegistrada()
        throws Exception;

    public void saveCuentaRegistrada(CuentaRegistrada entity)
        throws Exception;

    public void deleteCuentaRegistrada(CuentaRegistrada entity)
        throws Exception;

    public void updateCuentaRegistrada(CuentaRegistrada entity)
        throws Exception;

    public CuentaRegistrada getCuentaRegistrada(Long cureId)
        throws Exception;

    public List<CuentaRegistrada> findByCriteriaInCuentaRegistrada(
        Object[] variables, Object[] variablesBetween,
        Object[] variablesBetweenDates) throws Exception;

    public List<CuentaRegistrada> findPageCuentaRegistrada(
        String sortColumnName, boolean sortAscending, int startRow,
        int maxResults) throws Exception;

    public Long findTotalNumberCuentaRegistrada() throws Exception;

    public List<CuentaRegistradaDTO> getDataCuentaRegistrada()
        throws Exception;

    public void validateCuentaRegistrada(CuentaRegistrada cuentaRegistrada)
        throws Exception;

    public List<Transaccion> getTransaccion() throws Exception;

    public void saveTransaccion(Transaccion entity) throws Exception;

    public void deleteTransaccion(Transaccion entity) throws Exception;

    public void updateTransaccion(Transaccion entity) throws Exception;

    public Transaccion getTransaccion(Long tranId) throws Exception;

    public List<Transaccion> findByCriteriaInTransaccion(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<Transaccion> findPageTransaccion(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception;

    public Long findTotalNumberTransaccion() throws Exception;

    public List<TransaccionDTO> getDataTransaccion() throws Exception;

    public void validateTransaccion(Transaccion transaccion)
        throws Exception;

    public List<Cliente> getCliente() throws Exception;

    public void saveCliente(Cliente entity) throws Exception;

    public void deleteCliente(Cliente entity) throws Exception;

    public void updateCliente(Cliente entity) throws Exception;

    public Cliente getCliente(Long clieId) throws Exception;

    public List<Cliente> findByCriteriaInCliente(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<Cliente> findPageCliente(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception;

    public Long findTotalNumberCliente() throws Exception;

    public List<ClienteDTO> getDataCliente() throws Exception;

    public void validateCliente(Cliente cliente) throws Exception;

    public List<TipoTransaccion> getTipoTransaccion() throws Exception;

    public void saveTipoTransaccion(TipoTransaccion entity)
        throws Exception;

    public void deleteTipoTransaccion(TipoTransaccion entity)
        throws Exception;

    public void updateTipoTransaccion(TipoTransaccion entity)
        throws Exception;

    public TipoTransaccion getTipoTransaccion(Long titrId)
        throws Exception;

    public List<TipoTransaccion> findByCriteriaInTipoTransaccion(
        Object[] variables, Object[] variablesBetween,
        Object[] variablesBetweenDates) throws Exception;

    public List<TipoTransaccion> findPageTipoTransaccion(
        String sortColumnName, boolean sortAscending, int startRow,
        int maxResults) throws Exception;

    public Long findTotalNumberTipoTransaccion() throws Exception;

    public List<TipoTransaccionDTO> getDataTipoTransaccion()
        throws Exception;

    public void validateTipoTransaccion(TipoTransaccion tipoTransaccion)
        throws Exception;

    public List<TipoDocumento> getTipoDocumento() throws Exception;

    public void saveTipoDocumento(TipoDocumento entity)
        throws Exception;

    public void deleteTipoDocumento(TipoDocumento entity)
        throws Exception;

    public void updateTipoDocumento(TipoDocumento entity)
        throws Exception;

    public TipoDocumento getTipoDocumento(Long tdocId)
        throws Exception;

    public List<TipoDocumento> findByCriteriaInTipoDocumento(
        Object[] variables, Object[] variablesBetween,
        Object[] variablesBetweenDates) throws Exception;

    public List<TipoDocumento> findPageTipoDocumento(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception;

    public Long findTotalNumberTipoDocumento() throws Exception;

    public List<TipoDocumentoDTO> getDataTipoDocumento()
        throws Exception;

    public void validateTipoDocumento(TipoDocumento tipoDocumento)
        throws Exception;

    public List<Usuario> getUsuario() throws Exception;

    public void saveUsuario(Usuario entity) throws Exception;

    public void deleteUsuario(Usuario entity) throws Exception;

    public void updateUsuario(Usuario entity) throws Exception;

    public Usuario getUsuario(String usuUsuario) throws Exception;

    public List<Usuario> findByCriteriaInUsuario(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<Usuario> findPageUsuario(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception;

    public Long findTotalNumberUsuario() throws Exception;

    public List<UsuarioDTO> getDataUsuario() throws Exception;

    public void validateUsuario(Usuario usuario) throws Exception;

    public List<TipoUsuario> getTipoUsuario() throws Exception;

    public void saveTipoUsuario(TipoUsuario entity) throws Exception;

    public void deleteTipoUsuario(TipoUsuario entity) throws Exception;

    public void updateTipoUsuario(TipoUsuario entity) throws Exception;

    public TipoUsuario getTipoUsuario(Long tiusId) throws Exception;

    public List<TipoUsuario> findByCriteriaInTipoUsuario(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<TipoUsuario> findPageTipoUsuario(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception;

    public Long findTotalNumberTipoUsuario() throws Exception;

    public List<TipoUsuarioDTO> getDataTipoUsuario() throws Exception;

    public void validateTipoUsuario(TipoUsuario tipoUsuario)
        throws Exception;

    /**
     * Retorna un usuario por login.
     * 
     * @param login
     * @return
     * @throws Exception
     */
    Usuario getUsuarioPorLogin(String login) throws Exception;
    
    Integer consignarACuenta(String numeroCuenta, String login, Double valor) throws Exception;
    
    RespuestaDTO retirarDinero(String numeroCuenta, String login, Double valor) throws Exception;

}
