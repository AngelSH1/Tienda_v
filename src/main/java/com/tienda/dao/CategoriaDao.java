
package com.tienda.dao;
import com.tienda.domain.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
////trallendonos la info de la clase categoria
///
public interface CategoriaDao extends JpaRepository <Categoria, Long>{
    
}
