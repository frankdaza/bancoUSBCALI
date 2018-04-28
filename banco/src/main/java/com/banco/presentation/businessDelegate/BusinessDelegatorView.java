package com.banco.presentation.businessDelegate;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.banco.model.Cliente;
import com.banco.model.Cuenta;
import com.banco.model.CuentaRegistrada;
import com.banco.model.TipoDocumento;
import com.banco.model.TipoTransaccion;
import com.banco.model.TipoUsuario;
import com.banco.model.Transaccion;
import com.banco.model.Usuario;
import com.banco.model.control.IClienteLogic;
import com.banco.model.control.ICuentaLogic;
import com.banco.model.control.ICuentaRegistradaLogic;
import com.banco.model.control.ITipoDocumentoLogic;
import com.banco.model.control.ITipoTransaccionLogic;
import com.banco.model.control.ITipoUsuarioLogic;
import com.banco.model.control.ITransaccionLogic;
import com.banco.model.control.IUsuarioLogic;
import com.banco.model.dto.ClienteDTO;
import com.banco.model.dto.CuentaDTO;
import com.banco.model.dto.CuentaRegistradaDTO;
import com.banco.model.dto.RespuestaDTO;
import com.banco.model.dto.TipoDocumentoDTO;
import com.banco.model.dto.TipoTransaccionDTO;
import com.banco.model.dto.TipoUsuarioDTO;
import com.banco.model.dto.TransaccionDTO;
import com.banco.model.dto.UsuarioDTO;



@Scope("singleton")
@Service("BusinessDelegatorView")
public class BusinessDelegatorView implements IBusinessDelegatorView {
    
	@Autowired
    private ICuentaLogic cuentaLogic;
    @Autowired
    private ICuentaRegistradaLogic cuentaRegistradaLogic;
    @Autowired
    private ITransaccionLogic transaccionLogic;
    @Autowired
    private IClienteLogic clienteLogic;
    @Autowired
    private ITipoTransaccionLogic tipoTransaccionLogic;
    @Autowired
    private ITipoDocumentoLogic tipoDocumentoLogic;
    @Autowired
    private IUsuarioLogic usuarioLogic;
    @Autowired
    private ITipoUsuarioLogic tipoUsuarioLogic;

    public List<Cuenta> getCuenta() throws Exception {
        return cuentaLogic.getCuenta();
    }

    public void saveCuenta(Cuenta entity) throws Exception {
        cuentaLogic.saveCuenta(entity);
    }

    public void deleteCuenta(Cuenta entity) throws Exception {
        cuentaLogic.deleteCuenta(entity);
    }

    public void updateCuenta(Cuenta entity) throws Exception {
        cuentaLogic.updateCuenta(entity);
    }

    public Cuenta getCuenta(String cuenId) throws Exception {
        Cuenta cuenta = null;

        try {
            cuenta = cuentaLogic.getCuenta(cuenId);
        } catch (Exception e) {
            throw e;
        }

        return cuenta;
    }

