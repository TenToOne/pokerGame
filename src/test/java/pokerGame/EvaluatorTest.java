package pokerGame;

import org.junit.Test;
import pokerGame.Card;
import pokerGame.Evaluator;
import pokerGame.Hand;
import pokerGame.Suit;

import static org.junit.Assert.assertTrue;

public class EvaluatorTest {

    @Test
    public void 로열스트레이트_플러시_검증_성공(){
        Hand hand = new Hand();
        hand.addCard(new Card(10, Suit.Spade));
        hand.addCard(new Card(11,Suit.Spade));
        hand.addCard(new Card(12,Suit.Spade));
        hand.addCard(new Card(13,Suit.Spade));
        hand.addCard(new Card(1,Suit.Spade));
        Evaluator evaluator = new Evaluator();
        String result = evaluator.evaluate(hand);
        assertTrue(result.equals("Royal_Straight_Flush"));
    }

    @Test
    public void 포카드_검증_성공(){
        Hand hand = new Hand();
        hand.addCard(new Card(10,Suit.Spade));
        hand.addCard(new Card(10,Suit.Club));
        hand.addCard(new Card(10,Suit.Heart));
        hand.addCard(new Card(10,Suit.Diamond));
        hand.addCard(new Card(1,Suit.Spade));
        Evaluator evaluator = new Evaluator();
        String result = evaluator.FourCard(hand);
        assertTrue(result.equals("FourCard"));
    }

    @Test
    public void 플러시_검증_성공(){
        Hand hand = new Hand();
        hand.addCard(new Card(5,Suit.Spade));
        hand.addCard(new Card(8,Suit.Spade));
        hand.addCard(new Card(6,Suit.Spade));
        hand.addCard(new Card(7,Suit.Spade));
        hand.addCard(new Card(9,Suit.Spade));
        Evaluator evaluator = new Evaluator();
        String result = evaluator.Flushe(hand);
        assertTrue(result.equals("Flushe"));
    }


    @Test
    public void 스트레이트_검증_성공(){
        Hand hand = new Hand();
        hand.addCard(new Card(5,Suit.Spade));
        hand.addCard(new Card(8,Suit.Club));
        hand.addCard(new Card(6,Suit.Diamond));
        hand.addCard(new Card(7,Suit.Spade));
        hand.addCard(new Card(9,Suit.Spade));
        Evaluator evaluator = new Evaluator();
        String result = evaluator.Straight(hand);
        assertTrue(result.equals("Straight"));
    }
}
