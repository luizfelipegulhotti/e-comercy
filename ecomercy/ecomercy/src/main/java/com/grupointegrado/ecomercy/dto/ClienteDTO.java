package com.grupointegrado.ecomercy.dto;

public record ClienteDTO(
        Integer id_cliente,
        String email,
        String nome,
        Integer idade,
        String local,
        String telefone,
        String numero_ct,
        String senha_ct,
        String validade_ct
) {}
