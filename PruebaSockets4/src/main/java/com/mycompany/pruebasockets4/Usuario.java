package com.mycompany.pruebasockets4;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Usuario {

    public static void main(String[] args) {

        Orden orden = new Orden(1);

        final String host = "127.0.0.1";
        final int puerto = 5000;
        ObjectInputStream ois;
        ObjectOutputStream oos;

        try (Socket sc = new Socket(host, puerto)) {
            System.out.println("Conectado al servidor");

            ois = new ObjectInputStream(sc.getInputStream());
            oos = new ObjectOutputStream(sc.getOutputStream());
            
            oos.flush();

            System.out.println("ENVIANDO OBJECTO");
            oos.writeObject(orden);
            oos.flush();
            System.out.println("OBJECTO ENVIADO");

            Orden ordenRespuesta = (Orden) ois.readObject();
            System.out.println(ordenRespuesta);
            System.out.println("OBJECTO RECIBIDO");

        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
