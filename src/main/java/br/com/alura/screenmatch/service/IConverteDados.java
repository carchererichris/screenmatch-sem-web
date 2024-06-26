package br.com.alura.screenmatch.service;

public interface IConverteDados {
    <T> T obterDados(String json, Class<T> classe); //Essa interface permite criar um método genérico para receber e converter
                                                    // as informações do Json
}
