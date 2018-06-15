CREATE DATABASE soporteAPDI

GO
USE soporteAPDI
GO

CREATE TABLE orientacionSexual(
id INT PRIMARY KEY IDENTITY(1,1),
nombre VARCHAR (30)
)
GO



CREATE TABLE juez(
run VARCHAR(20) PRIMARY KEY,
nombre VARCHAR(30),
apellido VARCHAR(30),
edad INT,
fk_genero INT FOREIGN KEY REFERENCES orientacionSexual (id),
sexo VARCHAR(20)
)
GO

CREATE TABLE perpetrador(
run VARCHAR(20) PRIMARY KEY,
nombre VARCHAR(30),
apellido VARCHAR(30),
edad INT,
fk_genero INT FOREIGN KEY REFERENCES orientacionSexual (id),
sexo VARCHAR(20)
)
GO

CREATE TABLE victima(
run VARCHAR(20) PRIMARY KEY,
nombre VARCHAR(30),
apellido VARCHAR(30),
edad INT,
fk_genero INT FOREIGN KEY REFERENCES orientacionSexual (id),
sexo VARCHAR(20)
)
GO


CREATE TABLE tipoDelito(
id INT PRIMARY KEY IDENTITY(1,1),
nombre VARCHAR (50)
)
GO


INSERT INTO tipoDelito VALUES ('Violación')
INSERT INTO tipoDelito VALUES ('Estupro')
INSERT INTO tipoDelito VALUES ('Abuso sexual')
INSERT INTO tipoDelito VALUES ('Producción de material pornográfico infantil')
INSERT INTO tipoDelito VALUES ('Comercialización de material pornográfico infantil')
INSERT INTO tipoDelito VALUES ('Favorecimiento de la prostitución de menores')
GO

CREATE TABLE delito(
id INT PRIMARY KEY IDENTITY(1,1),
	tipo_delito_fk INT FOREIGN KEY REFERENCES tipoDelito(id),
	fk_perpetrador VARCHAR(20)  FOREIGN KEY REFERENCES perpetrador(run),
	fk_victima VARCHAR(20)  FOREIGN KEY REFERENCES victima(run),
	detalle VARCHAR (200),
	fecha_delito DATETIME,
	fecha_denuncia DATETIME DEFAULT GETDATE(),
	aniosAntesDePreescribir INT
) 
GO

CREATE TABLE condena(
id INT PRIMARY KEY IDENTITY(1,1),
fk_juez VARCHAR (20) FOREIGN KEY REFERENCES juez(run),
fk_delito INT FOREIGN KEY REFERENCES delito (id)
)
GO


/*
Trigger que automaticamente agrega la cantidad de años antes de pre-escriba un delito, dependiendo de que tipo de delito se ingreso
*/
CREATE TRIGGER actualizarTiempoAntesDePreescripcion ON delito AFTER INSERT AS --DROP TRIGGER actualizarTiempoAntesDePreescripcion
DECLARE @id_mas_alto INT
DECLARE @fk_tipo_de_delito INT

SET @id_mas_alto=(SELECT MAX(id) FROM delito)
SET @fk_tipo_de_delito=(SELECT tipo_delito_fk FROM delito WHERE id=@id_mas_alto)

IF @fk_tipo_de_delito=1 
UPDATE delito SET aniosAntesDePreescribir=50 WHERE id=@id_mas_alto
ELSE IF @fk_tipo_de_delito=2
UPDATE delito SET aniosAntesDePreescribir=40 WHERE id=@id_mas_alto
ELSE IF @fk_tipo_de_delito=3
UPDATE delito SET aniosAntesDePreescribir=30 WHERE id=@id_mas_alto
ELSE IF @fk_tipo_de_delito=4
UPDATE delito SET aniosAntesDePreescribir=20 WHERE id=@id_mas_alto
ELSE IF @fk_tipo_de_delito=5
UPDATE delito SET aniosAntesDePreescribir=15 WHERE id=@id_mas_alto
ELSE IF @fk_tipo_de_delito=6
UPDATE delito SET aniosAntesDePreescribir=10 WHERE id=@id_mas_alto
GO	



CREATE TABLE registroDelitos(
id INT PRIMARY KEY IDENTITY(1,1),
delito_fk INT,
FOREIGN KEY (delito_fk) REFERENCES delito(id)
)
GO

