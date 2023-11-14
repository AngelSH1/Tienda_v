package com.tienda.service.impl;

import com.tienda.dao.ProductoDao;
import com.tienda.domain.Producto;
import com.tienda.service.ProductoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductoServiceImpl implements ProductoService {

    @Autowired
    private ProductoDao productoDao;

    @Override
    @Transactional(readOnly = true)//este va a ser un metodo que tengamos para hacer cosas transaccionales, por ejemplo, hacer consultas a la bd pero solo leer sin modificar nada
    public List<Producto> getProductos(boolean activos) {
        var lista = productoDao.findAll();
        if (activos) {
            lista.removeIf(e -> !e.isActivo());
        }
        return lista;
    }

    @Override
    @Transactional(readOnly = true)
    public Producto getProducto(Producto producto) {//buscar la producto en la bd con el id que se tenga
        return productoDao.findById(producto.getIdProducto()).orElse(null);
    }

    @Override
    @Transactional
    public void save(Producto producto) {//posiblemente una modificacion o insertar una nueva producto
        productoDao.save(producto);
    }

    @Override
    @Transactional
    public void delete(Producto producto) {/// borrar algo de la base de datos
        productoDao.delete(producto);
    }
///esta es mi consulta JPA de mi consulta de JPA para traer informacion Sobre precio inferior y superior
    @Override
    @Transactional(readOnly = true)
    public List<Producto> findByPrecioBetweenOrderByDescripcion(double precioInf, double precioSup) {

        return productoDao.findByPrecioBetweenOrderByDescripcion(precioInf, precioSup);
    }

   ///esta es mi consulta JPQL de mi consulta de JPQL para traer informacion Sobre precio inferior y superior
    @Override
    @Transactional(readOnly = true)
    public List<Producto> motodoJPQL(double precioInf, double precioSup) {

        return productoDao.metodoJPQL(precioInf, precioSup);
    } 
    
   ///esta es mi consulta nativa de mi consulta de nativa para traer informacion Sobre precio inferior y superior
    @Override
    @Transactional(readOnly = true)
    public List<Producto> motodoNativo(double precioInf, double precioSup) {

        return productoDao.metodoNativo(precioInf, precioSup);
    } 
    
    
    
    
    
    
    
}
