import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;


public class Deck{
    private List <String> suits = Arrays.asList("Clubs", "Diamonds", "Hearts", "Spades");
	private List <String> rank =Arrays.asList(null, "Ace", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King");
public  List<String>  makeDeck(List<String> deck) {
for(int i =0; i<4;i++){
	for (int y=1;y<14;y++){
		deck.add(rank.get(y)+" of "+suits.get(i));
	}
}
return deck;
}
public  Integer[] makeDecknum(Integer[] deck) {
for (int i =0; i < deck.length; i++ ){
deck[i]=i;}
return deck;
}
public  List<String>  makeDeckrep(List<String> deck, Integer[] decknum) {
	
for (int i =0;i < decknum.length;i++){
	Integer place = decknum[i];
	String place2= deck.get((int)place);
	deck.remove((int)place);
	deck.add(i,place2);
}
return deck;
}
}
