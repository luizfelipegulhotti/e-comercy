package com.grupointegrado.ecomercy.dto;

public record PagamentoDTO(
        Integer id_pagamento,
        Integer id_cliente,
        Integer id_compra,
        String pix,
        String conta_de_banco
) {}
