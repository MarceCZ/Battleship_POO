package Package.Clases;
import java.util.Random;

public class Destructor extends Barco{

    public Destructor(String orientacion) {
        super(orientacion);
    }

    @Override
    public void AsignarNombre() {
        this.nombre = "Destructor";
    }
    

    @Override
    public void Damage() {
        this.vida = this.vida - 50;
    }

    @Override
    public void AsignarEspacio() {
        this.espacio = 2;
    }

    @Override
    public void AsignarVida() {
        this.vida = 100;
    }

    @Override
    public void GenerarCodigo() {
        Random rd = new Random();
        int num;
        num = rd.nextInt(300-100+1)+100;
        while(num%2!=0){
            num = rd.nextInt(300-100+1)+100;
        }
        this.cod = "D-" + num;
    }
    
    @Override
    public String Mensaje() {
        return "El destructor ha sido HUNDIDO\n";
    }
}