/*
Se asume que hay un total de 13 orientaciones sexuales y 2 tipos de sexos (2 posibles organos reproductores
con lose que una persona puede nacer), sin embargo la base de datos da la posibilidad de ingresar nuevos sexos 
u orientaciones

Heterosexual
Homosexual
Bisexual
Transexual
Asexual
Pansexual
Antrosexual
Demisexual
Sapiosexual
Graysexual
Metrosexual
Spornosexual
Autosexual

Hombre
Mujer
	*/



/*
Procedimientos
*/
CREATE PROCEDURE crearVictima @run VARCHAR(20),@nombre VARCHAR(30), @apellido VARCHAR (30), @edad INT, @orientacionSexual VARCHAR(30), @sexo VARCHAR(20) 
	AS
		BEGIN
		
		DECLARE @runAIngresar VARCHAR (20)
		DECLARE @edadAIngresar INT
		DECLARE @fk_orientacionSexual INT
		DECLARE @sexoAagregar VARCHAR (20)
		DECLARE @orientacionSexualExiste BIT
		DECLARE @sexoExiste BIT
		DECLARE @nombreAIngresar VARCHAR (30)
		DECLARE @apellidoAIngresar VARCHAR (30)


		SET @orientacionSexualExiste=(SELECT COUNT(*) FROM orientacionSexual WHERE nombre=@orientacionSexual)
		IF @orientacionSexualExiste=1 
			SET @fk_orientacionSexual=(SELECT id FROM orientacionSexual WHERE nombre=@orientacionSexual)
		ELSE IF @orientacionSexualExiste=0
			INSERT INTO orientacionSexual VALUES (@orientacionSexual)
			SET @fk_orientacionSexual=(SELECT id FROM orientacionSexual WHERE nombre=@orientacionSexual)


		SET @runAIngresar=@run
		SET @nombreAIngresar=@nombre
		SET @apellidoAIngresar=@apellido	
		SET @edadAIngresar=@edad
		SET @sexoAagregar=@sexo

		INSERT INTO victima VALUES (@runAIngresar, @nombreAIngresar,@apellidoAIngresar, @edadAIngresar, @fk_orientacionSexual, @sexoAagregar)	
		
		END
		GO




CREATE PROCEDURE crearPerpetrador @run VARCHAR(20),@nombre VARCHAR(30), @apellido VARCHAR (30), @edad INT, @orientacionSexual VARCHAR(30), @sexo VARCHAR(20) 
	AS
		BEGIN
		
		DECLARE @runAIngresar VARCHAR (20)
		DECLARE @edadAIngresar INT
		DECLARE @fk_orientacionSexual INT
		DECLARE @sexoAagregar VARCHAR (20)
		DECLARE @orientacionSexualExiste BIT
		DECLARE @sexoExiste BIT
		DECLARE @nombreAIngresar VARCHAR (30)
		DECLARE @apellidoAIngresar VARCHAR (30)


		SET @orientacionSexualExiste=(SELECT COUNT(*) FROM orientacionSexual WHERE nombre=@orientacionSexual)
		IF @orientacionSexualExiste=1 
			SET @fk_orientacionSexual=(SELECT id FROM orientacionSexual WHERE nombre=@orientacionSexual)
		ELSE IF @orientacionSexualExiste=0
			INSERT INTO orientacionSexual VALUES (@orientacionSexual)
			SET @fk_orientacionSexual=(SELECT id FROM orientacionSexual WHERE nombre=@orientacionSexual)


		SET @runAIngresar=@run
		SET @nombreAIngresar=@nombre
		SET @apellidoAIngresar=@apellido	
		SET @edadAIngresar=@edad
		SET @sexoAagregar=@sexo

		INSERT INTO perpetrador VALUES (@runAIngresar, @nombreAIngresar,@apellidoAIngresar, @edadAIngresar, @fk_orientacionSexual, @sexoAagregar)	
		
		END
		GO

CREATE PROCEDURE crearJuez @run VARCHAR(20),@nombre VARCHAR(30), @apellido VARCHAR (30), @edad INT, @orientacionSexual VARCHAR(30), @sexo VARCHAR(20) 
	AS
		BEGIN
		
		DECLARE @runAIngresar VARCHAR (20)
		DECLARE @edadAIngresar INT
		DECLARE @fk_orientacionSexual INT
		DECLARE @sexoAagregar VARCHAR (20)
		DECLARE @orientacionSexualExiste BIT
		DECLARE @sexoExiste BIT
		DECLARE @nombreAIngresar VARCHAR (30)
		DECLARE @apellidoAIngresar VARCHAR (30)


		SET @orientacionSexualExiste=(SELECT COUNT(*) FROM orientacionSexual WHERE nombre=@orientacionSexual)
		IF @orientacionSexualExiste=1 
			SET @fk_orientacionSexual=(SELECT id FROM orientacionSexual WHERE nombre=@orientacionSexual)
		ELSE IF @orientacionSexualExiste=0
			INSERT INTO orientacionSexual VALUES (@orientacionSexual)
			SET @fk_orientacionSexual=(SELECT id FROM orientacionSexual WHERE nombre=@orientacionSexual)


		SET @runAIngresar=@run
		SET @nombreAIngresar=@nombre
		SET @apellidoAIngresar=@apellido	
		SET @edadAIngresar=@edad
		SET @sexoAagregar=@sexo

		INSERT INTO juez VALUES (@runAIngresar, @nombreAIngresar,@apellidoAIngresar, @edadAIngresar, @fk_orientacionSexual, @sexoAagregar)	
		
		END
		GO


