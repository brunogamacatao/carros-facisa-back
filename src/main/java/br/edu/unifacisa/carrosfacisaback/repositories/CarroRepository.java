package br.edu.unifacisa.carrosfacisaback.repositories;

import br.edu.unifacisa.carrosfacisaback.entities.Carro;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CarroRepository extends MongoRepository<Carro, String> {
}
