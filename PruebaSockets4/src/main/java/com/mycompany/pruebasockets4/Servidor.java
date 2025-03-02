package com.mycompany.pruebasockets4;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Servidor {

    private static final int PUERTO_USUARIO = 5000;
    private static final int PUERTO_RESTAURANTE = 5001;
    private static ObjectInputStream oisRestaurante = null;
    private static ObjectOutputStream oosRestaurante = null;
    private static Socket scRestaurante = null;

    public static void main(String[] args) {
        try (ServerSocket servidorUsuario = new ServerSocket(PUERTO_USUARIO); 
             ServerSocket servidorRestaurante = new ServerSocket(PUERTO_RESTAURANTE)) {
            System.out.println("Servidor disponible..");

            new Thread(() -> {
                try {
                    while (true) {
                        Socket scUsuario = servidorUsuario.accept();
                        System.out.println("Cliente Usuario conectado: " + scUsuario.getInetAddress().getHostAddress());
                        new Thread(new ClienteUsuarioHandler(scUsuario)).start();
                    }
                } catch (IOException ex) {
                    Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, "Error en el servidor para el usuario", ex);
                }
            }).start();

            while (true) {
                Socket scRestaurante = servidorRestaurante.accept();
                System.out.println("Cliente Restaurante conectado: " + scRestaurante.getInetAddress().getHostAddress());
                new Thread(new ClienteRestauranteHandler(scRestaurante)).start();
            }

        } catch (IOException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private static class ClienteRestauranteHandler implements Runnable {

        private final Socket socketRestaurante;
        private ObjectInputStream oisRestaurante;
        private ObjectOutputStream oosRestaurante;

        public ClienteRestauranteHandler(Socket socketRestaurante) {
            this.socketRestaurante = socketRestaurante;
        }

        @Override
        public void run() {
            try {
                oisRestaurante = new ObjectInputStream(socketRestaurante.getInputStream());
                oosRestaurante = new ObjectOutputStream(socketRestaurante.getOutputStream());

                System.out.println("RECIBIENDO OBJECTO");
                Orden orden = (Orden) oisRestaurante.readObject();
                System.out.println(orden);
                System.out.println("OBJECTO RECIBIDO");

                Orden confirmacion = new Orden(orden.getType());

                System.out.println("ENVIANDO OBJECTO");
                oosRestaurante.writeObject(confirmacion);
                oosRestaurante.flush();
                System.out.println(confirmacion);
                System.out.println("OBJECTO ENVIADO");

            } catch (IOException | ClassNotFoundException ex) {
                Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                try {
                    if (oisRestaurante != null) {
                        oisRestaurante.close();
                    }
                    if (oosRestaurante != null) {
                        oosRestaurante.close();
                    }
                    if (socketRestaurante != null) {
                        socketRestaurante.close();
                    }
                } catch (IOException ex) {
                    Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, "Error al cerrar recursos del Cliente Restaurante", ex);
                }
            }
        }

    }

    private static class ClienteUsuarioHandler implements Runnable {

        private final Socket socketUsuario;
        private ObjectInputStream oisUsuario;
        private ObjectOutputStream oosUsuario;

        public ClienteUsuarioHandler(Socket socketUsuario) {
            this.socketUsuario = socketUsuario;
        }

        @Override
        public void run() {
            try {

                System.out.println("x");

                oisUsuario = new ObjectInputStream(socketUsuario.getInputStream());
                oosUsuario = new ObjectOutputStream(socketUsuario.getOutputStream());

                System.out.println("RECIBIENDO OBJECTO");
                Orden orden = (Orden) oisUsuario.readObject();
                System.out.println(orden.toString());
                System.out.println("OBJECTO RECIBIDO");

                if (scRestaurante == null || scRestaurante.isClosed()) {
                    scRestaurante = new Socket("localhost", PUERTO_RESTAURANTE);
                    oisRestaurante = new ObjectInputStream(scRestaurante.getInputStream());
                    oosRestaurante = new ObjectOutputStream(scRestaurante.getOutputStream());
                }

                System.out.println("ENVIANDO OBJECTO");
                oosRestaurante.writeObject(orden);
                oosRestaurante.flush();
                System.out.println(orden);
                System.out.println("OBJECTO ENVIADO");

                System.out.println("RECIBIENDO OBJECTO");
                Orden ordenConfirmacion = (Orden) oisRestaurante.readObject();
                System.out.println(ordenConfirmacion);
                System.out.println("OBJECTO RECIBIDO");

                System.out.println("ENVIANDO OBJECTO");
                oosUsuario.writeObject(ordenConfirmacion);
                oosUsuario.flush();
                System.out.println("OBJECTO ENVIADO");

            } catch (IOException | ClassNotFoundException ex) {
                Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                try {
                    if (oisUsuario != null) {
                        oisUsuario.close();
                    }
                    if (oosUsuario != null) {
                        oosUsuario.close();
                    }
                    if (socketUsuario != null) {
                        socketUsuario.close();
                    }
                } catch (IOException ex) {
                    Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, "Error al cerrar recursos del Cliente Usuario", ex);
                }
            }
        }

    }

}
