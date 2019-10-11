import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

class Blackjackmain{
	
public static List <String>  deck1 =new ArrayList <String>();
public static List <String>  Dealer =new ArrayList <String>();
public static List <String>  Player1 =new ArrayList <String>();
public static List <String>  Player2 =new ArrayList <String>();
public static List <String>  Player3 =new ArrayList <String>();
public static List <String>  Player4 =new ArrayList <String>();
public static List <String>  Player5 =new ArrayList <String>();
public static List <String>  Player6 =new ArrayList <String>();
public static List <String>  Player1D =new ArrayList <String>();
public static List <String>  Player2D =new ArrayList <String>();
public static List <String>  Player3D =new ArrayList <String>();
public static List <String>  Player4D =new ArrayList <String>();
public static List <String>  Player5D =new ArrayList <String>();
public static List <String>  Player6D =new ArrayList <String>();
public static List <String>  BurnCard =new ArrayList <String>();
public static List <String>  Bets =new ArrayList <String>();
public static Integer[] decknum= new Integer [52];
public static String Rank;
public static int player1DCount = 22;
public static int player2DCount = 22;
public static int player3DCount = 22;
public static int player4DCount = 22;


 
public static List<String>  deckmaking(List<String> deck){	
Deck d1= new Deck();
deck = d1.makeDeck(deck);
return deck; 	
}
public static Integer[] deckmakingnum(Integer[] decknum ){	
Deck d2= new Deck();
decknum = d2.makeDecknum(decknum);
return decknum; 	
}

public static Integer[] Shuffling(Integer[] deck){
Shuffle s1= new Shuffle();
deck= s1.Fisheryates(deck);
return deck; 
}
public static double ShufflingSha(Integer[] deck){
Shuffle s1= new Shuffle();	
return s1.shannonEntropy(deck); 
}

public static List<String> deckmakingrep(List<String> deck,Integer[] decknum){	
Deck d2= new Deck();
return d2.makeDeckrep(deck,decknum); 	
}
public static List<String> Hands(List<String> deck,List <String> player){	
Players p2 = new Players();
return p2.hands(deck, player); 	
}

public static List<String> removeh(List<String> deck){	
Players p2= new Players();
return p2.Deckr(deck); 	
}

public static int CountCards(List <String> player) {
Cards c1 = new Cards();
String c2 = "";
int count = 0;
for(int c = 0; c < player.size(); c++) {
c2 = player.get(c);
String Val = c1.Split(c2);
int value = c1.displayValue(Val);
count = count + value;
}
return count;
}

public static void ChooseOption(List <String> Player, int x) {
Scanner s = new Scanner(System.in);
System.out.println("Player " + x + " what option would you like to choose?: " + '\n' + "[1] Hit " + '\n'+ "[2] Stand " + '\n' + "[3] Double Down " + '\n' + "[4] Split " + '\n' + "[5] Surrender ");

String option = s.nextLine();
if(option.equals("1")) {
hit(deck1,Player);
}
if(option.equals("2") ){
} 
if(option.equals("3") ){
hit(deck1,Player); }

if(option.equals("4")){
	
String card1 = Player.get(0);
String card2 = Player.get(1);
String Rank1 = Split(card1);
String Rank2 = Split(card2);;

if(Rank1.equals(Rank2)) {
	Player.remove(1);
if(x == 1) {
   player1DCount = 0;
splitHand(Player1D, card2 );
}
if(x == 2) { 
	player2DCount = 0;
splitHand(Player2D, card2 );
}
if(x == 3) {
   player3DCount = 0;
splitHand(Player3D, card2 );
}
if(x == 4) {
	player4DCount = 0;
splitHand(Player4D, card2 );
}
}
}
}

public static String Split(String upCard) {		
String [] card = upCard.split(" ");
String givenRank = card[0];
return givenRank.toUpperCase();
}

public static void splitHand(List <String> PlayerD, String card) {
BlackjackFunctions b1 = new BlackjackFunctions();
b1.SplitHand(PlayerD, card);
	
}
public static void PlayerSelection(List <String>  dealer,List <String>  player1, List <String>  player2, List <String>  player3, List <String>  player4, List <String>  player5, List <String>  player6, List <String>  player1D, List <String>  player2D, List <String>  player3D, List <String>  player4D, List <String>  player5D, List <String>  player6D, List <String> burnCard, List <String> bets) {
Scanner s = new Scanner(System.in);
System.out.println("How many players would like to play against the dealer?");
int m = s.nextInt();
while(m < 1 || m > 4) {
System.out.println("Sorry, invalid number of players, only 1 to 4 players allowed!");	
m = s.nextInt();
}
if(m == 1) {
hit(deck1, burnCard); //removes card from the deck and places into discard pile as the burn card
Hands(deck1,dealer); 
removeh(deck1);
String upCard = dealer.get(0);
Rank = Split(upCard);
int dealerCount = CountCards(dealer);

Hands(deck1,player1);
removeh(deck1);
System.out.println("Player 1, your original hand is: " + player1);
//String card1 = player1.get(0);
//String card2 = player1.get(1);


int player1Count = CountCards(player1);	
System.out.println("Player 1, you have: " + player1Count + " points");
if(player1Count == 21) {
System.out.println("Player 1 has a Blackjack!");
PlayerSelection(Dealer, Player1, Player2, Player3, Player4, Player5, Player6, Player1D, Player2D, Player3D, Player4D, Player5D, Player6D, BurnCard, Bets);
}
System.out.println("Dealer's original hand: " + upCard);
if(dealerCount == 21) {
System.out.println("Blackjack! Dealer wins");
PlayerSelection(Dealer, Player1, Player2, Player3, Player4, Player5, Player6, Player1D, Player2D, Player3D, Player4D, Player5D, Player6D, BurnCard, Bets);
}



while(player1Count < 21 | player1DCount < 21){
if(dealerCount < 17) { 
hit(deck1,dealer);
dealerCount = CountCards(dealer);
}
if(player1Count < 21  ){ChooseOption(player1, 1);
System.out.println("Player 1, your current hand is: " + player1);
player1Count = CountCards(player1);
if (player1Count > 21 ){System.out.println("Bust!" + " Player 1, you have: " + player1Count + " points");
System.out.println("Dealer wins!");
}
else if (player1Count == 21 ){System.out.println("Blackjack!" + " Player 1, you have: " + player1Count + " points");}
else{
System.out.println("Player 1, you have: " + player1Count + " points");}
}	

if(player1D.size() > 0) {
System.out.println("Player 1, your first hand is " + player1);
System.out.println("Player 1, your second hand is " + player1D);
player1DCount = CountCards(player1D);

if(player1Count < 21){ChooseOption(player1, 1);
System.out.println("Player 1, your first hand is: " + player1);
player1Count = CountCards(player1);
if (player1Count > 21 ){System.out.println("Bust!" + " Player 1, your first hand have: " + player1Count + " points");
System.out.println("Dealer wins!");
} 
else if (player1Count == 21 ){System.out.println("Blackjack!" + " Player 1, your first hand has: " + player1DCount + " points");}
else{
System.out.println("Player 1, your first hand has: " + player1Count + " points");}
}	
if(player1DCount < 21  ){ChooseOption(player1D, 1);
System.out.println("Player 1, your second hand is: " + player1D);
player1DCount = CountCards(player1D);
if (player1DCount > 21 ){System.out.println("Bust!" + " Player 1, you : " + player1DCount + " points");
System.out.println("Dealer wins!");
}
else if (player1DCount == 21 ){System.out.println("Blackjack!" + " Player 1, your second hand has: " + player1DCount + " points");}
else{
System.out.println("Player 1, your second hand has: " + player1DCount + " points");}
}		
}

}
}

if(m == 2) {
hit(deck1, burnCard); //removes card from the deck and places into discard pile as the burn card
Hands(deck1,dealer); 
removeh(deck1);
String upCard = dealer.get(0);
Rank = Split(upCard);
int dealerCount = CountCards(dealer);

Hands(deck1,player1);
removeh(deck1);
System.out.println("Player 1, your original hand is: " + player1);

Hands(deck1,player2);
removeh(deck1);
System.out.println("Player 2, your original hand is: " + player2);

int player1Count = CountCards(player1);	
System.out.println("Player 1, you have: " + player1Count + " points");
if(player1Count == 21) {
System.out.println("Player 1 has a Blackjack!");
PlayerSelection(Dealer, Player1, Player2, Player3, Player4, Player5, Player6, Player1D, Player2D, Player3D, Player4D, Player5D, Player6D, BurnCard, Bets);
}
int player2Count = CountCards(player2);	
System.out.println("Player 2, you have: " + player2Count + " points");
if(player1Count == 21) {
System.out.println("Player 1 has a Blackjack!");
PlayerSelection(Dealer, Player1, Player2, Player3, Player4, Player5, Player6, Player1D, Player2D, Player3D, Player4D, Player5D, Player6D, BurnCard, Bets);
}
System.out.println("Dealer's original hand: " + upCard);
if(dealerCount == 21) {
System.out.println("Blackjack! Dealer wins");
PlayerSelection(Dealer, Player1, Player2, Player3, Player4, Player5, Player6, Player1D, Player2D, Player3D, Player4D, Player5D, Player6D, BurnCard, Bets);
}




while(player1Count < 21 | player1DCount < 21 | player2Count < 21 | player2DCount < 21) {

if(dealerCount < 17) { 
hit(deck1,dealer);
}
if(player1Count < 21  ){ChooseOption(player1, 1);
System.out.println("Player 1, your current hand is: " + player1);
player1Count = CountCards(player1);
if (player1Count > 21 ){System.out.println("Bust!" + " Player 1, you have: " + player1Count + " points");

}
else if (player1Count == 21 ){System.out.println("Blackjack!" + " Player 1, you have: " + player1Count + " points");}
else{
System.out.println("Player 1, you have: " + player1Count + " points");}
}	

if(player2Count < 21  ){ChooseOption(player2, 2);
System.out.println("Player 2, your current hand is: " + player2);
player2Count = CountCards(player2);
if (player2Count > 21 ){System.out.println("Bust!" + " Player 2, you have: " + player2Count + " points");

}
else if (player2Count == 21 ){System.out.println("Blackjack!" + " Player 2, you have: " + player2Count + " points");}
else{
System.out.println("Player 2, you have: " + player2Count + " points");}
}	

if(player1D.size() > 0) {
System.out.println("Player 1, your first hand is " + player1);
System.out.println("Player 1, your second hand is " + player1D);
player1DCount = CountCards(player1D);

if(player1Count < 21){ChooseOption(player1, 1);
System.out.println("Player 1, your first hand is: " + player1);
player1Count = CountCards(player1);
if (player1Count > 21 ){System.out.println("Bust!" + " Player 1, your first hand have: " + player1Count + " points");
} 
else if (player1Count == 21 ){System.out.println("Blackjack!" + " Player 1, your first hand has: " + player1DCount + " points");}
else{
System.out.println("Player 1, your first hand has: " + player1Count + " points");}
}	
if(player1DCount < 21  ){ChooseOption(player1D, 1);
System.out.println("Player 1, your second hand is: " + player1D);
player1DCount = CountCards(player1D);
if (player1DCount > 21 ){System.out.println("Bust!" + " Player 1, you : " + player1DCount + " points");
}
else if (player1DCount == 21 ){System.out.println("Blackjack!" + " Player 1, your second hand has: " + player1DCount + " points");}
else{
System.out.println("Player 1, your second hand has: " + player1DCount + " points");}
}		
}

if(player2D.size() > 0) {
System.out.println("Player 2, your first hand is " + player2);
System.out.println("Player 2, your second hand is " + player2D);
player2DCount = CountCards(player2D);

if(player2Count < 21){ChooseOption(player2, 2);
System.out.println("Player 2, your first hand is: " + player2);
player2Count = CountCards(player2);
if (player2Count > 21 ){System.out.println("Bust!" + " Player 2, your first hand have: " + player2Count + " points");
} 
else if (player2Count == 21 ){System.out.println("Blackjack!" + " Player 2, your first hand has: " + player2DCount + " points");}
else{
System.out.println("Player 2, your first hand has: " + player2Count + " points");}
}	
if(player2DCount < 21  ){ChooseOption(player2D, 2);
System.out.println("Player 2, your second hand is: " + player2D);
player2DCount = CountCards(player2D);
if (player2DCount > 21 ){System.out.println("Bust!" + " Player 2, you : " + player2DCount + " points");
System.out.println("Dealer wins!");
}
else if (player2DCount == 21 ){System.out.println("Blackjack!" + " Player 2, your second hand has: " + player2DCount + " points");}
else{
System.out.println("Player 2, your second hand has: " + player2DCount + " points");}
}		
}



}
}


if(m == 3) {
hit(deck1, burnCard); //removes card from the deck and places into discard pile as the burn card
Hands(deck1,dealer); 
removeh(deck1);
String upCard = dealer.get(0);
Rank = Split(upCard);
int dealerCount = CountCards(dealer);

Hands(deck1,player1);
removeh(deck1);
System.out.println("Player 1, your original hand is: " + player1);

Hands(deck1,player2);
removeh(deck1);
System.out.println("Player 2, your original hand is: " + player2);

Hands(deck1,player3);
removeh(deck1);
System.out.println("Player 3, your original hand is: " + player3);

int player1Count = CountCards(player1);	
System.out.println("Player 1, you have: " + player1Count + " points");
if(player1Count == 21) {
System.out.println("Player 1 has a Blackjack!");
PlayerSelection(Dealer, Player1, Player2, Player3, Player4, Player5, Player6, Player1D, Player2D, Player3D, Player4D, Player5D, Player6D, BurnCard, Bets);
}
int player2Count = CountCards(player2);	
System.out.println("Player 2, you have: " + player2Count + " points");
if(player1Count == 21) {
System.out.println("Player 1 has a Blackjack!");
PlayerSelection(Dealer, Player1, Player2, Player3, Player4, Player5, Player6, Player1D, Player2D, Player3D, Player4D, Player5D, Player6D, BurnCard, Bets);
}
int player3Count = CountCards(player3);	
System.out.println("Player 3, you have: " + player3Count + " points");
if(player3Count == 21) {
System.out.println("Player 3 has a Blackjack!");
PlayerSelection(Dealer, Player1, Player2, Player3, Player4, Player5, Player6, Player1D, Player2D, Player3D, Player4D, Player5D, Player6D, BurnCard, Bets);
}
System.out.println("Dealer's original hand: " + upCard);
if(dealerCount == 21) {
System.out.println("Blackjack! Dealer wins");
PlayerSelection(Dealer, Player1, Player2, Player3, Player4, Player5, Player6, Player1D, Player2D, Player3D, Player4D, Player5D, Player6D, BurnCard, Bets);
}




while(player1Count < 21 | player1DCount < 21 | player2Count < 21 | player2DCount < 21 | player3Count < 21 | player3DCount < 21  ) {

if(dealerCount < 17) { 
hit(deck1,dealer);
}
if(player1Count < 21  ){ChooseOption(player1, 1);
System.out.println("Player 1, your current hand is: " + player1);
player1Count = CountCards(player1);
if (player1Count > 21 ){System.out.println("Bust!" + " Player 1, you have: " + player1Count + " points");

}
else if (player1Count == 21 ){System.out.println("Blackjack!" + " Player 1, you have: " + player1Count + " points");}
else{
System.out.println("Player 1, you have: " + player1Count + " points");}
}	

if(player2Count < 21  ){ChooseOption(player2, 2);
System.out.println("Player 2, your current hand is: " + player2);
player2Count = CountCards(player2);
if (player2Count > 21 ){System.out.println("Bust!" + " Player 2, you have: " + player2Count + " points");

}
else if (player2Count == 21 ){System.out.println("Blackjack!" + " Player 2, you have: " + player2Count + " points");}
else{
System.out.println("Player 2, you have: " + player2Count + " points");}
}	

if(player3Count < 21  ){ChooseOption(player3, 3);
System.out.println("Player 3, your current hand is: " + player3);
player3Count = CountCards(player3);
if (player3Count > 21 ){System.out.println("Bust!" + " Player 3, you have: " + player3Count + " points");

}
else if (player2Count == 21 ){System.out.println("Blackjack!" + " Player 2, you have: " + player2Count + " points");}
else{
System.out.println("Player 2, you have: " + player2Count + " points");}
}	

if(player1D.size() > 0) {
System.out.println("Player 1, your first hand is " + player1);
System.out.println("Player 1, your second hand is " + player1D);
player1DCount = CountCards(player1D);

if(player1Count < 21){ChooseOption(player1, 1);
System.out.println("Player 1, your first hand is: " + player1);
player1Count = CountCards(player1);
if (player1Count > 21 ){System.out.println("Bust!" + " Player 1, your first hand have: " + player1Count + " points");
} 
else if (player1Count == 21 ){System.out.println("Blackjack!" + " Player 1, your first hand has: " + player1DCount + " points");}
else{
System.out.println("Player 1, your first hand has: " + player1Count + " points");}
}	
if(player1DCount < 21  ){ChooseOption(player1D, 1);
System.out.println("Player 1, your second hand is: " + player1D);
player1DCount = CountCards(player1D);
if (player1DCount > 21 ){System.out.println("Bust!" + " Player 1, you : " + player1DCount + " points");
}
else if (player1DCount == 21 ){System.out.println("Blackjack!" + " Player 1, your second hand has: " + player1DCount + " points");}
else{
System.out.println("Player 1, your second hand has: " + player1DCount + " points");}
}		
}

if(player2D.size() > 0) {
System.out.println("Player 2, your first hand is " + player2);
System.out.println("Player 2, your second hand is " + player2D);
player2DCount = CountCards(player2D);

if(player2Count < 21){ChooseOption(player2, 2);
System.out.println("Player 2, your first hand is: " + player2);
player2Count = CountCards(player2);
if (player2Count > 21 ){System.out.println("Bust!" + " Player 2, your first hand have: " + player2Count + " points");
} 
else if (player2Count == 21 ){System.out.println("Blackjack!" + " Player 2, your first hand has: " + player2DCount + " points");}
else{
System.out.println("Player 2, your first hand has: " + player2Count + " points");}
}	
if(player2DCount < 21  ){ChooseOption(player2D, 2);
System.out.println("Player 2, your second hand is: " + player2D);
player2DCount = CountCards(player2D);
if (player2DCount > 21 ){System.out.println("Bust!" + " Player 2, you : " + player2DCount + " points");
System.out.println("Dealer wins!");
}
else if (player2DCount == 21 ){System.out.println("Blackjack!" + " Player 2, your second hand has: " + player2DCount + " points");}
else{
System.out.println("Player 2, your second hand has: " + player2DCount + " points");}
}		
}


if(player3D.size() > 0) {
System.out.println("Player 3, your first hand is " + player3);
System.out.println("Player 3, your second hand is " + player3D);
player3DCount = CountCards(player3D);

if(player3Count < 21){ChooseOption(player3, 3);
System.out.println("Player 3, your first hand is: " + player3);
player3Count = CountCards(player3);
if (player3Count > 21 ){System.out.println("Bust!" + " Player 3, your first hand have: " + player3Count + " points");
} 
else if (player3Count == 21 ){System.out.println("Blackjack!" + " Player 3, your first hand has: " + player3DCount + " points");}
else{
System.out.println("Player 3, your first hand has: " + player3Count + " points");}
}	
if(player3DCount < 21  ){ChooseOption(player3D, 3);
System.out.println("Player 3, your second hand is: " + player3D);
player3DCount = CountCards(player3D);
if (player3DCount > 21 ){System.out.println("Bust!" + " Player 3, you : " + player3DCount + " points");

}
else if (player3DCount == 21 ){System.out.println("Blackjack!" + " Player 3, your second hand has: " + player3DCount + " points");}
else{
System.out.println("Player 3, your second hand has: " + player3DCount + " points");}
}		
}

}
}



if(m == 4) {
hit(deck1, burnCard); //removes card from the deck and places into discard pile as the burn card
Hands(deck1,dealer); 
removeh(deck1);
String upCard = dealer.get(0);
Rank = Split(upCard);
int dealerCount = CountCards(dealer);

Hands(deck1,player1);
removeh(deck1);
System.out.println("Player 1, your original hand is: " + player1);

Hands(deck1,player2);
removeh(deck1);
System.out.println("Player 2, your original hand is: " + player2);

Hands(deck1,player3);
removeh(deck1);
System.out.println("Player 3, your original hand is: " + player3);

Hands(deck1,player4);
removeh(deck1);
System.out.println("Player 4, your original hand is: " + player4);

int player1Count = CountCards(player1);	
System.out.println("Player 1, you have: " + player1Count + " points");
if(player1Count == 21) {
System.out.println("Player 1 has a Blackjack!");
PlayerSelection(Dealer, Player1, Player2, Player3, Player4, Player5, Player6, Player1D, Player2D, Player3D, Player4D, Player5D, Player6D, BurnCard, Bets);
}
int player2Count = CountCards(player2);	
System.out.println("Player 2, you have: " + player2Count + " points");
if(player1Count == 21) {
System.out.println("Player 1 has a Blackjack!");
PlayerSelection(Dealer, Player1, Player2, Player3, Player4, Player5, Player6, Player1D, Player2D, Player3D, Player4D, Player5D, Player6D, BurnCard, Bets);
}
int player3Count = CountCards(player3);	
System.out.println("Player 3, you have: " + player3Count + " points");
if(player3Count == 21) {
System.out.println("Player 3 has a Blackjack!");
PlayerSelection(Dealer, Player1, Player2, Player3, Player4, Player5, Player6, Player1D, Player2D, Player3D, Player4D, Player5D, Player6D, BurnCard, Bets);
}
int player4Count = CountCards(player4);	
System.out.println("Player 4, you have: " + player4Count + " points");
if(player4Count == 21) {
System.out.println("Player 4 has a Blackjack!");
PlayerSelection(Dealer, Player1, Player2, Player3, Player4, Player5, Player6, Player1D, Player2D, Player3D, Player4D, Player5D, Player6D, BurnCard, Bets);
}
System.out.println("Dealer's original hand: " + upCard);
if(dealerCount == 21) {
System.out.println("Blackjack! Dealer wins");
PlayerSelection(Dealer, Player1, Player2, Player3, Player4, Player5, Player6, Player1D, Player2D, Player3D, Player4D, Player5D, Player6D, BurnCard, Bets);
}




while(player1Count < 21 | player1DCount < 21 | player2Count < 21 | player2DCount < 21 | player3Count < 21 | player3DCount < 21 | player4Count < 21 | player4DCount < 21 ) {

if(dealerCount < 17) { 
hit(deck1,dealer);
}
if(player1Count < 21  ){ChooseOption(player1, 1);
System.out.println("Player 1, your current hand is: " + player1);
player1Count = CountCards(player1);
if (player1Count > 21 ){System.out.println("Bust!" + " Player 1, you have: " + player1Count + " points");

}
else if (player1Count == 21 ){System.out.println("Blackjack!" + " Player 1, you have: " + player1Count + " points");}
else{
System.out.println("Player 1, you have: " + player1Count + " points");}
}	

if(player2Count < 21  ){ChooseOption(player2, 2);
System.out.println("Player 2, your current hand is: " + player2);
player2Count = CountCards(player2);
if (player2Count > 21 ){System.out.println("Bust!" + " Player 2, you have: " + player2Count + " points");

}
else if (player2Count == 21 ){System.out.println("Blackjack!" + " Player 2, you have: " + player2Count + " points");}
else{
System.out.println("Player 2, you have: " + player2Count + " points");}
}	

if(player3Count < 21  ){ChooseOption(player3, 3);
System.out.println("Player 3, your current hand is: " + player3);
player3Count = CountCards(player3);
if (player3Count > 21 ){System.out.println("Bust!" + " Player 3, you have: " + player3Count + " points");

}
else if (player2Count == 21 ){System.out.println("Blackjack!" + " Player 3, you have: " + player3Count + " points");}
else{
System.out.println("Player 3, you have: " + player3Count + " points");}
}

if(player4Count < 21  ){ChooseOption(player4, 4);
System.out.println("Player 4, your current hand is: " + player4);
player4Count = CountCards(player4);
if (player4Count > 21 ){System.out.println("Bust!" + " Player 4, you have: " + player4Count + " points");

}
else if (player4Count == 21 ){System.out.println("Blackjack!" + " Player 4, you have: " + player4Count + " points");}
else{
System.out.println("Player 4, you have: " + player4Count + " points");}
}	

if(player1D.size() > 0) {
System.out.println("Player 1, your first hand is " + player1);
System.out.println("Player 1, your second hand is " + player1D);
player1DCount = CountCards(player1D);

if(player1Count < 21){ChooseOption(player1, 1);
System.out.println("Player 1, your first hand is: " + player1);
player1Count = CountCards(player1);
if (player1Count > 21 ){System.out.println("Bust!" + " Player 1, your first hand have: " + player1Count + " points");
} 
else if (player1Count == 21 ){System.out.println("Blackjack!" + " Player 1, your first hand has: " + player1DCount + " points");}
else{
System.out.println("Player 1, your first hand has: " + player1Count + " points");}
}	
if(player1DCount < 21  ){ChooseOption(player1D, 1);
System.out.println("Player 1, your second hand is: " + player1D);
player1DCount = CountCards(player1D);
if (player1DCount > 21 ){System.out.println("Bust!" + " Player 1, you : " + player1DCount + " points");
}
else if (player1DCount == 21 ){System.out.println("Blackjack!" + " Player 1, your second hand has: " + player1DCount + " points");}
else{
System.out.println("Player 1, your second hand has: " + player1DCount + " points");}
}		
}

if(player2D.size() > 0) {
System.out.println("Player 2, your first hand is " + player2);
System.out.println("Player 2, your second hand is " + player2D);
player2DCount = CountCards(player2D);

if(player2Count < 21){ChooseOption(player2, 2);
System.out.println("Player 2, your first hand is: " + player2);
player2Count = CountCards(player2);
if (player2Count > 21 ){System.out.println("Bust!" + " Player 2, your first hand have: " + player2Count + " points");
} 
else if (player2Count == 21 ){System.out.println("Blackjack!" + " Player 2, your first hand has: " + player2DCount + " points");}
else{
System.out.println("Player 2, your first hand has: " + player2Count + " points");}
}	
if(player2DCount < 21  ){ChooseOption(player2D, 2);
System.out.println("Player 2, your second hand is: " + player2D);
player2DCount = CountCards(player2D);
if (player2DCount > 21 ){System.out.println("Bust!" + " Player 2, you : " + player2DCount + " points");
System.out.println("Dealer wins!");
}
else if (player2DCount == 21 ){System.out.println("Blackjack!" + " Player 2, your second hand has: " + player2DCount + " points");}
else{
System.out.println("Player 2, your second hand has: " + player2DCount + " points");}
}		
}


if(player3D.size() > 0) {
System.out.println("Player 3, your first hand is " + player3);
System.out.println("Player 3, your second hand is " + player3D);
player3DCount = CountCards(player3D);

if(player3Count < 21){ChooseOption(player3, 3);
System.out.println("Player 3, your first hand is: " + player3);
player3Count = CountCards(player3);
if (player3Count > 21 ){System.out.println("Bust!" + " Player 3, your first hand have: " + player3Count + " points");
} 
else if (player3Count == 21 ){System.out.println("Blackjack!" + " Player 3, your first hand has: " + player3DCount + " points");}
else{
System.out.println("Player 3, your first hand has: " + player3Count + " points");}
}	
if(player3DCount < 21  ){ChooseOption(player3D, 3);
System.out.println("Player 3, your second hand is: " + player3D);
player3DCount = CountCards(player3D);
if (player3DCount > 21 ){System.out.println("Bust!" + " Player 3, you : " + player3DCount + " points");

}
else if (player3DCount == 21 ){System.out.println("Blackjack!" + " Player 3, your second hand has: " + player3DCount + " points");}
else{
System.out.println("Player 3, your second hand has: " + player3DCount + " points");}
}		
}

if(player4D.size() > 0) {
System.out.println("Player 4, your first hand is " + player4);
System.out.println("Player 4, your second hand is " + player4D);
player4DCount = CountCards(player4D);

if(player4Count < 21){ChooseOption(player4, 4);
System.out.println("Player 4, your first hand is: " + player4);
player4Count = CountCards(player4);
if (player4Count > 21 ){System.out.println("Bust!" + " Player 4, your first hand have: " + player4Count + " points");
} 
else if (player4Count == 21 ){System.out.println("Blackjack!" + " Player 4, your first hand has: " + player4DCount + " points");}
else{
System.out.println("Player 4, your first hand has: " + player4Count + " points");}
}	
if(player4DCount < 21  ){ChooseOption(player4D, 4);
System.out.println("Player 4, your second hand is: " + player4D);
player4DCount = CountCards(player4D);
if (player4DCount > 21 ){System.out.println("Bust!" + " Player 4, you : " + player4DCount + " points");

}
else if (player4DCount == 21 ){System.out.println("Blackjack!" + " Player 4, your second hand has: " + player4DCount + " points");}
else{
System.out.println("Player 4, your second hand has: " + player4DCount + " points");}
}		
}

}
}
}

public static void hit(List<String> deck,List <String> player){	
BlackjackFunctions b1 = new BlackjackFunctions();
b1.Hit(deck, player);
b1.Deckr(deck); 
}

public static void main(String [] args){	
deckmaking(deck1);
System.out.println(deck1);
deckmakingnum(decknum);
Shuffling(decknum);
deckmakingrep(deck1,decknum);
System.out.println(deck1);
//System.out.println(Arrays.toString(decknum));
System.out.println("Shannon Entropy:  "+ ShufflingSha(decknum));
PlayerSelection(Dealer, Player1, Player2, Player3, Player4, Player5, Player6, Player1D, Player2D, Player3D, Player4D, Player5D, Player6D, BurnCard, Bets);



}

}
