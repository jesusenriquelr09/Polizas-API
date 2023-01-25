package com.example.demo.PolizasDTO;

import org.springframework.stereotype.Service;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Data

@Service
public class InventarioDTO {
    private int SKU;
    private String Nombre;
    private int Cantidad;

    public InventarioDTO()
    {

    }

    public InventarioDTO(int SKU, String Nombre,  int Cantidad)
    {
        this.SKU = SKU;
        this.Nombre = Nombre;
        this.Cantidad = Cantidad;
    }

    public int getSKU()
    {
        return SKU;
    }

    public int setSKU()
    {
        return this.SKU;
    }

    public String getNombre()
    {
        return Nombre;
    }

    public String setNombre()
    {
        return this.Nombre;
    }

    public int getCantidad()
    {
        return Cantidad;
    }

    public int setCantidad()
    {
        return this.Cantidad;
    }

}
