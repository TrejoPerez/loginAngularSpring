/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.springframework.logginconangular;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author root
 */
@Controller
@RequestMapping("/")
public class ControladorUsuario {
    @Autowired ServicioLoggin logginUsuarioM;
    
    @CrossOrigin
    @RequestMapping(value = "usuario/{email}/{password}", method = RequestMethod.GET, headers ={"Accept=text/html"})
    @ResponseBody String buscarUsuario(@PathVariable String email,@PathVariable String password) throws Exception{
        Usuario u  = new Usuario();
        u.setEmail(email);
        u.setPassword(password);
        ObjectMapper mapper = new ObjectMapper();
        ArrayList<Usuario> usuarios = logginUsuarioM.buscarUsuario(u);
        return mapper.writeValueAsString(usuarios);
    }
}
