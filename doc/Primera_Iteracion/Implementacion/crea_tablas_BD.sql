/**
José Peso Buendía

Creación de Tablas de la BBDD
*/
CREATE TABLE Pacientes(
Dni VARCHAR2(9) NOT NULL,
Nombre VARCHAR2(200) NOT NULL,
Apellidos VARCHAR2(200) NOT NULL,
Contrasena VARCHAR2(20) NOT NULL,
Direccion VARCHAR2(200) NOT NULL,
CorreoElectronico VARCHAR2(200),
Telefono VARCHAR2(20),
FechaNacimiento DATE,
LugarNacimiento VARCHAR2(200),
Fotografia IMAGE,
PRIMARY KEY (Dni)
);

CREATE TABLE Citas(
DniPaciente VARCHAR2(9) NOT NULL,
DniMedico VARCHAR2(9) NOT NULL,
Fecha DATE, /*El tipo Date guarda también la hora*/
Hora DATE,
Estado BOOLEAN,
DniAdministrativoCita VARCHAR2(9) NOT NULL,
PRIMARY KEY (DniPaciente, DniMedico),
FOREIGN KEY (DniAdministrativoCita) REFERENCES Administrativos(DniAdministrativo)
);

CREATE TABLE Personal(
Dni VARCHAR2(9) NOT NULL,
Tipo VARCHAR2(20) NOT NULL,
IdTurno INT NOT NULL,
PRIMARY KEY (Dni)
);

CREATE TABLE Administrativos(
Dni VARCHAR2(9) NOT NULL,
Nombre VARCHAR2(200) NOT NULL,
Apellidos VARCHAR2(200) NOT NULL,
Contrasena VARCHAR2(20) NOT NULL,
Direccion VARCHAR2(200) NOT NULL,
CorreoElectronico VARCHAR2(200),
Telefono VARCHAR2(20),
FechaNacimiento DATE,
LugarNacimiento VARCHAR2(200),
Fotografia IMAGE,
Puesto VARCHAR2(200),
PRIMARY KEY (Dni)
);

CREATE TABLE Medicos(
Dni VARCHAR2(9) NOT NULL,
Nombre VARCHAR2(200) NOT NULL,
Apellidos VARCHAR2(200) NOT NULL,
Contrasena VARCHAR2(20) NOT NULL,
Direccion VARCHAR2(200) NOT NULL,
CorreoElectronico VARCHAR2(200),
Telefono VARCHAR2(20),
FechaNacimiento DATE,
LugarNacimiento VARCHAR2(200),
Fotografia IMAGE,
Puesto VARCHAR2(200),
PRIMARY KEY (Dni)
);

CREATE TABLE Analistas(
Dni VARCHAR2(9) NOT NULL,
Nombre VARCHAR2(200) NOT NULL,
Apellidos VARCHAR2(200) NOT NULL,
Contrasena VARCHAR2(20) NOT NULL,
Direccion VARCHAR2(200) NOT NULL,
CorreoElectronico VARCHAR2(200),
Telefono VARCHAR2(20),
FechaNacimiento DATE,
LugarNacimiento VARCHAR2(200),
Fotografia IMAGE,
Puesto VARCHAR2(200),
PRIMARY KEY (Dni)
);

CREATE TABLE Radiologos(
Dni VARCHAR2(9) NOT NULL,
Nombre VARCHAR2(200) NOT NULL,
Apellidos VARCHAR2(200) NOT NULL,
Contrasena VARCHAR2(20) NOT NULL,
Direccion VARCHAR2(200) NOT NULL,
CorreoElectronico VARCHAR2(200),
Telefono VARCHAR2(20),
FechaNacimiento DATE,
LugarNacimiento VARCHAR2(200),
Fotografia IMAGE,
Puesto VARCHAR2(200),
PRIMARY KEY (Dni)
);

CREATE TABLE Farmaceuticos(
Dni VARCHAR2(9) NOT NULL,
Nombre VARCHAR2(200) NOT NULL,
Apellidos VARCHAR2(200) NOT NULL,
Contrasena VARCHAR2(20) NOT NULL,
Direccion VARCHAR2(200) NOT NULL,
CorreoElectronico VARCHAR2(200),
Telefono VARCHAR2(20),
FechaNacimiento DATE,
LugarNacimiento VARCHAR2(200),
Fotografia IMAGE,
Puesto VARCHAR2(200),
PRIMARY KEY (Dni)
);

CREATE TABLE Turnos(
Dni VARCHAR2(9) NOT NULL,
Fecha DATE, /*El tipo Date guarda también la hora*/
Hora DATE,
PRIMARY KEY (Dni)
);

CREATE TABLE PersonalTrabajaEnTurno(
DniPersonal VARCHAR2(9) NOT NULL,
DniTurno VARCHAR2(9) NOT NULL,
PRIMARY KEY (DniPersonal, DniTurno)
);

CREATE TABLE AdministrativoAsignaTurno(
DniAdministrativo VARCHAR2(9) NOT NULL,
DniTurno VARCHAR2(9) NOT NULL,
PRIMARY KEY (DniAdministrativo, DniTurno)
);
