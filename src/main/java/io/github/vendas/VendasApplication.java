package io.github.vendas;

import io.github.vendas.domain.entity.Cliente;
import io.github.vendas.domain.repositorio.Clientes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

@SpringBootApplication
public class VendasApplication {

    @Autowired
    JdbcTemplate jdbcTemplate;


    @Bean
    public CommandLineRunner init(@Autowired Clientes clientes){
        return args -> {
            Cliente cliente = new Cliente("beltrano");
            Cliente cliente1 = new Cliente();
            cliente1.setNome("João");
            clientes.salvar(cliente1);
            clientes.salvar(cliente);

            List<Cliente> TodosClientes = clientes.obterTodos();
            TodosClientes.forEach(System.out::println);

        };
    }

    public static void main(String[] args) {
        SpringApplication.run(VendasApplication.class, args);
    }
}

