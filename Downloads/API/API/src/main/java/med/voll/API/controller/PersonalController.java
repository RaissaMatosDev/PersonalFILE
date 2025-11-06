package med.voll.API.controller;

import jakarta.servlet.ServletOutputStream;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/personal")
public class PersonalController {

    @PostMapping
    public void cadastrar(@RequestBody DadosCadastroPersonal dados){
        System.out.println("Seu cadastro como Personal foi concluido com sucesso!");
        System.out.println(dados);
    }
}
