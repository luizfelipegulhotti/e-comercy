package com.grupointegrado.ecomercy.dto;

public record CompraDTO(
        Integer id_compra,
        Integer id_cliente,
        Integer preco,
        String nome_do_produto,
        Integer quantidade,
        String frete
) {}
