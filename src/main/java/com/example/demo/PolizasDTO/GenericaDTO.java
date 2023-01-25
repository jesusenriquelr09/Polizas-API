package com.example.demo.PolizasDTO;

import org.springframework.stereotype.Service;

import lombok.Data;

@Data

@Service
public class GenericaDTO {
    private int IdPolizas;
    private int Cantidad;
    private String Nombre;
    private String Apellido;
    private int SKU;
    private String NombreArticulo;

    public GenericaDTO()
    {
        
    }

    public GenericaDTO(int IdPolizas, int Cantidad, String Nombre, String Apellido, int SKU, String NombreArticulo)
    {
        this.IdPolizas = IdPolizas;
        this.Cantidad = Cantidad;
        this.Nombre = Nombre;
        this.Apellido = Apellido;
        this.SKU = SKU;
        this.NombreArticulo = NombreArticulo;
    }

    public int getIdPolizas()
    {
        return IdPolizas;
    }

    public int setIdPolizas()
    {
        return this.IdPolizas;
    }

    public int getCantidad()
    {
        return Cantidad;
    }

    public int setCantidad()
    {
        return this.Cantidad;
    }

    public String getNombre()
    {
        return Nombre;
    }

    public String setNombre()
    {
        return this.Nombre;
    }

    public String getApellido()
    {
        return Apellido;
    }

    public String setApellido()
    {
        return this.Apellido;
    }

    public int getSKU()
    {
        return SKU;
    }

    public int setSKU()
    {
        return this.SKU;
    }

    public String getNombreArticulo()
    {
        return NombreArticulo;
    }

    public String setNombreArticulo()
    {
        return this.NombreArticulo;
    }
}
