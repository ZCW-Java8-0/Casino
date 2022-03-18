package com.github.zipcodewilmington.casino.games.BlackJack;

import com.github.zipcodewilmington.casino.games.GameInterface.GamblingGame;
import com.github.zipcodewilmington.utils.AnsiColor;
import com.github.zipcodewilmington.utils.IOConsole;

import java.util.*;

public class BlackJack implements GamblingGame<BlackJackPlayer> {
    private final IOConsole console = new IOConsole(AnsiColor.BLUE);
    private Map<BlackJackPlayer, Integer> bets = new HashMap<>();
    private Map<BlackJackPlayer, List<Card>> playerHand = new HashMap<>();
    private Map<BlackJackPlayer, Integer> playerHandSum = new HashMap<>();
    private Map<BlackJackPlayer, Boolean> winLose = new HashMap<>();
    private Map<BlackJackPlayer, Boolean> blackJackFlag = new HashMap<>();
    private Map <BlackJackPlayer, Boolean> AceFlag = new HashMap<>();
    private int dealerHandSum;
    private List<Card> dealerHand = new ArrayList<>();
    private int maxPartySize;
    private boolean exitFlag = false, dealerBlackJack = false;
    private Deck deck = new Deck();

    @Override
    public void play() {
        while(!exitFlag) {
            System.out.println("Welcome to Blackjack!");
            setBets();
            dealFirst2Cards();
            blackJackCheck();
            if (dealerBlackJack) {
                System.out.println("Dealer Blackjack!");
            } else {
                System.out.println(displayCard(dealerHand, "Dealer"));
                for (BlackJackPlayer s : bets.keySet()) {
                    playerOption(s);
                }
            }
            postPlayerTurn();
            exit();
            if (deck.getSize()<25)
                deck=new Deck();
        }
    }

    private void postPlayerTurn() {
        dealerPlays();
        for (BlackJackPlayer s: bets.keySet()){
            winConditionCheck(s);
            if (winLose.get(s))
                distributeWinningsToWinners(s);
            //display win or lose and ending hand and total
            System.out.println(displayCard(playerHand.get(s),s.getPerson().getName()));
        }
    }

    private void dealFirst2Cards() {
        Card temp;
        for (int i = 0; i < 2; i++) {
            for (BlackJackPlayer s : bets.keySet()) {
                temp = deck.getTopCard();
                playerHand.get(s).add(temp);
                playerHandSum.put(s, playerHandSum.get(s) + this.cardValue(temp));
                if (temp.getCardFace().equals(CardFace.Ace))
                    AceFlag.put(s, true);
            }
            dealerHand.add(deck.getTopCard());
            dealerHandSum+=cardValue(dealerHand.get(dealerHand.size()-1));
        }
        blackJackCheck();
    }

    public BlackJack(List<BlackJackPlayer> players) {
        for (BlackJackPlayer s: players){
            this.bets.put(s,null);
            this.playerHand.put(s,null);
        }
    }

    public void dealerPlays(){
        if (winLose.containsValue(null)) {
            while (dealerHandSum < 17) {
                dealerHand.add(deck.getTopCard());
                dealerHandSum += cardValue(dealerHand.get(dealerHand.size() - 1));
            }
        }
        System.out.println("Dealer got:");
        for (Card s: dealerHand){
            System.out.println(s.toString());
        }
    }

    public String displayCard(List<Card> hand, String name){
        String cards= name+" has:";
        for (Card s: hand){
            cards+="\n"+s.toString();
        }
        return cards;
    }

