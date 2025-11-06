package med.voll.API.controller;

import med.voll.API.endereco.DadosEndereco;

public record DadosCadastroPersonal (
        String nome,
        String telefone,
        String cpf,
        String cref,
        DadosEndereco endereco
){

}
