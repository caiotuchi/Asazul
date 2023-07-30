package asazul.asazul.entity;

import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Document("empregados")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Empregado extends Pessoa{

    Double salario;
    Integer dataAdmissao;
    List<Dependente> dependentes;

}