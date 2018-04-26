package com.banco.dto.mapper;

import com.banco.model.*;
import com.banco.model.Usuario;
import com.banco.model.control.*;
import com.banco.model.dto.UsuarioDTO;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.Scope;

import org.springframework.stereotype.Component;

import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;


/**
* @author Zathura Code Generator http://zathuracode.org/
* www.zathuracode.org
*
*/
@Component
@Scope("singleton")
public class UsuarioMapper implements IUsuarioMapper {
    private static final Logger log = LoggerFactory.getLogger(UsuarioMapper.class);

    /**
    * Logic injected by Spring that manages TipoUsuario entities
    *
    */
    @Autowired
    ITipoUsuarioLogic logicTipoUsuario1;

    @Transactional(readOnly = true)
    public UsuarioDTO usuarioToUsuarioDTO(Usuario usuario)
        throws Exception {
        try {
            UsuarioDTO usuarioDTO = new UsuarioDTO();

            usuarioDTO.setUsuUsuario(usuario.getUsuUsuario());
            usuarioDTO.setActivo((usuario.getActivo() != null)
                ? usuario.getActivo() : null);
            usuarioDTO.setClave((usuario.getClave() != null)
                ? usuario.getClave() : null);
            usuarioDTO.setIdentificacion((usuario.getIdentificacion() != null)
                ? usuario.getIdentificacion() : null);
            usuarioDTO.setNombre((usuario.getNombre() != null)
                ? usuario.getNombre() : null);
            usuarioDTO.setTiusId_TipoUsuario((usuario.getTipoUsuario()
                                                     .getTiusId() != null)
                ? usuario.getTipoUsuario().getTiusId() : null);

            return usuarioDTO;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public Usuario usuarioDTOToUsuario(UsuarioDTO usuarioDTO)
        throws Exception {
        try {
            Usuario usuario = new Usuario();

            usuario.setUsuUsuario(usuarioDTO.getUsuUsuario());
            usuario.setActivo((usuarioDTO.getActivo() != null)
                ? usuarioDTO.getActivo() : null);
            usuario.setClave((usuarioDTO.getClave() != null)
                ? usuarioDTO.getClave() : null);
            usuario.setIdentificacion((usuarioDTO.getIdentificacion() != null)
                ? usuarioDTO.getIdentificacion() : null);
            usuario.setNombre((usuarioDTO.getNombre() != null)
                ? usuarioDTO.getNombre() : null);

            TipoUsuario tipoUsuario = new TipoUsuario();

            if (usuarioDTO.getTiusId_TipoUsuario() != null) {
                tipoUsuario = logicTipoUsuario1.getTipoUsuario(usuarioDTO.getTiusId_TipoUsuario());
            }

            if (tipoUsuario != null) {
                usuario.setTipoUsuario(tipoUsuario);
            }

            return usuario;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public List<UsuarioDTO> listUsuarioToListUsuarioDTO(
        List<Usuario> listUsuario) throws Exception {
        try {
            List<UsuarioDTO> usuarioDTOs = new ArrayList<UsuarioDTO>();

            for (Usuario usuario : listUsuario) {
                UsuarioDTO usuarioDTO = usuarioToUsuarioDTO(usuario);

                usuarioDTOs.add(usuarioDTO);
            }

            return usuarioDTOs;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public List<Usuario> listUsuarioDTOToListUsuario(
        List<UsuarioDTO> listUsuarioDTO) throws Exception {
        try {
            List<Usuario> listUsuario = new ArrayList<Usuario>();

            for (UsuarioDTO usuarioDTO : listUsuarioDTO) {
                Usuario usuario = usuarioDTOToUsuario(usuarioDTO);

                listUsuario.add(usuario);
            }

            return listUsuario;
        } catch (Exception e) {
            throw e;
        }
    }
}
