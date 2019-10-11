
import java.util.Scanner;

public class Cards {
public enum Rank1 {ACE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING} 

public String Split(String c2) {		
String [] card = c2.split(" ");
String givenRank = card[0];
return givenRank.toUpperCase();
}


public int displayValue(String givenRank) {
Rank1 card = Rank1.valueOf(givenRank);
int value = 0;
switch(card) {
case ACE:
Scanner s = new Scanner(System.in);
System.out.println("Do You want the Ace to be a 1 or 11? ");
value = s.nextInt();

break;

case TWO: 
value = 2;
break;

case THREE:
value = 3;
break;

case FOUR:
value = 4;
break;

case FIVE: 
value = 5;
break;

case SIX:
value = 6;
break;

case SEVEN:
value = 7;
break;
	
case EIGHT:
value = 8;
break;

case NINE:
value = 9; 
break;

case TEN:
value = 10;
break;

case JACK:
value = 10;
break;
	
case QUEEN:
value = 10;
break;

case KING:
value = 10;
break;

default:
break;
}
return value;
}
}

