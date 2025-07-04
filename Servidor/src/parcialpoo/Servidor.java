package parcialpoo;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author eddor
 */
public class Servidor {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(5000);
            System.out.println("Servidor escuchando en el puerto 5000...");

            while (true) {
                Socket socketCliente = serverSocket.accept();
                System.out.println("Cliente conectado desde " + socketCliente.getInetAddress());
                    new Thread(new ManejadorCliente(socketCliente)).start();
            }
        } catch (IOException e) {
            System.out.println("Error en el servidor: " + e.getMessage());
        }
    }
    /// En el método run:
    /// ■ Obtenga los flujos de entrada/salida
    /// ■ Lea el nombre y el número del cliente
    /// ■ Calcule el cuadrado del número
    /// ■ Obtenga la fecha y hora actual
    /// ■ Envíe la respuesta formateada al cliente
    /// ■ Cierre los recursos adecuadamente
    }

