package br.com.alurafood.orders.controller;

import br.com.alurafood.orders.dto.OrderDTO;
import br.com.alurafood.orders.dto.StatusDTO;
import br.com.alurafood.orders.service.OrderService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderController {
    @Autowired
    private OrderService service;

    @GetMapping
    public List<OrderDTO> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderDTO> findById(@PathVariable("id") Long id) {
        OrderDTO dto = service.findById(id);

        return ResponseEntity.ok(dto);
    }

    @GetMapping("/port")
    public String getPort(@Value("${local.server.port}") String port) {
        return String.format("Requisição bem sucedida pela instância executando na porta %s", port);
    }

    @PostMapping
    public ResponseEntity<OrderDTO> create(@RequestBody @Valid OrderDTO dto, UriComponentsBuilder uriBuilder) {
        OrderDTO orderPlaced = service.create(dto);

        URI address = uriBuilder.path("/orders/{id}").buildAndExpand(orderPlaced.getId()).toUri();

        return ResponseEntity.created(address).body(orderPlaced);
    }

    @PutMapping("/{id}/status")
    public ResponseEntity<OrderDTO> updateStatus(@PathVariable("id") Long id, @RequestBody StatusDTO status) {
        OrderDTO dto = service.updateStatus(id, status);

        return ResponseEntity.ok(dto);
    }

    @PutMapping("/{id}/paid")
    public ResponseEntity<Void> approvePayment(@PathVariable @NotNull Long id) {
        service.approveOrderPayment(id);

        return ResponseEntity.ok().build();
    }
}
