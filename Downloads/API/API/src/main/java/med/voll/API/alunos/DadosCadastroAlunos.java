package med.voll.API.alunos;
import med.voll.API.endereco.DadosEndereco;


public record DadosCadastroAlunos(
        String nome, String dataNascimento, String sexo, float altura, float peso,
        Objetivo objetivo, String restricoes,String lesoes, int frequenciaSemanal,
        String diasTreino, String tipoTreino, String exercicio,DadosEndereco endereco) {
}
