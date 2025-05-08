package prodotti;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;
import prodotti.GestioneUtente.UtenteAutenticato;
import prodotti.GestioneUtente.utente;

public class GestioneMain {

	public static void main(String[] args) {
		
		ArrayList<utente> users = new ArrayList<utente>();
		
		try {
			String riga;
    		BufferedReader lettura = new BufferedReader(new FileReader("utenti.txt"));
    		while ((riga = lettura.readLine()) != null) {
    			utente utente1 = new utente(riga);
    			users.add(utente1);
    			System.out.println("Utente caricato: " + utente1.toString());
            }
    		lettura.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
		
		UtenteAutenticato utenteAutenticato = new UtenteAutenticato(); //istanza vuota perchè l'utente non ha ancora fatto la login
		
		int opzione;
		Scanner scanner = new Scanner(System.in);
		
		
		 do {
			 
			 System.out.println("Scegli la tua operazione:");
			 System.out.println("1. Registrazione");
			 System.out.println("2. Login");
			 if(utenteAutenticato.isAuthenticated()) {
				 System.out.println("3. Logout");
				 System.out.println("4. Visualizza Prodotti");
			 }
			 
			 if(utenteAutenticato.isAdmin()) {
				 System.out.println("5. Modifica");
				 System.out.println("6. Rimuovi");
				 System.out.println("7. Inserisci Prodotti");
			 }
			 System.out.println("8. Esci");
			 opzione = scanner.nextInt();
			 scanner.nextLine();
				
			 switch (opzione) {
			 
			 case 1:
				 System.out.println("Registrazione:");
			 try {
				 utente nuovoutente = new utente();
	        	 FileWriter writer = new FileWriter("utenti.txt", true);
	        	 if (users.isEmpty()) {
	        		 nuovoutente.id = 1;
	        	 }
	        	 else {
	        		 nuovoutente.id = users.get(users.size() - 1).id+1;
	        	 }
	        	 System.out.println("Nome:");
	        	 nuovoutente.nome = scanner.nextLine();
		         System.out.println("cognome:");
		         nuovoutente.cognome = scanner.nextLine();
		         System.out.println("E-mail:");
		         nuovoutente.mail = scanner.nextLine();
		         System.out.println("Indirizzo di spedizione:");
		         nuovoutente.indirizzo = scanner.nextLine();
		         System.out.println("Password:");
		         nuovoutente.password = scanner.nextLine();
		         users.add(nuovoutente);
		         writer.write("\n" + nuovoutente.toString());
	             writer.close();
	             System.out.println("Registrato con successo!");
	         } 
			 catch (IOException e) {
	             System.out.println("Errore.");
	             e.printStackTrace();
	             }
			 break;
			 
			 case 2:
				 System.out.println("Login:");
				 System.out.println("E-mail:");
		         String mail = scanner.nextLine();
		         System.out.println("Password:");
		         String password = scanner.nextLine();
		         
		         for (int i=0; i<users.size(); i++) {
		        	 utente individuo = users.get(i);
		        	 if (individuo.mail.equals(mail) && individuo.password.equals(password)) {
		        		 utenteAutenticato = new UtenteAutenticato(individuo);
		        	 }
		         }
		         break;
			 case 3:
				 System.out.println("Logout effettuato.");
				 utenteAutenticato = new UtenteAutenticato(); // nuova istanza vuota per il logout
				 break;
			 case 4:
				 System.out.println("Prodotti presenti nello store:");
				 

	} 
		 } while (opzione !=5);
	}

}

