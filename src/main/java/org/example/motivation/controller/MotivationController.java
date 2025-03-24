package org.example.motivation.controller;

import org.example.motivation.entity.Motivation;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MotivationController {

    int lastId = 0; // 몇 번까지 썼더라?
    List<Motivation> motivations = new ArrayList<>(); // motivation 저장// 소
    Scanner sc;

    public MotivationController(Scanner sc) {
        this.sc = sc;
    }

    public void add() {

        int id = lastId + 1;
        System.out.print("body : ");
        String body = sc.nextLine();
        System.out.print("source : ");
        String source = sc.nextLine();

        Motivation motivation = new Motivation(id, body, source);

        motivations.add(motivation);

        System.out.printf("%d번 motivation이 등록됨\n", id);
        lastId++;
    }

    public void list() {
        if (motivations.size() == 0) {
            System.out.println("등록된 moti 없어");
            return;
        }

        System.out.println("=".repeat(40));
        System.out.printf("   id    /     source      /      body        \n");

        for (int i = motivations.size() - 1; i >= 0; i--) {
            Motivation motivation = motivations.get(i);

            if (motivation.getSource().length() > 7) {
                System.out.printf("   %d    /     %s     /      %s        \n", motivation.getId(), motivation.getSource().substring(0, 5) + "...", motivation.getBody());
                continue;
            }
            System.out.printf("   %d    /     %s        /      %s        \n", motivation.getId(), motivation.getSource(), motivation.getBody());
        }

        System.out.println("=".repeat(40));
    }

    public void delete(String cmd) {
        int id = 0;
        //굳이 새로운 메서드 만들 필요없이 delete에서 다 받아주면됨
        if (cmd.contains("?id=")) {//조건문 걸어서 넘어오는 명령문을 두개로 나누고 자르는 형식을 다르게 돌리면 조건문 하나만 추가해서 해결 가능함
            id = Integer.parseInt(cmd.split("=")[1]);
        }else{
            id = Integer.parseInt(cmd.split(" ")[1]);
        }

        Motivation foundMotivation = null;
        int foundIndex = -1;

        for (int i = 0; i < motivations.size(); i++) {
            Motivation motivation = motivations.get(i);
            if (motivation.getId() == id) {
                foundMotivation = motivation;
                foundIndex = i;
                break;
            }
        }


        if (foundMotivation == null) {
            System.out.println("해당 moti는 없던데????");
            return;
        }

        motivations.remove(foundIndex);
        System.out.println(id + "번 moti 삭제됨");
    }

//    public void delete1(String cmd) { 굳이 이렇게 할 필요 없음
//        int id = Integer.parseInt(cmd.split("=")[1]);
//
//        Motivation foundMotivation1 = null;
//        int foundIndex1 = -1;
//
//        for (int i = 0; i < motivations.size(); i++) {
//            Motivation motivation = motivations.get(i);
//            if (motivation.getId() == id) {
//                foundMotivation1 = motivation;
//                foundIndex1 = i;
//                break;
//            }
//        }
//        if (foundMotivation1 == null) {
//            System.out.println("해당 moti는 없던데????");
//            return;
//        }
//        motivations.remove(foundIndex1);
//        System.out.println(id + "번 moti 삭제됨");
    }
