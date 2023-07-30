package asazul.asazul.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Document("endereco")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Endereco{

    @Id
    int id;
    String logradouro;
    Integer numero;
    Integer cep;
    Integer complemento;

}