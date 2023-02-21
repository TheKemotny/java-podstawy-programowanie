package TaskNineteen;

public class Main {
    public static String printSurnameOfAuthorWithLongestPoem(Poem... poems){
        if(poems.length == 0) {
            return "";
        }
        String resultSurname = poems[0].getAuthorSurname();
        int longestPoem = poems[0].getStropheNumbers();
        for(int i = 1; i < poems.length; i++) {
            if(poems[i].getStropheNumbers() > longestPoem) {
                resultSurname = poems[i].getAuthorSurname();
                longestPoem = poems[i].getStropheNumbers();
            }
        }
        return resultSurname;
    }

    public static void main(String[] args) {
        Poem[] poems = new Poem[3];
        Author mickiewicz = new Author("Mickiewicz", "polska");
        Poem arcymistrz = new Poem(mickiewicz, 4);
        poems[0] = arcymistrz;
        Poem ulamki = new Poem("Słowacki", "polska", 10);
        poems[1] = ulamki;
        Poem paniTwardkowskaBallada = new Poem();
        paniTwardkowskaBallada.setCreator(mickiewicz);
        paniTwardkowskaBallada.setStropheNumbers(31);
        poems[2] = paniTwardkowskaBallada;
        System.out.println("IN OUR TABLE OF POEMS LONGEST POEM IS WRITTEN BY " + printSurnameOfAuthorWithLongestPoem(poems));
    }
}
