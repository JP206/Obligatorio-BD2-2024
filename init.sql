use obligatorio;

GRANT ALL PRIVILEGES ON obligatorio.* TO 'user'@'%';
FLUSH PRIVILEGES;

create table Usuarios (
    id int primary key auto_increment,
    nombre varchar(50),
    apellido varchar(50),
    correo varchar(50),
    contrasenia varchar(50)
);

create table Administradores (
    id int primary key,
    foreign key (id) references Usuarios (id)
);

create table Alumnos (
    id int primary key,
    campeon varchar(20),
    subcampeon varchar(20),
    foreign key (id) references Usuarios (id)
);

create table Carreras (
    nombre varchar(30) primary key
);

create table Partidos (
    id int primary key auto_increment,
    equipo_1 varchar(30),
    equipo_2 varchar(30),
    goles_equipo_1 int,
    goles_equipo_2 int,
    etapa varchar(20),
    fecha datetime
);

create table Puntajes (
    tipo varchar(15),
    puntaje int,
    primary key (tipo)
);

create table Predicciones (
    id int primary key auto_increment,
    preddiccion_equipo_1 int,
    prediccion_equipo_2 int,
    id_partido int,
    id_alumno int,
    tipo_puntaje varchar(10),
    foreign key (id_partido) references Partidos(id),
    foreign key (id_alumno) references Alumnos(id),
    foreign key (tipo_puntaje) references Puntajes(tipo)
);

create table Cursa (
    nombre_carrera varchar(30),
    id_alumno int,
    primary key (nombre_carrera, id_alumno),
    foreign key (nombre_carrera) references Carreras (nombre),
    foreign key (id_alumno) references Alumnos (id)
);

insert into Carreras (Carreras.nombre) value ('Informatica'), ('Abogacia'), ('Medicina');

insert into Usuarios (nombre, apellido, correo, contrasenia) values ('juan', 'perez', 'juan@gmail.com', 'juan123');
insert into Usuarios (nombre, apellido, correo, contrasenia) values ('pedro', 'gonzalez', 'pedro@gmail.com', 'pedro123');
insert into Usuarios (nombre, apellido, correo, contrasenia) values ('gumercindo', 'gumercindez', 'gumercindo@gmail.com', 'gumercindo123');

insert into Alumnos (id, campeon, subcampeon) values (1, 'Uruguay', 'Brasil'), (2, 'Argentina', 'Mexico');

insert into Administradores (id) values (3);

insert into Cursa (nombre_carrera, id_alumno) values ('Abogacia', 1), ('Informatica', 2);

insert into Puntajes (tipo, puntaje) values ('Exacto', 4), ('Correcto', 2), ('Campeon', 10), ('Subcampeon', 5);

insert into Partidos (equipo_1, equipo_2, goles_equipo_1, goles_equipo_2, etapa, fecha) values
    ('Argentina', 'Canada', -1, -1, 'Fase de grupos', '2024/06/20 21:00:00'),
    ('Peru', 'Chile', -1, -1, 'Fase de grupos', '2024/06/21 21:00:00'),
    ('Ecuador', 'Venezuela', -1, -1, 'Fase de grupos', '2024/06/22 19:00:00'),
    ('Mexico', 'Jamaica', -1, -1, 'Fase de grupos', '2024/06/22'),
    ('Estados Unidos', 'Bolivia', -1, -1, 'Fase de grupos', '2024/06/23 19:00:00'),
    ('Uruguay', 'Panama', -1, -1, 'Fase de grupos', '2024/06/23 22:00:00'),
    ('Colombia', 'Paraguay', -1, -1, 'Fase de grupos', '2024/06/24 19:00:00'),
    ('Brasil', 'Costa Rica', -1, -1, 'Fase de grupos', '2024/06/24 22:00:00'),
    ('Peru', 'Canada', -1, -1, 'Fase de grupos', '2024/06/25 19:00:00'),
    ('Chile', 'Argentina', -1, -1, 'Fase de grupos', '2024/06/25 22:00:00'),
    ('Ecuador', 'Jamaica', -1 ,-1, 'Fase de grupos', '2024/06/26 19:00:00'),
    ('Venezuela', 'México', -1, -1, 'Fase de grupos', '2024/06/26 22:00:00'),
    ('Panama', 'Estados Unidos', -1, -1, 'Fase de grupos', '2024/06/27 19:00:00'),
    ('Uruguay', 'Bolivia', -1, -1, 'Fase de grupos', '2024/06/27 22:00:00'),
    ('Colombia', 'Costa Rica', -1, -1, 'Fase de grupos', '2024/06/28 19:00:00'),
    ('Paraguay', 'Brasil', -1, -1, 'Fase de grupos', '2024/06/28 22:00:00'),
    ('Argentina', 'Peru', -1, -1, 'Fase de grupos', '2024/06/29 21:00:00'),
    ('Canada', 'Chile', -1, -1, 'Fase de grupos', '2024/06/29 21:00:00'),
    ('Mexico', 'Ecuador', -1, -1, 'Fase de grupos', '2024/06/30 21:00:00'),
    ('Jamaica', 'Venezuela', -1, -1, 'Fase de grupos', '2024/06/30 21:00:00'),
    ('Bolivia', 'Panama', -1, -1, 'Fase de grupos', '2024/07/01 22:00:00'),
    ('Estados Unidos', 'Uruguay', -1, -1, 'Fase de grupos', '2024/07/01 22:00:00'),
    ('Brasil', 'Colombia', -1, -1, 'Fase de grupos', '2024/07/02 22:00:00'),
    ('Costa Rica', 'Paraguay', -1, -1, 'Fase de grupos', '2024/07/02 22:00:00');