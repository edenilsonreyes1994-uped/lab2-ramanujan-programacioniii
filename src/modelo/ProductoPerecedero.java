package modelo;

// Subclase 1 que extiende de la superclase abstracta[cite: 3]
public class ProductoPerecedero extends Producto {
    private String fechaVencimiento;

    public ProductoPerecedero(String codigo, String nombre, double precioBase, int stock, String fechaVencimiento) {
        super(codigo, nombre, precioBase, stock);
        this.fechaVencimiento = fechaVencimiento;
    }

    // --- POLIMORFISMO POR SOBRESCRITURA (OVERRIDING) ---
    // Método sobrescrito 1[cite: 3]
    @Override
    public void mostrarInformacion() {
        System.out.println("[Perecedero] " + nombre + " - Vence: " + fechaVencimiento + " - Stock: " + stock);
    }

    // Método sobrescrito de la interfaz Facturable
    @Override
    public double calcularPrecioVenta() {
        // Lógica de negocio: si es perecedero, tiene un recargo mínimo por refrigeración
        return this.precioBase * 1.05; 
    }

    @Override
    public String obtenerDescripcionFactura() {
        return nombre + " (Vence: " + fechaVencimiento + ")";
    }
}