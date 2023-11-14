package com.tienda.service.impl;

import com.tienda.dao.CategoriaDao;
import com.tienda.domain.Categoria;
import com.tienda.service.CategoriaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CategoriaServiceImpl implements CategoriaService {

    @Autowired
    private CategoriaDao categoriaDao;

    @Override
    @Transactional(readOnly = true)//este va a ser un metodo que tengamos para hacer cosas transaccionales, por ejemplo, hacer consultas a la bd pero solo leer sin modificar nada
    public List<Categoria> getCategorias(boolean activos) {
        var lista = categoriaDao.findAll();
        if (activos) {
            lista.removeIf(e -> !e.isActivo());
        }
        return lista;
    }

    @Override
    @Transactional(readOnly = true)
    public Categoria getCategoria(Categoria categoria) {//buscar la categoria en la bd con el id que se tenga
        return categoriaDao.findById(categoria.getIdCategoria()).orElse(null);
    }

    @Override
    @Transactional
    public void save(Categoria categoria) {//posiblemente una modificacion o insertar una nueva categoria
        categoriaDao.save(categoria);
    }

    @Override
    @Transactional
    public void delete(Categoria categoria) {/// borrar algo de la base de datos
        categoriaDao.delete(categoria);
    }
}
