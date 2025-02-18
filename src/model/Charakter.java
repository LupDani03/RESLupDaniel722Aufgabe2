package model;

import java.util.List;

public class Charakter {
    int id;
    String name;
    String dorf;
    List<Produkt> listeProdukte;

    public Charakter(int id, String name, String dorf, List<Produkt> listeProdukte) {
        this.id = id;
        this.name = name;
        this.dorf = dorf;
        this.listeProdukte = listeProdukte;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDorf() {
        return dorf;
    }

    public void setDorf(String dorf) {
        this.dorf = dorf;
    }

    public List<Produkt> getListeProdukte() {
        return listeProdukte;
    }

    public void setListeProdukte(List<Produkt> listeProdukte) {
        this.listeProdukte = listeProdukte;
    }

    @Override
    public String toString() {
        return "Charaktere{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", dorf='" + dorf + '\'' +
                ", listeProdukte=" + listeProdukte +
                '}';
    }

    public boolean richtigeRegion(String herkunfstRegion) {
        for (Produkt p : this.listeProdukte) {
            if (p.getHerkunfstregion().equals(herkunfstRegion)) {
                return true;
            }
        }
        return false;
    }

}