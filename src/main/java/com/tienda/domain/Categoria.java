package com.tienda.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.util.List;
import lombok.Data;
////el domain es hacer una clase en java para la tabla de bd

@Data
@Entity
@Table(name = "categoria")
public class Categoria implements Serializable {

    ///basicamente sirializable va a guardar informacion en memoria,
    //funciona para almacenar ciertos datos en el disco
    private static final long serialVersionUID = 1L;///para poder hacer el ciclo de la sumatoriia del id de categoria
    @Id//decir que la tabla categoria tiene una lleve key que va a ser el ID
    ///LOS VALORRE generados que tipo de estrategia utilizanm idetico = sea igual en la bd y en la clase
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_categoria")
    private long idCategoria;
    private String descripcion;
    private String rutaImagen;
    private boolean activo;

    @OneToMany
    @JoinColumn(name = "id_categoria", updatable = false)
    List<Producto> productos;

    public Categoria() {
    }

    public Categoria(String descripcion, boolean activo) {
        this.descripcion = descripcion;
        this.activo = activo;
    }

}
