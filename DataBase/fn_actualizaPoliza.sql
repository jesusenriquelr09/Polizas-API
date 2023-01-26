--DROP FUNCTION fn_actualizaPoliza (pPoliza INT, pSKU INT, pCantidad INT) 
CREATE OR REPLACE FUNCTION fn_actualizaPoliza (pPoliza INT, pSKU INT) 
    RETURNS TABLE(
	rMensaje CHARACTER(80)
    ) 
AS $$
	DECLARE  
	rMensaje CHARACTER(80);
BEGIN
	
	UPDATE Polizas 
	SET SKU = pSKU
	WHERE idpolizas = pPoliza;
	
	IF NOT FOUND THEN
		SELECT 'Ha ocurrido un error al intentar actualizar la póliza #' || pPoliza::CHAR(10) INTO rMensaje;
		RETURN QUERY SELECT rMensaje;
	END IF;
	
	SELECT 'Se actualizó correctamente la póliza #' || pPoliza::CHAR(10) INTO rMensaje;
	RETURN QUERY SELECT rMensaje;
	
END; $$ 

LANGUAGE 'plpgsql';