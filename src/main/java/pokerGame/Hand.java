package pokerGame;

import java.util.ArrayList;
import java.util.List;

public class Hand {
    private List<Card> handList = new ArrayList<Card>();

    public void addCard(Card card) {
        if(handList.size()<5) handList.add(card);
        else throw new OverHandException();
    }

    public int getCountCard() {
        return handList.size();
    }

    public List<Card> getHandList(){
        return handList;
    }
}
