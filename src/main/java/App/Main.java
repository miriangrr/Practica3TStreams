package App;

import Services.ConsultasStream;
import models.Restaurante;
import models.Reserva;
import models.Cliente;
import models.EstadoReserva;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        Restaurante restaurante = new Restaurante("El Buen Sabor");

        cargarClientes(restaurante);
        cargarReservas(restaurante);

        List<Reserva> reservas = restaurante.getReservas();

        ConsultasStream cs = new ConsultasStream(reservas);

        System.out.println("1-------------------------------------------------");
        cs.getReservasConfirmadas(LocalDate.now()).forEach(r -> System.out.println(r));

        System.out.println("2-------------------------------------------------");
        cs.getReservasGrandes(4).forEach(r -> System.out.println(r));

        System.out.println("3-------------------------------------------------");
        System.out.println(cs.getPrimeraCancelada());

        System.out.println("4-------------------------------------------------");
        cs.getReservasOrdenadas(LocalDate.now()).forEach(r -> System.out.println(r));


        System.out.println("5-------------------------------------------------");
        cs.getClientesReservasGrandes().forEach(r -> System.out.println(r));

        System.out.println("6-------------------------------------------------");
        System.out.println(cs.getTotalPrevistoAtendidas());


        System.out.println("7-------------------------------------------------");
        cs.getReservasPorEstado()
                .forEach((k,v) -> IO.println(k + ": " + v));


        System.out.println("8-------------------------------------------------");
        cs.getReservasPorZona()
                .forEach((k,v) -> IO.println(k + ": " + v));


        System.out.println("9-------------------------------------------------");
        cs.getReservasAgrupadasPorFecha()
                .forEach((k,v) -> IO.println(k + ": " + v));


        System.out.println("10------------------------------------------------");
        System.out.println(cs.getClienteTop());



        System.out.println("11------------------------------------------------");
        System.out.println(cs.getTotalPrevistoAgrupadoPorFecha());



        System.out.println("12------------------------------------------------");
        IO.println( "Media: " + cs.getEstadisticasNumPersonas().getAverage() +
                " Maximo: " + cs.getEstadisticasNumPersonas().getMax() +
                " Minimo " + cs.getEstadisticasNumPersonas().getMin() +
                " Suma " + cs.getEstadisticasNumPersonas().getSum());


        System.out.println("13------------------------------------------------");
        cs.getClientes().forEach(r -> System.out.println(r));



        System.out.println("14------------------------------------------------");
        cs.getReservasFuturasAgrupadasPorFecha()
                .forEach((k,v) -> IO.println(k + ": " + v));




        System.out.println("15------------------------------------------------");
        System.out.println(cs.getPorcentajeCanceladas()+"%");

    }

    public static void cargarClientes(Restaurante restaurante) {
        restaurante.addCliente(new Cliente("11111111A", "Carlos", "600111222",
                "carlos@email.com", "Almería"));
        restaurante.addCliente(new Cliente("22222222B", "Lucía", "611222333",
                "lucia@email.com", "Murcia"));
        restaurante.addCliente(new Cliente("33333333C", "David", "622333444",
                "david@email.com", "Granada"));
        restaurante.addCliente(new Cliente("44444444D", "Sara", "633444555",
                "sara@email.com", "Málaga"));
        restaurante.addCliente(new Cliente("55555555E", "Pablo", "644555666",
                "pablo@email.com", "Jaén"));
        restaurante.addCliente(new Cliente("66666666F", "Elena", "655666777",
                "elena@email.com", "Córdoba"));
    }

    public static void cargarReservas(Restaurante restaurante) {

        restaurante.addReserva(new Reserva(
                1,
                restaurante.getClientePorDni("11111111A"),
                LocalDate.now(),
                LocalTime.of(14, 0),
                2,
                45.0,
                EstadoReserva.CONFIRMADA,
                "terraza"));

        restaurante.addReserva(new Reserva(
                2,
                restaurante.getClientePorDni("22222222B"),
                LocalDate.now().plusDays(1),
                LocalTime.of(21, 30),
                4,
                90.0,
                EstadoReserva.PENDIENTE,
                "interior"));

        restaurante.addReserva(new Reserva(
                3,
                restaurante.getClientePorDni("33333333C"),
                LocalDate.now().plusDays(2),
                LocalTime.of(15, 0),
                3,
                70.0,
                EstadoReserva.ATENDIDA,
                "salón"));

        restaurante.addReserva(new Reserva(
                4,
                restaurante.getClientePorDni("44444444D"),
                LocalDate.now(),
                LocalTime.of(22, 0),
                5,
                120.0,
                EstadoReserva.CONFIRMADA,
                "barra"));

        restaurante.addReserva(new Reserva(
                5,
                restaurante.getClientePorDni("55555555E"),
                LocalDate.now().plusDays(3),
                LocalTime.of(13, 30),
                2,
                35.0,
                EstadoReserva.CANCELADA,
                "terraza"));

        restaurante.addReserva(new Reserva(
                6,
                restaurante.getClientePorDni("66666666F"),
                LocalDate.now(),
                LocalTime.of(20, 0),
                6,
                150.0,
                EstadoReserva.CONFIRMADA,
                "salón"));
    }
}