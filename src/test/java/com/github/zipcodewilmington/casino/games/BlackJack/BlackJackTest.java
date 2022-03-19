package com.github.zipcodewilmington.casino.games.BlackJack;

import com.github.zipcodewilmington.casino.games.Person.Person;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class BlackJackTest {
    BlackJack bj = new BlackJack();
    Deck deck1=new Deck();
    Person person = new Person("Test",5000);

    @Test
    void displayCardTest() {
        //When
        List<Card> testHand = new ArrayList<>();
        testHand.add(deck1.getTopCard());
        String cardDisplay = bj.displayCard(testHand,"Test"),
                expected = "Test has:\n"+testHand.get(0).toString();
        //Then
        Assertions.assertEquals(expected,cardDisplay);
    }

    @Test
    void addPlayerAndsetBetTest() {
        //Given
        BlackJackPlayer bjp = new BlackJackPlayer(person);

        //When
        bj.addPlayer(bjp);
        bj.setBet(bjp, 100);

        //Then
        Assertions.assertTrue(person.getWallet()==4900);
    }

    @Test
    void distributeWinningsToWinnersTest() {
        //Given
        BlackJackPlayer bjp = new BlackJackPlayer(person);
        bj.addPlayer(bjp);
        bj.setBet(bjp, 100);
        //When
        bj.distributeWinningsToWinners(bjp);
        //Then
        Assertions.assertTrue(person.getWallet()==5100);
    }

    @Test
    void drawTest() throws NoSuchFieldException, IllegalAccessException {
        //Given
        BlackJackPlayer bjp = new BlackJackPlayer(person);
        bj.addPlayer(bjp);
        //When
        bj.draw(bjp);
        Field field = bj.getClass().getDeclaredField("playerHandSum");
        field.setAccessible(true);
        Map<BlackJackPlayer, Integer> handsum= (Map<BlackJackPlayer, Integer>) field.get(bj);
        //Then
        Assertions.assertTrue(handsum.get(bjp)>0);
    }

    @Test
    void dealerPlaysTest() throws NoSuchFieldException, IllegalAccessException {
        //Given
        BlackJackPlayer bjp = new BlackJackPlayer(person);
        bj.addPlayer(bjp);
        //When
        bj.dealerPlays();
        Field field = bj.getClass().getDeclaredField("dealerHandSum");
        field.setAccessible(true);
        //Then
        Assertions.assertTrue((int)field.get(bj)>16);
    }


    @Test
    void blackJackFlagTest() {
        //When
        List<Card> hand = new ArrayList<>();
        hand.add(new Card(CardFace.Ace,Suit.Diamonds));
        hand.add(new Card(CardFace.Jack,Suit.Diamonds));
        //Then
        Assertions.assertTrue(bj.blackJackFlag(hand));
    }

    @Test
    void removePlayerTest() throws NoSuchFieldException, IllegalAccessException {
        //Given
        BlackJackPlayer bjp = new BlackJackPlayer(person);
        BlackJackPlayer bjp1 = new BlackJackPlayer(person);
        bj.addPlayer(bjp);
        bj.addPlayer(bjp1);
        //When
        bj.removePlayer(bjp);
        Map<BlackJackPlayer, Integer> expectedMap = new HashMap<>();
        expectedMap.put(bjp1,0);
        Field field = bj.getClass().getDeclaredField("bets");
        field.setAccessible(true);
        Map<BlackJackPlayer, Integer> actualMap = (Map<BlackJackPlayer, Integer>) field.get(bj);
        //Then
        Assertions.assertEquals(expectedMap,actualMap);
    }

    @Test
    void dealFirst2CardTest() throws IllegalAccessException, NoSuchFieldException {
        //Given
        BlackJackPlayer bjp = new BlackJackPlayer(person);
        bj.addPlayer(bjp);
        //When
        bj.dealFirst2Cards();
        Field field = bj.getClass().getDeclaredField("dealerHand");
        Field field1 = bj.getClass().getDeclaredField("playerHandSum");
        field.setAccessible(true);
        field1.setAccessible(true);
        Map<BlackJackPlayer, Integer> handsum= (Map<BlackJackPlayer, Integer>) field1.get(bj);
        List<Card> actualHand = (List<Card>) field.get(bj);
        //Then
        Assertions.assertTrue(handsum.get(bjp)>0);
        Assertions.assertEquals(2,actualHand.size());
    }

    @Test
    void bustCheckTest() {
    }

    @Test
    void setPlayerMaxTest() {
    }

    @Test
    void cardValueTest(){
    }

    @Test
    void winConditionCheckTest() {
    }
}