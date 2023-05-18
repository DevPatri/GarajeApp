
package garaje;

/**
 *
 * @author Patricio Egea Vera
 */
public class TipoMedidas{
    protected int alto, ancho, largo;
    
    public TipoMedidas(){
        
    }
    
    public TipoMedidas(int alto, int ancho, int largo){
        this.alto = alto;
        this.ancho = ancho;
        this.largo = largo;
    }

    public int getAlto() {
        return alto;
    }

    public int getAncho() {
        return ancho;
    }

    public int getLargo() {
        return largo;
    }

    public void setAlto(int alto) {
        this.alto = alto;
    }

    public void setAncho(int ancho) {
        this.ancho = ancho;
    }

    public void setLargo(int largo) {
        this.largo = largo;
    }

    @Override
    public String toString() {
        return "{" + "alto=" + alto + "cm, ancho=" + ancho + "cm, largo=" + largo + "cm}";
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 71 * hash + this.alto;
        hash = 71 * hash + this.ancho;
        hash = 71 * hash + this.largo;
        return hash;
    }

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
        final TipoMedidas other = (TipoMedidas) obj;
        if (this.alto != other.alto) {
            return false;
        }
        if (this.ancho != other.ancho) {
            return false;
        }
        return this.largo == other.largo;
    }
    
}
