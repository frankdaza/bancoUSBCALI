package com.banco.rest.controllers;

import com.banco.dto.mapper.ITransaccionMapper;

import com.banco.model.*;
import com.banco.model.dto.RespuestaDTO;
import com.banco.model.dto.TransaccionDTO;

import com.banco.presentation.businessDelegate.IBusinessDelegatorView;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/transaccion")
public class TransaccionRestController {
    private static final Logger log = LoggerFactory.getLogger(TransaccionRestController.class);
    @Autowired
    private IBusinessDelegatorView businessDelegatorView;
    @Autowired
    private ITransaccionMapper transaccionMapper;

    @PostMapping(value = "/saveTransaccion")
    public void saveTransaccion(@RequestBody
    TransaccionDTO transaccionDTO) throws Exception {
        try {
            Transaccion transaccion = transaccionMapper.transaccionDTOToTransaccion(transaccionDTO);

            businessDelegatorView.saveTransaccion(transaccion);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @DeleteMapping(value = "/deleteTransaccion/{tranId}")
    public void deleteTransaccion(@PathVariable("tranId")
    Long tranId) throws Exception {
        try {
            Transaccion transaccion = businessDelegatorView.getTransaccion(tranId);

            businessDelegatorView.deleteTransaccion(transaccion);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @PutMapping(value = "/updateTransaccion/")
    public void updateTransaccion(@RequestBody
    TransaccionDTO transaccionDTO) throws Exception {
        try {
            Transaccion transaccion = transaccionMapper.transaccionDTOToTransaccion(transaccionDTO);

            businessDelegatorView.updateTransaccion(transaccion);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @GetMapping(value = "/getDataTransaccion")
    public List<TransaccionDTO> getDataTransaccion() throws Exception {
        try {
            return businessDelegatorView.getDataTransaccion();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @GetMapping(value = "/getTransaccion/{tranId}")
    public TransaccionDTO getTransaccion(@PathVariable("tranId")
    Long tranId) throws Exception {
        try {
            Transaccion transaccion = businessDelegatorView.getTransaccion(tranId);

            return transaccionMapper.transaccionToTransaccionDTO(transaccion);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }

        return null;
    }
    
    
    @CrossOrigin
    @GetMapping(value = "/consignarTransaccion/{numeroCuenta}/{login}/{valor}/{cliId}")
    public RespuestaDTO consignarTransaccion(@PathVariable("numeroCuenta") String numeroCuenta,
    		@PathVariable("login") String login,
    		@PathVariable("valor") Double valor,
    		@PathVariable("cliId") Long cliId) throws Exception {
    	RespuestaDTO respuestaDTO = null;
        try {
            Integer codigo = businessDelegatorView.consignarACuenta(numeroCuenta, login, valor, cliId);
            respuestaDTO = new RespuestaDTO();
            respuestaDTO.setCodigoError(codigo);
            
            String mensajeError;
            
            if (codigo == 0)
            	mensajeError = "Error al consignar";
            else
            	mensajeError = "Consignación realizada exitosamente";
            
            respuestaDTO.setMensajeError(mensajeError);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
        return respuestaDTO;
    }
    
    @CrossOrigin
    @GetMapping(value = "/retiroTransaccion/{numeroCuenta}/{login}/{valor}/{cliId}/{clave}")
    public RespuestaDTO retiroTransaccion(@PathVariable("numeroCuenta") String numeroCuenta,
    		@PathVariable("login") String login,
    		@PathVariable("valor") Double valor,
    		@PathVariable("cliId") Long cliId,
    		@PathVariable("clave") String clave) throws Exception {
    	RespuestaDTO respuestaDTO = null;
        try {
        	respuestaDTO = businessDelegatorView.retirarDinero(numeroCuenta, login, valor, cliId, clave);            
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
        return respuestaDTO;
    }
    
}