    public void playerOption(BlackJackPlayer player) {
        String input;
        Card temp;
        int cardValue = 0;
        while (true) {
            if(blackJackFlag.get(player))
                break;
            if (playerHandSum.get(player) > 21) {
                if (AceFlag.get(player)) {
                    cardValue -= 10;
                    AceFlag.put(player, false);
                } else {
                    System.out.println("Busted!");
                    winLose.put(player, false);
                    break;
                }
            }
            displayCard(playerHand.get(player),player.getPerson().getName());
            input = console.getStringInput(player.getPerson().getName() + ", do you want to hit, double, or stay?");
            if (input.equalsIgnoreCase("hit")) {
                temp = deck.getTopCard();
                playerHand.get(player).add(temp);
                playerHandSum.put(player, playerHandSum.get(player)+cardValue(temp));
                if (temp.getCardFace().equals(CardFace.Ace))
                    AceFlag.put(player, true);
            } else if (input.equalsIgnoreCase("stay"))
                break;
            else if (input.equalsIgnoreCase("double")) {
                playerHand.get(player).add(deck.getTopCard());
                displayCard(playerHand.get(player), player.getPerson().getName());
                bets.put(player, bets.get(player) * 2);
                break;
            }
        }
    }

    private int cardValue(Card card){
        int value = 0;
        CardFace cardFace = card.getCardFace();
        switch (cardFace){
            case Ace: value = 11; break;
            case Two: value = 2; break;
            case Three: value = 3; break;
            case Four: value = 4; break;
            case Five: value = 5; break;
            case Six: value = 6; break;
            case Seven: value = 7; break;
            case Eight: value = 8; break;
            case Nine: value = 9; break;
            case Ten: case Jack: case Queen:
            case King: value = 10; break;
        }
        return value;
    }

    public void blackJackCheck() {
        for (BlackJackPlayer s : bets.keySet()) {
            if (blackJackFlag(playerHand.get(s)))
                blackJackFlag.put(s, true);
            else
                blackJackFlag.put(s, false);
        }
        if (blackJackFlag(dealerHand))
            dealerBlackJack=true;
    }

    public boolean blackJackFlag(List<Card> hand){
        if (this.cardValue(hand.get(0))==10)
        {
            if (hand.get(1).getCardFace().equals(CardFace.Ace)) {
                return true;
            }
            else
                return false;
        }
        else if (this.cardValue(hand.get(1))==10) {
            if (hand.get(0).getCardFace().equals(CardFace.Ace)) {
                return true;
            }
            else
                return false;
        }
        return false;
    }

    @Override
    public void setPlayerMax() {
        this.maxPartySize = 4;
    }

    @Override
    public void addPlayer(BlackJackPlayer player) {
        this.bets.put(player,0);
    }

    @Override
    public void removePlayer(BlackJackPlayer player) {
        this.bets.remove(player);
    }


    @Override
    public void winConditionCheck(BlackJackPlayer blackJackPlayer) {
        int playerSum = playerHandSum.get(blackJackPlayer);
        if (dealerBlackJack) {
            if (blackJackFlag.get(blackJackPlayer))
                this.winLose.put(blackJackPlayer, true);
            else
                this.winLose.put(blackJackPlayer, false);
        }
        else if (dealerHandSum>21){
            if (playerSum>21)
                this.winLose.put(blackJackPlayer,false);
            else
                this.winLose.put(blackJackPlayer,true);
        }
        else {
            if (blackJackFlag.get(blackJackPlayer))
                this.winLose.put(blackJackPlayer, true);
            else if (playerSum > dealerHandSum && playerSum <= 21)
                this.winLose.put(blackJackPlayer, true);
            else
                this.winLose.put(blackJackPlayer, false);
        }
    }

    @Override
    public void exit() {
        String input = console.getStringInput("Do you want to exit the game?");
        if (input.equalsIgnoreCase("Yes"))
            this.exitFlag=true;
        else
            System.out.println("Dealing new hands");
    }

    @Override
    public void setBets() {
        Integer bet = 0, walletBalance;
        for (BlackJackPlayer s: bets.keySet()){
            walletBalance = s.getBalance();
            bet = console.getIntegerInput(
                    "Hello" +s.getPerson().getName() + ", how much would you like to bet?");
            while (bet>walletBalance){
                bet= console.getIntegerInput("Bet exceeds what you have, try again");
            }
            bets.put(s, bet);
            s.applyBet(bet);
            playerHand.put(s, new ArrayList<>());
            playerHandSum.put(s, 0);
        }
    }

    @Override
    public void distributeWinningsToWinners(BlackJackPlayer winner) {
        winner.addWinning(bets.get(winner)*2);
    }
}
