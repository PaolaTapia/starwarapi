import java.io.IOException;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        ConsultaPelicula consulta = new ConsultaPelicula();
        System.out.println("Escribe el nro de pelicula a consultar: ");
        try {
            var nroPelicula = Integer.parseInt(entrada.nextLine());
            Pelicula pelicula = consulta.buscaPelicula(nroPelicula);
            System.out.println(pelicula);
            GeneradorDeArchivo generador= new GeneradorDeArchivo();
            generador.GuardarJson(pelicula);
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());
            System.out.println("Nro no encontrado");
        }catch (RuntimeException | IOException e) {
            System.out.println(e.getMessage());
            System.out.println("App finalizada");
        }

    }
}
