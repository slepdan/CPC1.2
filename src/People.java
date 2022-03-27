public class People {
    String fam, ima, otch;
    int voz, raz_odejdi;

    public People(String fam, String ima, String otch, int voz, int raz_odejdi) {

    }

    public People() {

    }

    @Override
    public String toString() {
        return "fam='" + fam + '\'' +
                " ima='" + ima + '\'' +
                " otch='" + otch + '\'' +
                " voz=" + voz +
                " raz_odejdi=" + raz_odejdi;
    }
}
