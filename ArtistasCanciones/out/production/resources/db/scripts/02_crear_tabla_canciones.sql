create table canciones (
    codcancion varchar(10) PRIMARY KEY,
    titulo varchar(10) NOT NULL,
    favorito bit DEFAULT 0,
    codartista varchar(10)
);