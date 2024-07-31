package br.com.alurafood.orders.dto;

import br.com.alurafood.orders.model.Status;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StatusDTO {
    private Status status;
}
