package com.pucgo.projetointegradorib.controllers;

import com.pucgo.projetointegradorib.models.Reserva;
import com.pucgo.projetointegradorib.services.ReservaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/reservas")
public class ReservaController {
    @Autowired
    private ReservaService reservaService;

    @PostMapping("/criar")
    public ResponseEntity<Reserva> criarReserva(@RequestParam Long idLivro, @RequestParam Long idUsuario) {
        try {
            Reserva novaReserva = reservaService.criarReserva(idLivro, idUsuario);
            return new ResponseEntity<>(novaReserva, HttpStatus.CREATED);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/finalizar/{idReserva}")
    public ResponseEntity<Reserva> finalizarReserva(@PathVariable Long idReserva) {
        try {
            Reserva reservaFinalizada = reservaService.finalizarReserva(idReserva);
            return new ResponseEntity<>(reservaFinalizada, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
}
