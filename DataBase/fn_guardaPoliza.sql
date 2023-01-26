-- DROP FUNCTION fn_guardaPoliza (pEmpleadoGenero INT, pSKU INT, pCantidad INT, pFecha INT) 
CREATE OR REPLACE FUNCTION fn_guardaPoliza(pPoliza INT, pCantidad INT, pEmpleadoGenero INT, pSKU INT) 
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
	
	INSERT INTO Polizas (idpolizas, EmpleadoGenero, SKU, Cantidad, Fecha)
	VALUES (pPoliza, pEmpleadoGenero, pSKU, pCantidad, current_date);
	
	UPDATE Inventario
	SET Cantidad = (SELECT Cantidad - pCantidad FROM Inventario WHERE SKU = pSKU)
	WHERE SKU = pSKU;
	
	IF FOUND THEN
		RETURN QUERY SELECT 
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
	END IF;
	
END; $$ 

LANGUAGE 'plpgsql';