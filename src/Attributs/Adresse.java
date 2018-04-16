package Attributs;

import java.io.Serializable;
import java.util.Scanner;

/**
 * Created by PagNi1731620 on 2018-03-01.
 */

public class Adresse implements Serializable{
    private static final String tableauPays[]={"Canada","États-Unis","Brésil","France","Espagne","Mexique","Portugal"};
    private  static final String tableauProvince[]={"Québec","Ontario","Nouveau-Brunswick","IPE","T-N-L","Manitoba","Alberta","C-B"};
    private String numeroPorte;
    private String rue;
    private String appartement;
    private String ville;
    private String province;
    private String pays;
    private String input;

    public String getNumeroPorte() {return numeroPorte;}
    public String getRue() {return rue;}
    public String getAppartement() {return appartement;}
    public String getVille() {return ville;}
    public String getProvince() {return province;}
    public String getPays() {return pays;}

    public void setNumeroPorte(String numeroPorte) {this.numeroPorte = numeroPorte;}
    public void setRue(String rue) {this.rue = rue;}
    public void setAppartement(String appartement) {this.appartement = appartement;}
    public void setVille(String ville) {this.ville = ville;}
    public void setProvince(String province) {this.province = province;}
    public void setPays(String pays) {this.pays = pays;}

    public static Adresse creerAdresse(){
        Adresse adresse=new Adresse();
        Scanner sc= new Scanner(System.in);
        System.out.println("Création de l'adresse.");
        System.out.println("Numéro de porte?");
        adresse.setNumeroPorte(sc.next());
        System.out.println("Rue?");
        adresse.setRue(sc.next());
        System.out.println("Appartement(falcutatif)?");
        adresse.setAppartement(sc.next());
        System.out.println("Pays?");
        adresse.setPays(choixPays());
        if (adresse.getPays().equals("Canada")){
            adresse.setProvince();
        }

        System.out.println("Ville?");
        adresse.setVille(sc.next());

        return adresse;
    }
    public void modifierAdresse(){
        Scanner sc= new Scanner(System.in);
        System.out.println("Modification de l'adresse.");
        System.out.println("Numéro de porte: "+numeroPorte);
        input=sc.nextLine().trim();
        if (!input.equals("")){
            setNumeroPorte(input);
        }
        System.out.println("Rue: "+rue);
        input=sc.nextLine().trim();
        if (!input.equals("")){
            setRue(input);
        }
        System.out.println("Appartement(facultatif): "+appartement);
        input=sc.nextLine().trim();
        if (!input.equals("")){
            setAppartement(input);
        }
        System.out.println("Ville: "+ville);
        input=sc.nextLine().trim();
        if (!input.equals("")){
            setVille(input);
        }
        System.out.println("Province: "+province);
        input=sc.nextLine().trim();
        if (!input.equals("")){
            setProvince(input);
        }
        System.out.println("Pays: "+pays);
        input=sc.nextLine().trim();
        if (!input.equals("")){
            setPays(input);
        }
    }
    public void afficherAdresse(){
        System.out.println("Numéro de porte: "+numeroPorte);
        System.out.println("Rue: "+rue);
        System.out.println("Appartement: "+appartement);
        System.out.println("Ville: "+ville);
        System.out.println("Province: "+province);
        System.out.println("Pays: "+pays);
    }
   public static String choixPays(){
        int pays=0;
        boolean ok3=false;
        while (!ok3){
            ok3=true;
            for (int i=0;i<7;i++){
                System.out.println(i +"-"+tableauPays[i]);
            }
            Scanner sc = new Scanner(System.in);

            try {
                pays=sc.nextInt();

            }catch (Exception nombre){
                System.out.println("Veuillez entrer un nombre de 0 à 6.");
                ok3=false;
            }
        }
        return tableauPays[pays];
    }
    public static String choixProvince(){

    }
}

