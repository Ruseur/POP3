package serveur;

import client.ClientController;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.util.Scanner;

public class Main {

    private static final int PORT = 110;

    public static void main(String[] args){
        startServeur();
    }

    public static ServeurController serveurFactory(){
        return new ServeurController(PORT);
    }

    public static void startServeur(){
        ServeurController serveur =  serveurFactory();

        try{
            serveur.start();
        } catch (Exception e){
            System.err.println(e.getMessage());
        }
    }

    public static void commandHandler(){
        Scanner sc = new Scanner(System.in);
        String command;
        do{
            System.out.println("Que voulez vous faire? (!afficher | !exit)");
            command = sc.nextLine();
            switch (command){
                case "!login":
                    System.out.println("Connexion");
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
