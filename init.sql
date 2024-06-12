USE obligatorio;

-- GRANT ALL PRIVILEGES ON obligatorio.* TO 'user'@'%';
-- FLUSH PRIVILEGES;

CREATE TABLE Usuarios (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(50),
    apellido VARCHAR(50),
    correo VARCHAR(50),
    contrasenia VARCHAR(50),
    borrado BOOL
);

CREATE TABLE Administradores (
    id INT PRIMARY KEY,
    FOREIGN KEY (id) REFERENCES Usuarios (id)
);

CREATE TABLE Alumnos (
    id INT PRIMARY KEY ,
    campeon VARCHAR(20),
    subcampeon VARCHAR(20),
    FOREIGN KEY (id) REFERENCES Usuarios (id)
);

CREATE TABLE Carreras (
    nombre VARCHAR(30) PRIMARY KEY
);

CREATE TABLE Cursa (
    nombre_carrera VARCHAR(30),
    id_alumno INT,
    borrado BOOL,
    PRIMARY KEY (nombre_carrera, id_alumno),
    FOREIGN KEY (nombre_carrera) REFERENCES Carreras (nombre),
    FOREIGN KEY (id_alumno) REFERENCES Alumnos (id)
);

CREATE TABLE Etapas (
    etapa VARCHAR(30) PRIMARY KEY
);

CREATE TABLE Paises (
    nombre VARCHAR(30) PRIMARY KEY ,
    bandera VARCHAR(100)
);

CREATE TABLE Estadios (
    nombre VARCHAR(50) PRIMARY KEY ,
    ciudad VARCHAR(50),
    imagen VARCHAR(100),
    capacidad INT
);

CREATE TABLE Partidos (
    id INT PRIMARY KEY AUTO_INCREMENT,
    equipo_1 VARCHAR(30),
    equipo_2 VARCHAR(30),
    goles_equipo_1 INT,
    goles_equipo_2 INT,
    etapa VARCHAR(30),
    fecha DATE,
    hora TIME,
    estadio VARCHAR(50),
    borrado BOOL,
    posicion_formulario int,
    FOREIGN KEY (equipo_1) REFERENCES Paises (nombre),
    FOREIGN KEY (equipo_2) REFERENCES Paises (nombre),
    FOREIGN KEY (etapa) REFERENCES Etapas (etapa),
    FOREIGN KEY (estadio) REFERENCES Estadios (nombre)
);

CREATE TABLE Puntajes (
    tipo VARCHAR(15) PRIMARY KEY ,
    puntaje INT
);

CREATE TABLE Predicciones (
    preddiccion_equipo_1 INT,
    prediccion_equipo_2 INT,
    id_partido INT,
    id_alumno INT,
    tipo_puntaje VARCHAR(15),
    PRIMARY KEY (id_partido, id_alumno),
    FOREIGN KEY (id_partido) REFERENCES Partidos(id),
    FOREIGN KEY (id_alumno) REFERENCES Alumnos(id),
    FOREIGN KEY (tipo_puntaje) REFERENCES Puntajes(tipo)
);

-- #############################################################################################
-- INSERCIONES EN TABLAS
-- #############################################################################################

INSERT INTO Usuarios (nombre, apellido, correo, contrasenia, borrado) VALUES
    ('juan', 'perez', 'juan@gmail.com', 'juan123', false),
    ('pedro', 'gonzalez', 'pedro@gmail.com', 'pedro123', false),
    ('gumercindo', 'gumercindez', 'gumercindo@gmail.com', 'gumercindo123', false);

INSERT INTO Administradores (id) VALUES (3);

INSERT INTO Alumnos (id, campeon, subcampeon) VALUES (1, 'Uruguay', 'Brasil'), (2, 'Argentina', 'Mexico');

INSERT INTO Carreras (Carreras.nombre) VALUES ('Informatica'), ('Abogacia'), ('Medicina');

INSERT INTO Cursa (nombre_carrera, id_alumno, borrado) VALUES ('Abogacia', 1, false), ('Informatica', 2, false);

INSERT INTO Etapas (etapa) VALUES ('Fase de grupos A'),
                                  ('Fase de grupos B'),
                                  ('Fase de grupos C'),
                                  ('Fase de grupos D'),
                                  ('Cuartos de final'),
                                  ('Semifinales'),
                                  ('3° puesto'),
                                  ('Final');

