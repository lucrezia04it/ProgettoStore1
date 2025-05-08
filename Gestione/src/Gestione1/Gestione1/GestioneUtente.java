package Gestione1;

public class GestioneUtente {
	public static class Utente {

		private Integer id;
		private String nome;
		private String cognome;
		private String mail;

		public Integer getId() { return id;	}
		public void setId(Integer id) {
			this.id = id;
		}

		public String getNome() {
			return nome;
		}

		public void setNome(String nome) {
			this.nome = nome;
		}

		public String getCognome() {
			return cognome;
		}

		public void setCognome(String cognome) {
			this.cognome = cognome;
		}

		public String getMail() {
			return mail;
		}

		public void setMail(String mail) {
			this.mail = mail;
		}

		public String getIndirizzo() {
			return indirizzo;
		}

		public void setIndirizzo(String indirizzo) {
			this.indirizzo = indirizzo;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		private String indirizzo;
		private String password;

		//Metodo utilizzato per la serializzazione dell'oggetto, in maniera da salvarlo all'interno del file "utenti.txt"
		public String toString() {
			return id + "," + nome + "," + cognome + "," + mail + "," + indirizzo + "," + password + "\n";
		}

		//Costruttore vuoto per l'inizializzazione di Utente
		public Utente() {}

		//Costruttore che riceve in input una riga del file "utenti.txt" che viene deserializzata 
		public Utente(String rigaFile) {	
			String[] DatiUtente = rigaFile.split(",");

			Integer id = Integer.valueOf(DatiUtente[0]);
			this.id = id;
			this.nome = DatiUtente[1];
			this.cognome = DatiUtente[2];
			this.mail = DatiUtente[3];
			this.indirizzo = DatiUtente[4];
			this.password = DatiUtente[5];

		}

		//Classe utlizzata per la gestione di un utente atenticato 	
		public static class UtenteAutenticato extends Utente {
			public UtenteAutenticato(Utente utente)
			{
				if(utente != null)
				{
					this.setId(utente.getId());
					this.setNome(utente.getNome());
					this.setCognome(utente.getCognome());
					this.setMail(utente.getMail());	
				}
			}

			public UtenteAutenticato() {
				this.setId(0);
			}

			public Boolean isAuthenticated() {
				return this.getId() != 0;
			}; //se ha l'id è autenticato


			public Boolean isAdmin() {
				return this.isAuthenticated() && this.getMail().equals("lucrelongo400@gmail.com");
			}
		}
	}
}

