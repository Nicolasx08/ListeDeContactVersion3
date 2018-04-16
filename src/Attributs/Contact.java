package Attributs;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by PagNi1731620 on 2018-03-01.
 */
public class Contact implements Serializable{
    private String nom;
    private String nomDeFamille;
    private Adresse adresse;
    private Occupation occupation;
    private List<Telephone> liste= new ArrayList<>();

    public String getNom() {return nom;}
    public String getNomDeFamille() {return nomDeFamille;}
    public Adresse getAdresse() {return adresse;}
    public Occupation getOccupation() {return occupation;}
    public List<Telephone> getListe() {return liste;}

    public void setNom(String nom) {this.nom = nom;}
    public void setNomDeFamille(String nomDeFamille) {this.nomDeFamille = nomDeFamille;}
    public void setAdresse(Adresse adresse) {this.adresse = adresse;}
    public void setOccupation(Occupation occupation) {this.occupation = occupation;}
    public void setListe(List<Telephone> liste) {this.liste = liste;}

    public static Contact creerContact(){
        boolean ok= false;
        char rep='d';
        Contact contact = new Contact();
        Scanner sc = new Scanner(System.in);
        System.out.println("Quelle est le prénom de votre contact?");
        contact.setNom(sc.next());
        System.out.println("Quelle est le nom de famille de votre contact?");
        contact.setNomDeFamille(sc.next());
        Adresse adresse = Adresse.creerAdresse();
        Occupation occupation= Occupation.creerOccupation();
        contact.setAdresse(adresse);
        contact.setOccupation(occupation);
        while (!ok) {
            Telephone telephone= Telephone.creerTel();
            contact.getListe().add(telephone);
            System.out.println("Voulez-vous créer un autre num de tel?");
            rep=sc.next().toLowerCase().charAt(0);
            if (rep=='o'){
                ok=false;
            }
            else if (rep=='n'){
                ok=true;
            }
            else {
                System.out.println("Entrez une réponse valide.");
            }
        }

        return contact;
    }
    public void modifierContact(){
        String input="s";
        char choix = 'w';
        boolean ok= false;
        Scanner sc =new Scanner(System.in);
        System.out.println("Votre contact s'appelle(prénom): "+ nom);
        input=sc.nextLine().trim();
        if (!input.equals("")){
            setNom(input);
        }
        else {

        }
        System.out.println("Votre contact s'appelle(nom de famille): "+ nomDeFamille);
        input=sc.nextLine().trim();
        if (!input.equals("")){
            setNomDeFamille(input);
        }
        adresse.modifierAdresse();
        System.out.println("Occupation: ");
        occupation.modifierOccupation();
        for (Telephone telephone:liste) {
            telephone.modifierTel();
        }
        while (!ok){
            System.out.println("Voulez-vous entrer un nouveau numéro de téléphone?(o/n)");
            choix=sc.next().toLowerCase().charAt(0);
            if (choix=='o'){
                Telephone tel = new Telephone();
                System.out.println("De quelle type de téléphona s'agit-il?");
                tel.setType(sc.next());
                System.out.println("Quelle est le numéro?");
                tel.setNumero(sc.next());
                liste.add(tel);
            }
            else if (choix=='n'){
                ok=true;
            }
            else {
                System.out.println("Entrez une réponse valide.");
            }
        }


    }
    public void afficherContact(){
        System.out.println("Nom: "+nom);
        System.out.println("Nom de famille: "+nomDeFamille);
        adresse.afficherAdresse();
        System.out.println("Occupation");
        occupation.afficherOccupation();
        for (Telephone tel:liste){
            tel.afficherTel();
        }
    }


}