    public List<Cuenta> findByCriteriaInCuenta(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception {
        return cuentaLogic.findByCriteria(variables, variablesBetween,
            variablesBetweenDates);
    }

    public List<Cuenta> findPageCuenta(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception {
        return cuentaLogic.findPageCuenta(sortColumnName, sortAscending,
            startRow, maxResults);
    }

    public Long findTotalNumberCuenta() throws Exception {
        return cuentaLogic.findTotalNumberCuenta();
    }

    public List<CuentaDTO> getDataCuenta() throws Exception {
        return cuentaLogic.getDataCuenta();
    }

    public void validateCuenta(Cuenta cuenta) throws Exception {
        cuentaLogic.validateCuenta(cuenta);
    }

    public List<CuentaRegistrada> getCuentaRegistrada()
        throws Exception {
        return cuentaRegistradaLogic.getCuentaRegistrada();
    }

    public void saveCuentaRegistrada(CuentaRegistrada entity)
        throws Exception {
        cuentaRegistradaLogic.saveCuentaRegistrada(entity);
    }

    public void deleteCuentaRegistrada(CuentaRegistrada entity)
        throws Exception {
        cuentaRegistradaLogic.deleteCuentaRegistrada(entity);
    }

    public void updateCuentaRegistrada(CuentaRegistrada entity)
        throws Exception {
        cuentaRegistradaLogic.updateCuentaRegistrada(entity);
    }

    public CuentaRegistrada getCuentaRegistrada(Long cureId)
        throws Exception {
        CuentaRegistrada cuentaRegistrada = null;

        try {
            cuentaRegistrada = cuentaRegistradaLogic.getCuentaRegistrada(cureId);
        } catch (Exception e) {
            throw e;
        }

        return cuentaRegistrada;
    }

    public List<CuentaRegistrada> findByCriteriaInCuentaRegistrada(
        Object[] variables, Object[] variablesBetween,
        Object[] variablesBetweenDates) throws Exception {
        return cuentaRegistradaLogic.findByCriteria(variables,
            variablesBetween, variablesBetweenDates);
    }

    public List<CuentaRegistrada> findPageCuentaRegistrada(
        String sortColumnName, boolean sortAscending, int startRow,
        int maxResults) throws Exception {
        return cuentaRegistradaLogic.findPageCuentaRegistrada(sortColumnName,
            sortAscending, startRow, maxResults);
    }

    public Long findTotalNumberCuentaRegistrada() throws Exception {
        return cuentaRegistradaLogic.findTotalNumberCuentaRegistrada();
    }

    public List<CuentaRegistradaDTO> getDataCuentaRegistrada()
        throws Exception {
        return cuentaRegistradaLogic.getDataCuentaRegistrada();
    }

    public void validateCuentaRegistrada(CuentaRegistrada cuentaRegistrada)
        throws Exception {
        cuentaRegistradaLogic.validateCuentaRegistrada(cuentaRegistrada);
    }

    public List<Transaccion> getTransaccion() throws Exception {
        return transaccionLogic.getTransaccion();
    }

    public void saveTransaccion(Transaccion entity) throws Exception {
        transaccionLogic.saveTransaccion(entity);
    }

    public void deleteTransaccion(Transaccion entity) throws Exception {
        transaccionLogic.deleteTransaccion(entity);
    }

    public void updateTransaccion(Transaccion entity) throws Exception {
        transaccionLogic.updateTransaccion(entity);
    }

    public Transaccion getTransaccion(Long tranId) throws Exception {
        Transaccion transaccion = null;

        try {
            transaccion = transaccionLogic.getTransaccion(tranId);
        } catch (Exception e) {
            throw e;
        }

        return transaccion;
    }

    public List<Transaccion> findByCriteriaInTransaccion(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception {
        return transaccionLogic.findByCriteria(variables, variablesBetween,
            variablesBetweenDates);
    }

    public List<Transaccion> findPageTransaccion(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception {
        return transaccionLogic.findPageTransaccion(sortColumnName,
            sortAscending, startRow, maxResults);
    }

    public Long findTotalNumberTransaccion() throws Exception {
        return transaccionLogic.findTotalNumberTransaccion();
    }

    public List<TransaccionDTO> getDataTransaccion() throws Exception {
        return transaccionLogic.getDataTransaccion();
    }

    public void validateTransaccion(Transaccion transaccion)
        throws Exception {
        transaccionLogic.validateTransaccion(transaccion);
    }

    public List<Cliente> getCliente() throws Exception {
        return clienteLogic.getCliente();
    }

    public void saveCliente(Cliente entity) throws Exception {
        clienteLogic.saveCliente(entity);
    }

    public void deleteCliente(Cliente entity) throws Exception {
        clienteLogic.deleteCliente(entity);
    }

    public void updateCliente(Cliente entity) throws Exception {
        clienteLogic.updateCliente(entity);
    }

    public Cliente getCliente(Long clieId) throws Exception {
        Cliente cliente = null;

        try {
            cliente = clienteLogic.getCliente(clieId);
        } catch (Exception e) {
            throw e;
        }

        return cliente;
    }

    public List<Cliente> findByCriteriaInCliente(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception {
        return clienteLogic.findByCriteria(variables, variablesBetween,
            variablesBetweenDates);
    }

    public List<Cliente> findPageCliente(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception {
        return clienteLogic.findPageCliente(sortColumnName, sortAscending,
            startRow, maxResults);
    }

    public Long findTotalNumberCliente() throws Exception {
        return clienteLogic.findTotalNumberCliente();
    }

    public List<ClienteDTO> getDataCliente() throws Exception {
        return clienteLogic.getDataCliente();
    }

    public void validateCliente(Cliente cliente) throws Exception {
        clienteLogic.validateCliente(cliente);
    }

    public List<TipoTransaccion> getTipoTransaccion() throws Exception {
        return tipoTransaccionLogic.getTipoTransaccion();
    }

    public void saveTipoTransaccion(TipoTransaccion entity)
        throws Exception {
        tipoTransaccionLogic.saveTipoTransaccion(entity);
    }

    public void deleteTipoTransaccion(TipoTransaccion entity)
        throws Exception {
        tipoTransaccionLogic.deleteTipoTransaccion(entity);
    }

    public void updateTipoTransaccion(TipoTransaccion entity)
        throws Exception {
        tipoTransaccionLogic.updateTipoTransaccion(entity);
    }

    public TipoTransaccion getTipoTransaccion(Long titrId)
        throws Exception {
        TipoTransaccion tipoTransaccion = null;

        try {
            tipoTransaccion = tipoTransaccionLogic.getTipoTransaccion(titrId);
        } catch (Exception e) {
            throw e;
        }

        return tipoTransaccion;
    }

    public List<TipoTransaccion> findByCriteriaInTipoTransaccion(
        Object[] variables, Object[] variablesBetween,
        Object[] variablesBetweenDates) throws Exception {
        return tipoTransaccionLogic.findByCriteria(variables, variablesBetween,
            variablesBetweenDates);
    }

    public List<TipoTransaccion> findPageTipoTransaccion(
        String sortColumnName, boolean sortAscending, int startRow,
        int maxResults) throws Exception {
        return tipoTransaccionLogic.findPageTipoTransaccion(sortColumnName,
            sortAscending, startRow, maxResults);
    }

    public Long findTotalNumberTipoTransaccion() throws Exception {
        return tipoTransaccionLogic.findTotalNumberTipoTransaccion();
    }

    public List<TipoTransaccionDTO> getDataTipoTransaccion()
        throws Exception {
        return tipoTransaccionLogic.getDataTipoTransaccion();
    }

    public void validateTipoTransaccion(TipoTransaccion tipoTransaccion)
        throws Exception {
        tipoTransaccionLogic.validateTipoTransaccion(tipoTransaccion);
    }

    public List<TipoDocumento> getTipoDocumento() throws Exception {
        return tipoDocumentoLogic.getTipoDocumento();
    }

    public void saveTipoDocumento(TipoDocumento entity)
        throws Exception {
        tipoDocumentoLogic.saveTipoDocumento(entity);
    }

    public void deleteTipoDocumento(TipoDocumento entity)
        throws Exception {
        tipoDocumentoLogic.deleteTipoDocumento(entity);
    }

    public void updateTipoDocumento(TipoDocumento entity)
        throws Exception {
        tipoDocumentoLogic.updateTipoDocumento(entity);
    }

    public TipoDocumento getTipoDocumento(Long tdocId)
        throws Exception {
        TipoDocumento tipoDocumento = null;

        try {
            tipoDocumento = tipoDocumentoLogic.getTipoDocumento(tdocId);
        } catch (Exception e) {
            throw e;
        }

        return tipoDocumento;
    }

    public List<TipoDocumento> findByCriteriaInTipoDocumento(
        Object[] variables, Object[] variablesBetween,
        Object[] variablesBetweenDates) throws Exception {
        return tipoDocumentoLogic.findByCriteria(variables, variablesBetween,
            variablesBetweenDates);
    }

    public List<TipoDocumento> findPageTipoDocumento(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception {
        return tipoDocumentoLogic.findPageTipoDocumento(sortColumnName,
            sortAscending, startRow, maxResults);
    }

    public Long findTotalNumberTipoDocumento() throws Exception {
        return tipoDocumentoLogic.findTotalNumberTipoDocumento();
    }

    public List<TipoDocumentoDTO> getDataTipoDocumento()
        throws Exception {
        return tipoDocumentoLogic.getDataTipoDocumento();
    }

    public void validateTipoDocumento(TipoDocumento tipoDocumento)
        throws Exception {
        tipoDocumentoLogic.validateTipoDocumento(tipoDocumento);
    }

    public List<Usuario> getUsuario() throws Exception {
        return usuarioLogic.getUsuario();
    }

    public void saveUsuario(Usuario entity) throws Exception {
        usuarioLogic.saveUsuario(entity);
    }

    public void deleteUsuario(Usuario entity) throws Exception {
        usuarioLogic.deleteUsuario(entity);
    }

    public void updateUsuario(Usuario entity) throws Exception {
        usuarioLogic.updateUsuario(entity);
    }

    public Usuario getUsuario(String usuUsuario) throws Exception {
        Usuario usuario = null;

        try {
            usuario = usuarioLogic.getUsuario(usuUsuario);
        } catch (Exception e) {
            throw e;
        }

        return usuario;
    }

    public List<Usuario> findByCriteriaInUsuario(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception {
        return usuarioLogic.findByCriteria(variables, variablesBetween,
            variablesBetweenDates);
    }

    public List<Usuario> findPageUsuario(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception {
        return usuarioLogic.findPageUsuario(sortColumnName, sortAscending,
            startRow, maxResults);
    }

    public Long findTotalNumberUsuario() throws Exception {
        return usuarioLogic.findTotalNumberUsuario();
    }

    public List<UsuarioDTO> getDataUsuario() throws Exception {
        return usuarioLogic.getDataUsuario();
    }

    public void validateUsuario(Usuario usuario) throws Exception {
        usuarioLogic.validateUsuario(usuario);
    }

    public List<TipoUsuario> getTipoUsuario() throws Exception {
        return tipoUsuarioLogic.getTipoUsuario();
    }

    public void saveTipoUsuario(TipoUsuario entity) throws Exception {
        tipoUsuarioLogic.saveTipoUsuario(entity);
    }

    public void deleteTipoUsuario(TipoUsuario entity) throws Exception {
        tipoUsuarioLogic.deleteTipoUsuario(entity);
    }

    public void updateTipoUsuario(TipoUsuario entity) throws Exception {
        tipoUsuarioLogic.updateTipoUsuario(entity);
    }

    public TipoUsuario getTipoUsuario(Long tiusId) throws Exception {
        TipoUsuario tipoUsuario = null;

        try {
            tipoUsuario = tipoUsuarioLogic.getTipoUsuario(tiusId);
        } catch (Exception e) {
            throw e;
        }

        return tipoUsuario;
    }

    public List<TipoUsuario> findByCriteriaInTipoUsuario(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception {
        return tipoUsuarioLogic.findByCriteria(variables, variablesBetween,
            variablesBetweenDates);
    }

    public List<TipoUsuario> findPageTipoUsuario(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception {
        return tipoUsuarioLogic.findPageTipoUsuario(sortColumnName,
            sortAscending, startRow, maxResults);
    }

    public Long findTotalNumberTipoUsuario() throws Exception {
        return tipoUsuarioLogic.findTotalNumberTipoUsuario();
    }

    public List<TipoUsuarioDTO> getDataTipoUsuario() throws Exception {
        return tipoUsuarioLogic.getDataTipoUsuario();
    }

    public void validateTipoUsuario(TipoUsuario tipoUsuario)
        throws Exception {
        tipoUsuarioLogic.validateTipoUsuario(tipoUsuario);
    }

	@Override
	public Usuario getUsuarioPorLogin(String login) throws Exception {
		return this.usuarioLogic.getUsuarioPorLogin(login);
	}

	@Override
	public Integer consignarACuenta(String numeroCuenta, String login, Double valor, Long cliId) throws Exception {
		return this.transaccionLogic.consignarACuenta(numeroCuenta, login, valor, cliId);
	}

	@Override
	public RespuestaDTO retirarDinero(String numeroCuenta, String login, Double valor, Long cliId, String clave) throws Exception {
		return this.transaccionLogic.retirarDinero(numeroCuenta, login, valor, cliId, clave);
	}
}
