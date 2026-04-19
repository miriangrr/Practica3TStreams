package models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Cliente {
    private String dni;
    private String nombre;
    private String telefono;
    private String email;
    private String ciudad;

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("--ID: ");
        sb.append(dni);
        sb.append(" | ").append(nombre);
        sb.append(" | ").append(telefono);
        sb.append(" | ").append(email);
        sb.append(" | ").append(ciudad);

        return sb.toString();
    }
}
