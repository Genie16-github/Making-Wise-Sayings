package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    private final Scanner sc;

    public App(Scanner sc){
        this.sc = sc;
    }

    public void run() {
        System.out.println("== 명언 앱 ==");

        long lastWiseSayingId = 0;
        List<WiseSaying> wiseSayings = new ArrayList<>();

        label:
        while (true) {
            System.out.print("명령) ");
            String command = sc.nextLine().trim();   // 좌우 공백 제거
            switch (command) {
                case "종료":
                    break label;
                case "등록":
                    long id = lastWiseSayingId + 1;
                    System.out.print("명언 : ");
                    String content = sc.nextLine().trim();
                    System.out.print("작가 : ");
                    String authorName = sc.nextLine().trim();

                    WiseSaying wiseSaying = new WiseSaying(id, content, authorName);
                    wiseSayings.add(wiseSaying);

                    System.out.printf("%d번 명언이 등록되었습니다.\n", id);
                    lastWiseSayingId = id;                // 인덱스 증가

                    break;
                case "목록":
                    System.out.printf("생성된 명언 수 : %d\n", wiseSayings.size());
                    break;
            }
        }
    }
}
