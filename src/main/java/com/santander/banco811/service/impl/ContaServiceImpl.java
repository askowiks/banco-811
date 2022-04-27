package com.santander.banco811.service.impl;

import com.santander.banco811.dto.ContaRequest;
import com.santander.banco811.dto.ContaResponse;
import com.santander.banco811.model.Conta;
import com.santander.banco811.model.Usuario;
import com.santander.banco811.repository.ContaRepository;
import com.santander.banco811.service.ContaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class ContaServiceImpl implements ContaService {

    @Autowired
    ContaRepository contaRepository;

    @Override
    public List<Conta> getAll(Integer id) {
        if (id != null) {
            return Arrays.asList(getById(id));
        } else {
            return contaRepository.findAll();
        }
    }

    @Override
    public ContaResponse create(Usuario usuario, ContaRequest contaRequest) {
        Conta conta = new Conta(contaRequest);
        conta.setUsuario(usuario);
        contaRepository.save(conta);
        return new ContaResponse(conta);
    }

    @Override
    public Conta getById(Integer id) {
        return contaRepository.findById(id).get();
    }

    @Override
    public Conta update(ContaRequest contaRequest, Integer id) {
        Conta conta = getById(id);

        conta.setNumero(contaRequest.getNumero());
        conta.setAgencia(contaRequest.getAgencia());
        conta.setTipoConta(contaRequest.getTipoConta());

        return contaRepository.save(conta);
    }

    @Override
    public void delete(Integer id) {
        var conta = getById(id);
        contaRepository.delete(conta);
    }
}
