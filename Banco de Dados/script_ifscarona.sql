-- exclui o banco de dados
Drop database if exists bd_ifscarona;

-- cria o banco de dados
CREATE DATABASE if not EXISTS bd_ifscarona;

USE bd_ifscarona;

CREATE TABLE IF NOT EXISTS `trajetos` (
  `id_trajeto` INT NOT NULL AUTO_INCREMENT,
  `origem` VARCHAR(45) NOT NULL,
  `destino` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id_trajeto`)
);

CREATE TABLE IF NOT EXISTS `veiculos` (
  `id_veiculo` INT NOT NULL AUTO_INCREMENT,
  `placa` VARCHAR(45) NOT NULL,
  `cor` VARCHAR(45) NOT NULL,
  `marca` VARCHAR(45) NOT NULL,
  `modelo` VARCHAR(45) NOT NULL,
  `cpf_pessoa` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id_veiculo`)
);

CREATE TABLE IF NOT EXISTS `pessoas` (
  `cpf` VARCHAR(45) NOT NULL,
  `nome` VARCHAR(45) NOT NULL,
  `sobrenome` VARCHAR(45) NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  `data_nasc` DATE NOT NULL,
  `senha` VARCHAR(45) NOT NULL,
  `id_veiculo` INT,
  PRIMARY KEY (`cpf`),
  CONSTRAINT `fk_Pessoa_Veiculo1`
    FOREIGN KEY (`id_veiculo`)
    REFERENCES `veiculos`(`id_veiculo`)
);

CREATE TABLE IF NOT EXISTS `caronas` (
  `id_carona` INT NOT NULL AUTO_INCREMENT,
  `cpf_motorista` VARCHAR(45) NOT NULL,
  `cpf_passageiro` VARCHAR(45),
  `id_trajeto` INT NOT NULL,
  `id_veiculo` INT NOT NULL,
  `qnt_passageiros` INT NOT NULL,
  `horario` TIME NOT NULL,
  `data` DATE NOT NULL,
  PRIMARY KEY (`id_carona`),
  CONSTRAINT `fk_Carona_Pessoa1`
    FOREIGN KEY (`cpf_motorista`)
    REFERENCES `pessoas` (`cpf`),
  CONSTRAINT `fk_Carona_Trajeto1`
    FOREIGN KEY (`id_trajeto`)
    REFERENCES `trajetos` (`id_trajeto`),
  CONSTRAINT `fk_Carona_Veiculo1`
    FOREIGN KEY (`id_veiculo`)
    REFERENCES `veiculos` (`id_veiculo`)
 );

CREATE TABLE IF NOT EXISTS `caronas_has_pessoas` (
  `caronas_id_carona` INT NOT NULL AUTO_INCREMENT,
  `pessoas_cpf` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`caronas_id_carona`, `pessoas_cpf`),
  CONSTRAINT `fk_caronas_has_pessoas_caronas1`
    FOREIGN KEY (`caronas_id_carona`)
    REFERENCES `caronas` (`id_carona`),
  CONSTRAINT `fk_caronas_has_pessoas_pessoas1`
    FOREIGN KEY (`pessoas_cpf`)
    REFERENCES `pessoas` (`cpf`)
);

-- insert into pessoas

insert into pessoas (cpf, nome, sobrenome, email, data_nasc, senha) values ('10030181967', 'Kelli', 'Walker', 'kloughlan0@state.gov', '1975-05-15', 'xH2%lR7a');
insert into pessoas (cpf, nome, sobrenome, email, data_nasc, senha) values ('26712351844', 'Malvina', 'Luna', 'mluna0@toplist.cz', '1975-05-15', 'dM7`\Yo9');
insert into pessoas (cpf, nome, sobrenome, email, data_nasc, senha) values ('51614124882', 'Carlin', 'Seakes', 'cseakes1@irs.gov', '1975-05-15', 'xY1,ib)Cs0');
insert into pessoas (cpf, nome, sobrenome, email, data_nasc, senha) values ('07599156294', 'Cristabel', 'Crompton', 'ccrompton2@va.gov', '1975-05-15', 'tI7#J,n<jP0+SdE');
insert into pessoas (cpf, nome, sobrenome, email, data_nasc, senha) values ('11340801441', 'Chrissy', 'Squeers', 'csqueers3@google.com.au', '1975-05-15', 'cJ4>4/Zm8afHxyB');
insert into pessoas (cpf, nome, sobrenome, email, data_nasc, senha) values ('07334041561', 'Michelina', 'Chessil', 'mchessil4@globo.com', '1975-05-15', 'rT3|BvQ+Ve');
insert into pessoas (cpf, nome, sobrenome, email, data_nasc, senha) values ('11111111111', 'IFSC', 'Arona', 'abc@gmail.com', '2023-03-01', '123');

SELECT COUNT(*) FROM pessoas;
SELECT * FROM pessoas order by cpf;
SELECT * FROM veiculos;
SELECT * FROM trajetos;
SELECT * FROM caronas;


-- update

UPDATE pessoas set nome = 'Ash', sobrenome = 'Mezadri', email = 'Ash2005@gmail.com', data_nasc = '2005-06-10', senha = 'jurema123' Where cpf = '10030181967';

-- delete

DELETE FROM pessoas WHERE cpf = '10030181967';

desc pessoas;