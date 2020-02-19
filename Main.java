
import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Scanner;


public class Main {

	public static void main(String[] args) {
	
		ArrayList<Book> readBooks = fillReadList();	

		ArrayList<ArrayList<Book>> anneeDeLecture = trierParMois(readBooks);
	
		// Commandes tests :
		int numberOfBooksReadInAYear = numberOfBooksReadInAYear(anneeDeLecture);
		System.out.println("Nombre de livres lus en 2019 : " + numberOfBooksReadInAYear);
		
		ArrayList<Book> moisTest = anneeDeLecture.get(2); // Teste les fonctions sur le mois de mars.
		String strMoisTest = "mars";
		
		int numberOfBooksReadThisMonth = numberOfBooksReadThisMonth(moisTest);
		System.out.println("Nombre de livres lus en " + strMoisTest + " : " +numberOfBooksReadThisMonth);
		
		double averageReadPerMonth = averageReadPerMonth(anneeDeLecture);
		System.out.println("Moyenne de livres lus par mois : " + averageReadPerMonth);
		
		int numberOfPagesReadThisMonth = numberOfPagesReadThisMonth(moisTest);
		System.out.println("Nombre de pages lues en " + strMoisTest + " : " + numberOfPagesReadThisMonth);
		
		double averagePagesReadPerMonth = averagePagesReadPerMonth(anneeDeLecture);
		System.out.println("Moyenne de pages lues par mois : " + averagePagesReadPerMonth);
		
		double moneySpentThisMonth = moneySpentThisMonth(moisTest);
		System.out.println("Somme dépensée en " + strMoisTest + " : " + moneySpentThisMonth + " euros");
		
		double moneySpentInAYear = moneySpentInAYear(anneeDeLecture);
		System.out.println("Somme dépensée en 2019 : " + moneySpentInAYear + " euros");
		
		double averageMoneySpentPerMonth = averageMoneySpentPerMonth(anneeDeLecture);
		System.out.println("Somme dépensée en moyenne par mois : " + averageMoneySpentPerMonth + " euros");
		
		/*String favoriteGenreThisMonth = favoriteGenreThisMonth(moisTest);
		System.out.println("Genre(s) le(s) plus lu(s) en " + strMoisTest + " : " + favoriteGenreThisMonth);*/
		
		String titlesReadThisMonth = titlesReadThisMonth(moisTest);
		System.out.println("Liste des titres lus en " + strMoisTest+ " : " + titlesReadThisMonth);
		
		
	}
	
	
	

	/** 
	 * trierParMois : fonction qui trie les livres d'une liste entre 12 listes représentant les mois de l'année.
	 * @param readBooks
	 * @return Retourne une superListe de ces 12 listes.
	 */
	private static ArrayList<ArrayList<Book>> trierParMois(ArrayList<Book> readBooks) {
		ArrayList<Book> janvier = new ArrayList<Book>(); ArrayList<Book> fevrier = new ArrayList<Book>(); ArrayList<Book> mars = new ArrayList<Book>(); 
		ArrayList<Book> avril = new ArrayList<Book>(); ArrayList<Book> mai = new ArrayList<Book>(); ArrayList<Book> juin = new ArrayList<Book>(); 
		ArrayList<Book> juillet = new ArrayList<Book>(); ArrayList<Book> aout = new ArrayList<Book>(); ArrayList<Book> septembre = new ArrayList<Book>(); 
		ArrayList<Book> octobre = new ArrayList<Book>(); ArrayList<Book> novembre = new ArrayList<Book>(); ArrayList<Book> decembre = new ArrayList<Book>(); 
		
		ArrayList<ArrayList<Book>> anneeDeLecture = new ArrayList<ArrayList<Book>>();
		anneeDeLecture.add(janvier); anneeDeLecture.add(fevrier);anneeDeLecture.add(mars); anneeDeLecture.add(avril); anneeDeLecture.add(mai); anneeDeLecture.add(juin);
		anneeDeLecture.add(juillet); anneeDeLecture.add(aout); anneeDeLecture.add(septembre); anneeDeLecture.add(octobre); anneeDeLecture.add(novembre); anneeDeLecture.add(decembre); 
		
		
		ArrayList<String> monthsOfTheYear = new ArrayList<String>();
		monthsOfTheYear.add("Janvier"); monthsOfTheYear.add("Fevrier");monthsOfTheYear.add("Mars"); monthsOfTheYear.add("Avril"); monthsOfTheYear.add("Mai"); monthsOfTheYear.add("Juin"); 
		monthsOfTheYear.add("Juillet"); monthsOfTheYear.add("Aout"); monthsOfTheYear.add("Septembre"); monthsOfTheYear.add("Octobre"); monthsOfTheYear.add("Novembre"); monthsOfTheYear.add("Decembre"); 
		
		
		for (int i = 0; i<readBooks.size(); i++) {
			for (int j = 0; j<anneeDeLecture.size(); j++) {
				String s1 = readBooks.get(i).getMoisDeLecture();
				String s2 = monthsOfTheYear.get(j);
				if (s1.equals(s2)) {
					anneeDeLecture.get(j).add(readBooks.get(i));
					break;
					}
				}
			}
		return anneeDeLecture;
	}

