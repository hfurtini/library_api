package com.br.emakers.lib_api.service;

import com.br.emakers.lib_api.data.dto.response.ViaCepResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
@RequiredArgsConstructor
public class ViaCepService {

    public ViaCepResponseDTO getAddressByCep(String cep){
        String url = "https://viacep.com.br/ws/" + cep + "/json/";

        RestClient restClient = RestClient.create();

        return restClient.get()
                .uri(url)
                .retrieve()
                .body(ViaCepResponseDTO.class);
    }
}
