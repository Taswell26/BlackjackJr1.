import java.util.Scanner;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class BlackjackFunctions{
	
public List <String> Hit(List <String> deck,List <String> player) {
String Card = deck.get(0);
player.add(Card);
return player;
}

public List <String> SplitHand(List<String> player, String card) {

player.add(card);
//System.out.println(player);
return player;
	
}

public List<String> Deckr(List <String> deck) {
deck.remove(0);
return deck;
}

}
