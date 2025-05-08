package Gestione1;

public class GestioneUtente {

public static class utente {
	
public Integer id;
public String nome;
public String cognome;
public String mail;
public String indirizzo;
public String password;

public String toString() {

return id + "," + nome + "," + cognome + "," + mail + "," + indirizzo + "," + password;
};//metodo che ritorna la stringa da salvare nel file txt,serializzazione


public utente() {} //costruttore per l'utente vuoto


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

if(utente != null)

{

this.id = utente.id;

this.mail = utente.mail;

this.password = utente.password;

}

}


public Boolean isAuthenticated() {

return this.id != 0;

}; //se ha l'id è autenticato


public Boolean isAdmin() {

return this.isAuthenticated() && this.mail.equals("lucrelongo400@gmail.com");

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
}
