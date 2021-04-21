package ie.tudublin;

public class Note {
    private int duaration;
    private char note;

    
    public Note(int duaration, char note) {
        this.duaration = duaration;
        this.note = note;
    }
    public int getDuaration() {
        return duaration;
    }
    public void setDuaration(int duaration) {
        this.duaration = duaration;
    }
    public char getNote() {
        return note;
    }
    public void setNote(char note) {
        this.note = note;
    }

    public String toStringQ() {
        return note + "\t" + duaration + "\t" + "Quaver";
    }

    public String toStringC() {
        return note + "\t" + duaration + "\t" + "Crotchet";
    }
    
    
}
