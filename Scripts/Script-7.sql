

CREATE TABLE `compra` (
  `id_compra` int(11) NOT NULL AUTO_INCREMENT,
  `id_cliente` int(11) DEFAULT NULL,
  `preco` int(11) DEFAULT NULL,
  `nome_do_produto` varchar(50) DEFAULT NULL,
  `quantidade` int(11) DEFAULT NULL,
  `frete` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id_compra`),
  KEY `id_cliente` (`id_cliente`),
  CONSTRAINT `compra_ibfk_1` FOREIGN KEY (`id_cliente`) REFERENCES `cliente` (`id_cliente`)
);


CREATE TABLE `pagamento` (
  `id_pagamento` int(11) NOT NULL AUTO_INCREMENT,
  `id_cliente` int(11) DEFAULT NULL,
  `id_compra` int(11) DEFAULT NULL,
  `pix` varchar(50) DEFAULT NULL,
  `conta_de_banco` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id_pagamento`),
  KEY `id_cliente` (`id_cliente`),
  KEY `id_compra` (`id_compra`),
  CONSTRAINT `pagamento_ibfk_1` FOREIGN KEY (`id_cliente`) REFERENCES `cliente` (`id_cliente`),
  CONSTRAINT `pagamento_ibfk_2` FOREIGN KEY (`id_compra`) REFERENCES `compra` (`id_compra`)
);

CREATE TABLE `cliente` (
  `id_cliente` int(11) NOT NULL AUTO_INCREMENT,
  `email` varchar(50) DEFAULT NULL,
  `nome` varchar(50) DEFAULT NULL,
  `idade` int(11) DEFAULT NULL,
  `local` varchar(50) DEFAULT NULL,
  telefone int (20) DEFAULT NULL,
  numero_ct int(20) DEFAULT null,
  senha_ct int(20) DEFAULT null,
  validade_ct int(20) DEFAULT null,
  PRIMARY KEY (`id_cliente`)
);

CREATE TABLE `carrinho` (
  `id_carrinho` int(11) NOT NULL AUTO_INCREMENT,
  `id_cliente` int(11) DEFAULT NULL,
  `id_produto` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_carrinho`),
  KEY `id_cliente` (`id_cliente`),
  KEY `id_produto` (`id_produto`),
  CONSTRAINT `carrinho_ibfk_1` FOREIGN KEY (`id_cliente`) REFERENCES `cliente` (`id_cliente`),
  CONSTRAINT `carrinho_ibfk_2` FOREIGN KEY (`id_produto`) REFERENCES `produto` (`id_produto`)
);

CREATE TABLE `produto` (
  `id_produto` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(50) DEFAULT NULL,
  `preco` int(11) DEFAULT NULL,
  `quantidade` int(11) DEFAULT NULL,
  `descricao` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id_produto`)
);

CREATE TABLE `favorito` (
  `id_favorito` int(11) NOT NULL AUTO_INCREMENT,
  `id_cliente` int(11) DEFAULT NULL,
  `id_produto` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_favorito`),
  KEY `id_cliente` (`id_cliente`),
  KEY `id_produto` (`id_produto`),
  CONSTRAINT `favorito_ibfk_1` FOREIGN KEY (`id_cliente`) REFERENCES `cliente` (`id_cliente`),
  CONSTRAINT `favorito_ibfk_2` FOREIGN KEY (`id_produto`) REFERENCES `produto` (`id_produto`)
);