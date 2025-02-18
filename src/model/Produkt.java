package model;

public class Produkt {
    String name;
    double preis;
    String herkunfstregion;

    public Produkt(String name, double preis, String herkunfstregion) {
        this.name = name;
        this.preis = preis;
        this.herkunfstregion = herkunfstregion;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPreis() {
        return preis;
    }

    public void setPreis(double preis) {
        this.preis = preis;
    }

    public String getHerkunfstregion() {
        return herkunfstregion;
    }

    public void setHerkunfstregion(String herkunfstregion) {
        this.herkunfstregion = herkunfstregion;
    }

    @Override
    public String toString() {
        return "Produkt{" +
                "Name='" + name + '\'' +
                ", Preis=" + preis +
                ", Herkunfstregion='" + herkunfstregion + '\'' +
                '}';
    }

    public double compareTo(Object o) {
        return this.getPreis() - ((Produkt) o).getPreis();
    }
}
