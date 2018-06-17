CREATE DATABASE soporteAPDI

GO
USE soporteAPDI
GO


/*TABLAS*/
CREATE TABLE orientacionSexual(
id INT PRIMARY KEY IDENTITY(1,1),
nombre VARCHAR (30)
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


CREATE TABLE perpetrador(
run VARCHAR(20) PRIMARY KEY,
nombre VARCHAR(30),
apellido VARCHAR(30),
edad INT,
fk_genero INT FOREIGN KEY REFERENCES orientacionSexual (id),
sexo VARCHAR(20),
cantidadDeDelitosCometidos INT,
)
GO



CREATE TABLE juez(
run VARCHAR(20) PRIMARY KEY,
nombre VARCHAR(30),
apellido VARCHAR(30),
edad INT,
fk_genero INT FOREIGN KEY REFERENCES orientacionSexual (id),
sexo VARCHAR(20),
cantidadDeSentenciasDictadas INT
)
GO



CREATE TABLE tipoDelito(
id INT PRIMARY KEY IDENTITY(1,1),
nombre VARCHAR (50)
)
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

/*PROCEDIMIENTOS CRUD Y DE INFORME*/

/*CRUD orientacion Sexual, toma parametros y ejecuta consultas. 1,2,3,4 para INSERT, SELECT, UPDATE y DELETE respectivamente*/
CREATE PROCEDURE CRUDorientacionSexual @id INT, @nombre VARCHAR(30), @tipoDeQuery INT AS --DROP PROCEDURE CRUDorientacionSexual

	BEGIN
	DECLARE @idOrientacion INT
	DECLARE @nombreOrientacion VARCHAR(30)

	SET @idOrientacion=@id
	SET @nombreOrientacion=@nombre

	IF @tipoDeQuery=1
		INSERT INTO orientacionSexual VALUES (@nombre)
	ELSE IF @tipoDeQuery=2
		 SELECT * FROM orientacionSexual WHERE id=@idOrientacion
	ELSE IF @tipoDeQuery=3
		UPDATE orientacionSexual SET nombre=@nombreOrientacion WHERE id=@idOrientacion
	ELSE IF @tipoDeQuery=4
		DELETE FROM orientacionSexual WHERE id=@idOrientacion
	END
	GO	


/*CRUD victima, toma parametros y ejecuta consultas. 1,2,3,4 para INSERT, SELECT, UPDATE y DELETE respectivamente*/
CREATE PROCEDURE CRUDVictima @run VARCHAR(20),@nombre VARCHAR(30), @apellido VARCHAR (30), @edad INT, @orientacionSexual VARCHAR(30), @sexo VARCHAR(20), @tipoDeQuery INT --DROP PROCEDURE CRUDVictima
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
		BEGIN
		IF @orientacionSexualExiste=1 
			SET @fk_orientacionSexual=(SELECT TOP 1 id FROM orientacionSexual WHERE nombre=@orientacionSexual)
		ELSE IF @orientacionSexualExiste=0
			EXEC CRUDorientacionSexual 1,@orientacionSexual,1
			SET @fk_orientacionSexual=(SELECT TOP 1 id FROM orientacionSexual WHERE nombre=@orientacionSexual)
		END

		SET @runAIngresar=@run
		SET @nombreAIngresar=@nombre
		SET @apellidoAIngresar=@apellido	
		SET @edadAIngresar=@edad
		SET @sexoAagregar=@sexo

		IF @tipoDeQuery=1
			INSERT INTO victima VALUES (@runAIngresar, @nombreAIngresar,@apellidoAIngresar, @edadAIngresar, @fk_orientacionSexual, @sexoAagregar)	
		ELSE IF @tipoDeQuery=2
			SELECT  TOP 1 * FROM victima WHERE run=@run
		ELSE IF @tipoDeQuery=3
			UPDATE victima SET nombre=@nombreAIngresar, apellido=@apellidoAIngresar, edad=@edadAIngresar, fk_genero=@fk_orientacionSexual, sexo=@sexoAagregar WHERE run=@runAIngresar
		ELSE IF @tipoDeQuery=4
			DELETE FROM victima WHERE run=@runAIngresar

		END
		
		GO





/*CRUD perpetrador, toma parametros y ejecuta consultas. 1,2,3,4 para INSERT, SELECT, UPDATE y DELETE respectivamente*/
CREATE PROCEDURE CRUDperpetrador @run VARCHAR(20),@nombre VARCHAR(30), @apellido VARCHAR (30), @edad INT, @orientacionSexual VARCHAR(30), @sexo VARCHAR(20), @cantidadDeDelitosCometidos INT, @tipoDeQuery INT --DROP PROCEDURE CRUDperpetrador
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
		DECLARE @cantDelitosAIngresar INT


		SET @orientacionSexualExiste=(SELECT COUNT(*) FROM orientacionSexual WHERE nombre=@orientacionSexual)
		IF @orientacionSexualExiste=1 
			SET @fk_orientacionSexual=(SELECT TOP 1 id FROM orientacionSexual WHERE nombre=@orientacionSexual)
		ELSE IF @orientacionSexualExiste=0
			EXEC CRUDorientacionSexual 1,@orientacionSexual,1
			SET @fk_orientacionSexual=(SELECT TOP 1 id FROM orientacionSexual WHERE nombre=@orientacionSexual)


		SET @runAIngresar=@run
		SET @nombreAIngresar=@nombre
		SET @apellidoAIngresar=@apellido	
		SET @edadAIngresar=@edad
		SET @sexoAagregar=@sexo
		SET @cantDelitosAIngresar=0

		IF @tipoDeQuery=1
			INSERT INTO perpetrador VALUES (@runAIngresar, @nombreAIngresar,@apellidoAIngresar, @edadAIngresar, @fk_orientacionSexual, @sexoAagregar,@cantDelitosAIngresar)	
		ELSE IF @tipoDeQuery=2
			SELECT TOP 1 * FROM perpetrador WHERE run=@runAIngresar
		ELSE IF @tipoDeQuery=3
			UPDATE perpetrador SET nombre=@nombreAIngresar, apellido=@apellidoAIngresar, edad=@edadAIngresar, fk_genero=@fk_orientacionSexual, sexo=@sexoAagregar WHERE run=@runAIngresar
		ELSE IF @tipoDeQuery=4
			DELETE FROM perpetrador WHERE run=@runAIngresar


		END
		GO

/*CRUD juez, toma parametros y ejecuta consultas. 1,2,3,4 para INSERT, SELECT, UPDATE y DELETE respectivamente*/
CREATE PROCEDURE CRUDjuez @run VARCHAR(20),@nombre VARCHAR(30), @apellido VARCHAR (30), @edad INT, @orientacionSexual VARCHAR(30), @sexo VARCHAR(20), @cantidadDeSentenciasDictadas INT, @tipoDeQuery INT -- DROP PROCEDURE CRUDjuez
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
		DECLARE @cantidadDeSentenciasDictadasAIngresar INT



		SET @orientacionSexualExiste=(SELECT COUNT(*) FROM orientacionSexual WHERE nombre=@orientacionSexual)
		IF @orientacionSexualExiste=1 
			SET @fk_orientacionSexual=(SELECT TOP 1 id FROM orientacionSexual WHERE nombre=@orientacionSexual)
		ELSE IF @orientacionSexualExiste=0
			EXEC CRUDorientacionSexual 1,@orientacionSexual,1
			SET @fk_orientacionSexual=(SELECT TOP 1 id FROM orientacionSexual WHERE nombre=@orientacionSexual)


		SET @runAIngresar=@run
		SET @nombreAIngresar=@nombre
		SET @apellidoAIngresar=@apellido	
		SET @edadAIngresar=@edad
		SET @sexoAagregar=@sexo
		SET @cantidadDeSentenciasDictadasAIngresar=0

		IF @tipoDeQuery=1
			INSERT INTO juez VALUES (@runAIngresar, @nombreAIngresar,@apellidoAIngresar, @edadAIngresar, @fk_orientacionSexual, @sexoAagregar,@cantidadDeSentenciasDictadasAIngresar)	
		ELSE IF @tipoDeQuery=2
			SELECT TOP 1 * FROM juez WHERE run=@runAIngresar
		ELSE IF @tipoDeQuery=3
			UPDATE juez SET nombre=@nombreAIngresar, apellido=@apellidoAIngresar, edad=@edadAIngresar, fk_genero=@fk_orientacionSexual, sexo=@sexoAagregar WHERE run=@runAIngresar
		ELSE IF @tipoDeQuery=4
			DELETE FROM juez WHERE run=@runAIngresar
		
		END
		GO


/*CRUD tipoDeDelito, toma parametros y ejecuta consultas. 1,2,3,4 para INSERT, SELECT, UPDATE y DELETE respectivamente*/
CREATE PROCEDURE CRUDtipoDelito(@id INT, @nombre VARCHAR(50), @tipoDeQuery INT) AS --DROP PROCEDURE CRUDtipoDelito

	BEGIN
	DECLARE @idTipoDeDelito INT
	DECLARE @nombreDeDelito VARCHAR(50)

	SET @idTipoDeDelito=@id
	SET @nombreDeDelito=@nombre

	IF @tipoDeQuery=1
		INSERT INTO tipoDelito VALUES (@nombre)
	ELSE IF @tipoDeQuery=2
		 SELECT * FROM tipoDelito WHERE id=@idTipoDeDelito
	ELSE IF @tipoDeQuery=3
		UPDATE tipoDelito SET nombre=@nombreDeDelito WHERE id=@idTipoDeDelito
	ELSE IF @tipoDeQuery=4
		DELETE FROM tipoDelito WHERE id=@idTipoDeDelito
	END
	GO	



/*CRUD delito, toma parametros y ejecuta consultas. 1,2,3,4 para INSERT, SELECT, UPDATE y DELETE respectivamente*/
CREATE PROCEDURE CRUDDelito(@id INT, @tipo_de_delito INT,@fk_perpetrador VARCHAR (20), @fk_victima VARCHAR (20),@detalle VARCHAR (200),@fecha_delito DATETIME, @tipoDeQuery INT) AS --DROP PROCEDURE CRUDDelito


	BEGIN
	DECLARE @tipoDeDelitoAIngresar INT
	DECLARE @fk_perpAIngresar VARCHAR (20)
	DECLARE @fk_victAIngresar VARCHAR (20)
	DECLARE @detalleAIngresar VARCHAR (200)
	DECLARE @fechaDeDelitoAIngresar DATETIME

	SET @tipoDeDelitoAIngresar=@tipo_de_delito
	SET @fk_perpAIngresar=@fk_perpetrador
	SET @fk_victAIngresar=@fk_victima
	SET @detalleAIngresar=@detalle
	SET @fechaDeDelitoAIngresar=@fecha_delito

	

	IF @tipoDeQuery=1
		INSERT INTO delito (tipo_delito_fk,fk_perpetrador,fk_victima,detalle,fecha_delito) VALUES (@tipoDeDelitoAIngresar,@fk_perpAIngresar,@fk_victAIngresar,@detalleAIngresar,@fechaDeDelitoAIngresar)
	ELSE IF @tipoDeQuery=2
		 SELECT * FROM delito WHERE id=@id
	ELSE IF @tipoDeQuery=3
		UPDATE delito SET tipo_delito_fk=@tipoDeDelitoAIngresar, fk_perpetrador=@fk_perpAIngresar, fk_victima=@fk_victAIngresar, detalle=@detalleAIngresar,fecha_delito=@fechaDeDelitoAIngresar  WHERE id=@id
	ELSE IF @tipoDeQuery=4
		DELETE FROM delito WHERE id=@id
	END
	GO	


/*CRUD condena, toma parametros y ejecuta consultas. 1,2,3,4 para INSERT, SELECT, UPDATE y DELETE respectivamente*/
CREATE PROCEDURE CRUDCondena(@id INT,@fk_juez VARCHAR(20), @fk_delito INT , @tipoDeQuery INT) AS --DROP PROCEDURE CRUDCondena
	
	DECLARE @fkJuezAIngresar VARCHAR (20)
	DECLARE @fkDelitoIngresar INT

	SET @fkJuezAIngresar=@fk_juez
	SET @fkDelitoIngresar=@fk_delito

	BEGIN

	IF @tipoDeQuery=1
		INSERT INTO condena VALUES (@fkJuezAIngresar,@fkDelitoIngresar)
	ELSE IF @tipoDeQuery=2
		 SELECT * FROM condena WHERE id=@id
	ELSE IF @tipoDeQuery=3
		UPDATE condena SET fk_juez=@fkJuezAIngresar, fk_delito=@fkDelitoIngresar WHERE id=@id
	ELSE IF @tipoDeQuery=4
		DELETE FROM condena WHERE id=@id
	END
	GO	


EXEC CRUDtipoDelito 1,'Violación',1
EXEC CRUDtipoDelito 1,'Estupro',1
EXEC CRUDtipoDelito 1,'Abuso Sexual',1
EXEC CRUDtipoDelito 1,'Producción de material pornográfico infantil',1
EXEC CRUDtipoDelito 1,'Comercialización de material pornográfico infantil',1
EXEC CRUDtipoDelito 1,'Favorecimiento de la prostitución de menores',1
GO

EXEC CRUDorientacionSexual 1,'Heterosexual',1
EXEC CRUDorientacionSexual 1,'Homosexual',1
EXEC CRUDorientacionSexual 1,'Bisexual',1
EXEC CRUDorientacionSexual 1,'Transexual',1
EXEC CRUDorientacionSexual 1,'Asexual',1
EXEC CRUDorientacionSexual 1,'Pansexual',1
EXEC CRUDorientacionSexual 1,'Antrosexual',1
EXEC CRUDorientacionSexual 1,'Demisexual',1
EXEC CRUDorientacionSexual 1,'Sapiosexual',1
EXEC CRUDorientacionSexual 1,'Graysexual',1
EXEC CRUDorientacionSexual 1,'Metrosexual',1
EXEC CRUDorientacionSexual 1,'Spornosexual',1
EXEC CRUDorientacionSexual 1,'Autosexual',1
GO



EXEC CRUDVictima'12343133-1','Fulanita','Del Solar',17,'Heterosexual','Mujer',1
EXEC CRUDVictima'1032088-1','Fulanita','Del Solar',17,'Heterosexual','Mujer',1
GO

EXEC CRUDperpetrador'20896688-1','Pedro','Jorquera',33,'Heterosexual','Hombre',0,1
GO

EXEC CRUDjuez'33898088-1','Fernando','Vibemas',65,'Homosexual','Hombre',0,1
GO


EXEC CRUDDelito 1,1,'20896688-1','1032088-1','Victima sufrio el delito por 3 horas','2016-06-06',1
GO


EXEC CRUDCondena 1,'33898088-1',1,1
GO

/*Hasta aqui debiese estar todo bien (Los Trigger tambien funcionan)*/





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



/*FUNCIONES*/

/*
Funcion que muestra la cantidad de condenas hechas por un determinado juez
*/
CREATE FUNCTION cantidadDeCondenasDictadasPorUnJuez (@run_de_juez VARCHAR(20)) RETURNS INT AS
 BEGIN
	 RETURN (SELECT COUNT(*) FROM juez WHERE run=@run_de_juez)
END

GO

PRINT dbo.cantidadDeCondenasDictadasPorUnJuez('30898088-1')

/* CONSULTAS */


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




/*TRIGGERS*/

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



/*Trigger que actualiza la cantidad de delitos cometidos por un perpetrador, cada vez que este se registre en un delito*/
CREATE TRIGGER actualizarCantDelitosDeUnPerpetrador ON delito FOR INSERT AS --DROP TRIGGER actualizarCantDelitosDeUnPerpetrador
DECLARE @id_mas_alto INT
DECLARE @runPerpetrador VARCHAR (20)
DECLARE @cantActualDeDelitosCometidos INT

SET @id_mas_alto=(SELECT MAX(id) FROM delito)
SET @cantActualDeDelitosCometidos=(SELECT perpetrador.cantidadDeDelitosCometidos FROM delito,perpetrador WHERE delito.fk_perpetrador=perpetrador.run AND delito.id=@id_mas_alto)
SET @runPerpetrador=(SELECT perpetrador.run FROM delito,perpetrador WHERE delito.fk_perpetrador=perpetrador.run AND delito.id=@id_mas_alto)

UPDATE perpetrador SET cantidadDeDelitosCometidos=(@cantActualDeDelitosCometidos+1) WHERE run=@runPerpetrador
GO


/*Trigger que actualiza la cantidad de sentencias dictadas por un juez cada vez que una condena se dicta*/
CREATE TRIGGER actualizarCantidadDeSentenciasDeJuez ON condena AFTER INSERT AS	--DROP TRIGGER actualizarCantidadDeSentenciasDeJuez
DECLARE @id_mas_alto INT
DECLARE @runJuez VARCHAR (20)
DECLARE @cantidadActualDeCondenas INT


SET @id_mas_alto=(SELECT MAX(id) FROM condena)
SET @cantidadActualDeCondenas=(SELECT juez.cantidadDeSentenciasDictadas FROM condena, juez WHERE condena.fk_juez=juez.run AND condena.id=@id_mas_alto)
SET @runJuez=(SELECT juez.run FROM condena, juez WHERE condena.fk_juez=juez.run AND condena.id=@id_mas_alto)

UPDATE juez SET cantidadDeSentenciasDictadas=(@cantidadActualDeCondenas+1) WHERE run=@runJuez
GO






USE MASTER
GO
ALTER DATABASE soporteAPDI
SET SINGLE_USER WITH ROLLBACK IMMEDIATE;
DROP DATABASE soporteAPDI
GO



























