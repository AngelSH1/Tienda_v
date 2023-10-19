
package com.tienda.service.impl;

import com.tienda.dao.CategoriaDao;
import com.tienda.domain.Categoria;
import com.tienda.service.CategoriaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoriaServiceImpl implements CategoriaService{
    
    @Autowired//crear un unico objeto mientras se ejecuta la app, solo crea una lista
    private CategoriaDao categoriaDao;
    @Override
    public List<Categoria> getCategorias(boolean activos){
        var lista=categoriaDao.findAll();//encontrar todos los datos que tenga la lista
        if (activos) {
            lista.removeIf(e-> !e.isActivo());//devuelve solo los que salen en activo, los demas los borra de la lista
        }
        return lista;
    }
    
}
