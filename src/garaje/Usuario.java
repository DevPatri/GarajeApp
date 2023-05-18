package garaje;

import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;

/**
 *
 * @author Patricio Egea Vera
 */
public class Usuario {

//Atributos
    private String nombre, apellido, provincia;
    private Date fechaNac;
    private ArrayList <Vehiculo> Fav = new ArrayList<>();

//Constructores
    public Usuario() {

    }

    public Usuario(String nombre, String apellido, String provincia, Date fechaNac) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.provincia = provincia;
        this.fechaNac = fechaNac;
    }

//constructor copia
    public Usuario(Usuario p) {
        this.nombre = p.nombre;
        this.apellido = p.apellido;
        this.provincia = p.provincia;
        this.fechaNac = p.fechaNac;
    }

//método toString
    @Override
    public String toString() {
        return "Usuario{" + "nombre=" + nombre + ", apellido=" + apellido + ", provincia=" + provincia + ", fechaNac=" + fechaNac + '}';
    }

//HashCode
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + Objects.hashCode(this.nombre);
        hash = 71 * hash + Objects.hashCode(this.apellido);
        hash = 71 * hash + Objects.hashCode(this.provincia);
        hash = 71 * hash + Objects.hashCode(this.fechaNac);
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
        final Usuario other = (Usuario) obj;
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        if (!Objects.equals(this.apellido, other.apellido)) {
            return false;
        }
        if (!Objects.equals(this.provincia, other.provincia)) {
            return false;
        }
        return Objects.equals(this.fechaNac, other.fechaNac);
    }

//Getters and Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public Date getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(Date fechaNac) {
        this.fechaNac = fechaNac;
    }

    public void getFav() {
        
        for (Vehiculo v1: Fav) {
            System.out.println(v1);
        }
    }

    public void setFav(Vehiculo Fav) {        
        this.Fav.add(Fav);
        
    }
}
