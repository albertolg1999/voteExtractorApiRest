package com.example.demo.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Usuario;

import java.util.List;
import java.util.Optional;

@Repository
public interface UsuariosRepository extends JpaRepository<Usuario, Integer> {

   //para comprobar el login
    Usuario findByUserAndPsw (@Param("user") String user, @Param("psw") String psw);

    //para comprobar que al registrar no se repita el nombre de usuario
    Optional<Usuario> findByUser (@Param("user") String user);
    //para obtener los usuarios de un determinado rol, en nuestro caso nos servir� para obtener los del rol 1, para hacer el crud
    List<Usuario> findByRol (@Param("rol") int rol);
    

}
