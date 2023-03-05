package org.example;

import org.example.system.controller.SystemController;
import org.example.wiseSaying.controller.WiseSayingController;

public class App {

    public void run() {
        System.out.println("== 명언앱 ==");

        SystemController systemController = new SystemController();
        WiseSayingController wiseSayingController = new WiseSayingController();

        while (true) {
            System.out.print("명령) ");
            String command = Container.getScanner().nextLine().trim();
            Request rq = new Request(command);

            switch (rq.getActionCode()) {
                case "종료":
                    systemController.exit();
                    return;
                case "등록":
                    wiseSayingController.write();
                    break;
                case "목록":
                    wiseSayingController.list();
                    break;
                case "삭제":
                    wiseSayingController.delete(rq);
                    break;
                case "수정":
                    wiseSayingController.modify(rq);
                    break;
                case "빌드":
                    wiseSayingController.build();
                    break;
            }
        }
    }
}
