package prodotti;
import java.util.HashMap;
import java.util.Map;

public class main {

	public static void main(String[] args) {
		HashMap<String, Double> ProdottoPrezzo= new HashMap <String, Double>();
		ProdottoPrezzo.put("Laptop", 1200.50);
        ProdottoPrezzo.put("Smartphone", 850.00);
        ProdottoPrezzo.put("Tablet", 300.75);
        ProdottoPrezzo.put("Cuffie", 150.20);
        ProdottoPrezzo.put("Smartwatch", 280.99);
        
        	for (String i : ProdottoPrezzo.keySet()) {
			System.out.println("Prodotto: " + i);
        	}
        
        	for (Map.Entry<String, Double> entry : ProdottoPrezzo.entrySet()) {
        	
        			if (entry.getValue()>550) {
        			System.out.println("Prodotto con prezzo maggiore di 550 euro: " + entry.getKey());
        			}
        	}
        	int somma= 0;
        	int numerop= 0;
        	for (double prezzo : ProdottoPrezzo.values()) {
        	somma += prezzo;
        	numerop++;	
        	}
        	int pmedio = somma/numerop;
        	System.out.println("Il oprezzo medio è: " + pmedio);
    } 
}
