package pokerGame;

import org.junit.Test;
import pokerGame.Deck;
import pokerGame.Hand;
import pokerGame.OverHandException;

import static org.junit.Assert.assertTrue;

public class HandTest {
    @Test
    public void 덱에서_카드를_1장드로우해_핸드에_1장있어야한다(){
        Deck deck = new Deck(1);
        Hand hand= new Hand();
        hand.addCard(deck.drawCard());
        assertTrue(hand.getCountCard()==1);
    }

    @Test(expected = OverHandException.class)
    public void 핸드는5장일떄_드로우하면_에러(){
        Deck deck = new Deck(1);
        Hand hand = new Hand();
        for(int i=0;i<5;i++){
            hand.addCard(deck.drawCard());
        }
        hand.addCard(deck.drawCard());
    }
}
