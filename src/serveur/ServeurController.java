package serveur;

import java.net.DatagramSocket;
import java.util.Scanner;

public class ServeurController {

    private int etat = CONNEXION;
    private boolean estDispo = true;

    private DatagramSocket socket;

    private static final byte CONNEXION = 0;
    private static final byte AUTORISATION = 1;
    private static final byte TRANSACTION = 2;

    public ServeurController(int port){
        super();
        try{
            this.socket = new DatagramSocket(port);
        } catch(Exception e) {
            e.printStackTrace();
            this.socket = null;
        }
    }

    public int start() throws Exception {
        if(this.etat != CONNEXION){
            throw new Exception("Accès non-autorisé");
        }
        System.out.println("Démarrage du serveur");

        throw new Exception("Non supporté");
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
