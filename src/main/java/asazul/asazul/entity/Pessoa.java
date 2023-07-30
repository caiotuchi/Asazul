package asazul.asazul.entity;

import org.springframework.data.annotation.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public abstract class Pessoa{
    
    @Id
    int id;
    String nome;
    String dataNascimento;
    Endereco endereco;
}