package com.grupointegrado.ecomercy.controller;

import com.grupointegrado.ecomercy.model.Pagamento;
import com.grupointegrado.ecomercy.repository.PagamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pagamentos")
public class PagamentoController {

    @Autowired
    private PagamentoRepository pagamentoRepository;

    @GetMapping
    public List<Pagamento> getAllPagamentos() {
        return pagamentoRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pagamento> getPagamentoById(@PathVariable Integer id) {
        Optional<Pagamento> pagamento = pagamentoRepository.findById(id);
        if (pagamento.isPresent()) {
            return ResponseEntity.ok(pagamento.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public Pagamento createPagamento(@RequestBody Pagamento pagamento) {
        return pagamentoRepository.save(pagamento);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Pagamento> updatePagamento(@PathVariable Integer id, @RequestBody Pagamento pagamentoDetails) {
        Optional<Pagamento> pagamento = pagamentoRepository.findById(id);
        if (pagamento.isPresent()) {
            Pagamento pagamentoToUpdate = pagamento.get();
            pagamentoToUpdate.setCliente(pagamentoDetails.getCliente());
            pagamentoToUpdate.setCompra(pagamentoDetails.getCompra());
            pagamentoToUpdate.setPix(pagamentoDetails.getPix());
            pagamentoToUpdate.setConta_de_banco(pagamentoDetails.getConta_de_banco());
            Pagamento updatedPagamento = pagamentoRepository.save(pagamentoToUpdate);
            return ResponseEntity.ok(updatedPagamento);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePagamento(@PathVariable Integer id) {
        Optional<Pagamento> pagamento = pagamentoRepository.findById(id);
        if (pagamento.isPresent()) {
            pagamentoRepository.delete(pagamento.get());
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
