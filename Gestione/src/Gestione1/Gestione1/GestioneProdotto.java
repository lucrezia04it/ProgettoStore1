package Gestione1;

public class GestioneProdotto{
	public static class Prodotto {
		private Integer id;
		private String nome;
		private Double prezzo;

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		};
		
		public String getNome() {
			return nome;
		}

		public void setNome(String nome) {
			this.nome = nome;
		}

		public Double getPrezzo() {
			return prezzo;
		}

		public void setPrezzo(Double prezzo) {
			this.prezzo = prezzo;
		}

		public Prodotto(String linea) {		
			String[] ElencoProdotti = linea.split(",");

			this.nome = ElencoProdotti[0];
			this.prezzo = Double.valueOf(ElencoProdotti[1]);
		}

		public String toString() {
			return nome + "," + prezzo + "\n";
		}

	}
}