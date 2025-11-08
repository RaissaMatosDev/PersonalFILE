package med.voll.API.controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import med.voll.API.alunos.Aluno;
import med.voll.API.alunos.AlunoRepository;
import med.voll.API.alunos.DadosCadastroAlunos;
import med.voll.API.alunos.Endereco;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/alunos")

public class AlunoController {

    @Autowired
    private AlunoRepository repository;


    @PostMapping
    @Transactional
    public void Cadastrar(@RequestBody @Valid DadosCadastroAlunos dados){
       repository.save(new Aluno(dados));
    }


}
