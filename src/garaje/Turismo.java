package garaje;

/**
 *
 * @author Patri
 */
public final class Turismo extends Vehiculo {

//atributos
    /*atributo enum*/
    public enum TipoCarroceria {
        COMPACTO,
        BERLINA,
        SUV,
        MONOVOLUMEN,
        DESCAPOTABLE
    }

    private TipoCarroceria carroceria;

//constructor defecto
    public Turismo() {

    }

//constructor con parámetros
    public Turismo(TipoCarroceria carroceria, String marca, String modelo, int añoFab, int kms, int cV, double precio, TipoCombustible tipo, TipoMedidas medidas) {
        super(marca, modelo, añoFab, kms, cV, precio, tipo, medidas);
        this.carroceria = carroceria;
    }

//constructor copia
    public Turismo(TipoCarroceria carroceria, Vehiculo p) {
        super(p);
        this.carroceria = carroceria;
    }

//método toString
    @Override
    public String toString() {
        return "Turismo{ "+ super.toString() + " ,Tipo de Carroceria= " + getCarroceria() + '}';
    }

//Getters and Setters
    public TipoCarroceria getCarroceria() {
        return carroceria;
    }

    public void setCarroceria(TipoCarroceria carroceria) {
        this.carroceria = carroceria;
    }

}
