package com.grupointegrado.ecomercy.controller;

import com.grupointegrado.ecomercy.model.Carrinho;
import com.grupointegrado.ecomercy.repository.CarrinhoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/carrinhos")
public class CarrinhoController {

    @Autowired
    private CarrinhoRepository carrinhoRepository;

    @GetMapping
    public List<Carrinho> getAllCarrinhos() {
        return carrinhoRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Carrinho> getCarrinhoById(@PathVariable Integer id) {
        Optional<Carrinho> carrinho = carrinhoRepository.findById(id);
        if (carrinho.isPresent()) {
            return ResponseEntity.ok(carrinho.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public Carrinho createCarrinho(@RequestBody Carrinho carrinho) {
        return carrinhoRepository.save(carrinho);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Carrinho> updateCarrinho(@PathVariable Integer id, @RequestBody Carrinho carrinhoDetails) {
        Optional<Carrinho> carrinho = carrinhoRepository.findById(id);
        if (carrinho.isPresent()) {
            Carrinho carrinhoToUpdate = carrinho.get();
            carrinhoToUpdate.setCliente(carrinhoDetails.getCliente());
            carrinhoToUpdate.setProduto(carrinhoDetails.getProduto());
            Carrinho updatedCarrinho = carrinhoRepository.save(carrinhoToUpdate);
            return ResponseEntity.ok(updatedCarrinho);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCarrinho(@PathVariable Integer id) {
        Optional<Carrinho> carrinho = carrinhoRepository.findById(id);
        if (carrinho.isPresent()) {
            carrinhoRepository.delete(carrinho.get());
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
