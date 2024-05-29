package br.edu.unifacisa.carrosfacisaback.entities;

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class Carro {
    @Id
    private String id;
    private String nome;
    private String montadora;
    private Integer ano;
    private Long kilometragem;
    private Double preco;
}
