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

import asazul.asazul.entity.Empregado;
import asazul.asazul.services.EmpregadoService;

@RestController
@RequestMapping("/empregados")
public class EmpregadoController{
    private EmpregadoService empregadoService;

    @Autowired
    public EmpregadoController(EmpregadoService empregadoService){
        this.empregadoService = empregadoService;
    }

    @PostMapping
    @Transactional
    public void cadastrarEmpregado(@RequestBody Empregado empregado){
        empregadoService.cadastrarEmpregado(empregado);
    }

    @GetMapping("/{id}")
    public Empregado buscarEmpregado(@PathVariable Integer id){
        return empregadoService.buscarEmpregado(id);
    }

    @GetMapping
    public List<Empregado> listarEmpregados(){
        return empregadoService.listarEmpregados();
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void removerEmpregado(@PathVariable Integer id){
        empregadoService.removerEmpregado(id);
    }

    @PutMapping("/{id}")
    @Transactional
    public void editarEmpregado(@PathVariable Integer id,@RequestBody Empregado empregado){
        empregadoService.editarEmpregado(id, empregado);
    }

    

}