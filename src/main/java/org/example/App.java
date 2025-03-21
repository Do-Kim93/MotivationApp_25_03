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
            System.out.println("명령어- 추가:add, 목록:list, 삭제:remove 삭제하려는 글 id ");
            String cmd = sc.nextLine().trim();
            String cmd1 = "";
            int cmd2 = 0;
            try {//고민 하다 그냥 예외처리로 감싸버림 이렇게 안하면 if문 너무 많이 써야함
                if (cmd.contains("remove ")){
                    cmd1 = cmd.split(" ")[0];
                    cmd2 = Integer.parseInt(cmd.split(" ")[1]);
                }
            }catch (Exception e){
                System.out.println("사용할 수 없는 명령어야");
                continue;
            }
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
            } else if (cmd1.equals("remove")) {//근데 컨테인스 쓰면 remove가 포합되어 있고 뒤에 숫자가 없어도 실행되서 오류로 넘어가는 함정이 있음
                    motivationController.del(cmd2);

            }
            else {
                System.out.println("사용할 수 없는 명령어야");
                continue;
            }
        }
    }
}