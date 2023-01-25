package com.example.demo.PolizasDTO;

import org.springframework.stereotype.Service;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Data

@Service
public class EmpleadoDTO {
    private int IdEmpleado;
    private String Nombre;
    private String Apellido;
    private int Puesto;

    public EmpleadoDTO()
    {

    }

    public EmpleadoDTO(int IdEmpleado, String Nombre, String Apellido, int Puesto)
    {
        this.IdEmpleado = IdEmpleado;
        this.Nombre = Nombre;
        this.Apellido = Apellido;
        this.Puesto = Puesto;
    }

    public int getIdEmpleado()
    {
        return IdEmpleado;
    }

    public int setIdEmpleado()
    {
        return this.IdEmpleado;
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

    public int getPuesto()
    {
        return Puesto;
    }

    public int setPuesto()
    {
        return this.Puesto;
    }
}
