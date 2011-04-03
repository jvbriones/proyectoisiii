/**
José Peso Buendía

Creación de Tablas de la BBDD
*/
CREATE TABLE `Usuarios`(
`Dni` VARCHAR(9) NOT NULL,
`Nombre` VARCHAR(200) NOT NULL,
`Apellidos` VARCHAR(200) NOT NULL,
`Contrasena` VARCHAR(20) NOT NULL,
`Direccion` VARCHAR(200) NOT NULL,
`Email` VARCHAR(200),
`Telefono` VARCHAR(20),
`FechaNacimiento` DATE,
`LugarNacimiento` VARCHAR(200),
`Fotografia` VARCHAR(200),
`TipoUsuario` VARCHAR(20) NOT NULL,
PRIMARY KEY (`Dni`)
);

CREATE TABLE `Pacientes`(
`Dni` VARCHAR(9) NOT NULL,
PRIMARY KEY (`Dni`),
FOREIGN KEY (`Dni`) REFERENCES `Usuarios`(`Dni`) ON DELETE CASCADE
);

CREATE TABLE `Personal`(
`Dni` VARCHAR(9) NOT NULL,
`TipoPersonal` VARCHAR(20) NOT NULL,
PRIMARY KEY (`Dni`),
FOREIGN KEY (`Dni`) REFERENCES `Usuarios`(`Dni`) ON DELETE CASCADE,
);

CREATE TABLE `Administrativos`(
`Dni` VARCHAR(9) NOT NULL,
PRIMARY KEY (`Dni`),
FOREIGN KEY (`Dni`) REFERENCES `Personal`(`Dni`) ON DELETE CASCADE,
);

CREATE TABLE `Medicos`(
`Dni` VARCHAR(9) NOT NULL,
PRIMARY KEY (`Dni`),
FOREIGN KEY (`Dni`) REFERENCES `Personal`(`Dni`) ON DELETE CASCADE,
);

CREATE TABLE `Analistas`(
`Dni` VARCHAR(9) NOT NULL,
PRIMARY KEY (`Dni`),
FOREIGN KEY (`Dni`) REFERENCES `Personal`(`Dni`) ON DELETE CASCADE,
);

CREATE TABLE `Radiologos`(
`Dni` VARCHAR(9) NOT NULL,
PRIMARY KEY (`Dni`),
FOREIGN KEY (`Dni`) REFERENCES `Personal`(`Dni`) ON DELETE CASCADE,
);

CREATE TABLE `Farmaceuticos`(
`Dni` VARCHAR(9) NOT NULL,
PRIMARY KEY (`Dni`),
FOREIGN KEY (`Dni`) REFERENCES `Personal`(`Dni`) ON DELETE CASCADE,
);

CREATE TABLE `Turnos`(
`Dni` VARCHAR(9) NOT NULL,
`Tipo` VARCHAR(20) NOT NULL,
`FechaInicio` DATE,
`FechaFin` DATE,
PRIMARY KEY (`Dni`)
);

CREATE TABLE `Citas`(
`DniPaciente` VARCHAR(9) NOT NULL,
`DniMedico` VARCHAR(9) NOT NULL,
`Fecha` DATE,
`Estado` BOOLEAN,
`DniAdministrativoCita` VARCHAR(9) NOT NULL,
PRIMARY KEY (`DniPaciente`, `DniMedico`),
FOREIGN KEY (`DniPaciente`) REFERENCES `Pacientes`(`Dni`),
FOREIGN KEY (`DniMedico`) REFERENCES `Medicos`(`Dni`),
FOREIGN KEY (`DniAdministrativoCita`) REFERENCES `Administrativos`(`Dni`)
);

CREATE TABLE `PersonalTrabajaEnTurno`(
`DniPersonal` VARCHAR(9) NOT NULL,
`DniTurno` VARCHAR(9) NOT NULL,
PRIMARY KEY (`DniPersonal`, `DniTurno`),
FOREIGN KEY (`DniPersonal`) REFERENCES `Personal`(`Dni`),
FOREIGN KEY (`DniTurno`) REFERENCES `Turnos`(`Dni`)
);

CREATE TABLE `AdministrativoAsignaTurno`(
`DniAdministrativo` VARCHAR(9) NOT NULL,
`DniTurno` VARCHAR(9) NOT NULL,
PRIMARY KEY (`DniAdministrativo`, `DniTurno`)
FOREIGN KEY (`DniAdministrativo`) REFERENCES `Administrativos`(`Dni`),
FOREIGN KEY (`DniTurno`) REFERENCES `Turnos`(`Dni`)
);
