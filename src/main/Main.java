package main;

import interfaces.Facturable;
import modelo.ProductoPerecedero;
import modelo.ProductoNoPerecedero;
import modelo.ServicioDelivery;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("--- SISTEMA DE MINIMARKET ---");

        // Creación de objetos de las subclases
        ProductoPerecedero leche = new ProductoPerecedero("P001", "Leche Entera", 1.20, 50, "20-10-2026");
        ProductoNoPerecedero arroz = new ProductoNoPerecedero("N001", "Arroz San Pedro", 0.90, 100, 12);
        ServicioDelivery envio = new ServicioDelivery(5.0);

        // Demostración de Polimorfismo por Sobrecarga (Overloading)[cite: 1, 3]
        System.out.println("\n--- PROBANDO SOBRECARGA ---");
        arroz.agregarStock(20); // Usa el método sobrecargado 1
        leche.agregarStock(10, "Lácteos La Salud"); // Usa el método sobrecargado 2 con proveedor
        
        leche.aplicarDescuento(10); // Método sobrecargado 3
        arroz.aplicarDescuento(15, "PROMO-FIN-AÑO"); // Método sobrecargado 4

        // Demostración de Polimorfismo por Sobrescritura (Overriding) y ligadura dinámica[cite: 3]
        System.out.println("\n--- PROBANDO SOBRESCRITURA Y CLASE ABSTRACTA ---");
        leche.mostrarInformacion(); 
        arroz.mostrarInformacion(); 

        // Demostración de Interfaces y Polimorfismo dinámico en colecciones[cite: 3]
        System.out.println("\n--- PROBANDO INTERFACES Y CARRITO DE COMPRAS ---");
        List<Facturable> carrito = new ArrayList<>();
        carrito.add(leche);
        carrito.add(arroz);
        carrito.add(envio);

        double totalPagar = 0;
        for (Facturable item : carrito) {
            System.out.println(item.obtenerDescripcionFactura() + " -> $" + String.format("%.2f", item.calcularPrecioVenta()));
            totalPagar += item.calcularPrecioVenta();
        }
        
        System.out.println("TOTAL A PAGAR: $" + String.format("%.2f", totalPagar));
    }
}