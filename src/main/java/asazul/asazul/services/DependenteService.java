package asazul.asazul.services;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import asazul.asazul.entity.Dependente;
import asazul.asazul.repository.DependenteRepository;

@Service
public class DependenteService {
    private DependenteRepository repository;

    @Autowired
    public DependenteService(DependenteRepository repository){
        this.repository = repository;
    }

    public Dependente cadastrarDependente(Dependente dependente){
        return repository.save(dependente);
    }
    
    public Dependente buscarDependente(Integer id){
        return repository.findById(id).get();
    }

    public List<Dependente> listarDependentes(){
        return repository.findAll();
    }

    public Dependente editarDependente(Integer id, Dependente dependente){
        Dependente dependenteParaAtualizar = repository.findById(id).get();
        if(dependente.getNome() != null){
            dependenteParaAtualizar.setNome(dependente.getNome());
        }
        if(dependente.getDataNascimento() != null){
            dependenteParaAtualizar.setDataNascimento(dependente.getDataNascimento());
        }
        if(dependente.getParentesco() != null){
            dependenteParaAtualizar.setParentesco(dependente.getParentesco());
        }

        return repository.save(dependenteParaAtualizar);
    }

    public void removerDependente(Integer id){
        repository.findById(id);
        Optional<Dependente> optional = repository.findById(id);
        if(optional.isPresent()){
            repository.delete(optional.get());
        } else {
            throw new RuntimeException("O dependente não foi cadastrado");
        }
    }


}
