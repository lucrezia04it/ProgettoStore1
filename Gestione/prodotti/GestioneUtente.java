package prodotti;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;
import prodotti.GestioneUtente.UtenteAutenticato;
import prodotti.GestioneUtente.utente;


public class GestioneUtente {
	
	public static class utente {
		public Integer id;
		public String nome;
		public String cognome;
		public String mail;
		public String indirizzo;
		public String password;
		
		
		public Utente() {
        } // Costruttore per l'utente vuoto
		
		@Override
		public String toString() {
			return id + "," + nome + "," + cognome + "," + mail + "," + indirizzo + "," + password;
		};//metodo che ritorna la stringa da salvare nel file txt,serializzazione
		
		 public static class UtenteAutenticato extends Utente {
		        public UtenteAutenticato() {
		            this.id = 0; // Inizializza l'id a 0 per indicare non autenticato
		        }
		}
		
		public utente(String linea) {
			String[] DatiUtente = linea.split(",");
			Integer id = Integer.valueOf(DatiUtente[0]);
			this.id = id;
			this.nome = DatiUtente[1];
			this.cognome = DatiUtente[2];
			this.mail = DatiUtente[3];
			this.indirizzo = DatiUtente[4];
			this.password = DatiUtente[5];
		}//deserializzazioe
	}
	public static class UtenteAutenticato extends utente {
		public UtenteAutenticato() {
			this.id = 0;
		}
		public UtenteAutenticato(utente utente) //oggetto
		{ 
			public UtenteAutenticato(Utente utente) { // Costruttore che accetta un oggetto Utente
	            if (utente != null) { //aggiunto controllo null
	            	 public Integer getId() { return id; }
	            	    public String getNome() { return nome; }
	            	    public String getCognome() { return cognome; }
	            	    public String getMail() { return mail; }
	            	    public String getIndirizzo() { return indirizzo; }
	            	    public String getPassword() { return password; } //incapsulamemto
	            }
			}
		
			 public Boolean isAuthenticated() {
			        return this.getId() != 0;
			    };

			    public Boolean isAdmin() {
			        return this.isAuthenticated() && "lucrelongo400@gmail.com".equals(this.getMail());
			    };
	}
	
	public static class Prodotto {
		private String nome;
        private double prezzo;

        public Prodotto(String nome, double prezzo) { //facciamo un costruttore con dei parametri
            this.nome = nome;
            this.prezzo = prezzo;
        }

        public String getNome() {
            return nome;
        }

        public double getPrezzo() {
            return prezzo;
        }

        public String toString() {
            return "Nome: " + nome + ", Prezzo: " + prezzo;
        }
	}




//crere una sezione utenti con id(email), 
//nome, cognome, indirizzo, login, logout
//menù principale, inserimento, modifica, visualizza, rimozione