INSERT INTO Paises (nombre, bandera) VALUES
    ('Argentina', 'https://i.pinimg.com/736x/8c/4b/e0/8c4be0d18947b001c8516a5da134d121.jpg'),
    ('Peru', 'https://i.pinimg.com/736x/fe/5b/01/fe5b014b43af7aa1d291ff770a17fe2a.jpg'),
    ('Chile', 'https://i.pinimg.com/736x/d9/23/7f/d9237f96cc87a4a042ba0d8f4ffa9658.jpg'),
    ('Mexico', 'https://i.pinimg.com/736x/0e/d5/f1/0ed5f1fbe077ada1740e475f5b0ca0fe.jpg'),
    ('Ecuador', 'https://i.pinimg.com/736x/c5/56/9a/c5569a45809ea01c455e17cf6c5ef4a2.jpg'),
    ('Venezuela', 'https://i.pinimg.com/736x/10/49/0f/10490f2bdec79d28c184aa4bd4eb7209.jpg'),
    ('Jamaica', 'https://i.pinimg.com/736x/c9/d6/59/c9d6590e9ae8d5faaa4d0f25f0855822.jpg'),
    ('Estados Unidos', 'https://i.pinimg.com/736x/10/99/78/109978a82d0efa2aca34a6fb252969f9.jpg'),
    ('Uruguay', 'https://i.pinimg.com/736x/cd/dd/f7/cdddf7fe9be0f5b3cfb36d3fca167daf.jpg'),
    ('Panama', 'https://i.pinimg.com/736x/a6/76/69/a6766997d34137955969a7618df307d3.jpg'),
    ('Bolivia', 'https://i.pinimg.com/736x/70/f4/d9/70f4d9dd3e771ee36f103a9afea6c741.jpg'),
    ('Brasil', 'https://i.pinimg.com/736x/91/07/cd/9107cdbb5c7bf198ac74550ab8bbfe46.jpg'),
    ('Colombia', 'https://i.pinimg.com/736x/94/89/00/94890093ffe02179022cb0f6d423842b.jpg'),
    ('Paraguay', 'https://i.pinimg.com/736x/54/eb/ed/54ebed9b415e2d7c3d200d9157ebe6ac.jpg'),
    ('Canada', 'https://i.pinimg.com/736x/62/9f/08/629f08cc1d11182e1159a7cf874aca94.jpg'),
    ('Costa Rica', 'https://i.pinimg.com/736x/4a/66/aa/4a66aa187af2070bdc8871035cdd60f7.jpg');

INSERT INTO Estadios (nombre, ciudad, imagen, capacidad) VALUES
    ('Mercedes-Benz Stadium', 'Atlanta', 'https://i.pinimg.com/736x/1c/17/c3/1c17c3f190c33afe2fb03241a48b5103.jpg', 71000),
    ('Hard Rock Stadium', 'Miami Gardens', 'https://i.pinimg.com/736x/3b/67/86/3b6786fabbbfde33e2c81a9e6f9f5b6d.jpg', 65300),
    ('AT&T Stadium', 'Arlington', 'https://i.pinimg.com/736x/95/d8/c7/95d8c7ad35144b745fdf961e02c13f6e.jpg', 80000),
    ('GEHA Field at Arrowhead Stadium', 'Kansas City', 'https://i.pinimg.com/736x/c4/79/80/c47980ed367400e9ce71497d2ced6899.jpg', 76400),
    ('Q2 Stadium', 'Austin', 'https://i.pinimg.com/736x/e1/74/9a/e1749a1ccbd7271a10b409b513ca2b90.jpg', 20700),
    ('Bank of America Stadium', 'Charlotte', 'https://i.pinimg.com/736x/54/7d/44/547d441145fc33c2e61b7e4b4b5c1c24.jpg', 74500),
    ('MetLife Stadium', 'East Rutherford', 'https://i.pinimg.com/736x/67/55/50/675550759a4b9f3efd1e44c01d3a3468.jpg', 82500),
    ('State Farm Stadium', 'Glendale', 'https://i.pinimg.com/736x/59/90/17/599017961082e0ba05c2ab4734d4f458.jpg', 63400),
    ('NRG Stadium', 'Houston', 'https://i.pinimg.com/736x/f8/53/cc/f853cc3195c9584c7436683211369dce.jpg', 72220),
    ('SoFI Stadium', 'Inglewood', 'https://i.pinimg.com/736x/8f/9c/c5/8f9cc54beb537b767996b5f1b5dd845b.jpg', 70000),
    ('Children\'s Mercy Park', 'Kansas City', 'https://i.pinimg.com/736x/6e/2b/ea/6e2bea1d4653a8fa7e59b632c9339f34.jpg', 185000),
    ('Allegiant Stadium', 'Las Vegas', 'https://i.pinimg.com/736x/74/57/e4/7457e44a2d21d2df7415287c96be3e3a.jpg', 65000),
    ('Inter&Co Stadium', 'Orlando', 'https://i.pinimg.com/736x/a8/c8/c0/a8c8c0a90744062906007c7a84bf1fbf.jpg', 25500),
    ('Levi’s Stadium', 'Santa Clara', 'https://i.pinimg.com/736x/1f/b8/80/1fb880040f79fb3244a016477c5bd7ad.jpg', 68500);

