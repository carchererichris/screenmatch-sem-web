package br.com.alura.screenmatch.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ConverteDados implements IConverteDados{ //Implementação da interface com o método criado
    private ObjectMapper mapper = new ObjectMapper(); //Objeto do Jackson que faz a conversão

    @Override
    public <T> T obterDados(String json, Class<T> classe) {
        try {
            return mapper.readValue(json,classe); //O mapper vai realizar a leitura do Json e tentar converter na classe passada
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
