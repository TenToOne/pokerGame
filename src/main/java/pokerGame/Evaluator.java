package pokerGame;

import java.util.*;

public class Evaluator {


    public String evaluate(Hand hand) {
        if(hand.getCountCard()!=5){
            throw new OverHandException();
        }

        // check royal straight flush
        boolean isRoyalStraightFlush = true;
        int[] RankCheck = {0,0,0,0,0,0,0,0,0,0,0,0,0};
        List<Card> handList = hand.getHandList();
        for(Card card : handList){
            if(card.getSuit()!=Suit.Spade) {
                isRoyalStraightFlush = false;
                break;
            }
            RankCheck[card.getRank()-1]++;
        }
        if(!(RankCheck[0]==1&&RankCheck[9]==1&&RankCheck[10]==1&&RankCheck[11]==1&&RankCheck[12]==1)){
            isRoyalStraightFlush=false;
        }

        if(isRoyalStraightFlush) return "Royal_Straight_Flush";

        return null;
    }

    public String FourCard (Hand hand) {
        if(hand.getCountCard()!=5){
            throw new OverHandException();
        }
        Map<Integer, Integer> cardList = new HashMap<Integer, Integer>();
        // check royal straight flush
        boolean isFourCard = false;

        List<Card> handList = hand.getHandList();

        for(Card card : handList){
            int freq = (cardList.get(card.getRank()) == null) ? 1 : cardList.get(card.getRank()) + 1;
            cardList.put(card.getRank(), freq);
            if(freq==4)
                isFourCard=true;
        }

        if(isFourCard)
            return "FourCard";

        return null;
    }

    public String Flushe(Hand hand) {
        if(hand.getCountCard()!=5){
            throw new OverHandException();
        }

        // check royal straight flush
        boolean isFlushe = true;
        Map<Suit, Integer> cardList = new HashMap<Suit, Integer>();
        List<Card> handList = hand.getHandList();

        for(Card card : handList){
            int freq = (cardList.get(card.getSuit()) == null) ? 1 : cardList.get(card.getSuit()) + 1;
            cardList.put(card.getSuit(), freq);
            if(freq==5)
                isFlushe=true;
        }

        if(isFlushe)
            return "Flushe";

        return null;
    }

    public String Straight(Hand hand) {
        if(hand.getCountCard()!=5){
            throw new OverHandException();
        }

        // check royal straight flush
        boolean isStraight = true;
        int[] cardList = new int[5];
        List<Card> handList = hand.getHandList();
        int i=0;
        for(Card card : handList){
            cardList[i]= card.getRank();
            i++;
        }
        Arrays.sort(cardList);

        for(int n=0; n<4; n++) {
            if(cardList[n]+1!=cardList[n+1]) {
                isStraight = false;
                break;
            }
        }
        if(isStraight)
            return "Straight";

        return null;
    }

    ///// 나중에 각 카드 판정 메소드를 모아 높은 값부터 if문을 만들어 높은 카드를 선택하는 메소드 제작
}
