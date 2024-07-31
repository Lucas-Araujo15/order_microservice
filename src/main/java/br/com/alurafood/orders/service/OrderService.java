package br.com.alurafood.orders.service;

import br.com.alurafood.orders.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderService {
    @Autowired
    private OrderRepository repository;

    @Autowired
    private final ModelMapper modelMapper;
}
