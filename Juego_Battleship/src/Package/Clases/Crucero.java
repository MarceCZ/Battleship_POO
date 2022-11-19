package Package.Clases;
import java.util.Random;

public class Crucero extends Barco{

    public Crucero(String orientacion) {
        super(orientacion);
    }

    @Override
    public void AsignarNombre() {
        this.nombre = "Crucero";
    }

    @Override
    public void Damage() {
        this.vida = this.vida - 20;
    }

    @Override
    public void AsignarEspacio() {
        this.espacio = 3;
    }

    @Override
    public void AsignarVida() {
        this.vida = 60;
    }
    
        @Override
    public void GenerarCodigo() {
        Random rd = new Random();
        int num;
        num = rd.nextInt(900-300+1)+300;
        while(num%3!=0){
            num = rd.nextInt(900-300+1)+300;
        }
        this.cod = "C-" + num;
    }
    
    @Override
    public String Mensaje() {
        return "El crucero ha sido HUNDIDO\n";
    }
}
