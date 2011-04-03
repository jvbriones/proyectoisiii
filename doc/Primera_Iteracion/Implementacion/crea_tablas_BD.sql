/**
José Peso Buendía

Creación de Tablas de la BBDD
*/
CREATE TABLE Usuarios(
Dni VARCHAR2(9) NOT NULL,
Nombre VARCHAR2(200) NOT NULL,
Apellidos VARCHAR2(200) NOT NULL,
Contrasena VARCHAR2(20) NOT NULL,
Direccion VARCHAR2(200) NOT NULL,
Email VARCHAR2(200),
Telefono VARCHAR2(20),
FechaNacimiento DATE,
LugarNacimiento VARCHAR2(200),
Fotografia VARCHAR2(200),
TipoUsuario VARCHAR2(20) NOT NULL,
PRIMARY KEY (Dni)
);

CREATE TABLE Pacientes(
Dni VARCHAR2(9) NOT NULL,
PRIMARY KEY (Dni),
FOREIGN KEY (Dni) REFERENCES Usuarios(Dni) ON DELETE CASCADE,
);

CREATE TABLE Citas(
DniPaciente VARCHAR2(9) NOT NULL,
DniMedico VARCHAR2(9) NOT NULL,
Fecha DATE,
Estado BOOLEAN,
DniAdministrativoCita VARCHAR2(9) NOT NULL,
PRIMARY KEY (DniPaciente, DniMedico),
FOREIGN KEY (DniPaciente) REFERENCES Pacientes(Dni),
FOREIGN KEY (DniMedico) REFERENCES Medicos(Dni),
FOREIGN KEY (DniAdministrativoCita) REFERENCES Administrativos(Dni)
);

CREATE TABLE Personal(
Dni VARCHAR2(9) NOT NULL,
TipoPersonal VARCHAR2(20) NOT NULL,
PRIMARY KEY (Dni),
FOREIGN KEY (Dni) REFERENCES Usuarios(Dni) ON DELETE CASCADE,
);

CREATE TABLE Administrativos(
Dni VARCHAR2(9) NOT NULL,
PRIMARY KEY (Dni),
FOREIGN KEY (Dni) REFERENCES Personal(Dni) ON DELETE CASCADE,
);

CREATE TABLE Medicos(
Dni VARCHAR2(9) NOT NULL,
PRIMARY KEY (Dni),
FOREIGN KEY (Dni) REFERENCES Personal(Dni) ON DELETE CASCADE,
);

CREATE TABLE Analistas(
Dni VARCHAR2(9) NOT NULL,
PRIMARY KEY (Dni),
FOREIGN KEY (Dni) REFERENCES Personal(Dni) ON DELETE CASCADE,
);

CREATE TABLE Radiologos(
Dni VARCHAR2(9) NOT NULL,
PRIMARY KEY (Dni),
FOREIGN KEY (Dni) REFERENCES Personal(Dni) ON DELETE CASCADE,
);

CREATE TABLE Farmaceuticos(
Dni VARCHAR2(9) NOT NULL,
PRIMARY KEY (Dni),
FOREIGN KEY (Dni) REFERENCES Personal(Dni) ON DELETE CASCADE,
);

CREATE TABLE Turnos(
/* Dni VARCHAR2(9) NOT NULL, */
Dni VARCHAR2(9) NOT NULL, /* Identificador de turno */
Tipo VARCHAR2(20) NOT NULL,
FechaInicio DATE,
FechaFin DATE,
PRIMARY KEY (Id)
);

CREATE TABLE PersonalTrabajaEnTurno(
DniPersonal VARCHAR2(9) NOT NULL,
/*DniTurno VARCHAR2(9) NOT NULL,*/
DniTurno VARCHAR2(9) NOT NULL, /* Identificador de turno */
PRIMARY KEY (DniPersonal, DniTurno),
FOREIGN KEY (DniPersonal) REFERENCES Personal(Dni),
FOREIGN KEY (DniTurno) REFERENCES Turnos(DniTurno)
);

CREATE TABLE AdministrativoAsignaTurno(
DniAdministrativo VARCHAR2(9) NOT NULL,
/*DniTurno VARCHAR2(9) NOT NULL,*/
DniTurno VARCHAR2(9) NOT NULL, /* Identificador de turno */
PRIMARY KEY (DniAdministrativo, DniTurno)
FOREIGN KEY (DniAdministrativo) REFERENCES Administrativos(Dni),
FOREIGN KEY (DniTurno) REFERENCES Turnos(DniTurno)
);
