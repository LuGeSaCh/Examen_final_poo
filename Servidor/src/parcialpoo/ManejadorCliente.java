package parcialpoo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.time.LocalDateTime;



/**
 *
 * @author eddor
 */
public class ManejadorCliente implements Runnable {

    private Socket socketCliente;

    public ManejadorCliente(Socket socketCliente) {
        this.socketCliente = socketCliente;
    }

    /// En el método run:
    @Override
    public void run() {
                try{
                    /// ■ Obtenga los flujos de entrada/salida
                    InputStream inputStream = socketCliente.getInputStream();
                    OutputStream outputStream = socketCliente.getOutputStream();


                    /// ■ Lea el nombre y el número del cliente
                    BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

                    System.out.println("Cliente" + nombre + "conectado");
                    ///  constructor de writer
                    PrintWriter writer = new PrintWriter(outputStream, true);

                    String Nombre = reader.readLine();


                    /// ■ Calcule el cuadrado del número
                    int Num = Integer.parseInt(reader.readLine());
                    Num = Num * Num;

                    /// ■ Obtenga la fecha y hora actual
                    LocalDateTime fechaHoraActual = LocalDateTime.now();

                    /// ■ Envíe la respuesta formateada al cliente
                    String respuesta = "¡Bienvenido, " + Nombre +
                                "!\n"
                                + "El cuadrado de tu número es: " + Num +
                                "\n"
                                + "Fecha y hora del servidor: " + fechaHoraActual;

                    writer.println(respuesta);

                    /// ■ Cierre los recursos adecuadamente
                    socketCliente.close();
                    System.out.println("Cliente" + nombre + "desconectado");
                }

                catch(IOException e){
                    System.out.println(e);
            }

        }

    }
