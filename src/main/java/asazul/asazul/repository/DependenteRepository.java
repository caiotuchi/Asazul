package asazul.asazul.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import asazul.asazul.entity.Dependente;



@Repository
public interface DependenteRepository extends MongoRepository<Dependente, Integer>{
}