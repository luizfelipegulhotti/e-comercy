

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
    FOREIGN KEY (cenaAtual) REFERENCES cenas(id_cenas),
    FOREIGN KEY (inventarioAtual) REFERENCES inventarioSave(id_inventory)
);

INSERT INTO cenas (nomeTitulo, descricaoCenas) 
VALUES ('ajude botas a chegar na casa da dora', 'botas após passar a noite explorando floresta, ao ver o nascer do sol boras percebe que não reconhece o local onde está.
olhar em volta:
ao observar bem percebe que esta em meio arvore imensas e quase não vê a copa delas, ele para checa sua mochila, ele separa os intens dela, agua (ok) MAPA (ok) FACA(afiada e ok) Revolver 38 (carregado e ok), apos isso ele penso no que sera mais util para voltar para casa de dora.');


SELECT * FROM cenas WHERE id_cenas = 1