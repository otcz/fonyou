package com.fonyou.fonyou.controllers;
import com.fonyou.fonyou.dao.UsuarioDao;
import com.fonyou.fonyou.models.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
public class UsuarioController {
    @Autowired
    private UsuarioDao usuarioDao;
    @RequestMapping(value = "api/usuarios/{id}", method = RequestMethod.GET)
    public Usuario getUsuarios(@PathVariable Long id) {
        Usuario usuario=new Usuario();
        usuario.setId(id);
        usuario.setSNombre("TOMAS");
        usuario.setSApellidos("CARRILLO");
        usuario.setSEmail("CARRILLOZULETA");
        usuario.setSPassword("123456");

        return usuario;
    }

    @RequestMapping(value = "api/usuarios", method = RequestMethod.GET)
    public List <Usuario> getUsuarios() {
      return  usuarioDao.getUsuario();
    }

    @RequestMapping(value = "api/usuarios", method = RequestMethod.POST)
    public void registrarUsuario(@RequestBody Usuario usuario) {
        usuarioDao.registrar(usuario);
    }
    @RequestMapping(value = "usuario45")
    public Usuario editar() {
        Usuario usuario=new Usuario();
        usuario.setId(Long.valueOf(2344));
        usuario.setSNombre("TOMAS");
        usuario.setSApellidos("CARRILLO");
        usuario.setSEmail("CARRILLOZULETA");
        usuario.setSPassword("123456");

        return usuario;
    }

    @RequestMapping(value = "api/usuarios/{id}", method = RequestMethod.DELETE)
    public void eliminar(@PathVariable Long id) {
       usuarioDao.eliminar(id);
    }
    @RequestMapping(value = "usuario123")
    public Usuario buscar() {
        Usuario usuario=new Usuario();
        usuario.setSNombre("TOMAS");
        usuario.setSApellidos("CARRILLO");
        usuario.setSEmail("CARRILLOZULETA");
        usuario.setSPassword("123456");

        return usuario;
    }
}
