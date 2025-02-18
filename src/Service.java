import model.Charakter;
import model.Produkt;

import java.util.ArrayList;
import java.util.List;

public class Service {

    private Repository<Produkt> produktRepository;
    private Repository<Charakter> charaktereRepository;

    public Service(Repository<Charakter> charaktereRepository, Repository<Produkt> produktRepository) {
        this.charaktereRepository = charaktereRepository;
        this.produktRepository = produktRepository;
    }

    public List<Charakter> alleCharakterenZuruckgeben() {
        return charaktereRepository.getAllElements();
    }

    public List<Produkt> alleProdukteZuruckgeben() {
        return produktRepository.getAllElements();
    }

    public void createAProdukt(String name, int preis, String jahreszeit) {
        produktRepository.addElement(new Produkt(name, preis, jahreszeit));
    }

    public Produkt getProdukt(String name) {
        int id = -1;
        for (Produkt p : produktRepository.getAllElements()) {
            if (p.getName().equals(name)) {
                id = produktRepository.getAllElements().indexOf(p);
                break;
            }
        }
        return produktRepository.getElement(id);
    }

    public void updateProdukt(Produkt produkt) {
        for (Produkt p : produktRepository.getAllElements()) {
            if (p.getName().equals(produkt.getName())) {
                int index = produktRepository.getAllElements().indexOf(p);
                p.setPreis(produkt.getPreis());
                p.setHerkunfstregion(produkt.getHerkunfstregion());
                produktRepository.updateElement(index, produkt);
                break;
            }
        }
    }

    public void deleteProdukt(String name) {
        for (Produkt p : produktRepository.getAllElements()) {
            if (p.getName().equals(name)) {
                produktRepository.remove(p);
                break;
            }
        }
    }

    public void createACharaktere(String name, String ort) {
        int id = -1;
        for (Charakter k : charaktereRepository.getAllElements()) {
            if (id < k.getId())
                id = k.getId();
        }
        id += 1;

        charaktereRepository.addElement(new Charakter(id, name, ort, new ArrayList<>()));
    }

    public Charakter getCharaktere(int id) {
        for (Charakter p : charaktereRepository.getAllElements()) {
            if (p.getId() == id)
                return p;
        }
        throw new RuntimeException("Charakter nicht gefunden");
    }

    public void updateCharaktere(Charakter charakter) {
        for (Charakter p : charaktereRepository.getAllElements()) {
            if (p.getId() == charakter.getId()) {
                int index = charaktereRepository.getAllElements().indexOf(p);
                p.setName(charakter.getName());
                p.setDorf(charakter.getDorf());
                charaktereRepository.updateElement(index, p);
                break;
            }
        }
    }

    public void deleteCharaktere(int id) {
        for (Charakter p : charaktereRepository.getAllElements()) {
            if (p.getId() == id) {
                charaktereRepository.remove(p);
                break;
            }
        }
    }


    public List<Charakter> filterNachOrt(String dorf) {
        List<Charakter> charaktereList = new ArrayList<>();
        charaktereList = charaktereRepository.getAllElements().stream().filter(Charaktere -> dorf.equals(Charaktere.getDorf())).toList();

        return charaktereList;
    }
}
