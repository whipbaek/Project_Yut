package PlayTest;

import MYProject.Yut.Play.WholeGame;
import org.junit.jupiter.api.Test;

import java.util.Scanner;

public class WholeGameLogicTest {

    @Test
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("몇명이서 플레이 하시겠습니까?");
        int numofplayer = sc.nextInt();

        System.out.println("몇개의 말을 가지시겠습니까?");
        int numofmal = sc.nextInt();

        WholeGame wholeGame = new WholeGame(numofplayer, numofmal);
        wholeGame.StartGame(sc);

    }
}
