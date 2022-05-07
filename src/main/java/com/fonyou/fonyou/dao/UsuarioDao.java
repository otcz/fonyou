package com.fonyou.fonyou.dao;

import com.fonyou.fonyou.models.Usuario;

import java.util.List;

public interface UsuarioDao {
    List<Usuario> getUsuario();

    void eliminar(Long id);

    void registrar(Usuario usuario);
}
