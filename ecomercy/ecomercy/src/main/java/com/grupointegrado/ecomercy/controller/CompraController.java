package com.grupointegrado.ecomercy.controller;

import com.grupointegrado.ecomercy.model.Compra;
import com.grupointegrado.ecomercy.repository.CompraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/compras")
public class CompraController {

    @Autowired
    private CompraRepository compraRepository;

    @GetMapping
    public List<Compra> getAllCompras() {
        return compraRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Compra> getCompraById(@PathVariable Integer id) {
        Optional<Compra> compra = compraRepository.findById(id);
        if (compra.isPresent()) {
            return ResponseEntity.ok(compra.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public Compra createCompra(@RequestBody Compra compra) {
        return compraRepository.save(compra);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Compra> updateCompra(@PathVariable Integer id, @RequestBody Compra compraDetails) {
        Optional<Compra> compra = compraRepository.findById(id);
        if (compra.isPresent()) {
            Compra compraToUpdate = compra.get();
            compraToUpdate.setCliente(compraDetails.getCliente());
            compraToUpdate.setPreco(compraDetails.getPreco());
            compraToUpdate.setNome_do_produto(compraDetails.getNome_do_produto());
            compraToUpdate.setQuantidade(compraDetails.getQuantidade());
            compraToUpdate.setFrete(compraDetails.getFrete());
            Compra updatedCompra = compraRepository.save(compraToUpdate);
            return ResponseEntity.ok(updatedCompra);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCompra(@PathVariable Integer id) {
        Optional<Compra> compra = compraRepository.findById(id);
        if (compra.isPresent()) {
            compraRepository.delete(compra.get());
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
