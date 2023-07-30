package asazul.asazul.entity;

import org.springframework.data.mongodb.core.mapping.Document;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Document("dependente")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Dependente extends Pessoa{

    Integer parentesco;
    
}