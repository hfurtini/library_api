package com.br.emakers.lib_api.data.dto.response;

public record ViaCepResponseDTO(
        String cep,
        String logradouro,
        String bairro,
        String localidade,
        String uf
) {
}
