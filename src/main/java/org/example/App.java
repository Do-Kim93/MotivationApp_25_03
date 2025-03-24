package org.example;

import org.example.motivation.controller.MotivationController;
import org.example.system.controller.SystemController;

import java.util.Scanner;

public class App {

    private Scanner sc;

    public App(Scanner sc) {
        this.sc = sc;
    }

    public void run() {
        System.out.println("== motivation 실행 ==");

        SystemController systemController = new SystemController();
        MotivationController motivationController = new MotivationController(sc);

        while (true) {
            System.out.print("명령어) ");
            String cmd = sc.nextLine().trim();
            if (cmd.equals("exit")) {
                systemController.exit();
                break;
            } else if (cmd.length() == 0) {
                System.out.println("명령어가 입력되지 않았음");
                continue;
            }

            if (cmd.equals("add")) {
                motivationController.add();
            } else if (cmd.equals("list")) {
                motivationController.list();
            } else if (cmd.startsWith("delete")) {
                motivationController.delete(cmd);
//                if (cmd.contains("?id=")) { 굳이 펑션 하나더 만들 필요 없음 조건문 하나로 해결 가능한 문제
//                    motivationController.delete1(cmd);
//                    continue;
//                }else {
//                    motivationController.delete(cmd);
//                }
            } else {
                System.out.println("사용할 수 없는 명령어야");
                continue;
            }
        }
    }
}