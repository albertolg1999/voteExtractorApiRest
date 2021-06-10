package com.example.demo.service;

import java.io.IOException;
import java.io.InputStream;
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
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.model.Usuario;
import com.example.demo.model.Votos;
import com.example.demo.repository.UsuariosRepository;
import com.example.demo.repository.VotosRepository;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;




@Service
@Transactional
public class ServicioVotos {
	
	
	@Autowired
	VotosRepository vr;
	
	
    
    
    
    public ResponseEntity<String>  updateVotos(String representante) {
		Votos op = vr.findByNombre(representante);
		
	   	 // Devolvemos el usuario si existe.
	    	if (op!=null) {
	  	         op.setVotos(op.getVotos()+1);
	  	        
	  	         vr.save(op);
	  	         
	  	       //return ResponseEntity.ok("correcto");
	  	     }
	    	return ResponseEntity.ok("correcto");
          
      } 
    
    /**
     * Listamos todos los resultados de los participantes
     *
     * @param rol
     * @return List<Usuario></Usuario>
     */
	public List<Votos> listAllVotos() {
        return vr.findAll();
    }
    
    public Votos getRep(String representante) {
		Votos op = vr.findByNombre(representante);
		 return op;
    } 
    
  
  
}
