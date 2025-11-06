package med.voll.API.alunos;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "alunos")
@Entity(name = "Aluno")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")

public class Aluno {


    @Id @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    @Column(name = "dataNascimento")
    private String dataNascimento;
    private String sexo;
    private String telefone;


    @Enumerated(EnumType.STRING)
    private Objetivo objetivo;

    @Embedded
    private Endereco endereco;

    public Aluno(DadosCadastroAlunos dados) {
        this.nome = dados.nome();
        this.dataNascimento = dados.dataNascimento();
        this.objetivo = dados.objetivo();
        this.sexo = dados.sexo();
        this.endereco = new Endereco(dados.endereco());
    }
}