package com.tienda.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.io.Serializable;
import lombok.Data;
////el domain es hacer una clase en java para la tabla de bd
@Data
@Entity
@Table(name="producto")
public class Producto implements Serializable{
    ///basicamente sirializable va a guardar informacion en memoria,
    //funciona para almacenar ciertos datos en el disco
    private static final long serialVersionUID = 1L;///para poder hacer el ciclo de la sumatoriia del id de producto
    @Id//decir que la tabla producto tiene una lleve key que va a ser el ID
    ///LOS VALORRE generados que tipo de estrategia utilizanm idetico = sea igual en la bd y en la clase
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_producto")
    private long idProducto;
    //private long idCategoria;
    private String descripcion;
    private String detalle;
    private double precio;
    private int existencias;
    private String rutaImagen;
    private boolean activo;
    
    @ManyToOne
    @JoinColumn(name="id_categoria")//en la bd hay algo que se llama
    Categoria categoria;
    
    
    
    public Producto() {
    }

    public Producto(String descripcion, boolean activo) {
        this.descripcion = descripcion;
        this.activo = activo;
    }

//    public Producto(String descripcion, String detalle, double precio, int existencias, boolean activo) {
//        
//        this.descripcion = descripcion;
//        this.detalle = detalle;
//        this.precio = precio;
//        this.existencias = existencias;
//        this.activo = activo;
//    }


    
    
    
}
