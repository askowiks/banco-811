package com.santander.banco811.service;

import com.santander.banco811.dto.ContaRequest;
import com.santander.banco811.dto.ContaResponse;
import com.santander.banco811.model.Conta;
import com.santander.banco811.model.Usuario;

import java.util.List;

public interface ContaService {
    List<Conta> getAll(Integer id);
    ContaResponse create(Usuario usuario, ContaRequest contaRequest);
    Conta getById(Integer id);
    Conta update(ContaRequest contaRequest, Integer id);
    void delete (Integer id);
}
