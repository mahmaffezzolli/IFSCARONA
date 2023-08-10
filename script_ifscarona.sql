-- exclui o banco de dados
Drop database if exists bd_ifscarona;

-- cria o banco de dados
CREATE DATABASE if not EXISTS bd_ifscarona;


USE bd_ifscarona;


CREATE TABLE IF NOT EXISTS `pessoas` (
  `cpf` BIGINT(11) NOT NULL,
  `nome` VARCHAR(45) NOT NULL,
  `sobrenome` VARCHAR(45) NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  `data_nasc` DATETIME NOT NULL,
  `senha` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`cpf`));


CREATE TABLE IF NOT EXISTS `trajetos` (
  `id_trajeto` INT NOT NULL,
  `origem` VARCHAR(45) NOT NULL,
  `destino` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id_trajeto`));




CREATE TABLE IF NOT EXISTS `veiculos` (
  `id_veiculo` INT NOT NULL,
  `placa` VARCHAR(45) NOT NULL,
  `cor` VARCHAR(45) NOT NULL,
  `marca` VARCHAR(45) NOT NULL,
  `modelo` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id_veiculo`));


CREATE TABLE IF NOT EXISTS `caronas` (
  `id_carona` INT NULL,
  `cpf_motorista` BIGINT(11) NOT NULL,
  `id_trajeto` INT NOT NULL,
  `id_veiculo` INT NOT NULL,
  PRIMARY KEY (`id_carona`),
  CONSTRAINT `fk_Carona_Pessoa1`
    FOREIGN KEY (`cpf_motorista`)
    REFERENCES `mydb`.`pessoas` (`cpf`)
   ,
  CONSTRAINT `fk_Carona_Trajeto1`
    FOREIGN KEY (`id_trajeto`)
    REFERENCES `mydb`.`trajetos` (`id_trajeto`)
    ,
  CONSTRAINT `fk_Carona_Veiculo1`
    FOREIGN KEY (`id_veiculo`)
    REFERENCES `mydb`.`veiculos` (`id_veiculo`)
 );


CREATE TABLE IF NOT EXISTS `mydb`.`caronas_has_pessoas` (
  `caronas_id_carona` INT NOT NULL,
  `pessoas_cpf` BIGINT(11) NOT NULL,
  PRIMARY KEY (`caronas_id_carona`, `pessoas_cpf`),
  CONSTRAINT `fk_caronas_has_pessoas_caronas1`
    FOREIGN KEY (`caronas_id_carona`)
    REFERENCES `mydb`.`caronas` (`id_carona`)
,
  CONSTRAINT `fk_caronas_has_pessoas_pessoas1`
    FOREIGN KEY (`pessoas_cpf`)
    REFERENCES `mydb`.`pessoas` (`cpf`)
);

-- insert into pessoas

insert into pessoas (cpf, nome, sobrenome, email, data_nasc, senha) values (1003081967, 'Kelli', 'Walker', 'kloughlan0@state.gov', 15/8/2007, 'xH2%lR7a');
insert into pessoas (cpf, nome, sobrenome, email, data_nasc, senha) values (2671235844, 'Malvina', 'Luna', 'mluna0@toplist.cz', 23/09/1962, 'dM7`\Yo9');
insert into pessoas (cpf, nome, sobrenome, email, data_nasc, senha) values (5164124882, 'Carlin', 'Seakes', 'cseakes1@irs.gov', 25/08/1940, 'xY1,ib)Cs0');
insert into pessoas (cpf, nome, sobrenome, email, data_nasc, senha) values (0759956294, 'Cristabel', 'Crompton', 'ccrompton2@va.gov', 17/07/1976, 'tI7#J,n<jP0+SdE');
insert into pessoas (cpf, nome, sobrenome, email, data_nasc, senha) values (1134080441, 'Chrissy', 'Squeers', 'csqueers3@google.com.au', 24/12/1954, 'cJ4>4/Zm8afHxyB');
insert into pessoas (cpf, nome, sobrenome, email, data_nasc, senha) values (0733404561, 'Michelina', 'Chessil', 'mchessil4@globo.com', 11/06/1952, 'rT3|BvQ+Ve');

-- select

SELECT COUNT(*) FROM pessoas;
SELECT * FROM pessoas order by cpf;

-- update

UPDATE pessoas set nome = 'Ash', sobrenome = 'Mezadri', email = 'Ash2005@gmail.com', data_nasc = 10/06/05, senha 'jurema123' Where cpf = 1003081967;

-- delete

DELETE FROM pessoas WHERE cpf = 1003081967;