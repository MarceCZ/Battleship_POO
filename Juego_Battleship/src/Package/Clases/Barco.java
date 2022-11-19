package Package.Clases;


public abstract class Barco {
    //Atributos a utilizar
    protected String nombre;
    protected String cod;
    protected int espacio;    //Cantidad de espacios que ocupa en el tablero de juego
    protected int vida;   //Dato a mostrar en el juego
    protected String orientacion; //Forma que sera colocado en el tablero de juego

    //Constructor
    public Barco(String orientacion) {
        this.orientacion = orientacion;
    }
    
    //Getter y setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCod() {
        return cod;
    }

    public void setCod(String cod) {
        this.cod = cod;
    }

    public int getEspacio() {
        return espacio;
    }

    public void setEspacio(int espacio) {
        this.espacio = espacio;
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public String getOrientacion() {
        return orientacion;
    }

    public void setOrientacion(String orientacion) {    
        this.orientacion = orientacion;
    }
    
   //Metodos abstractos
    public abstract void AsignarNombre();
    public abstract void GenerarCodigo();
    public abstract void Damage();
    public abstract void AsignarEspacio();
    public abstract void AsignarVida();
    public abstract String Mensaje();
    
    public String verInfo(){
        return  "Nombre: " + nombre +
                "\nCodigo: " + cod +
                "\nEspacio que ocupa: " + espacio +
                "\nVida del barco: " + vida +
                "\nOrientacion: " + orientacion + '\n';
    }
}
