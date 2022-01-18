package com.serasa.Experian.desafioCliente.service;

import com.serasa.Experian.desafioCliente.model.Cliente;
import com.serasa.Experian.desafioCliente.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public List<Cliente> findClienteAll() {
        return clienteRepository.findAll();
    }

    public List<Cliente> findClienteById(Long id) {
        return clienteRepository.findAllById(id);
    }

    public Optional <Cliente> save(Cliente cliente) {
        if(clienteRepository.findByNomeContainingIgnoreCase(cliente.getNome()).isPresent()){
            return Optional.empty();
        } else {
            return Optional.ofNullable(clienteRepository.save(cliente));
        }
    }

    public void deleteById(Long id){
        clienteRepository.deleteById(id);
    }
}
