import model.Charakter;
import model.Produkt;

import java.util.ArrayList;
import java.util.Scanner;

public class Controller {
    private final Service service;

    public Controller(Service service) {
        this.service = service;
    }

    public void alleProdukteAnschreiben() {
        for (Produkt produkt : service.alleProdukteZuruckgeben())
            System.out.println(produkt);
    }

    public void alleCharakterenAnschreiben() {
        for (Charakter charaktere : service.alleCharakterenZuruckgeben())
            System.out.println(charaktere);
    }

    public void createProdukt() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Name: ");
        String name = sc.nextLine();
        System.out.println("Preis: ");
        int preis = sc.nextInt();
        sc.nextLine();
        System.out.println("Herkunfstregion");
        String herkunfstregion = sc.nextLine();

        service.createAProdukt(name, preis, herkunfstregion);
    }

    public void showAProdukt() {
        System.out.println("Gebe den Namen des Produktes ein: ");
        Scanner sc = new Scanner(System.in);
        String name = sc.nextLine();
        Produkt produkt = service.getProdukt(name);
        System.out.println(produkt);
    }

    public void updateProduktValidate() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Name des Produktes, das geandert werden soll: ");
        String name = sc.nextLine();
        System.out.println("Preis: ");
        int preis = sc.nextInt();
        sc.nextLine();
        System.out.println("Herkunfstregion:");
        String herkunfstregion = sc.nextLine();

        service.updateProdukt(new Produkt(name, preis, herkunfstregion));
    }

    public void deleteProdukt() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Name des Produktes, das geloescht werden soll: ");
        String name = sc.nextLine();
        service.deleteProdukt(name);
    }

    public void createCharaktere() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Name: ");
        String name = sc.nextLine();
        System.out.println("Ort: ");
        String ort = sc.nextLine();

        service.createACharaktere(name, ort);
    }

    public void showCharaktere() {
        System.out.println("ID des Kundes:");
        Scanner sc = new Scanner(System.in);
        int id = sc.nextInt();
        sc.nextLine();
        System.out.println(service.getCharaktere(id));
    }

    public void updateCharaktereValidate() {
        Scanner sc = new Scanner(System.in);

        System.out.println("ID des Charakteres, das geandert werden soll: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.println("Neuer Name: ");
        String name = sc.nextLine();
        System.out.println("Neuer Ort: ");
        String ort = sc.nextLine();

        Charakter charaktere = new Charakter(id, name, ort, new ArrayList<>());
        service.updateCharaktere(charaktere);
    }

    public void deleteCharaktere() {
        Scanner sc = new Scanner(System.in);
        System.out.println("ID des Kunden, der geloescht werden soll: ");
        int id = sc.nextInt();
        sc.nextLine();
        service.deleteCharaktere(id);
    }

    public void charaktereNachOrtFiltrieren() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ort: ");
        String ort = sc.nextLine();
        for (Charakter charaktere : service.filterNachOrt(ort))
            System.out.println(charaktere);
    }
}
