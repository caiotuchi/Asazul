package asazul.asazul.services;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import asazul.asazul.entity.Endereco;
import asazul.asazul.repository.EnderecoRepository;

@Service
public class EnderecoService {
    private EnderecoRepository repository;

    @Autowired
    public EnderecoService(EnderecoRepository repository){
        this.repository = repository;
    }

    public Endereco cadastrarEndereco(Endereco endereco){
        return repository.save(endereco);
    }
    
    public Endereco buscarEndereco(Integer id){
        return repository.findById(id).get();
    }

    public List<Endereco> listarEnderecos(){
        return repository.findAll();
    }

    public Endereco editarEndereco(Integer id, Endereco endereco){
        Endereco enderecoParaAtualizar = repository.findById(id).get();
        if(endereco.getLogradouro() != null){
            enderecoParaAtualizar.setLogradouro(endereco.getLogradouro());
        }
        if(endereco.getNumero() != null){
            enderecoParaAtualizar.setNumero(endereco.getNumero());
        }
        if(endereco.getCep() != null){
            enderecoParaAtualizar.setCep(endereco.getCep());
        }
        if(endereco.getComplemento() != null){
            enderecoParaAtualizar.setComplemento(endereco.getComplemento());
        }

        return repository.save(enderecoParaAtualizar);
    }

    public void removerEndereco(Integer id){
        repository.findById(id);
        Optional<Endereco> optional = repository.findById(id);
        if(optional.isPresent()){
            repository.delete(optional.get());
        } else {
            throw new RuntimeException("O endereco não foi cadastrado");
        }
    }


}
