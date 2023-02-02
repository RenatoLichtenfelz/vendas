package io.github.vendas.domain.repositorio;

import io.github.vendas.domain.entity.Cliente;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class Clientes {

    private String INSERT = "insert into cliente (nome) values (?) ";
    private String SELECT_ALL = "SELECT * FROM CLIENTE ";

    @Autowired
    private JdbcTemplate jdbcTemplate;
    public Cliente salvar(@NotNull Cliente cliente){
        jdbcTemplate.update( INSERT, new Object[]{cliente.getNome()}  );
        return cliente;
    }

    public List<Cliente> obterTodos() {
        return jdbcTemplate.queryForList(SELECT_ALL, new RowMapper<Cliente>() {
            @Override
            public Cliente mapRow(ResultSet resultSet, int i) throws SQLException {
                return new Cliente(resultSet.getString("nome"));
            }
        });
    }
}
