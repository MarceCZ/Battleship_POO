package Package.Clases;
import java.util.Random;

public class Submarino extends Barco{

    public Submarino(String orientacion) {
        super(orientacion);
    }

    @Override
    public void AsignarNombre() {
        this.nombre = "Submarino";
    }

    @Override
    public void Damage() {
        this.vida = this.vida - 30;
    }

    @Override
    public void AsignarEspacio() {
        this.espacio = 3;
    }

    @Override
    public void AsignarVida() {
        this.vida = 90;
    }
    
        @Override
    public void GenerarCodigo() {
        Random rd = new Random();
        int num;
        num = rd.nextInt(700-500+1)+500;
        while(num%2!=1){
            num = rd.nextInt(700-500+1)+500;
        }
        this.cod = "S-" + num;
    }
    
    @Override
    public String Mensaje() {
        return "El crucero ha sido HUNDIDO\n";
    }
}
