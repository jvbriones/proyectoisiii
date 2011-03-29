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
FOREIGN KEY (DniPaciente) REFERENCES Paciente(Dni),
FOREIGN KEY (DniMedico) REFERENCES Medicos(Dni),
FOREIGN KEY (DniAdministrativoCita) REFERENCES Administrativos(Dni),
);

/* Esta tabla sobraría, si nos ceñimos al modelo ER */
CREATE TABLE Personal(
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
/* Tipo VARCHAR2(20) NOT NULL, */
/* El campo tipo sobra en el diagrama de clases de diseño, y aqui... hay que ver primero como haremos el modelo ER */
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
/* Dni VARCHAR2(9) NOT NULL, */
Id INT NOT NULL, /* Identificador de turno */
Fecha DATE, /*El tipo Date guarda también la hora*/
Hora DATE,
PRIMARY KEY (Id)
);

CREATE TABLE PersonalTrabajaEnTurno(
DniPersonal VARCHAR2(9) NOT NULL,
/*DniTurno VARCHAR2(9) NOT NULL,*/
IdTurno INT NOT NULL, /* Identificador de turno */
PRIMARY KEY (DniPersonal, IdTurno),
FOREIGN KEY (DniPersonal) REFERENCES Personal(Dni),
FOREIGN KEY (IdTurno) REFERENCES Turnos(IdTurno)
);

CREATE TABLE AdministrativoAsignaTurno(
DniAdministrativo VARCHAR2(9) NOT NULL,
/*DniTurno VARCHAR2(9) NOT NULL,*/
IdTurno INT NOT NULL, /* Identificador de turno */
PRIMARY KEY (DniAdministrativo, IdTurno)
FOREIGN KEY (DniAdministrativo) REFERENCES Administrativos(Dni),
FOREIGN KEY (IdTurno) REFERENCES Turnos(IdTurno)
);
