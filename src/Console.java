import model.Charakter;
import model.Produkt;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Console {

    private Controller controller;

    public Console(Controller controller) {
        this.controller = controller;
    }

    public Console() {
    }

    public void setController(Controller controller) {
        this.controller = controller;
    }

    public void run() {
        Scanner sc = new Scanner(System.in);
        int option = -1;
        while (option != 0) {
            System.out.println("""
                    1. Alles anschreiben
                    2. Produkt CRUD
                    3. Charaktere CRUD
                    0. Exit""");

            option = sc.nextInt();
            sc.nextLine();

            switch (option) {
                case 1: {
                    controller.alleCharakterenAnschreiben();
                    controller.alleProdukteAnschreiben();
                    break;
                }
                case 2: {
                    System.out.println("""
                            1. Neues Produkte hinzufugen
                            2. Alle Produkte sehen
                            3. Ein bestimmtes Produkte finden
                            4. Ein Produkte aktualisieren
                            5. Ein Produkte loschen
                            0. Exit""");
                    int crudOption = sc.nextInt();
                    sc.nextLine();
                    switch (crudOption) {
                        case 1: {
                            controller.createProdukt();
                            break;
                        }
                        case 2: {
                            controller.alleProdukteAnschreiben();
                            break;
                        }
                        case 3: {
                            controller.showAProdukt();
                            break;
                        }
                        case 4: {
                            controller.updateProduktValidate();
                            break;
                        }
                        case 5: {
                            controller.deleteProdukt();
                            break;
                        }
                        case 0:
                            break;
                    }
                }
                case 3: {
                    System.out.println("""
                            1. Neuer Charaktere hinzufugen
                            2. Alle Charakteren sehen
                            3. Einen bestimmten Charakteren finden
                            4. Einen Charakteren aktualisieren
                            5. Einen Charakteren loschen
                            6. Charakteren nach Ort filtrieren
                            0. Exit""");
                    int crudOption = sc.nextInt();
                    sc.nextLine();
                    switch (crudOption) {
                        case 1: {
                            controller.createCharaktere();
                            break;
                        }
                        case 2: {
                            controller.alleCharakterenAnschreiben();
                            break;
                        }
                        case 3: {
                            controller.showCharaktere();
                            break;
                        }
                        case 4: {
                            controller.updateCharaktereValidate();
                            break;
                        }
                        case 5: {
                            controller.deleteCharaktere();
                            break;
                        }
                        case 6: {
                            controller.charaktereNachOrtFiltrieren();
                            break;
                        }
                        case 0:
                            break;
                    }
                }
                case 0:
                    break;
            }
        }

    }

    public static void main(String[] args) {

        Repository<Produkt> produktRepository = new Repository<>();
        Repository<Charakter> charaktereRepository = new Repository<>();

        Console console = new Console();
        console.initialiseData(charaktereRepository, produktRepository);

        Service service = new Service(charaktereRepository, produktRepository);
        Controller controller = new Controller(service);

        console = new Console(controller);
        console.run();
    }

    public void initialiseData(Repository<Charakter> charakterRepository, Repository<Produkt> produktRepository) {
        // Initialisierung der Produkte
        List<Produkt> produkte = new ArrayList<>();
        produkte.add(new Produkt("Kunai", 50.0, "Konoha"));
        produkte.add(new Produkt("Shuriken", 30.0, "Konoha"));
        produkte.add(new Produkt("Schwert", 200.0, "Kirigakure"));
        produkte.add(new Produkt("Heiltrank", 100.0, "Sunagakure"));
        produkte.add(new Produkt("Sprengsiegel", 75.0, "Iwagakure"));
        produkte.add(new Produkt("Riesenfächer", 300.0, "Sunagakure"));
        produkte.add(new Produkt("Giftklinge", 150.0, "Kirigakure"));
        produkte.add(new Produkt("Explosionskugel", 250.0, "Iwagakure"));
        produkte.add(new Produkt("Schattendolch", 180.0, "Konoha"));
        produkte.add(new Produkt("Wasserperle", 90.0, "Kirigakure"));
        produktRepository.addElement(produkte.get(0));
        produktRepository.addElement(produkte.get(1));
        produktRepository.addElement(produkte.get(2));
        produktRepository.addElement(produkte.get(3));
        produktRepository.addElement(produkte.get(4));
        produktRepository.addElement(produkte.get(5));
        produktRepository.addElement(produkte.get(6));
        produktRepository.addElement(produkte.get(7));
        produktRepository.addElement(produkte.get(8));
        produktRepository.addElement(produkte.get(9));

        // Initialisierung der Charaktere
        List<Charakter> charaktere = new ArrayList<>();
        List<Produkt> listeCharaktere1 = new ArrayList<>();
        listeCharaktere1.add(produkte.get(0));
        listeCharaktere1.add(produkte.get(3));
        listeCharaktere1.add(produkte.get(8));
        listeCharaktere1.add(produkte.get(5));
        Charakter c1 = new Charakter(1, "Naruto Uzumaki", "Konoha", listeCharaktere1);

        List<Produkt> listeCharaktere2 = new ArrayList<>();
        listeCharaktere2.add(produkte.get(2));
        listeCharaktere2.add(produkte.get(4));
        listeCharaktere2.add(produkte.get(6));
        listeCharaktere2.add(produkte.get(1));
        Charakter c2 = new Charakter(2, "Gaara", "Sunagakure", listeCharaktere2);

        List<Produkt> listeCharaktere3 = new ArrayList<>();
        listeCharaktere3.add(produkte.get(1));
        listeCharaktere3.add(produkte.get(2));
        listeCharaktere3.add(produkte.get(3));
        listeCharaktere3.add(produkte.get(7));
        listeCharaktere1.add(produkte.get(9));
        Charakter c3 = new Charakter(3, "Kisame Hoshigaki", "Kirigakure", listeCharaktere3);

        List<Produkt> listeCharaktere4 = new ArrayList<>();
        listeCharaktere4.add(produkte.get(0));
        listeCharaktere4.add(produkte.get(4));
        listeCharaktere4.add(produkte.get(7));
        listeCharaktere4.add(produkte.get(9));
        Charakter c4 = new Charakter(4, "Deidara", "Iwagakure", listeCharaktere4);

        List<Produkt> listeCharaktere5 = new ArrayList<>();
        listeCharaktere5.add(produkte.get(8));
        listeCharaktere5.add(produkte.get(6));
        listeCharaktere5.add(produkte.get(2));
        listeCharaktere5.add(produkte.get(7));
        Charakter c5 = new Charakter(5, "Itachi Uchiha", "Konoha", listeCharaktere5);

        charaktere.add(c1);
        charakterRepository.addElement(c1);
        charaktere.add(c2);
        charakterRepository.addElement(c2);
        charaktere.add(c3);
        charakterRepository.addElement(c3);
        charaktere.add(c4);
        charakterRepository.addElement(c4);
        charaktere.add(c5);
        charakterRepository.addElement(c5);
    }
}
