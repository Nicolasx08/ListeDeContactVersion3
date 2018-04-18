import Attributs.*;
import java.io.*;
import java.util.*;


public class ListeDeContactDynamique implements Serializable {
    static HashMap<String, Contact> map = new HashMap<>();
    static Queue<Contact> listeRappel=new LinkedList<>();
 public static void main(String[] args) {
     int decision = 0;
     boolean quitter = false;
     String choix = "l";
     boolean listePasFini = false;
     Scanner sc = new Scanner(System.in);

     while (!listePasFini) {
         quitter = false;
         while (!quitter) {
             System.out.println("1-Ajouter un contact.");
             System.out.println("2-Modifier un contact.");
             System.out.println("3-Afficher un contact.");
             System.out.println("4-Supprimer un contact.");
             System.out.println("5-Ajouter un contact à la liste de rappel.");
             System.out.println("6-Voir la liste de rappel.");
             System.out.println("7- Charger les données.");
             System.out.println("8- Quitter");
             try {
                 String var = sc.nextLine();
                 decision = Integer.parseInt(var);
             } catch (Exception lettre) {
                 System.out.println("Entrez un chiffre valide entre 1 et 8.");
                 decision=0;
             }
             switch (decision) {
                 case 1:
                     Contact contact = Contact.creerContact();
                     map.put(contact.getNom(), contact);
                     break;
                 case 2:

                     System.out.println("Quel est le prénom du contact que vous voulez modifier?");
                     choix = sc.next();
                     if (map.get(choix) != null) {
                         map.get(choix).modifierContact();
                     } else if (!choix.equals(map.get(choix).getNom())) {
                         map.put(map.get(choix).getNom(), map.get(choix));
                         map.remove(choix);
                     } else {
                         System.out.println("Le contact n'existe pas!");
                     }
                     break;
                 case 3:
                     map.forEach((k, contact2) -> {
                         contact2.afficherContact();
                     });
                     break;
                 case 4:
                     System.out.println("Quel est le prenom du contact ?");
                     choix = sc.next();
                     if (map.get(choix) != null) {
                         map.remove(choix);
                     } else {
                         System.out.println("Le contact n'existe pas");
                     }
                     break;
                 case 5:
                     System.out.println("Quel est le prénom du contact?");
                     choix = sc.next();
                     if (map.get(choix) != null) {
                         listeRappel.add(map.get(choix));
                     } else {
                         System.out.println("Le contact n'existe pas.");
                     }
                     break;
                 case 6:
                     if (listeRappel.peek() != null) {
                         System.out.println("Le contact a rappelé au plus tôt est " + listeRappel.peek().getNom() + " " + listeRappel.poll().getNomDeFamille());
                     } else {
                         System.out.println("Il n'y a aucun contact à rappeler");
                     }
                     break;
                 case 7:
                     Charger();
                     break;
                 case 8:
                     System.out.println("Bye!Bye!");
                     Sauvegarde();
                     quitter=true;
                     System.exit(0);
                     break;
             }
         }
     }
    }
    static void Sauvegarde(){
     try {
         ObjectOutputStream sortie = new ObjectOutputStream( new BufferedOutputStream( new FileOutputStream("monfichier.dat")));
         sortie.writeObject(map);
         sortie.writeObject(listeRappel);
         sortie.close();
     }catch (Exception IO){
        System.out.println("CELA N'A PAS SAUVEGARDÉ!");
     }
    }
    static void Charger(){
        try {
            ObjectInputStream entree = new ObjectInputStream(new BufferedInputStream(new FileInputStream("monfichier.dat")));
            map= (HashMap<String,Contact>)entree.readObject();
            listeRappel= (Queue<Contact>)entree.readObject();
            entree.close();
        }catch (Exception IO2){
            System.out.println("Fichier inexistant.");
        }

    }
 }