-- DROP FUNCTION fn_obtenerPoliza (pPoliza INT)
CREATE OR REPLACE FUNCTION fn_obtenerPoliza (pPoliza INT) 
    RETURNS TABLE (
        rIDPoliza INT,
        rCantidad INT,
		rNombreEmp CHARACTER(50),
		rApellido CHARACTER(50),
		rSKU INT,
		rNombreArt CHARACTER(50)
)
AS $$
BEGIN
    RETURN QUERY 
	SELECT
        P.IdPolizas,
        P.Cantidad,
		E.Nombre,
		E.Apellido,
		I.SKU,
		I.Nombre
    FROM Polizas P
	INNER JOIN Empleado E ON (P.EmpleadoGenero = E.IdEmpleado)
	INNER JOIN Inventario I ON (P.SKU = I.SKU)
    WHERE IdPolizas = pPoliza;
	
END; $$ 

LANGUAGE 'plpgsql';