package type;

/**
 * класс для описания структуры заметок: дата - заметка
 */
public class Journal {
    private String date;//Дата
    private String note;//Заметка

    public Journal() {
    }

    public Journal(String date, String note) {
        this.date = date;
        this.note = note;
    }


    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public String toString() {
        return "Journal{" +
                "date='" + date + '\'' +
                ", note='" + note + '\'' +
                '}';
    }
}
