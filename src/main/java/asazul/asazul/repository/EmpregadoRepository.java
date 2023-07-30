package asazul.asazul.repository;

import org.springframework.data.mongodb.repository.MongoRepository;import org.springframework.stereotype.Repository;

import asazul.asazul.entity.Empregado;



@Repository
public interface EmpregadoRepository extends MongoRepository<Empregado, Integer>{
}