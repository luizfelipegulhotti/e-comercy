package com.grupointegrado.ecomercy.dto;

public record ProdutoDTO(
        Integer id_produto,
        String nome,
        Integer preco,
        Integer quantidade,
        String descricao
) {}
