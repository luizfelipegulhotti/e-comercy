package com.grupointegrado.ecomercy.controller;

import com.grupointegrado.ecomercy.dto.EcomercyResquestDTO;
import com.grupointegrado.ecomercy.model.Ecomercy;
import com.grupointegrado.ecomercy.repository.EcomercyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/api/ecomercy")
public class EcomercyController {

    @Autowired
    private EcomercyRepository repository;

    @GetMapping
    public ResponseEntity<List<Ecomercy>> findAll() {
        List<Ecomercy> ecomercy = this.repository.findAll();
        return ResponseEntity.ok(ecomercy);
    }

    @GetMapping("/{id}")
    public Ecomercy findById(@PathVariable Integer id) {
        return this.repository.findById(id)
                .orElseThrow(() ->
                        new IllegalArgumentException("produto não foi encontrado"));
    }

    @PostMapping
    public ResponseEntity<Ecomercy> save(@RequestBody EcomercyResquestDTO dto) {
        if (dto.nome().isEmpty()) {
            return ResponseEntity.status(428).build();
        }

        Ecomercy ecomercy = new Ecomercy();
        ecomercy.setNome(dto.nome());

        this.repository.save(ecomercy);
        return ResponseEntity.ok(ecomercy);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        Ecomercy ecomercy = this.repository.findById(id)
                .orElseThrow(() ->
                        new IllegalArgumentException("produto não foi encontrado"));

        this.repository.delete(ecomercy);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Ecomercy> update(@PathVariable Integer id, @RequestBody EcomercyResquestDTO dto) {
        if (dto.nome().isEmpty()) {
            return ResponseEntity.status(428).build();
        }

        Ecomercy ecomercy = this.repository.findById(id)
                .orElseThrow(() ->
                        new IllegalArgumentException("produto não foi encontrado"));

        ecomercy.setNome(dto.nome());

        this.repository.save(ecomercy);
        return ResponseEntity.ok(ecomercy);
    }

    @PostMapping("/{id}/nota")
    public ResponseEntity<Ecomercy> addNota(@PathVariable Integer id,
                                           @RequestBody BigDecimal nota) {

        Ecomercy ecomercy = this.repository.findById(id)
                .orElseThrow(() ->
                        new IllegalArgumentException("produto não foi encontrado"));

        ecomercy.setNota(nota);

        this.repository.save(ecomercy);
        return ResponseEntity.ok(ecomercy);
    }

    @PostMapping("/{id}/resumo")
    public ResponseEntity<Ecomercy> addResumo(@PathVariable Integer id,
                                             @RequestBody String resumo) {

        Ecomercy ecomercy = this.repository.findById(id)
                .orElseThrow(() ->
                        new IllegalArgumentException("produto não foi encontrado"));

        ecomercy.setResumo(resumo);

        this.repository.save(ecomercy);
        return ResponseEntity.ok(ecomercy);
    }

}