EXEC crearVictima '10898088-1','Fulanita','Del Solar',17,'Heterosexual','Mujer'
GO

EXEC crearPerpetrador '20896688-1','Pedro','Jorquera',33,'Heterosexual','Hombre'
GO

EXEC crearJuez '30898088-1','Fernando','Vibemas',65,'Homosexual','Hombre'
GO


CREATE PROCEDURE crearInformeDeDenunciasHastaLaFecha @informe VARCHAR(MAX) AS --DROP PROCEDURE  crearInformeDeDenunciasHastaLaFecha
BEGIN
	DECLARE @texto VARCHAR(MAX)
	
	DECLARE @run_victima VARCHAR (20)
	DECLARE @edad_victima INT

	SET @texto=''

	DECLARE cursor_informe CURSOR
		FOR (SELECT run, edad FROM victima)

	OPEN cursor_informe

	FETCH NEXT FROM cursor_informe
		INTO @run_victima, @edad_victima -- count = 0


	WHILE @@FETCH_STATUS=0
	BEGIN
		IF @edad_victima<18
			/*PRINT CONCAT(@run_victima,' es menor de edad')*/
			SET @texto=CONCAT(@texto, @run_victima, ' es menor de edad ')

		

		FETCH NEXT FROM cursor_informe
			INTO @run_victima, @edad_victima -- count += 1
	END

	

	CLOSE cursor_informe
	DEALLOCATE cursor_informe
END
SELECT @texto AS 'Texto'

	GO

EXEC crearInformeDeDenunciasHastaLaFecha 'oka'
INSERT INTO delito (tipo_delito_fk,fk_perpetrador, fk_victima, detalle, fecha_delito) VALUES (1,'20896688-1','10898088-1','Se toma constancia de que la victima asegura haber estado a merced del perpetrador durante un periodo de 3 horas','03-03-2000')
GO

/*
Funciones
*/


/*
Funcion que muestra la cantidad de condenas hechas por un determinado juez
*/
CREATE FUNCTION cantidadDeCondenasDictadasPorUnJuez (@run_de_juez VARCHAR(20)) RETURNS INT AS
 BEGIN
	 RETURN (SELECT COUNT(*) FROM juez WHERE run=@run_de_juez)
END

GO

PRINT dbo.cantidadDeCondenasDictadasPorUnJuez('30898088-1')

/*
Consultas relacionadas
*/


-- cantidad de victimas menores de edad heterosexuales
SELECT COUNT(*) FROM victima, orientacionSexual WHERE victima.edad<18 AND orientacionSexual.nombre='Heterosexual'
GO

-- cantidad de victimas mayores de edad heterosexuales
SELECT COUNT(*) FROM victima, orientacionSexual WHERE victima.edad>=18 AND orientacionSexual.nombre='Heterosexual'
GO


-- cantidad de perpetradores mayores de edad heterosexuales
SELECT COUNT(*) FROM perpetrador, orientacionSexual WHERE perpetrador.edad>=18 AND orientacionSexual.nombre='Heterosexual'
GO

-- cantidad de perpetradores menores de edad heterosexuales
SELECT COUNT(*) FROM perpetrador, orientacionSexual WHERE perpetrador.edad<18 AND orientacionSexual.nombre='Heterosexual'
GO


-- cantidad de condenas a un perpetrador, en donde la victima es un menor de edad
SELECT COUNT (*) FROM condena, delito, victima WHERE condena.fk_delito=delito.id AND delito.fk_victima=victima.run AND victima.edad<18
GO



USE MASTER
GO
ALTER DATABASE soporteAPDI
SET SINGLE_USER WITH ROLLBACK IMMEDIATE;
DROP DATABASE soporteAPDI
GO



























