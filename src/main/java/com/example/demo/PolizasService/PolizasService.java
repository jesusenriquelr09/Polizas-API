package com.example.demo.PolizasService;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.PolizasDAO.PolizasDAO;
import com.example.demo.PolizasDTO.GenericaDTO;
import com.example.demo.PolizasDTO.PolizasDTO;


@Service
@Transactional
public class PolizasService {
    @Autowired
    PolizasDTO polizasDTO;
    
    @Autowired
    PolizasDAO polizasDAO;
    public List<GenericaDTO> GetPolizasDTO(int IDPolizas) throws SQLException{
        return polizasDAO.obtenerPolizas(IDPolizas);
    }

    public String PostActualizarPolizasDTO(int IDPolizas, int SKU) throws SQLException{
        return polizasDAO.actualizarPolizas(IDPolizas, SKU);
    }

    public List<GenericaDTO> PostGuardarPolizasDTO(int IDPolizas, int Cantidad, int EmpleadoGenero, int SKU) throws SQLException{
        return polizasDAO.guardarPolizas(IDPolizas, Cantidad, EmpleadoGenero, SKU);
    }

    public String PostEliminarPolizasDTO(int IDPolizas) throws SQLException{
        
        return polizasDAO.eliminarPolizas(IDPolizas);
    }
}
