package client;

import client.ClientController;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.util.Scanner;

public class Main {

    public static void main(String[] args){
        commandHandler();
    }

    public static void commandHandler(){
        Scanner sc = new Scanner(System.in);
        String command;
        do{
            System.out.println("Que voulez vous faire? (!afficher | !exit)");
            command = sc.nextLine();
            switch (command){
                case "!afficher":
                    afficherMails();
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

    public static ClientController clientFactory(){
        return new ClientController();
    }

    public static void afficherMails(){
        ClientController client = clientFactory();
        client.afficherMails();
    }
}
