package com.example.demo.PolizasController;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.PolizasDAO.PolizasDAO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/api")
public class PolizasController {
    @RequestMapping("")
    public String pruebaAplicacion()
    {
        return "La aplicacion esta en linea";
    }

    @Autowired
    public PolizasDAO polizasService;

    @RequestMapping("obtenerpolizas")
    public ResponseEntity<Object> GetObtenerPolizas(@RequestParam("IDPolizas") int IDPolizas) throws SQLException
    {
        log.info("Entra al metodo controlador de obtenerPolizas");
        Object polizas = polizasService.obtenerPolizas(IDPolizas);
        return ResponseEntity.ok(polizas);
    }

    @RequestMapping(value = "actualizarpolizas", method = RequestMethod.POST)
    public ResponseEntity<Object> PostActualizarPolizas(@RequestParam int IDPolizas, @RequestParam int SKU) throws SQLException
    {
        log.info("Entra al metodo controlador de actualizarpolizas");
        Object polizas = polizasService.actualizarPolizas(IDPolizas, SKU);
        return ResponseEntity.ok(polizas);
    }

    @RequestMapping(value = "guardarpolizas", method = RequestMethod.POST)
    public ResponseEntity<Object> PostguardarPolizas(@RequestParam int IDPolizas, @RequestParam int Cantidad, @RequestParam int EmpleadoGenero, @RequestParam int SKU) throws SQLException
    {
        log.info("Entra al metodo controlador de guardarpolizas");
        Object polizas = polizasService.guardarPolizas(IDPolizas, Cantidad, EmpleadoGenero, SKU);
        return ResponseEntity.ok(polizas);
    }

    @RequestMapping(value = "eliminarpolizas", method = RequestMethod.POST)
    public ResponseEntity<Object> PostEliminarPolizas(@RequestParam int IDPolizas) throws SQLException
    {
        log.info("Entra al metodo controlador de eliminarpolizas");
        Object polizas = polizasService.eliminarPolizas(IDPolizas);
        return ResponseEntity.ok(polizas);
    }
}
