package com.github.zipcodewilmington.casino.games.BlackJack;

import com.github.zipcodewilmington.casino.games.GameInterface.GamblingGame;

import java.util.*;

public class BlackJack implements GamblingGame<BlackJackPlayer> {
    Scanner scanner = new Scanner(System.in);
    private Map<BlackJackPlayer, Integer> bets = new HashMap<>();
    private Map<BlackJackPlayer, List<Card>> playerHand = new HashMap<>();
    private Map<BlackJackPlayer, Integer> playerHandSum = new HashMap<>();
    private Map<BlackJackPlayer, Boolean> winLose = new HashMap<>();
    private Map<BlackJackPlayer, Boolean> blackJackFlag = new HashMap<>();
    private int dealerHandSum;
    private List<Card> dealerHand;
    private int maxPartySize;
    private boolean exitFlag = false;

    @Override
    public void play() {
        String input;
        int cardValue = 0;
        Card temp;
        boolean AceFlag=false;
        while(exitFlag==false) {
            Deck deck = new Deck();
            for (int i=0; i<2;i++) {
                for (BlackJackPlayer s : bets.keySet()) {
                    playerHand.get(s).add(deck.getTopCard());
                }
                dealerHand.add(deck.getTopCard());
            }
            System.out.println("Dealer got a " + dealerHand.get(0).toString());
            for (BlackJackPlayer s : bets.keySet()){
                while (true){
                    System.out.println(s.getPerson().getName() + ", do you want to hit, double, or stay?");
                    input= scanner.nextLine();
                    if (input == "hit") {
                        temp = deck.getTopCard();
                        playerHand.get(s).add(temp);
                        cardValue += this.cardValue(temp)[0];
                        if(temp.getCardFace().equals(CardFace.Ace))
                            AceFlag=true;
                    }
                    else if (input == "stay")
                        break;
                    else if (input == "double") {
                        playerHand.get(s).add(deck.getTopCard());
                        bets.put(s,bets.get(s)*2);
                        break;
                    }
                    else if (playerHandSum.get(s)>21){
                        if (AceFlag){
                            cardValue -= 10;
                        }
                        else {
                            System.out.println("Busted!");
                            break;
                        }
                    }
                    input = "";
                }
            }
            dealerPlays();
            for (BlackJackPlayer s: bets.keySet()){
                winConditionCheck(s);
                if (winLose.get(s))
                    distributeWinningsToWinners(s);
            }
            input=scanner.nextLine();
            if (input=="Exit"){
                exitFlag=true;
            }
        }
    }

    public BlackJack(List<BlackJackPlayer> players) {
        for (BlackJackPlayer s: players){
            this.bets.put(s,null);
            this.playerHand.put(s,null);
            if (bets.size()>maxPartySize){
                System.out.println("Only 4 players are allowed to play!");
                break;
            }
        }
    }

    public void dealerPlay(){

    }

    private int[] cardValue(Card card){
        int[] value = new int[0];
        CardFace cardFace = card.getCardFace();
        switch (cardFace){
            case Ace: value= new int[]{11, 1}; break;
            case Two: value= new int[]{2}; break;
            case Three: value= new int[]{3}; break;
            case Four: value= new int[]{4}; break;
            case Five: value= new int[]{5}; break;
            case Six: value= new int[]{6}; break;
            case Seven: value= new int[]{7}; break;
            case Eight: value= new int[]{8}; break;
            case Nine: value= new int[]{9}; break;
            case Ten: case Jack: case Queen:
            case King: value= new int[]{10}; break;
        }
        return value;
    }

    public void blackJackCheck(BlackJackPlayer blackJackPlayer){
        List<Card> tempPlayerHand = playerHand.get(blackJackPlayer);
        if (tempPlayerHand.size() != 2) {
            blackJackFlag.put(blackJackPlayer, false);
        }
        else if (this.cardValue(tempPlayerHand.get(0))[0]==10)
        {
            if (tempPlayerHand.get(1).getCardFace().equals(CardFace.Ace)) {
                blackJackFlag.put(blackJackPlayer, true);
            }
            else
                blackJackFlag.put(blackJackPlayer, false);
        }
        else if (this.cardValue(tempPlayerHand.get(1))[0]==10) {
            if (tempPlayerHand.get(0).getCardFace().equals(CardFace.Ace)) {
                blackJackFlag.put(blackJackPlayer, true);
            }
            else
                blackJackFlag.put(blackJackPlayer, false);
        }
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
        if (blackJackFlag.get(blackJackPlayer)==true)
            this.winLose.put(blackJackPlayer, true);
        else if (playerSum>dealerHandSum && playerSum <= 21)
            this.winLose.put(blackJackPlayer, true);
        else
            this.winLose.put(blackJackPlayer,false);
    }

    @Override
    public BlackJackPlayer[] getWinner() {
        List<BlackJackPlayer> winner = new ArrayList<>();
        for (BlackJackPlayer s : winLose.keySet()){
            if (winLose.get(s)==true)
                winner.add(s);
        }
        return winner.toArray(new BlackJackPlayer[winner.size()]);
    }

    @Override
    public void exit() {
        this.exitFlag=true;
    }

    @Override
    public void setBets() {
        Integer bet = 0, walletBalance;
        for (BlackJackPlayer s: bets.keySet()){
            walletBalance = s.getBalance();
            try {
                System.out.println("Hello" +s.getPerson().getName() + ", how much would you like to bet?");
                System.out.println();
                bet=scanner.nextInt();
                if (bet<walletBalance){
                    System.out.println("Bet exceeds what you have, try again");
                    continue;
                }
            } catch (InputMismatchException e){
                System.out.println("Not a number, try again");
                continue;
            }
            bets.put(s, bet);
            s.applyBet(bet);
        }
    }

    @Override
    public void distributeWinningsToWinners(BlackJackPlayer winner) {
        winner.addWinning(bets.get(winner)*2);
    }
}
