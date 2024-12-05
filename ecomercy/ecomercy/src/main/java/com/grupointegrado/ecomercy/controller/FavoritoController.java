package com.grupointegrado.ecomercy.controller;

import com.grupointegrado.ecomercy.model.Favorito;
import com.grupointegrado.ecomercy.repository.FavoritoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/favoritos")
public class FavoritoController {

    @Autowired
    private FavoritoRepository favoritoRepository;

    @GetMapping
    public List<Favorito> getAllFavoritos() {
        return favoritoRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Favorito> getFavoritoById(@PathVariable Integer id) {
        Optional<Favorito> favorito = favoritoRepository.findById(id);
        if (favorito.isPresent()) {
            return ResponseEntity.ok(favorito.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public Favorito createFavorito(@RequestBody Favorito favorito) {
        return favoritoRepository.save(favorito);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Favorito> updateFavorito(@PathVariable Integer id, @RequestBody Favorito favoritoDetails) {
        Optional<Favorito> favorito = favoritoRepository.findById(id);
        if (favorito.isPresent()) {
            Favorito favoritoToUpdate = favorito.get();
            favoritoToUpdate.setCliente(favoritoDetails.getCliente());
            favoritoToUpdate.setProduto(favoritoDetails.getProduto());
            Favorito updatedFavorito = favoritoRepository.save(favoritoToUpdate);
            return ResponseEntity.ok(updatedFavorito);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFavorito(@PathVariable Integer id) {
        Optional<Favorito> favorito = favoritoRepository.findById(id);
        if (favorito.isPresent()) {
            favoritoRepository.delete(favorito.get());
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
