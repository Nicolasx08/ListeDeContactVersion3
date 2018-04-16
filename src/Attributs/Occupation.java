package Attributs;

import java.io.Serializable;
import java.util.Scanner;

/**
 * Created by PagNi1731620 on 2018-03-01.
 */
public class Occupation implements Serializable{
    private String poste;
    Entreprise entreprise= new Entreprise();
    private String input;

    public String getPoste() {return poste;}
    public Entreprise getEntreprise() {return entreprise;}

    public void setPoste(String poste) {this.poste = poste;}
    public void setEntreprise(Entreprise entreprise) {this.entreprise = entreprise;}

    public static Occupation creerOccupation(){
        Scanner sc= new Scanner(System.in);
        Occupation occupation=new Occupation();
        System.out.println("Quelle est votre occupation(poste)?");
        occupation.setPoste(sc.next());
        System.out.println("Entreprise: ");
        Entreprise entreprise=Entreprise.creerEntreprise();
        occupation.setEntreprise(entreprise);
        return occupation;
    }
    public void modifierOccupation(){
        Scanner sc= new Scanner(System.in);
        System.out.println("Occupation: "+poste);
        input=sc.nextLine().trim();
        if (!input.equals("")){
            setPoste(input);
        }
        System.out.println("Entreprise: ");
        entreprise.modifierEntreprise();

    }
    public void afficherOccupation(){
        System.out.println("Poste: "+poste);
        System.out.println("Entreprise: ");
        entreprise.afficherEntreprise();
    }
}
