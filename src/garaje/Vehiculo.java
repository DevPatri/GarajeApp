package garaje;

import java.util.Objects;

/**
 *
 * @author Patricio Egea Vera
 */
public abstract class Vehiculo {

//atributos    
    private String marca, modelo;
    private int añoFab, kms, cV;
    private double precio;
    private TipoCombustible tipo;
    private TipoMedidas medidas;

//constructor por defecto
    public Vehiculo() {

    }

//constructor con parámetros
    public Vehiculo(String marca, String modelo, int añoFab, int kms, int cV, double precio, TipoCombustible tipo, TipoMedidas medidas) {
        this.marca = marca;
        this.modelo = modelo;
        this.añoFab = añoFab;
        this.kms = kms;
        this.cV = cV;
        this.precio = precio;
        this.tipo = tipo;
        this.medidas = medidas;
    }

//método de copia
    public Vehiculo(Vehiculo p) {
        this.marca = p.marca;
        this.modelo = p.modelo;
        this.añoFab = p.añoFab;
        this.kms = p.kms;
        this.cV = p.cV;
        this.precio = p.precio;
        this.tipo = p.tipo;
        this.medidas = p.medidas;

    }

//Getters y Setters
    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getAñoFab() {
        return añoFab;
    }

    public void setAñoFab(int añoFab) {
        this.añoFab = añoFab;
    }

    public int getKms() {
        return kms;
    }

    public void setKms(int kms) {
        this.kms = kms;
    }

    public int getcV() {
        return cV;
    }

    public void setcV(int cV) {
        this.cV = cV;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public TipoCombustible getTipo() {
        return tipo;
    }

    public void setTipo(TipoCombustible tipo) {
        this.tipo = tipo;
    }

    public TipoMedidas getMedidas() {
        return medidas;
    }

    public void setMedidas(TipoMedidas medidas) {
        this.medidas = medidas;
    }

//Hascode
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 19 * hash + Objects.hashCode(this.marca);
        hash = 19 * hash + Objects.hashCode(this.modelo);
        hash = 19 * hash + this.añoFab;
        hash = 19 * hash + this.kms;
        hash = 19 * hash + this.cV;
        hash = 19 * hash + (int) (Double.doubleToLongBits(this.precio) ^ (Double.doubleToLongBits(this.precio) >>> 32));
        hash = 19 * hash + Objects.hashCode(this.tipo);
        hash = 19 * hash + Objects.hashCode(this.medidas);
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
        final Vehiculo other = (Vehiculo) obj;
        if (this.añoFab != other.añoFab) {
            return false;
        }
        if (this.kms != other.kms) {
            return false;
        }
        if (this.cV != other.cV) {
            return false;
        }
        if (Double.doubleToLongBits(this.precio) != Double.doubleToLongBits(other.precio)) {
            return false;
        }
        if (!Objects.equals(this.marca, other.marca)) {
            return false;
        }
        if (!Objects.equals(this.modelo, other.modelo)) {
            return false;
        }
        if (this.tipo != other.tipo) {
            return false;
        }
        return Objects.equals(this.medidas, other.medidas);
    }

//toString

    @Override
    public String toString() {
        return "Vehiculo{" + "marca=" + marca + ", modelo=" + modelo + ", a\u00f1oFab=" + añoFab + ", kms=" + kms + ", cV=" + cV + ", precio=" + precio + ", tipo=" + tipo + ", medidas=" + medidas + '}';
    }
    

//método para calcular la potencia en KW
    public double getPotenciaKw() {
        double kW;
        kW = (int) (cV * 1.34);
        return kW;
    }

    public enum TipoCombustible {
        GASOLINA,
        DIESEL,
        HIBRIDO,
        ELECTRICO,
        GLP
    }
}
