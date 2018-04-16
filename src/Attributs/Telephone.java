package Attributs;

import java.io.Serializable;
import java.util.Scanner;

/**
 * Created by PagNi1731620 on 2018-03-01.
 */
public class Telephone implements Serializable{
    static boolean ok;
    private String type;
    private String numero;
    private String input;

    public String getType() {return type;}
    public String getNumero() {return numero;}

    public void setType(String type) {this.type = type;}
    public void setNumero(String numero) {this.numero = numero;}

    public static Telephone creerTel(){
        Scanner sc = new Scanner(System.in);
        Telephone nouveauTelephone = new Telephone();
        System.out.println("Téléphone");
        nouveauTelephone.setType(typeTel());
        nouveauTelephone.setNumero(formatNumeroTel());
        return nouveauTelephone;
    }
    public void modifierTel(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Téléphone");
    System.out.println("Type: "+type);
    input=sc.nextLine().trim();
    if (!input.equals("")){
        setType(input);
    }
    System.out.println("numero: "+numero);
    input=sc.nextLine().trim();
    if (!input.equals("")){
        setNumero(input);
    }
    }
    public void afficherTel(){
        System.out.println("Téléphone: ");
        System.out.println("Type: "+type);
        System.out.println("Numéro: "+ numero);
    }
    static String typeTel(){
        boolean ok2= false;
        Scanner sc = new Scanner(System.in);
        String type = "";
        while (!ok2) {
            ok2=true;
        System.out.println("Entrez un type de téléphone.(Maison,Portable,Travail,Autre)");
        type= sc.next();
            if (!type.equals("Maison") && !type.equals("Portable") && !type.equals("Travail") && !type.equals("Autre")) {
                System.out.println("Veuillez entrez un type de téléphone valide.");
                ok2=false;
            }
            else if (type.equals("Autre")) {
                System.out.println("Entrez votre type de téléphone.");
                type = sc.next();
            }
        }
        return type;
    }
    static String formatNumeroTel(){
        Scanner sc = new Scanner(System.in);
        String nbeChiffre="";
        int nombre=0;
        boolean ok1=false;
        while (!ok1) {
            System.out.println("Quelle est votre numéro?(xxx-xxx-xxxx)");
            nbeChiffre=sc.nextLine();
            ok1=true;
            if (nbeChiffre.length() != 12) {
                System.out.println("Vous n'avez pas entré un bon num de tel.");
                ok1=false;
            }
            else if (nbeChiffre.charAt(3) != '-' && nbeChiffre.charAt(7) != '-') {
                System.out.println("Entrez un numero avec des tirets aux places 3 et 7.(suivre l'exemple)");
                ok1=false;
            }
            else {
                for (int i=0;i<12;i++){
                   nombre= (int)nbeChiffre.charAt(i);
                   if (i==3 || i==7){
                   } else if (57<nombre || 48>nombre){
                       System.out.println("Le chiffre a la position "+i+" n'est pas bon.");
                       ok1=false;
                   }
                }
            }

        }
        return nbeChiffre;
    }
}

