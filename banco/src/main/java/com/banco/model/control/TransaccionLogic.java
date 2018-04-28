package com.banco.model.control;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.banco.dataaccess.dao.ITransaccionDAO;
import com.banco.dto.mapper.ITransaccionMapper;
import com.banco.exceptions.ZMessManager;
import com.banco.model.Cliente;
import com.banco.model.Cuenta;
import com.banco.model.TipoTransaccion;
import com.banco.model.Transaccion;
import com.banco.model.Usuario;
import com.banco.model.dto.RespuestaDTO;
import com.banco.model.dto.TransaccionDTO;
import com.banco.utilities.Utilities;


/**
* @author Zathura Code Generator http://zathuracode.org/
* www.zathuracode.org
*
*/
@Scope("singleton")
@Service("TransaccionLogic")
public class TransaccionLogic implements ITransaccionLogic {
    private static final Logger log = LoggerFactory.getLogger(TransaccionLogic.class);
    @Autowired
    private ITransaccionDAO transaccionDAO;
    @Autowired
    private ITransaccionMapper transaccionMapper;
    @Autowired
    private Validator validator;
    @Autowired
    private ICuentaLogic cuentaLogic;
    @Autowired
    private ITipoTransaccionLogic tipoTransaccionLogic;
    @Autowired
    private IUsuarioLogic usuarioLogic;
    @Autowired
    private IClienteLogic clienteLogic;

