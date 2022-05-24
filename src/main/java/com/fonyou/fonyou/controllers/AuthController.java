package com.fonyou.fonyou.controllers;

import com.fonyou.fonyou.dao.UsuarioDao;
import com.fonyou.fonyou.models.Usuario;
import com.fonyou.fonyou.utils.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {
    @Autowired
    private UsuarioDao usuarioDao;

    @Autowired
    private JWTUtil jwtUtil;

    @RequestMapping(value = "api/login", method = RequestMethod.POST)
    public String login(@RequestBody Usuario usuario) {
        Usuario usuarioLogin = usuarioDao.obtenerUsuarioPorCredenciales(usuario);
        if (usuarioLogin != null) {
            String token = jwtUtil.create(String.valueOf(usuarioLogin.getId()), usuarioLogin.getEmail());
            return token;
        }
        return "FAIL";
    }
}
