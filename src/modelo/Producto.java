package modelo;
import interfaces.Facturable;

// Se implementa al menos una clase abstracta que define comportamientos comunes obligatorios para sus subclases[cite: 1, 3].
public abstract class Producto implements Facturable {
    protected String codigo;
    protected String nombre;
    protected double precioBase;
    protected int stock;

    public Producto(String codigo, String nombre, double precioBase, int stock) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.precioBase = precioBase;
        this.stock = stock;
    }

    // Método concreto en la clase abstracta
    public boolean verificarStock(int cantidad) {
        return this.stock >= cantidad;
    }

    // --- POLIMORFISMO POR SOBRECARGA (OVERLOADING) ---
    // Método sobrecargado 1
    public void agregarStock(int cantidad) {
        this.stock += cantidad;
        System.out.println("Se agregaron " + cantidad + " unidades a " + nombre);
    }

    // Método sobrecargado 2 (Mismo nombre, diferente firma)
    public void agregarStock(int cantidad, String proveedor) {
        this.stock += cantidad;
        System.out.println("Se agregaron " + cantidad + " unidades a " + nombre + " desde el proveedor: " + proveedor);
    }

    // Método sobrecargado 3
    public void aplicarDescuento(double porcentaje) {
        this.precioBase -= (this.precioBase * (porcentaje / 100));
    }

    // Método sobrecargado 4 (Mismo nombre, diferente firma)
    public void aplicarDescuento(double porcentaje, String codigoPromo) {
        System.out.println("Aplicando promo " + codigoPromo);
        this.precioBase -= (this.precioBase * (porcentaje / 100));
    }

    // Método abstracto: Obliga a las subclases a definir cómo mostrar su info específica
    public abstract void mostrarInformacion();
    
    public String getNombre() {
        return nombre;
    }
}