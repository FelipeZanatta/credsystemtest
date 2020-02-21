DROP TABLE IF EXISTS customers;
 
CREATE TABLE customers (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  nome VARCHAR(250) NOT NULL,
  salario double NOT NULL,
  email VARCHAR(250) NOT NULL
);

DROP TABLE IF EXISTS cards;

CREATE TABLE cards (  
  cartao VARCHAR(30) PRIMARY KEY,
  numero INT(16) NOT NULL,
  limite_utilizado DOUBLE NOT NULL,
  senha VARCHAR(30) NOT NULL
);