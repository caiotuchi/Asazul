package asazul.asazul.repository;

import org.springframework.data.mongodb.repository.MongoRepository;import org.springframework.stereotype.Repository;
import asazul.asazul.entity.Endereco;



@Repository
public interface EnderecoRepository extends MongoRepository<Endereco, Integer>{
}