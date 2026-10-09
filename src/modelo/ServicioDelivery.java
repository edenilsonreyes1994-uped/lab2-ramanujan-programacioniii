package modelo;
import interfaces.Facturable;

// Esta clase implementa la misma interfaz, demostrando el uso polimórfico en clases relacionadas funcionalmente pero no por herencia[cite: 1, 3]
public class ServicioDelivery implements Facturable {
    private double distanciaKm;
    private double tarifaPorKm = 1.50;

    public ServicioDelivery(double distanciaKm) {
        this.distanciaKm = distanciaKm;
    }

    @Override
    public double calcularPrecioVenta() {
        return distanciaKm * tarifaPorKm;
    }

    @Override
    public String obtenerDescripcionFactura() {
        return "Servicio de Delivery (" + distanciaKm + " Km)";
    }
}