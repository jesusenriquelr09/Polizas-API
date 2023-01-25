package com.example.demo.PolizasDTO;

import java.sql.Date;
import org.springframework.stereotype.Service;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Data

@Service
public class PolizasDTO {
    private int IdPolizas;
    private String EmpleadoGenero;
    private int SKU;
    private int Cantidad;
    private Date Fecha;

    public PolizasDTO()
    {
        
    }

    public PolizasDTO(int IdPolizas, String EmpleadoGenero, int SKU, int Cantidad, Date Fecha)
    {
        this.IdPolizas = IdPolizas;
        this.EmpleadoGenero = EmpleadoGenero;
        this.SKU = SKU;
        this.Cantidad = Cantidad;
        this.Fecha = Fecha;
    }

    public int getIdPolizas()
    {
        return IdPolizas;
    }

    public int setIdPolizas()
    {
        return this.IdPolizas;
    }

    public String getEmpleadoGenero()
    {
        return EmpleadoGenero;
    }

    public String setEmpleadoGenero()
    {
        return this.EmpleadoGenero;
    }

    public int getSKU()
    {
        return SKU;
    }

    public int setSKU()
    {
        return this.SKU;
    }

    public int getCantidad()
    {
        return Cantidad;
    }

    public int setCantidad()
    {
        return this.Cantidad;
    }

    public Date getFecha()
    {
        return Fecha;
    }

    public Date setFecha()
    {
        return this.Fecha;
    }

}
