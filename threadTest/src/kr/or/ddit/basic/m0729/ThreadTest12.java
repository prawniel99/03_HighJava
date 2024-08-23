package kr.or.ddit.basic.m0729;

import java.util.ArrayList;

/*
 * 10마리의 말들이 경주하는 경마 프로그램을 작성하시오.
 * 말은 Horse라는 이름의 쓰레드 클래스로 작성하는데,
 * 이 클래스는 말이름(String), 등수(int), 현재위치(int)를 멤버 변수로 갖는다.
 * 그리고 이 클래스에는 등수를 오름차순으로 처리할 수 있는 내부 정렬 기준이 있다.
 * (Comparable 인터페이스 구현)
 * 
 * 경기 구간은 1~50 구간으로 되어있다.
 * 
 * 경기 중간 중간에 각 말들의 현재 위치를 나타내시오.
 * 예)
 * 말이름01 ----------->------------------------
 * 말이름01 ------->----------------------------
 * ...
 * ...
 * 말이름01 -------------------->---------------
 * 
 * 경기가 모두 끝나면 등수 순으로 출력한다.
 */

public class ThreadTest12 {
    ArrayList<String> ranking = new ArrayList<String>();
    public static void main(String[] args) {
        ThreadTest12 tt = new ThreadTest12();
        tt.ranking.add("잉");
        tt.ranking.add("엥");
        System.out.println(tt.ranking.get(0));
        Horses[] horses = new Horses[] {
            new Horses("일번마"),
            new Horses("이번마"),
            new Horses("삼번마"),
            new Horses("사번마"),
            new Horses("오번마"),
            new Horses("육번마"),
            new Horses("칠번마"),
            new Horses("팔번마"),
            new Horses("구번마"),
            new Horses("십번마")
        };
        
        for(Horses hor : horses) {
            hor.start();
        }

        for(int t=0; t<30; t++) {
            System.out.println("Horse Race\n");
            int stop = 0;
            for(int i=0; i<horses.length; i++) {
                System.out.print(horses[i].getHorsename()+" ");
                int pos = horses[i].getPosition();
                if(pos>=100) stop+=1;
                for(int j=0; j<pos; j++) {
                    System.out.print(" ");
                }
                if(pos<100) {
                    System.out.print(">");
                    System.out.print(pos);
                    System.out.println();
                    System.out.println("-------------------------------------------------------------------------------------------------------------------");
                } else {
                    System.out.print(">");
                    System.out.print("골인");
                    System.out.println();
                    System.out.println("-------------------------------------------------------------------------------------------------------------------");
                }
            }
            try {
                Thread.sleep(1000);
            } catch (Exception e) {

            }
            if(stop==10) break;
            sp();
        }

        System.out.println("끝");

        
        for(int i=0; i<horses.length; i++) {
            try {
                horses[i].join();
            } catch (InterruptedException e) {
                
            }
        }
        System.out.println(tt.ranking.toString());
        
        // System.out.println(horse);
    }

    public static void sp() {
        for(int i=0; i<20; i++) {
            System.out.println();
        }
    }
}

class Horses extends Thread {
    private String horsename;
    private int rank;
    private int position;
    ThreadTest12 a = new ThreadTest12();
    
    public Horses(String horsename) {
        this.horsename = horsename;
    }

    public Horses() {
    }

    @Override
    public void run() {
        while(true) {
            position+=((int)(Math.random()*3)+1);
            if(position>=100) {
                a.ranking.add(horsename);
                break;
            }
            
            try {
                sleep(300);
            } catch (InterruptedException e) {
                
            }
        }
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public String getHorsename() {
        return horsename;
    }

    public void setHorsename(String horsename) {
        this.horsename = horsename;
    }
}
