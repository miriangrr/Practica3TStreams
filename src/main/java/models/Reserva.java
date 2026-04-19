package models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Reserva {
    private long id;
    private Cliente cliente;
    private LocalDate fecha;
    private LocalTime hora;
    private int numPersonas;
    private double importePrevisto;
    private EstadoReserva estado;
    private String zona;

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("--ID: ");
        sb.append(id);
        sb.append(" | ").append(cliente);
        sb.append(" | ").append(fecha);
        sb.append(" | ").append(hora);
        sb.append(" | ").append(numPersonas);
        sb.append(" | ").append(importePrevisto);
        sb.append(" | ").append(estado);
        sb.append(" | ").append(zona);
        return sb.toString();
    }

}
