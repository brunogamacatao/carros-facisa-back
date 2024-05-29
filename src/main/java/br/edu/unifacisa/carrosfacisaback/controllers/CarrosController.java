package br.edu.unifacisa.carrosfacisaback.controllers;

import br.edu.unifacisa.carrosfacisaback.entities.Carro;
import br.edu.unifacisa.carrosfacisaback.repositories.CarroRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@CrossOrigin
@RestController
@RequestMapping("/carros")
public class CarrosController {
    private CarroRepository repository;

    public CarrosController(CarroRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Carro> getTodos() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Carro> getPorId(@PathVariable String id) {
        try {
            return new ResponseEntity<>(repository.findById(id).get(), HttpStatus.OK);
        } catch (NoSuchElementException ex) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public Carro adicionar(@RequestBody Carro carro) {
        return repository.save(carro);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Carro> alterar(@RequestBody Carro dados, String id) {
        try {
            Carro carro = repository.findById(id).get();
            carro.setNome(dados.getNome());
            carro.setAno(dados.getAno());
            carro.setPreco(dados.getPreco());
            carro.setMontadora(dados.getMontadora());
            carro.setKilometragem(dados.getKilometragem());
            return new ResponseEntity<>(repository.save(carro), HttpStatus.OK);
        } catch (NoSuchElementException ex) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Carro> excluir(String id) {
        try {
            Carro carro = repository.findById(id).get();
            repository.delete(carro);
            return new ResponseEntity<>(carro, HttpStatus.OK);
        } catch (NoSuchElementException ex) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
