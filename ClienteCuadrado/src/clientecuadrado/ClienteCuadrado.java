package clientecuadrado;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author eddor
 */
public class ClienteCuadrado {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try (
                //estableciendo conexion 
                Socket socket = new Socket("localhost", 5000); //metodos de entrada y salida de datos            
                InputStream inputStream = socket.getInputStream(); OutputStream outputStream = socket.getOutputStream(); PrintWriter writer = new PrintWriter(outputStream, true); BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream)); Scanner teclado = new Scanner(System.in);) {
            System.out.print("Ingresa tu nombre: ");
            String Nombre = teclado.nextLine();

            System.out.print("Ingrese un numero entero: ");
            int Num = teclado.nextInt();

            writer.println(Nombre);
            writer.println(Num);
            String respuesta = reader.readLine();
            System.out.println("Respuesta del servidor: " + respuesta);

            //Cerrando recursos
            writer.close();
            reader.close();
            teclado.close();
            socket.close();
        } catch (IOException e) {
            System.out.println("Eror en el cliente. " + e.getMessage());
        }
    }

}
