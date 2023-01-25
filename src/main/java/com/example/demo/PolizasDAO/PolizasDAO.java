package com.example.demo.PolizasDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import com.example.demo.PolizasDTO.GenericaDTO;

import lombok.extern.slf4j.Slf4j;

import com.example.demo.PolizasDAO.PolizasDAO;

@Service
@Slf4j
public class PolizasDAO {
    @Value("${spring.datasource.url}")
    String urlCon;

    @Value("${spring.datasource.username}")
    String pgUser;

    @Value("${spring.datasource.password}")
    String pgPass;

    public List<GenericaDTO> obtenerPolizas(int IDPolizas) throws SQLException {
        Connection con = null;
        List<GenericaDTO> listPolizas = new ArrayList<GenericaDTO>();
        GenericaDTO polizas = new GenericaDTO();

        log.info("Entra al metodo obtenerPolizas");
        try {
            con = DriverManager.getConnection(urlCon, pgUser, pgUser);
            String urlCon = String.format("SELECT rIDPoliza, rCantidad, rNombreEmp, rApellido, rSKU, rNombreArt from fn_obtenerPoliza(%d::INTEGER)", IDPolizas);
            log.info("Se ejecuta la funcion "+urlCon);
            ResultSet returnData;
            // ejecuta la consulta
            try ( // prepara la consulta
                    Statement executeSql = con.createStatement()) {
                // ejecuta la consulta
                returnData = executeSql.executeQuery(urlCon);
                // contiene la data
                if (returnData.next()) {
                    polizas.setIdPolizas(returnData.getInt("rIDPoliza"));
                    polizas.setCantidad(returnData.getInt("rCantidad"));
                    polizas.setNombre(returnData.getString("rNombreEmp"));
                    polizas.setApellido(returnData.getString("rApellido"));
                    polizas.setSKU(returnData.getInt("rSKU"));
                    polizas.setNombreArticulo(returnData.getString("rNombreArt"));
                    listPolizas.add(polizas);
                }
            }
            returnData.close();
            con.close();
        } catch (SQLException e) {
            throw new SQLException("Ocurrio un error al generar la consulta", e);
        }
        return listPolizas;
    }

    public String actualizarPolizas(int IDPolizas, int SKU) throws SQLException {
        String Data = null;
        Connection con = null;
        log.info("Entra al metodo actualizarPolizas");

        try {
            con = DriverManager.getConnection(urlCon, pgUser, pgUser);

            String urlCon = String.format("SELECT rMensaje from fn_actualizaPoliza(%d::INTEGER, %d::INTEGER)", IDPolizas, SKU) ;
            log.info("Se ejecuta la funcion "+urlCon);
            ResultSet returnData;
            // ejecuta la consulta
            try ( // prepara la consulta
                    Statement executeSql = con.createStatement()) {
                // ejecuta la consulta
                returnData = executeSql.executeQuery(urlCon);
                // contiene la data
                if (returnData.next()) {
                    Data = returnData.getString("rMensaje");
                }
            }
            returnData.close();
            con.close();
        } catch (SQLException e) {
            throw new SQLException("Ocurrio un error al generar la consulta", e);
        }
        return Data;
    }

    public List<GenericaDTO> guardarPolizas(int IDPolizas, int Cantidad, int EmpleadoGenero, int SKU) throws SQLException {
        List<GenericaDTO> listPolizas = new ArrayList<GenericaDTO>();
        GenericaDTO polizas = new GenericaDTO();
        Connection con = null;
        log.info("Entra al metodo guardarPolizas");
        try {
            con = DriverManager.getConnection(urlCon, pgUser, pgUser);

            String urlCon = String.format("SELECT rIDPoliza, rCantidad, rNombreEmp, rApellido, rSKU, rNombreArt from fn_guardaPoliza(%d::INTEGER, %d::INTEGER, %d::INTEGER, %d::INTEGER)", IDPolizas, Cantidad, EmpleadoGenero, SKU) ;
            log.info("Se ejecuta la funcion "+urlCon);
            ResultSet returnData;
            // ejecuta la consulta
            try ( // prepara la consulta
                    Statement executeSql = con.createStatement()) {
                // ejecuta la consulta
                returnData = executeSql.executeQuery(urlCon);
                // contiene la data
                if (returnData.next()) {
                    polizas.setIdPolizas(returnData.getInt("rIDPoliza"));
                    polizas.setCantidad(returnData.getInt("rCantidad"));
                    polizas.setNombre(returnData.getString("rNombreEmp"));
                    polizas.setApellido(returnData.getString("rApellido"));
                    polizas.setSKU(returnData.getInt("rSKU"));
                    polizas.setNombreArticulo(returnData.getString("rNombreArt"));
                    listPolizas.add(polizas);
                }
            }
            returnData.close();
            con.close();
        } catch (SQLException e) {
            throw new SQLException("Ocurrio un error al generar la consulta", e);
        }
        return listPolizas;
    }

    public String eliminarPolizas(int IDPolizas) throws SQLException {
        String Data = null;
        Connection con = null;
        log.info("Entra al metodo eliminarPolizas");
        try {
            con = DriverManager.getConnection(urlCon, pgUser, pgUser);

            String urlCon = String.format("SELECT rMensaje from fn_eliminarPoliza(%d::INTEGER)", IDPolizas) ;
            log.info("Se ejecuta la funcion "+urlCon);
            ResultSet returnData;
            // ejecuta la consulta
            try ( // prepara la consulta
                    Statement executeSql = con.createStatement()) {
                // ejecuta la consulta
                returnData = executeSql.executeQuery(urlCon);
                // contiene la data
                if (returnData.next()) {
                    Data = returnData.getString("rMensaje");
                }
            }
            returnData.close();
            con.close();
        } catch (SQLException e) {
            throw new SQLException("Ocurrio un error al generar la consulta", e);
        }
        return Data;
    }
}