    public void validateTransaccion(Transaccion transaccion)
        throws Exception {
        try {
            Set<ConstraintViolation<Transaccion>> constraintViolations = validator.validate(transaccion);

            if (constraintViolations.size() > 0) {
                StringBuilder strMessage = new StringBuilder();

                for (ConstraintViolation<Transaccion> constraintViolation : constraintViolations) {
                    strMessage.append(constraintViolation.getPropertyPath()
                                                         .toString());
                    strMessage.append(" - ");
                    strMessage.append(constraintViolation.getMessage());
                    strMessage.append(". \n");
                }

                throw new Exception(strMessage.toString());
            }
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public List<Transaccion> getTransaccion() throws Exception {
        log.debug("finding all Transaccion instances");

        List<Transaccion> list = new ArrayList<Transaccion>();

        try {
            list = transaccionDAO.findAll();
        } catch (Exception e) {
            log.error("finding all Transaccion failed", e);
            throw new ZMessManager().new GettingException(ZMessManager.ALL +
                "Transaccion");
        } finally {
        }

        return list;
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void saveTransaccion(Transaccion entity) throws Exception {
        log.debug("saving Transaccion instance");

        try {
            if (entity == null) {
                throw new ZMessManager().new NullEntityExcepcion("Transaccion");
            }
            validateTransaccion(entity);
            transaccionDAO.save(entity);
            log.debug("save Transaccion successful");
        } catch (Exception e) {
            log.error("save Transaccion failed", e);
            throw e;
        } finally {
        }
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void deleteTransaccion(Transaccion entity) throws Exception {
        log.debug("deleting Transaccion instance");

        if (entity == null) {
            throw new ZMessManager().new NullEntityExcepcion("Transaccion");
        }

        if (entity.getTranId() == null) {
            throw new ZMessManager().new EmptyFieldException("tranId");
        }

        try {
            transaccionDAO.delete(entity);

            log.debug("delete Transaccion successful");
        } catch (Exception e) {
            log.error("delete Transaccion failed", e);
            throw e;
        } finally {
        }
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void updateTransaccion(Transaccion entity) throws Exception {
        log.debug("updating Transaccion instance");

        try {
            if (entity == null) {
                throw new ZMessManager().new NullEntityExcepcion("Transaccion");
            }

            validateTransaccion(entity);

            transaccionDAO.update(entity);

            log.debug("update Transaccion successful");
        } catch (Exception e) {
            log.error("update Transaccion failed", e);
            throw e;
        } finally {
        }
    }

    @Transactional(readOnly = true)
    public List<TransaccionDTO> getDataTransaccion() throws Exception {
        try {
            List<Transaccion> transaccion = transaccionDAO.findAll();

            List<TransaccionDTO> transaccionDTO = new ArrayList<TransaccionDTO>();

            for (Transaccion transaccionTmp : transaccion) {
                TransaccionDTO transaccionDTO2 = transaccionMapper.transaccionToTransaccionDTO(transaccionTmp);
                transaccionDTO.add(transaccionDTO2);
            }

            return transaccionDTO;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public Transaccion getTransaccion(Long tranId) throws Exception {
        log.debug("getting Transaccion instance");

        Transaccion entity = null;

        try {
            entity = transaccionDAO.findById(tranId);
        } catch (Exception e) {
            log.error("get Transaccion failed", e);
            throw new ZMessManager().new FindingException("Transaccion");
        } finally {
        }

        return entity;
    }

    @Transactional(readOnly = true)
    public List<Transaccion> findPageTransaccion(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception {
        List<Transaccion> entity = null;

        try {
            entity = transaccionDAO.findPage(sortColumnName, sortAscending,
                    startRow, maxResults);
        } catch (Exception e) {
            throw new ZMessManager().new FindingException("Transaccion Count");
        } finally {
        }

        return entity;
    }

    @Transactional(readOnly = true)
    public Long findTotalNumberTransaccion() throws Exception {
        Long entity = null;

        try {
            entity = transaccionDAO.count();
        } catch (Exception e) {
            throw new ZMessManager().new FindingException("Transaccion Count");
        } finally {
        }

        return entity;
    }

    /**
    *
    * @param varibles
    *            este arreglo debera tener:
    *
    * [0] = String variable = (String) varibles[i]; representa como se llama la
    * variable en el pojo
    *
    * [1] = Boolean booVariable = (Boolean) varibles[i + 1]; representa si el
    * valor necesita o no ''(comillas simples)usado para campos de tipo string
    *
    * [2] = Object value = varibles[i + 2]; representa el valor que se va a
    * buscar en la BD
    *
    * [3] = String comparator = (String) varibles[i + 3]; representa que tipo
    * de busqueda voy a hacer.., ejemplo: where nombre=william o where nombre<>william,
        * en este campo iria el tipo de comparador que quiero si es = o <>
            *
            * Se itera de 4 en 4..., entonces 4 registros del arreglo representan 1
            * busqueda en un campo, si se ponen mas pues el continuara buscando en lo
            * que se le ingresen en los otros 4
            *
            *
            * @param variablesBetween
            *
            * la diferencia son estas dos posiciones
            *
            * [0] = String variable = (String) varibles[j]; la variable ne la BD que va
            * a ser buscada en un rango
            *
            * [1] = Object value = varibles[j + 1]; valor 1 para buscar en un rango
            *
            * [2] = Object value2 = varibles[j + 2]; valor 2 para buscar en un rango
            * ejempolo: a > 1 and a < 5 --> 1 seria value y 5 seria value2
                *
                * [3] = String comparator1 = (String) varibles[j + 3]; comparador 1
                * ejemplo: a comparator1 1 and a < 5
                    *
                    * [4] = String comparator2 = (String) varibles[j + 4]; comparador 2
                    * ejemplo: a comparador1>1  and a comparador2<5  (el original: a > 1 and a <
                            * 5) *
                            * @param variablesBetweenDates(en
                            *            este caso solo para mysql)
                            *  [0] = String variable = (String) varibles[k]; el nombre de la variable que hace referencia a
                            *            una fecha
                            *
                            * [1] = Object object1 = varibles[k + 2]; fecha 1 a comparar(deben ser
                            * dates)
                            *
                            * [2] = Object object2 = varibles[k + 3]; fecha 2 a comparar(deben ser
                            * dates)
                            *
                            * esto hace un between entre las dos fechas.
                            *
                            * @return lista con los objetos que se necesiten
                            * @throws Exception
                            */
    @Transactional(readOnly = true)
    public List<Transaccion> findByCriteria(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception {
        List<Transaccion> list = new ArrayList<Transaccion>();
        String where = new String();
        String tempWhere = new String();

        if (variables != null) {
            for (int i = 0; i < variables.length; i++) {
                if ((variables[i] != null) && (variables[i + 1] != null) &&
                        (variables[i + 2] != null) &&
                        (variables[i + 3] != null)) {
                    String variable = (String) variables[i];
                    Boolean booVariable = (Boolean) variables[i + 1];
                    Object value = variables[i + 2];
                    String comparator = (String) variables[i + 3];

                    if (booVariable.booleanValue()) {
                        tempWhere = (tempWhere.length() == 0)
                            ? ("(model." + variable + " " + comparator + " \'" +
                            value + "\' )")
                            : (tempWhere + " AND (model." + variable + " " +
                            comparator + " \'" + value + "\' )");
                    } else {
                        tempWhere = (tempWhere.length() == 0)
                            ? ("(model." + variable + " " + comparator + " " +
                            value + " )")
                            : (tempWhere + " AND (model." + variable + " " +
                            comparator + " " + value + " )");
                    }
                }

                i = i + 3;
            }
        }

        if (variablesBetween != null) {
            for (int j = 0; j < variablesBetween.length; j++) {
                if ((variablesBetween[j] != null) &&
                        (variablesBetween[j + 1] != null) &&
                        (variablesBetween[j + 2] != null) &&
                        (variablesBetween[j + 3] != null) &&
                        (variablesBetween[j + 4] != null)) {
                    String variable = (String) variablesBetween[j];
                    Object value = variablesBetween[j + 1];
                    Object value2 = variablesBetween[j + 2];
                    String comparator1 = (String) variablesBetween[j + 3];
                    String comparator2 = (String) variablesBetween[j + 4];
                    tempWhere = (tempWhere.length() == 0)
                        ? ("(" + value + " " + comparator1 + " " + variable +
                        " and " + variable + " " + comparator2 + " " + value2 +
                        " )")
                        : (tempWhere + " AND (" + value + " " + comparator1 +
                        " " + variable + " and " + variable + " " +
                        comparator2 + " " + value2 + " )");
                }

                j = j + 4;
            }
        }

        if (variablesBetweenDates != null) {
            for (int k = 0; k < variablesBetweenDates.length; k++) {
                if ((variablesBetweenDates[k] != null) &&
                        (variablesBetweenDates[k + 1] != null) &&
                        (variablesBetweenDates[k + 2] != null)) {
                    String variable = (String) variablesBetweenDates[k];
                    Object object1 = variablesBetweenDates[k + 1];
                    Object object2 = variablesBetweenDates[k + 2];
                    String value = null;
                    String value2 = null;

                    try {
                        Date date1 = (Date) object1;
                        Date date2 = (Date) object2;
                        value = Utilities.formatDateWithoutTimeInAStringForBetweenWhere(date1);
                        value2 = Utilities.formatDateWithoutTimeInAStringForBetweenWhere(date2);
                    } catch (Exception e) {
                        list = null;
                        throw e;
                    }

                    tempWhere = (tempWhere.length() == 0)
                        ? ("(model." + variable + " between " + value +
                        " and " + value2 + ")")
                        : (tempWhere + " AND (model." + variable + " between " +
                        value + " and " + value2 + ")");
                }

                k = k + 2;
            }
        }

        if (tempWhere.length() == 0) {
            where = null;
        } else {
            where = "(" + tempWhere + ")";
        }

        try {
            list = transaccionDAO.findByCriteria(where);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        } finally {
        }

        return list;
    }

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public Integer consignarACuenta(String numeroCuenta, String login, Double valor, Long cliId) throws Exception {
		Integer codigoExito = 0; // 0 -> No exitoso, 1 -> Exitoso.
		try {
			// Verifico que la cuenta exista y sea activa
			Object[] variablesCuenta = {"cuenId", true, numeroCuenta, "=",
											"activa", true, "S", "="};
			List<Cuenta> listCuenta = this.cuentaLogic.findByCriteria(variablesCuenta, null, null);
			if (listCuenta != null && !listCuenta.isEmpty() 
					&& valor > 0D) {				
				Cuenta cuentaCons = listCuenta.get(0);
				
				Cliente cliente = this.clienteLogic.getCliente(cuentaCons.getCliente().getClieId());
				
				if (cliente.getClieId().equals(cliId)) {
					// Obtengo el objeto de consignacion
					TipoTransaccion tipoTransaccion = this.tipoTransaccionLogic.getTipoTransaccion(2L);
					
					// Obtengo el usuario
					Usuario usuario = this.usuarioLogic.getUsuario(login);
					
					// Creo una transacción
					Transaccion transaccion = new Transaccion();
					transaccion.setCuenta(cuentaCons);
					transaccion.setFecha(new Date());
					transaccion.setTipoTransaccion(tipoTransaccion);
					transaccion.setUsuario(usuario);
					transaccion.setValor(valor);
					saveTransaccion(transaccion);		
					
					// Actualizo el valor del saldo de la cuenta
					Double nuevoValor = cuentaCons.getSaldo() + valor;
					cuentaCons.setSaldo(nuevoValor);
					this.cuentaLogic.updateCuenta(cuentaCons);
					codigoExito = 1; // Codigo exitoso
				} else {
					codigoExito = 0; // Codigo erróneo
				}
			}
		} catch (Exception e) {
			codigoExito = 0; // Codigo erróneo
			log.error(e.getMessage(), e);
		}
		return codigoExito;
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public RespuestaDTO retirarDinero(String numeroCuenta, String login, Double valor, Long cliId, String clave) throws Exception {
		RespuestaDTO respuestaDTO = new RespuestaDTO(); // 0 -> No exitoso, 1 -> Exitoso.
		try {
			// Verifico que la cuenta exista y sea activa
			Object[] variablesCuenta = {"cuenId", true, numeroCuenta, "=",
											"activa", true, "S", "="};
			List<Cuenta> listCuenta = this.cuentaLogic.findByCriteria(variablesCuenta, null, null);
			if (listCuenta != null && !listCuenta.isEmpty() && valor > 0D) {				
				Cuenta cuentaCons = listCuenta.get(0);
				
				if (cuentaCons.getClave().equals(clave)) {
					Cliente cliente = this.clienteLogic.getCliente(cuentaCons.getCliente().getClieId());
					
					if (cliente.getClieId().equals(cliId)) {
						// Verifico que el valor a retirar sea menor o igual al valor que existe en la cuenta
						if (valor <= cuentaCons.getSaldo()) {
							// Obtengo el objeto de retirar
							TipoTransaccion tipoTransaccion = this.tipoTransaccionLogic.getTipoTransaccion(1L);
							
							// Obtengo el usuario
							Usuario usuario = this.usuarioLogic.getUsuario(login);
							
							// Creo una transacción
							Transaccion transaccion = new Transaccion();
							transaccion.setCuenta(cuentaCons);
							transaccion.setFecha(new Date());
							transaccion.setTipoTransaccion(tipoTransaccion);
							transaccion.setUsuario(usuario);
							transaccion.setValor(valor);
							saveTransaccion(transaccion);		
							
							// Actualizo el valor del saldo de la cuenta
							Double nuevoValor = cuentaCons.getSaldo() - valor;
							cuentaCons.setSaldo(nuevoValor);
							this.cuentaLogic.updateCuenta(cuentaCons);
							respuestaDTO.setCodigoError(1); // Codigo exitoso
							respuestaDTO.setMensajeError("El retiro se ha realizado satisfactoriamente.");
						} else {
							respuestaDTO.setCodigoError(0); // Codigo error
							respuestaDTO.setMensajeError("No hay fondos sufientes para retirar el valor solicitado.");
//							return respuestaDTO; 
						}
					} else {
						respuestaDTO.setCodigoError(0); // Codigo error
						respuestaDTO.setMensajeError("La cuenta no pertenece a ese cliente.");
					}
				} else {
					respuestaDTO.setCodigoError(0); // Codigo error
					respuestaDTO.setMensajeError("La clave no es válida.");
				}
			} else {
				respuestaDTO.setCodigoError(0); // Codigo error
				respuestaDTO.setMensajeError("No se ha podido realizar el retiro.");
			}
		} catch (Exception e) {
			respuestaDTO.setCodigoError(0); // Codigo error
			respuestaDTO.setMensajeError(e.getMessage());
			log.error(e.getMessage(), e);
		}
		return respuestaDTO;
	}
}
