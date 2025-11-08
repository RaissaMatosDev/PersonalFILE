package med.voll.API.endereco;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosEndereco(
        @NotBlank
        String rua,

        @NotBlank
        String bairro,

        @NotBlank
        String cidade,

        @NotBlank
        String estado) {
}
