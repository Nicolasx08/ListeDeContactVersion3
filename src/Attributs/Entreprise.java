package Attributs;

import java.io.Serializable;
import java.util.Scanner;

/**
 * Created by PagNi1731620 on 2018-03-01.
 */
public class Entreprise implements Serializable{
    private String nom;
    private Adresse adresseEntreprise;
    private String input;

    public String getNom() {return nom;}
    public Adresse getAdresseEntreprise() {return adresseEntreprise;}

    public void setNom(String nom) {this.nom = nom;}
    public void setAdresseEntreprise(Adresse adresseEntreprise) {this.adresseEntreprise = adresseEntreprise;}

    public static Entreprise creerEntreprise(){
        Scanner sc = new Scanner(System.in);
        Entreprise entreprise=new Entreprise();
        System.out.println("Quelle est le nom de votre entreprise?");
        entreprise.setNom(sc.next());
        Adresse adresse1= Adresse.creerAdresse();
        entreprise.setAdresseEntreprise(adresse1);
        return entreprise;
    }
    public void modifierEntreprise(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Entreprise");
        System.out.println("Nom: "+ nom);
        input=sc.nextLine().trim();
        if (!input.equals("")){
            setNom(input);
        }
        adresseEntreprise.modifierAdresse();
    }
    public void afficherEntreprise(){
        System.out.println("Nom: "+nom);
        adresseEntreprise.afficherAdresse();
    }
}
