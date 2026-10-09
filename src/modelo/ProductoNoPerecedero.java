package modelo;

// Subclase 2 que extiende de la superclase abstracta[cite: 3]
public class ProductoNoPerecedero extends Producto {
    private int mesesGarantia;

    public ProductoNoPerecedero(String codigo, String nombre, double precioBase, int stock, int mesesGarantia) {
        super(codigo, nombre, precioBase, stock);
        this.mesesGarantia = mesesGarantia;
    }

    // Método sobrescrito 2[cite: 3]
    @Override
    public void mostrarInformacion() {
        System.out.println("[No Perecedero] " + nombre + " - Garantía: " + mesesGarantia + " meses - Stock: " + stock);
    }

    @Override
    public double calcularPrecioVenta() {
        // Lógica de negocio: tiene recargo de IVA normal
        return this.precioBase * 1.13; 
    }

    @Override
    public String obtenerDescripcionFactura() {
        return nombre + " (Garantía: " + mesesGarantia + " meses)";
    }
}