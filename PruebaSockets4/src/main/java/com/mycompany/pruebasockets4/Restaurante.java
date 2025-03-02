package com.mycompany.pruebasockets4;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Restaurante {

    public static void main(String[] args) {

        final String HOST = "localhost";
        final int PUERTO_LOCAL = 5001;
        Socket sc = null;
        ObjectInputStream ois = null;
        ObjectOutputStream oos = null;

        try {
            sc = new Socket(HOST, PUERTO_LOCAL);
            System.out.println("Conectado al servidor");

            ois = new ObjectInputStream(sc.getInputStream());
            oos = new ObjectOutputStream(sc.getOutputStream());

            System.out.println("RECIBIENDO OBJECTO");
            Orden orden = (Orden) ois.readObject();
            System.out.println(orden);
            System.out.println("OBJECTO RECIBIDO");

            Orden confirmacion = new Orden(orden.getType());

            System.out.println("ENVIANDO OBJECTO");
            oos.writeObject(confirmacion);
            oos.flush();
            System.out.println(confirmacion);
            System.out.println("OBJECTO ENVIADO");

        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(Restaurante.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (ois != null) {
                    ois.close();
                }
                if (oos != null) {
                    oos.close();
                }
                if (sc != null) {
                    sc.close();
                }
            } catch (IOException ex) {
                Logger.getLogger(Restaurante.class.getName()).log(Level.SEVERE, "Error al cerrar los recursos", ex);
            }
        }

    }

}
