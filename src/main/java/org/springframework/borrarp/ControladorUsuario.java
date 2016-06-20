/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.springframework.borrarp;

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
    @Autowired ServicioLogin logginUsuarioM;
    public Integer getUsuario(ArrayList<Usuario> user){
        Integer getUser =0;
        for(Usuario u:user ){
            getUser = u.getIdUsuario();
        }
            return getUser;
    }
    @CrossOrigin
    @RequestMapping(value = "usuario/{email}/{password}", method = RequestMethod.GET, headers ={"Accept=text/html"})
    @ResponseBody String buscarUsuario(@PathVariable String email,@PathVariable String password) throws Exception{
        ObjectMapper mapper = new ObjectMapper();
        ArrayList<Usuario> usuarios = logginUsuarioM.buscarUsuario(email,password);
        Integer id = usuarios.size();
        String nombre = String.valueOf(usuarios.get(id-1).getEmail());
        //Aquui me marca el mismo error de casteo
        return "El nombre es  " +nombre;
    }
    @CrossOrigin
    @RequestMapping(value="usuario/{id}", method = RequestMethod.GET,headers={"Accept=application/json"})
    @ResponseBody String buscarId(@PathVariable Integer id) throws Exception{
        ObjectMapper mapper = new ObjectMapper();
        Usuario usuario = logginUsuarioM.buscarId(id);
        //No puedo obtener a un usuario por su id
        return mapper.writeValueAsString(usuario);
    }
    
}
