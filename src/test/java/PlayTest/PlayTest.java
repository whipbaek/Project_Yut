package PlayTest;


import MYProject.Yut.Play.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Scanner;

import static org.assertj.core.api.Assertions.*;

public class PlayTest {


    @Test
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("말의 개수를 입력하세요");
        int n = sc.nextInt();
        Player player = new Player(n);

        for(Mal mal : player.getMals())
            System.out.println("mal = " + mal);

        System.out.println("현재 보드에 없는 말은");
        for(int i=0; i<player.getMals().size(); i++){
            Mal t_mal = player.getMals().get(i);
            if(t_mal.getBeforelocatoin() == null){
                System.out.println(i + " ");
            }
        }
        System.out.println("번째 말들입니다.");
    }
}