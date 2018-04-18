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
        adresse.setNumeroPorte(chiffre());
        System.out.println("Rue?");
        adresse.setRue(sc.next());
        System.out.println("Appartement(falcutatif)?");
        adresse.setAppartement(chiffre());
        adresse.setPays(choixPays());
        if (adresse.getPays().equals("Canada")){
            adresse.setProvince(choixProvince());
        }

        System.out.println("Ville?");
        adresse.setVille(sc.next());

        return adresse;
    }
    public void modifierAdresse(){
        Scanner sc= new Scanner(System.in);
        System.out.println("Modification de l'adresse.");
        System.out.println("Numéro de porte: "+numeroPorte);
        setNumeroPorte(chiffre());
        System.out.println("Rue: "+rue);
        input=sc.nextLine().trim();
        if (!input.equals("")){
            setRue(input);
        }
        System.out.println("Appartement(facultatif): "+appartement);
       setAppartement(chiffre());
        System.out.println("Pays: "+pays);
        setPays(choixPays());
        if (pays.equals("Canada")){
            System.out.println("Province: "+province);
            setProvince(choixProvince());
        }
        System.out.println("Ville: "+ville);
        input=sc.nextLine().trim();
        if (!input.equals("")){
            setVille(input);
        }


    }
    public void afficherAdresse(){
        System.out.println("Numéro de porte: "+numeroPorte);
        System.out.println("Rue: "+rue);
        System.out.println("Appartement: "+appartement);
        System.out.println("Pays: "+pays);
        if (pays.equals("Canada")){
            System.out.println("Province: "+province);
        }
        System.out.println("Ville: "+ville);
    }
   public static String choixPays(){
        int pays=0;
        boolean ok3=false;
        while (!ok3){
            ok3=true;
            System.out.println("Pays?");
            for (int i=0;i<tableauPays.length;i++){
                System.out.println(i +"- "+tableauPays[i]);
            }
            Scanner sc = new Scanner(System.in);

            try {
                pays=sc.nextInt();

            }catch (Exception nombre){
                System.out.println("Veuillez entrer un nombre de 0 à 6.");
                ok3=false;
            }
            if (pays<0 || pays>tableauPays.length){
                System.out.println("Entrez un nombre entre 0 et 6");
                ok3=false;
            }
        }
        return tableauPays[pays];
    }
    public static String choixProvince(){
        int province=0;
        boolean ok4=false;
        while (!ok4){
            ok4=true;
            System.out.println("Province?");
            for (int i=0;i<tableauProvince.length;i++){
                System.out.println(i+"- "+tableauProvince[i]);
            }
            Scanner sc = new Scanner(System.in);

            try{
                province=sc.nextInt();
            }catch (Exception nombre1){
                System.out.println("Entrez une province dans la liste svp!");
                ok4=false;
            }
            if (province<0 || province>tableauProvince.length){
                System.out.println("Entrez un nombre entre 0 et 6");
                ok4=false;
            }
        }
        return tableauProvince[province];
    }
    public static String chiffre(){
        Scanner sc =new Scanner(System.in);
        boolean ok5=false;
        String choix1="0";
        int test=0;
        while (!ok5){
            ok5=true;
                choix1=sc.nextLine();
                for (int i=0;i<choix1.length();i++) {
                    test = (int) choix1.charAt(i);
                    if (57 < test || 48 > test) {
                        System.out.println("Vous devez mettre un chiffre à la position " + i);
                        ok5 = false;
                    }
                }
        }
        return choix1;
    }
}

