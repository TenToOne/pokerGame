package pokerGame;

import org.junit.Test;
import pokerGame.Card;
import pokerGame.Deck;
import pokerGame.NoMoreCardException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertTrue;

public class DeckTest {

    @Test
    public void Deck_1덱에52장의카드(){
        Deck deck = new Deck(1);
        assertTrue(deck.getToTalCard()==52);
    }

    @Test
    public void Deck_1덱에서카드1장드로우_총카드는51장(){
        Deck deck = new Deck(1);
        Card card = deck.drawCard();
        assertTrue(deck.getToTalCard()==51);
    }

    @Test(expected = NoMoreCardException.class)
    public void Deck_이없는상태에서_드로우하면에러(){
        Deck deck = new Deck(1);
        for(int i=0;i<52;i++){
            Card card = deck.drawCard();
            System.out.println(card.getRank()+":"+card.getSuit());
        }
        deck.drawCard();
    }
}
