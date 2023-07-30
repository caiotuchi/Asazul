package asazul.asazul.services;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import asazul.asazul.entity.Empregado;
import asazul.asazul.repository.EmpregadoRepository;

@Service
public class EmpregadoService {
    private EmpregadoRepository repository;

    @Autowired
    public EmpregadoService(EmpregadoRepository repository){
        this.repository = repository;
    }

    public Empregado cadastrarEmpregado(Empregado empregado){
        return repository.save(empregado);
    }
    
    public Empregado buscarEmpregado(Integer id){
        return repository.findById(id).get();
    }

    public List<Empregado> listarEmpregados(){
        return repository.findAll();
    }

    public Empregado editarEmpregado(Integer id, Empregado empregado){
        Empregado empregadoParaAtualizar = repository.findById(id).get();
        if(empregado.getNome() != null){
            empregadoParaAtualizar.setNome(empregado.getNome());
        }
        if(empregado.getDataNascimento() != null){
            empregadoParaAtualizar.setDataNascimento(empregado.getDataNascimento());
        }
        if(empregado.getSalario() != null){
            empregadoParaAtualizar.setSalario(empregado.getSalario());
        }
        if(empregado.getDataAdmissao() != null){
            empregadoParaAtualizar.setDataAdmissao(empregado.getDataAdmissao());
        }

        return repository.save(empregadoParaAtualizar);
    }

    public void removerEmpregado(Integer id){
        repository.findById(id);
        Optional<Empregado> optional = repository.findById(id);
        if(optional.isPresent()){
            repository.delete(optional.get());
        } else {
            throw new RuntimeException("O empregado não foi cadastrado");
        }
    }


}
