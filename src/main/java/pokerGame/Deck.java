package pokerGame;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
    private List<Card> cardList = new ArrayList<Card>();

    public Deck(int deckCount) {
        for(int c=0;c<deckCount;c++) {
            for (Suit suit : Suit.values()) {
                for (int i = 1; i < 14; i++) {
                    Card card = new Card(i, suit);
                    cardList.add(card);
                }
            }
        }
        Collections.shuffle(cardList);
    }

    public int getToTalCard() {
        return cardList.size();
    }

    public Card drawCard() {
        if(cardList.size()>0) {
            return cardList.remove(0);
        }
        throw new NoMoreCardException();
    }
}