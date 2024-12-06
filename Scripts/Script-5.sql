create database facul




CREATE TABLE cenas (
    id_cenas INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    nomeTitulo VARCHAR(50),
    descricaoCenas LONGTEXT
);

CREATE TABLE itens (
    id_itens INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(50),
    descricaoItens LONGTEXT,
    descricao_Positiva VARCHAR(255),
    descricao_Negativa VARCHAR(255),
    comando_correto VARCHAR(255),
    cena_Atual INT,
    proxima_Cena INT,
    FOREIGN KEY (cena_Atual) REFERENCES cenas(id_cenas)
);

CREATE TABLE inventarioSave (
    id_inventory INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    id_itens INT,
    FOREIGN KEY (id_itens) REFERENCES itens(id_itens)
);

CREATE TABLE save (
    id_save INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    cenaAtual INT,
    inventarioAtual INT,
    FOREIGN KEY (cenaAtual) REFERENCES itens(id_itens),
    FOREIGN KEY (inventarioAtual) REFERENCES inventarioSave(id_inventory)
);


insert into itens (nome,descricaoItens,descricao_Positiva,descricao_Negativa,comando_correto,cena_Atual,proxima_Cena)
VALUES('VOAR','a o usar VOAR botas tentará voar','Pegou o item ou selecionou ações','Botas morre ao tentar voar','USE VOAR',1,7),
('SEGUIR','Botas segue em frente sem pensar em nada','Pegou item ou selecionou ações','Botas cai e morre','USE SEGUIR',1,7),
('TABUA','Botas usa TABUA no buraco','Pegou o item ou selecionou ações','não tem','USE TABUA NO BURACO',1,2),
('MÃOS','Botas tenta lutar com as mãos nuas','Pegou o item ou selecionou ações','Morreu ao lutar com as mãos nuas','USE MÃOS',2,7),
('MINIGUN','Botas usa a minigun','Pegou o item ou selecionou ações','não tem','USE MINIGUN',2,3),
('BAZUCA','Botas usa bazuca no raposo','Pegou o item ou selecionou ações','não tem','USE BAZUCA',2,3),
('ESQUERDA','Botas vai pela esquerda','Pegou o item ou selecionou ações','não tem','USE ESQUERDA',3,4),
('DIREITA','Botas vai pela direita','Pegou o item ou selecionou ações','morreu espetado','USE DIREITA',3,7),
('SEGUIR','Botas não está com vontade de tomar café e segui seu caminho','Pegou o item ou selecionou ações','não tem','USE SEGUIR',4,5),
('CAFÉ','Botas bebe o café','Pegou o item ou selecionou ações','morreu envenenado','USE CAFÉ',4,7),
('ESCADA','Botas usa a escada e resgata a Dora','Pegou item ou selecionou ações','não tem','USE ESCADA',5,6),
('PULAR','Botas fala para Dora pular','Pegou item ou selecionou ações','Você matou a Dora','USE PULAR',5,7)


select * from itens i 

INSERT INTO cenas (nomeTitulo, descricaoCenas) 
values ("Botas tem que voltar para a Dora","Botas está na selva e para chegar a dora ele tem que passar pelo caminho na qual tem um buraco: ele tem as seguintes opções, tentar 'VOAR', 'SEGUIR', pegar 'TABUA' e usar no 'BURACO'."),
("cena2","Botas segue seu caminho e encontra o raposo, que quer matá-lo, para se defender você tem as seguintes opções: usar 'MÃOS','MINIGUN','BAZUCA'."),
("cena3","Botas mata o raposo, e segue seu caminho. seguindo seu caminho Botas sua estrada se divide em dois, ele tem duas opções: caminho da 'ESQUERDA' caminho tranquilo, e o caminho da 'DIREITA' tem espinhos."),
("cena4","Botas segue seu caminho e encontra uma mesa no meio do caminho com cafézinho, você tem duas opções: beber 'CAFÉ', ou 'SEGUIR'."),
("cena5","Botas segue seu caminho e falta pouco, a Dora está logo a frente, mas ela está presa em cima da arvore, você tem duas opções para ajudar a Dora: pegar a 'ESCADA' e usar na arvore, ou falar para ela confiar nele e 'PULAR' que ele pega ela"),
("cena6","Botas consegue chegar a Dora e vivem felizes e para sempre."),
("cena_fail","GAME OVER")

select * from cenas c 

DESCRIBE itens