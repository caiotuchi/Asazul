package asazul.asazul.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import asazul.asazul.entity.Dependente;
import asazul.asazul.services.DependenteService;

@RestController
@RequestMapping("/dependentes")
public class DependenteController{
    private DependenteService dependenteService;

    @Autowired
    public DependenteController(DependenteService dependenteService){
        this.dependenteService = dependenteService;
    }

    @PostMapping
    @Transactional
    public void cadastrarDependente(@RequestBody Dependente dependente){
        dependenteService.cadastrarDependente(dependente);
    }

    @GetMapping("/{id}")
    public Dependente buscarDependente(@PathVariable Integer id){
        return dependenteService.buscarDependente(id);
    }

    @GetMapping
    public List<Dependente> listarDependentes(){
        return dependenteService.listarDependentes();
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void removerDependente(@PathVariable Integer id){
        dependenteService.removerDependente(id);
    }

    @PutMapping("/{id}")
    @Transactional
    public void editarDependente(@PathVariable Integer id,@RequestBody Dependente dependente){
        dependenteService.editarDependente(id, dependente);
    }



}