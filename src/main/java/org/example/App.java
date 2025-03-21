package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {

    private Scanner sc;

    public App(Scanner sc) {
        this.sc = sc;
    }

    public void run() {
        System.out.println("== motivation 실행 ==");

        int lastId = 0;

//        Motivation motivation0 = null;
//        Motivation motivation1 = null;
//        Motivation motivation2 = null;

//        Motivation[] motivations = new Motivation[2];

        List<Motivation> motivations = new ArrayList<Motivation>();

        while (true) {
            System.out.print("명령어) ");
            String cmd = sc.nextLine().trim();

            if (cmd.equals("exit")) {
                System.out.println("== motivation 종료 ==");
                break;
            } else if (cmd.length() == 0) {
                System.out.println("명령어가 입력되지 않았음");
                continue;
            }

            if (cmd.equals("add")) {
                int id = lastId + 1;
                System.out.print("body : ");
                String body = sc.nextLine();
                System.out.print("source : ");
                String source = sc.nextLine();

                Motivation motivation = new Motivation(id, body, source);
//                motivation.id = id;
//                motivation.body = body;
//                motivation.source = source;

                motivations.add(motivation);

//                if (motivation.id == 1) {
//                    motivation0 = motivation;
//                } else if (motivation.id == 2) {
//                    motivation1 = motivation;
//                } else if (motivation.id == 3) {
//                    motivation2 = motivation;
//                }

                System.out.printf("%d번 motivation이 등록됨\n", id);
                lastId++;
            } else if (cmd.equals("list")) {
                System.out.println("=".repeat(40));
                System.out.printf("   번호    /     source      /      motivation        \n");
//                System.out.println(motivation0.toString());
//                System.out.println(motivation1.toString());
//                System.out.println(motivation2.toString());
//                for (Motivation motivation : motivations) {
//                    System.out.println(motivation.toString());
//                }

                if (motivations.size() == 0) {
                    System.out.println("등록된 moti 없어");
                } else {
                    System.out.println("1개 이상 있음");
                }

                System.out.println("=".repeat(40));
            }


        }
    }
}

class Motivation {
    int id;
    String body;
    String source;

    public Motivation(int id, String body, String source) {
        this.id = id;
        this.body = body;
        this.source = source;
    }

    @Override
    public String toString() {
        return "Motivation{" +
                "id=" + id +
                ", body='" + body + '\'' +
                ", source='" + source + '\'' +
                '}';
    }
}