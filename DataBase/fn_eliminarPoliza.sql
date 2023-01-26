-- DROP FUNCTION fn_eliminarPoliza (pPoliza INT) 
CREATE OR REPLACE FUNCTION fn_eliminarPoliza (pPoliza INT) 
    RETURNS TABLE(
	rMensaje CHARACTER(80)
    ) 
AS $$
	DECLARE  
	rMensaje CHARACTER(80);
BEGIN
	
	DELETE FROM polizas
	WHERE idpolizas = pPoliza;
	
	IF NOT FOUND THEN
		SELECT 'Ha ocurrido un error al intentar eliminar la póliza #' || pPoliza::CHAR(10) INTO rMensaje;
		RETURN QUERY SELECT rMensaje;
	END IF;
	
	SELECT 'Se elimino correctamente la póliza #' || pPoliza::CHAR(10) INTO rMensaje;
	RETURN QUERY SELECT rMensaje;
	
END; $$ 

LANGUAGE 'plpgsql';