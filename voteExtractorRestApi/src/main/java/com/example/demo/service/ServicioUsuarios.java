package com.example.demo.service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

//import com.example.demo.model.User;
//import com.example.demo.model.User;
import com.example.demo.model.Usuario;
import com.example.demo.repository.UsuariosRepository;




@Service
@Transactional
public class ServicioUsuarios {
	
	@Autowired
	UsuariosRepository ur;
	/**
     * Listamos todos los usuarios dado un rol
     *
     * @param rol
     * @return List<Usuario></Usuario>
     */
	public List<Usuario> listAllUser() {
        return ur.findAll();
    }
	
    public List<Usuario> findByRol(int rol) {

        
		// Se conecta y busca los usuarios
        List<Usuario> l = ur.findByRol(rol);
        // Devolvemos la ista de usuarios
        return l;
    }
    
    /**
     * Metodo para insertar un usuario nuevo
     *
     * @param user
     * @return Usuario
     */
    
    
    public void saveUser(Usuario user) {
        ur.save(user);
    }
    
    public ResponseEntity<String>  deleteUser(Integer id) {
    	Optional<Usuario> op = ur.findById(id);
    	// si existe lo borramos y devolvemos
      if (op.isPresent()) {
          // Le pasamos los datos
          Usuario p = op.get();
          ur.deleteById(id);
          return ResponseEntity.ok("Usuario eliminado correctamente");
      } else {
          return ResponseEntity.noContent().build();
      }
       
    }
    
    public ResponseEntity<Usuario>  login(String user, String psw) {
    	
    	// si existe lo borramos y devolvemos
    	try {
    		Usuario op = ur.findByUserAndPsw(user,psw);
            return new ResponseEntity<Usuario>(op, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<Usuario>(HttpStatus.NOT_FOUND);
        }
       
    }
    
    
    /**
   * Método para borrar un usuario
   * @param id
   * @return Usuario
   */
  @RequestMapping(value = "/borrar/{id}", method = RequestMethod.DELETE)
  public ResponseEntity<Usuario> delete(@PathVariable("id") Integer id) {
      // Buscamos el usuario por id
      Optional<Usuario> op = ur.findById(id);
      // si existe lo borramos y devolvemos
      if (op.isPresent()) {
          // Le pasamos los datos
          Usuario p = op.get();
          ur.deleteById(id);
          return ResponseEntity.ok(p);
      } else {
          return ResponseEntity.noContent().build();
      }
  }
}
