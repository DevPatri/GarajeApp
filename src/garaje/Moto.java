
package garaje;

/**
 *
 * @author Patricio Egea Vera
 */
public final class Moto extends Vehiculo{
//Atributos
    private int numRuedas;

//constructor defecto
    public Moto() {
        
    }
    
//constructuor con parámetros
    public Moto(String marca, String modelo, int añoFab, int kms, int cV, double precio, TipoCombustible tipo, TipoMedidas medidas,int numRuedas) {
        super(marca, modelo, añoFab, kms, cV, precio, tipo, medidas);
        this.numRuedas = numRuedas;
    }

//constructor de copia

    public Moto(int numRuedas, Vehiculo p) {
        super(p);
        this.numRuedas = numRuedas;
    }
    
//método toString

    @Override
    public String toString() {
        return "Moto{ "+ super.toString() + " ,Numero de ruedas= " + getNumRuedas() + '}';
    }

//Getters and setters

    public int getNumRuedas() {
        return numRuedas;
    }

    public void setNumRuedas(int numRuedas) {
        this.numRuedas = numRuedas;
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
        final Moto other = (Moto) obj;
        return true;
    }
    
//hashcode
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 61 * hash + this.numRuedas;
        return hash;
    }

}
