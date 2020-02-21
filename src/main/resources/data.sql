DROP TABLE IF EXISTS cards;

DROP TABLE IF EXISTS customers;
 
CREATE TABLE customers (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  nome VARCHAR(250) NOT NULL,
  salario DOUBLE NOT NULL,
  email VARCHAR(250) NOT NULL
);

CREATE TABLE cards (  
  cartao VARCHAR(30) PRIMARY KEY,
  limite DOUBLE NOT NULL,
  limite_utilizado DOUBLE NOT NULL,
  customer_id INT,
  senha VARCHAR(30) NOT NULL);
