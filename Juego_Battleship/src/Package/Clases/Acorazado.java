package Package.Clases;
import java.util.Random;

public class Acorazado extends Barco{

    public Acorazado(String orientacion) {
        super(orientacion);
    }

    @Override
    public void AsignarNombre() {
        this.nombre = "Acorazado";
    }

    @Override
    public void Damage() {
        this.vida = this.vida - 30;
    }

    @Override
    public void AsignarEspacio() {
        this.espacio = 4;
    }

    @Override
    public void AsignarVida() {
        this.vida = 120;
    }

    @Override
    public String Mensaje() {
        return "El acorazado ha sido HUNDIDO\n";
    }

    @Override
    public void GenerarCodigo() {
        Random rd = new Random();
        int num;
        num = rd.nextInt(1000-400+1)+400;
        while(num%7!=0){
            num = rd.nextInt(1000-400+1)+400;
        }
        this.cod = "A-" + num;
    }
}
