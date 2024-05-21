import java.io.IOException;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {

        Scanner lectura = new Scanner(System.in);

        ConsultarPelicula consulta = new ConsultarPelicula();

        System.out.println("Escriba el número de la pelicula de SW que quiere consultar");

        try {
            var numeroDePelicula = Integer.valueOf(lectura.nextInt());
            Pelicula pelicula = consulta.bucarPelicula(numeroDePelicula);
            System.out.println(pelicula);
            GeneradorDeArchivo generador = new GeneradorDeArchivo();
            generador.guardarJson(pelicula);
        } catch(NumberFormatException e){
            System.out.println("Número no encontrado" + e.getMessage());
        } catch(RuntimeException | IOException e){
            System.out.println(e.getMessage());
            System.out.println("Finalizando la apliación");
        }

    }
}
