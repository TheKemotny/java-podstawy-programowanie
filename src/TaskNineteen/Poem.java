package TaskNineteen;

public class Poem {
    private Author creator;
    private int stropheNumbers;

    public Poem() {
    }

    public Poem(Author creator, int stropheNumbers) {
        this.creator = creator;
        this.stropheNumbers = stropheNumbers;
    }

    public Poem(String authorSurname, String authorNationality, int stropheNumbers) {
        this.creator = new Author(authorSurname, authorNationality);
        this.stropheNumbers = stropheNumbers;
    }

    public Author getCreator() {
        return creator;
    }

    public void setCreator(Author creator) {
        this.creator = creator;
    }

    public int getStropheNumbers() {
        return stropheNumbers;
    }

    public void setStropheNumbers(int stropheNumbers) {
        this.stropheNumbers = stropheNumbers;
    }

    public String getAuthorSurname(){
        return this.creator.getSurname();
    }

    @Override
    public String toString() {
        return "Poem{" +
                "creator=" + creator +
                ", stropheNumbers=" + stropheNumbers +
                '}';
    }


}
