SELECT *
FROM Inventario;

SELECT *
FROM Empleado;

SELECT *
FROM Polizas;

SELECT * 
FROM fn_obtenerPoliza(1);

SELECT * 
FROM fn_actualizaPoliza(1,1,2,3);

SELECT * 
FROM fn_eliminaPoliza(2);

SELECT * 
FROM fn_guardaPoliza(1, 2, 5, current_date);