INSERT INTO Partidos (equipo_1, equipo_2, goles_equipo_1, goles_equipo_2, etapa, fecha, hora, estadio, borrado, posicion_formulario) VALUES
     ('Argentina', 'Canada', -1, -1, 'Fase de grupos A', '2024/06/20', '21:00:00', 'Mercedes-Benz Stadium', false, -1),
     ('Peru', 'Chile', -1, -1, 'Fase de grupos A', '2024/06/21', '21:00:00', 'AT&T Stadium', false, -1),
     ('Ecuador', 'Venezuela', -1, -1, 'Fase de grupos B', '2024/06/22', '19:00:00', 'Levi’s Stadium', false, -1),
     ('Mexico', 'Jamaica', -1, -1, 'Fase de grupos B', '2024/06/22', '22:00:00', 'NRG Stadium', false, -1),
     ('Estados Unidos', 'Bolivia', -1, -1, 'Fase de grupos C', '2024/06/23', '19:00:00', 'AT&T Stadium', false, -1),
     ('Uruguay', 'Panama', -1, -1, 'Fase de grupos C', '2024/06/23', '22:00:00', 'Hard Rock Stadium', false, -1),
     ('Colombia', 'Paraguay', -1, -1, 'Fase de grupos D', '2024/06/24', '19:00:00', 'NRG Stadium', false, -1),
     ('Brasil', 'Costa Rica', -1, -1, 'Fase de grupos D', '2024/06/24', '22:00:00', 'SoFI Stadium', false, -1),
     ('Peru', 'Canada', -1, -1, 'Fase de grupos A', '2024/06/25', '19:00:00', 'Children\'s Mercy Park', false, -1),
     ('Chile', 'Argentina', -1, -1, 'Fase de grupos A', '2024/06/25', '22:00:00', 'MetLife Stadium', false, -1),
     ('Ecuador', 'Jamaica', -1 ,-1, 'Fase de grupos B', '2024/06/26', '19:00:00', 'Allegiant Stadium', false, -1),
     ('Venezuela', 'México', -1, -1, 'Fase de grupos B', '2024/06/26', '22:00:00', 'SoFI Stadium', false, -1),
     ('Panama', 'Estados Unidos', -1, -1, 'Fase de grupos C', '2024/06/27', '19:00:00', 'Mercedes-Benz Stadium', false, -1),
     ('Uruguay', 'Bolivia', -1, -1, 'Fase de grupos C', '2024/06/27', '22:00:00', 'MetLife Stadium', false, -1),
     ('Colombia', 'Costa Rica', -1, -1, 'Fase de grupos D', '2024/06/28', '19:00:00', 'State Farm Stadium', false, -1),
     ('Paraguay', 'Brasil', -1, -1, 'Fase de grupos D', '2024/06/28', '22:00:00', 'Allegiant Stadium', false, -1),
     ('Argentina', 'Peru', -1, -1, 'Fase de grupos A', '2024/06/29', '21:00:00', 'Hard Rock Stadium', false, -1),
     ('Canada', 'Chile', -1, -1, 'Fase de grupos A', '2024/06/29', '21:00:00', 'Inter&Co Stadium', false, -1),
     ('Mexico', 'Ecuador', -1, -1, 'Fase de grupos B', '2024/06/30', '21:00:00', 'State Farm Stadium', false, -1),
     ('Jamaica', 'Venezuela', -1, -1, 'Fase de grupos B', '2024/06/30', '21:00:00', 'Q2 Stadium', false, -1),
     ('Bolivia', 'Panama', -1, -1, 'Fase de grupos C', '2024/07/01', '22:00:00', 'Inter&Co Stadium', false, -1),
     ('Estados Unidos', 'Uruguay', -1, -1, 'Fase de grupos C', '2024/07/01', '22:00:00', 'GEHA Field at Arrowhead Stadium', false, -1),
     ('Brasil', 'Colombia', -1, -1, 'Fase de grupos D', '2024/07/02', '22:00:00', 'Levi’s Stadium', false, -1),
     ('Costa Rica', 'Paraguay', -1, -1, 'Fase de grupos D', '2024/07/02', '22:00:00', 'Q2 Stadium', false, -1);

INSERT INTO Puntajes (tipo, puntaje) VALUES ('Exacto', 4), ('Correcto', 2), ('Campeon', 10), ('Subcampeon', 5), ('No determinado', -1);

INSERT INTO Predicciones (preddiccion_equipo_1, prediccion_equipo_2, id_partido, id_alumno, tipo_puntaje) VALUES
    (0, 1, 1, 1, 'No determinado');