package serveur;

import org.omg.CORBA.Environment;

import java.io.*;
import java.net.DatagramSocket;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ServeurController {

    private int etat = CONNEXION;
    private boolean estDispo = true;

    private ServerSocket socket;
    private InputStream inputStream = null;
    private OutputStream outputStream = null;
    private BufferedInputStream bufferedInputStream = null;
    private BufferedOutputStream bufferedOutputStream = null;

    private static final byte CONNEXION = 0;
    private static final byte AUTORISATION = 1;
    private static final byte TRANSACTION = 2;

    public ServeurController(int port) throws IOException {
        super();
        this.socket = new ServerSocket(port);
    }

    public void start() throws Exception {
        System.out.println("Démarrage du serveur");
        System.out.println("Écoute du serveur sur le port "+this.socket.getLocalPort());

        Socket connexionSocket = this.socket.accept();
        inputStream = connexionSocket.getInputStream();
        outputStream = connexionSocket.getOutputStream();
        bufferedInputStream = new BufferedInputStream(inputStream);
        bufferedOutputStream = new BufferedOutputStream(outputStream);

        System.out.println("Connexion au serveur depuis la machine " + connexionSocket.getInetAddress().getHostAddress() + ":" + connexionSocket.getLocalPort());
        String request = "";
        if (this.etat != CONNEXION) {
            request = this.getRequest();
        }

    }

    private String getRequest() throws IOException {
        byte[] requestBytes = new byte[0];
        byte[] tempBytes = new byte[0];
        byte[] currentBytes = new byte[0];
        boolean end = false;
        // Wait until there is something in the buffer
        while(this.bufferedInputStream.available() == 0) {}
        while (!end) {
            currentBytes = requestBytes;
            tempBytes = new byte[this.bufferedInputStream.available()];
            this.bufferedInputStream.read(tempBytes);
            requestBytes = new byte[currentBytes.length + tempBytes.length];

            System.arraycopy(currentBytes,0,requestBytes,0         ,currentBytes.length);
            System.arraycopy(tempBytes,0,requestBytes,currentBytes.length,tempBytes.length);

            end = (requestBytes[requestBytes.length - 2] == Byte.valueOf("\r") && requestBytes[requestBytes.length - 1] == Byte.valueOf("\n"));
        }
        return new String(requestBytes);
    }

    public int apop() throws Exception {
        if(this.etat != AUTORISATION){
            throw new Exception("Accès non-autorisé");
        }

        throw new Exception("Non supporté");
    }
    public int retr() throws Exception {
        if(this.etat != TRANSACTION){
            throw new Exception("Accès non-autorisé");
        }


        throw new Exception("Non supporté");
    }

    public int quit() throws Exception {
        if(this.etat != TRANSACTION){
            throw new Exception("Accès non-autorisé");
        }


        throw new Exception("Non supporté");
    }

}
