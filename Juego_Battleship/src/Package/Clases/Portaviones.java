package Package.Clases;
import java.util.Random;

public class Portaviones extends Barco{

    public Portaviones(String orientacion) {
        super(orientacion);
    }

    @Override
    public void AsignarNombre() {
        this.nombre = "Portaviones";
    }
    
    @Override
    public void GenerarCodigo() {
        Random rd = new Random();
        int num;
        num = rd.nextInt(700-500+1)+500;
        while(num%5!=0){
            num = rd.nextInt(700-500+1)+500;
        }
        this.cod = "P-" + num;
    }
    
    @Override
    public void Damage() {
        this.vida = this.vida - 40;
    }

    @Override
    public void AsignarEspacio() {
        this.espacio = 5;
    }

    @Override
    public void AsignarVida() {
        this.vida = 200;
    }

    @Override
    public String Mensaje() {
        return "El Portaviones ha sido HUNDIDO\n";
    }
    
}
