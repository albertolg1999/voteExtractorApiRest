package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

//import com.example.demo.model.User;
import com.example.demo.model.Usuario;
import com.example.demo.service.ServicioUsuarios;




@RestController
@RequestMapping("/app")
public class Controller {

	@Autowired
	ServicioUsuarios s;
	
	@GetMapping("hola")
    
    public String hola() {
        return "hola chicos, vuestro lider avanza";
    }

	@GetMapping("")
    public List<Usuario> list() {
        return s.listAllUser();
    }

	@RequestMapping(value = "/guardar", method = RequestMethod.POST)
    public void add(@RequestBody Usuario user) {
		s.saveUser(user);
		
    }
	
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<String> delete(@PathVariable Integer id) {

        ResponseEntity<String> t=s.deleteUser(id);
        return t;
    }
	
	/**
   * Método para actualizar los datos del usuario
   * @param id
   * @param u
   * @return Usuario
   */
 @RequestMapping(value = "modificarUser/{id}", method = RequestMethod.PUT)
  public ResponseEntity<String> update(@PathVariable("id") Integer id, @RequestBody Usuario u) {
	 ResponseEntity<String> t=s.updateUser(id,u);
	 return t;
  }
	
	/**
     * Listamos todos los usuarios dado un rol
     *
     * @param rol
     * @return List<Usuario></Usuario>
     */
    @RequestMapping(value = "/usuarios/{rol}", method = RequestMethod.GET)
    public ResponseEntity<List<Usuario>> findByRol(@PathVariable("rol") int rol) {

        // Se conecta y busca los usuarios
        List<Usuario> l = s.findByRol(rol);
        // Devolvemos la lista de usuarios
        return ResponseEntity.ok(l);
    }
    
    /**
   * Metodo para realizar el login
   *
   * @param user
   * @param psw
   * @return
   */
  @RequestMapping(value = "/login/{user}/{psw}", method = RequestMethod.GET)
  public ResponseEntity<Usuario> findByUserAndPsw(@PathVariable("user") String user, @PathVariable("psw") String psw) {
      // Buscamos el usuario  por usuario y contraseña

      ResponseEntity<Usuario>ent=s.login(user, psw);
      return ent;

  }
    
    
    
    
    
}
