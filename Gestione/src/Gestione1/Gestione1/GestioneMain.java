package Gestione1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import Gestione1.GestioneProdotto.Prodotto;
import Gestione1.GestioneUtente.Utente;
import Gestione1.GestioneUtente.Utente.UtenteAutenticato;

public class GestioneMain {

	public static void main(String[] args) {
		//Lettura del file "utenti.txt"
		//Il file viene caricato all'interno di un ArrayList<utente>
			
	    String nomeFileUtenti = "utenti.txt";
	    File fileUtenti = new File(nomeFileUtenti);

	    ArrayList<Utente> utenti = new ArrayList<Utente>();
	    if(!fileUtenti.exists()) {	
	    	try (FileWriter fileWriter = new FileWriter(nomeFileUtenti)) {
	    		System.out.println("Il file " + nomeFileUtenti + " è stato creato corretatmente");
	        } 
	    	catch (IOException e) 
	    	{
	    		System.err.println("Si è verificato un errore durante la creazione del file " + nomeFileUtenti + ": " + e.getMessage());
	 	    }
	    } else {
	    	try {
	    		String riga;
				BufferedReader letturaUtenti = new BufferedReader(new FileReader(nomeFileUtenti));
				while ((riga = letturaUtenti.readLine()) != null) {
					Utente utente = new Utente(riga);
					utenti.add(utente);
					System.out.println("Utente caricato: " + utente.toString());
				}
				
				letturaUtenti.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
	    }
	        
	        
	    String nomeFileProdotti = "prodotti.txt";
	    File fileProdotti = new File(nomeFileProdotti);

	    ArrayList<Prodotto> prodotti = new ArrayList<Prodotto>();
	    if(!fileProdotti.exists()) {	
	    	try (FileWriter fileWriter = new FileWriter(nomeFileProdotti)) {
	    		System.out.println("Il file " + nomeFileProdotti + " è stato creato corretatmente");
	        } 
	    	catch (IOException e) 
	    	{
	    		System.err.println("Si è verificato un errore durante la creazione del file " + nomeFileProdotti + ": " + e.getMessage());
	    	}
	    } else {
	    	try {
	    		String riga;
	    		BufferedReader letturaProdotti = new BufferedReader(new FileReader(nomeFileProdotti));
				while ((riga = letturaProdotti.readLine()) != null) {
					Prodotto prodotto = new Prodotto(riga);
					prodotti.add(prodotto);
	
					System.out.println("prodotto caricato: " + prodotto.toString());
				}

				letturaProdotti.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
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
	
					try (FileWriter fileWriter = new FileWriter("utenti.txt", true)) { // Aggiungi al file
						Utente nuovoUtente = new Utente();
	
						if (utenti.isEmpty()) {
							nuovoUtente.setId(1);
						} else {
							nuovoUtente.setId(utenti.get(utenti.size() - 1).getId()+ 1);
						}
	
						System.out.println("Nome:");
						nuovoUtente.setNome(scanner.nextLine()) ;
	
						System.out.println("cognome:");
						nuovoUtente.setCognome(scanner.nextLine());
	
						System.out.println("E-mail:");
						nuovoUtente.setMail(scanner.nextLine());
	
						System.out.println("Indirizzo di spedizione:");
						nuovoUtente.setIndirizzo(scanner.nextLine());
	
						System.out.println("Password:");
						nuovoUtente.setPassword(scanner.nextLine());
	
						utenti.add(nuovoUtente);
	
						fileWriter.write(nuovoUtente.toString() + "\n"); // Scrivi i dati dell'utente nel file
						System.out.println("Registrato con successo!");
	
					} catch (IOException e) {
						System.out.println("Errore durante la registrazione.");
						e.printStackTrace();
					}
	
					break;
	
	    		case 2:		
	    			System.out.println("Login");

	    			System.out.println("E-mail:");
	    			String mail = scanner.nextLine();
		
	    			System.out.println("Password:");
	    			String password = scanner.nextLine();
		
					for (int i=0; i< utenti.size(); i++) {
						Utente utente = utenti.get(i);
		
						if (utente.getMail().equals(mail) && utente.getPassword().equals(password)) {
							utenteAutenticato = new UtenteAutenticato(utente);
						}
					}
		
					break;
				case 3:
					System.out.println("Logout effettuato.");
					utenteAutenticato = new UtenteAutenticato(); // nuova istanza vuota per il logout
		
					break;
				case 4:
					System.out.println("Prodotti presenti nello store:");

					break;
				}
	
			} while (opzione !=8);
		}
	}

			