	/**
	 * fillReadList : fonction qui remplit une liste d'objets "Book" à partir d'un fichier txt.
	 * @return liste d'objets "Book"
	 */
	private static ArrayList<Book> fillReadList() {
		ArrayList<Book> readBooks = new ArrayList<Book>();
		
		try {
		//Find the file
		File file = new File("ListeDeLivres.txt");
		
		//Create scanner
		Scanner scanner = new Scanner(file, "utf8");

		while (scanner.hasNextLine()) {
		
		//Read a line in the file
		String nextLine = scanner.nextLine();
		
		
		//Split the line
		String[] bookComponents = nextLine.split(", ");
		
		String strTitle = bookComponents[0];
		String strAuthor = bookComponents[1];
		String strEditor = bookComponents[2];
		String strGenre = bookComponents[3];
		String strNombreDePages = bookComponents[4];
		int intNombreDePages = Integer.parseInt(strNombreDePages);
		String strDateDeParution = bookComponents[5];
		int intDateDeParution = Integer.parseInt(strDateDeParution);
		String strDateDeLecture = bookComponents[6];
		String strPrice = bookComponents[7];
		double doublePrice = Double.parseDouble(strPrice);
		
		//Create a book
		Book lineBook = new Book(strTitle, strAuthor, strEditor, strGenre, intNombreDePages, intDateDeParution, strDateDeLecture, doublePrice);
		readBooks.add(lineBook);
		}
		
		scanner.close();
		
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return readBooks;
	}
	
	
	private static int numberOfBooksReadInAYear(ArrayList<ArrayList<Book>> list) {
		int result = 0;
		for (int i=0; i<list.size(); i++) {
			result += list.get(i).size();
		}
		return result;
	}
	
	private static int numberOfBooksReadThisMonth(ArrayList<Book> list) {
		int result = list.size();
		return result;
	}
	
	private static double averageReadPerMonth(ArrayList<ArrayList<Book>> list) {
		double result = (double)numberOfBooksReadInAYear(list);
		//Arrondi du double à retourner à 10^-2
		BigDecimal bd = new BigDecimal(result/12);
		bd = bd.setScale(2, BigDecimal.ROUND_DOWN);
		result = bd.doubleValue();
		return result;
	}
	
	private static int numberOfPagesReadThisMonth (ArrayList<Book> list) {
		int result = 0;
		for (int i=0; i<list.size(); i++) {
			result += list.get(i).getNombreDePages();
		}
		return result;
	}
	
	private static double averagePagesReadPerMonth(ArrayList<ArrayList<Book>> list){
		double result = 0;
		for (int i=0; i<list.size(); i++) {
			result += numberOfPagesReadThisMonth(list.get(i));
		}
		return result/12;
	}
	
	private static double moneySpentThisMonth(ArrayList<Book> list) {
		double result = 0;
		for (int i = 0; i<list.size(); i++) {
			result += list.get(i).getPrice();
		}
		return result;
	}
	
	private static double moneySpentInAYear(ArrayList<ArrayList<Book>> list){
		double result = 0;
		for (int i=0; i<list.size(); i++) {
			result += moneySpentThisMonth(list.get(i));
		}
		return result;
	}
	
	private static double averageMoneySpentPerMonth(ArrayList<ArrayList<Book>> list) {
		double result = 0;
		for (int i=0; i<list.size(); i++) {
			result += moneySpentThisMonth(list.get(i));
		}
		//Arrondi du double à retourner à 10^-2
		BigDecimal bd = new BigDecimal(result/12);
		bd = bd.setScale(2, BigDecimal.ROUND_DOWN);
		result = bd.doubleValue();
		return result;
	}
	/**
	 * Parcours les genres listés pour un mois donné et en retient celui qui apparait le plus de fois
	 * @param list
	 * @return le genre le plus lu (String)
	 */
	private static String favoriteGenreThisMonth(ArrayList<Book> list) {
		String result = "Pas de genre favori";
		// genres compilera les différents genres listés pour un mois donné
		ArrayList<String> genres = new ArrayList<String>();
		// counters est une liste qui servira à comptabiliser les apparitions de chaque genre pour un mois donné
		ArrayList<Integer> counters = new ArrayList<Integer>();
		genres.add(list.get(0).getGenre());
		counters.add(1);
		System.out.println("Etape 1");System.out.println(list.size());
		for (int i = 1; i<list.size(); i++) {
			String s1 = list.get(i).getGenre();
			for (int j = 0; j<genres.size(); j++) {
				
				String s2 = genres.get(j);
				//Si le genre n'existe pas dans la liste "genre", il y est ajouté ; un compteur pour ce nouveau genre est ajouté dans la liste "counters"
				if (!s1.equals(s2)) {
					genres.add(s1);
					counters.add(1);
				}
				//Si le genre existe déjà, la valeur de ce compteur est augmentée de 1
				else {
					Integer a = counters.get(j) + 1;
					counters.set(j, a);
				}System.out.println("Etape 2");System.out.println(counters.size());
			}
		}System.out.println("Etape 3");
		//Dans ce while, la liste "genres" est réduite à un élément, celui dont la valeur du compteur est la plus haute
		while (counters.size() != 1) {
			
			if (counters.get(0).intValue() < counters.get(1).intValue()) {
				counters.remove(0);
				genres.remove(0);
			}
			if (counters.get(0).intValue() > counters.get(1).intValue()) {
				counters.remove(1);
				genres.remove(1);
			}
			//Si 2 genres apparaissent le même nombre de fois, ils sont effacés et remplacés par un nouveau genre qui réuni les 2
			if (counters.get(0).intValue() == counters.get(1).intValue()) {
				String mixe = genres.get(0) + ", " + genres.get(1);
				genres.set(0, mixe);
				counters.remove(1);
				genres.remove(1);
			}
		}System.out.println("Etape 4");
		result = genres.get(0);
		return result;
	}
	
	private static String titlesReadThisMonth(ArrayList<Book> list) {
		String result = "Pas de titres lus ce mois-ci";
		if (list.size() != 0) {
			result = list.get(0).getTitle();
			for (int i = 1; i<list.size(); i++) {
			result += ", " +list.get(i).getTitle();
			}
		}
		return result;
	}
	
	
}
