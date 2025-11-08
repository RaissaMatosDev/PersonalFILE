package med.voll.API.alunos;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import med.voll.API.endereco.DadosEndereco;
import org.springframework.format.annotation.NumberFormat;


public record DadosCadastroAlunos(

        @NotBlank
        String nome,

        @NotBlank
        String dataNascimento,

        @NotBlank
        String sexo,

        @NotNull
        Float altura,

        @NotNull
        Float peso,

        @NotNull
        Objetivo objetivo,

        @NotBlank
        String restricoes,

        String lesoes,

        @NotNull
        Integer frequenciaSemanal,

        String diasTreino,

        String tipoTreino,

        String exercicio,

        @Pattern(regexp = "\\(\\d{2}\\) \\d{4,5}-\\d{4}", message = "Telefone inválido")
        String telefone,

        @NotNull @Valid
        DadosEndereco endereco
) {

    public String telefoneFormatado() {
        String numero = telefone.replaceAll("\\D", "");
        if (numero.length() == 11)
            return String.format("(%s) %s-%s", numero.substring(0, 2), numero.substring(2, 7), numero.substring(7));
        if (numero.length() == 10)
            return String.format("(%s) %s-%s", numero.substring(0, 2), numero.substring(2, 6), numero.substring(6));
        return telefone;
    }
}
