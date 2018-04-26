package com.banco.dto.mapper;

import com.banco.model.Cliente;
import com.banco.model.dto.ClienteDTO;

import java.util.List;


/**
* @author Zathura Code Generator http://zathuracode.org/
* www.zathuracode.org
*
*/
public interface IClienteMapper {
    public ClienteDTO clienteToClienteDTO(Cliente cliente)
        throws Exception;

    public Cliente clienteDTOToCliente(ClienteDTO clienteDTO)
        throws Exception;

    public List<ClienteDTO> listClienteToListClienteDTO(List<Cliente> clientes)
        throws Exception;

    public List<Cliente> listClienteDTOToListCliente(
        List<ClienteDTO> clienteDTOs) throws Exception;
}
