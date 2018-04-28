package com.banco.model.control;

import java.util.List;

import com.banco.model.Transaccion;
import com.banco.model.dto.RespuestaDTO;
import com.banco.model.dto.TransaccionDTO;

/**
 * @author Zathura Code Generator http://zathuracode.org/ www.zathuracode.org
 *
 */
public interface ITransaccionLogic {
	List<Transaccion> getTransaccion() throws Exception;

	/**
	 * Save an new Transaccion entity
	 */
	void saveTransaccion(Transaccion entity) throws Exception;

	/**
	 * Delete an existing Transaccion entity
	 *
	 */
	void deleteTransaccion(Transaccion entity) throws Exception;

	/**
	 * Update an existing Transaccion entity
	 *
	 */
	void updateTransaccion(Transaccion entity) throws Exception;

	/**
	 * Load an existing Transaccion entity
	 *
	 */
	Transaccion getTransaccion(Long tranId) throws Exception;

	List<Transaccion> findByCriteria(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception;

	List<Transaccion> findPageTransaccion(String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception;

	Long findTotalNumberTransaccion() throws Exception;

	List<TransaccionDTO> getDataTransaccion() throws Exception;

	void validateTransaccion(Transaccion transaccion) throws Exception;
		
	Integer consignarACuenta(String numeroCuenta, String login, Double valor) throws Exception;
	
	RespuestaDTO retirarDinero(String numeroCuenta, String login, Double valor) throws Exception;
}
