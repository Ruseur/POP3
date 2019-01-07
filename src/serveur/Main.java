package serveur;

import client.ClientController;

import java.io.IOException;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.util.Scanner;

public class Main {

    private static final int PORT = 8888;

    public static void main(String[] args){
        commandHandler();
    }

    public static ServeurController serveurFactory() throws IOException {
        return new ServeurController(PORT);
    }

    public static void startServeur() throws Exception {
        ServeurController serveur =  serveurFactory();

        serveur.start();
    }

    public static void commandHandler(){
        Scanner sc = new Scanner(System.in);
        String command;
        System.out.println("Serveur POP3 Interactif");
        do{
            System.out.println("Port d'écoute actuel: "+ PORT);
            System.out.println("Que voulez vous faire? (!start | !exit)");
            command = sc.nextLine();
            switch (command){
                case "!start":
                    System.out.println("Démarrage");
                    try {
                        startServeur();
                    } catch (Exception e) {
                        System.out.println("Démarrage du serveur impossible.");
                        System.out.println("Erreur suivante: " + e.getLocalizedMessage());
                    }
                    break;
                case "!exit":
                    System.out.println("A bientôt");
                    break;
                default:
                    System.out.println("Non reconnu");
                    break;
            }
        } while(!command.equals("!exit"));
    }
}
