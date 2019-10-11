import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class Players{
public List <String> hands(List <String> deck,List <String> Player ){

String Card1= deck.get(0);
String Card2 = deck.get(1);
Player.add(Card1);
Player.add(Card2);
return Player;
}

public List<String> Deckr(List <String> deck) {
deck.remove(0);
deck.remove(0);

return deck;
}



}
