package garaje;

/**
 *
 * @author Patricio Egea Vera
 */
public final class Industrial extends Vehiculo implements Camperizable {

//Atributos
    private float tamCaja;

//constructor defecto
    public Industrial() {

    }

//constructor con parámetros
    public Industrial(int tamCaja, String marca, String modelo, int añoFab, int kms, int cV, double precio, TipoCombustible tipo, TipoMedidas medidas) {
        super(marca, modelo, añoFab, kms, cV, precio, tipo, medidas);
        this.tamCaja = tamCaja;
    }

//constructor de copia
    public Industrial(int tamCaja, Vehiculo p) {
        super(p);
        this.tamCaja = tamCaja;
    }

//método toString
    @Override
    public String toString() {
        return "Industrial{ " + super.toString() + " ,Tamaño de caja= " + getTamCaja() + '}';
    }

//Getters and Setters
    public float getTamCaja() {
        return tamCaja;
    }

    public void setTamCaja(float tamCaja) {
        this.tamCaja = tamCaja;
    }

//Hashcode
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Float.floatToIntBits(this.tamCaja);
        return hash;
    }

//Equals
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Industrial other = (Industrial) obj;
        return Float.floatToIntBits(this.tamCaja) == Float.floatToIntBits(other.tamCaja);
    }

//interfaces
    @Override
    public void añadirCama() {
        System.out.println("Cama instalada");

    }

    @Override
    public void añadirDucha() {
        System.out.println("Ducha Instalada");
    }

    @Override
    public void añadirCocina() {
        System.out.println("Cocina Instalada");
    }

}
