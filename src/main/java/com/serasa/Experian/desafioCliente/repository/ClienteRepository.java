package com.serasa.Experian.desafioCliente.repository;

import com.serasa.Experian.desafioCliente.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
     Optional<Cliente> findByNomeContainingIgnoreCase(String nome);

     List<Cliente> findAllById(Long id);
}
