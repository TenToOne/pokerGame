package pokerGame;

import org.junit.Test;
import pokerGame.Card;
import pokerGame.NoSuchRankException;
import pokerGame.Suit;

import static org.junit.Assert.assertTrue;

public class CardTest {

    @Test
    public void 카드_다이아_5_생성(){
        Card card = new Card(5, Suit.Diamond);
        int rank = card.getRank();
        Suit suit = card.getSuit();
        assertTrue(rank==5);
        assertTrue(suit.equals(Suit.Diamond));
    }

    @Test(expected = NoSuchRankException.class)
    public void 카드_렝크14이상생성시_에러발생(){
        Card card = new Card(16,Suit.Heart);
    }

    @Test(expected = NoSuchRankException.class)
    public void 카드_랭크가_음수이면_에러발생(){
        Card card = new Card(-9,Suit.Club);
    }


}