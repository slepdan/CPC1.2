import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class InfoAboutPeopleOne {
    public static void main(String[] args) {
        System.out.println("count");
        Scanner sc = new Scanner(System.in);
        int count = sc.nextInt();
        sc.nextLine();
        People[] peoples = new People[count];
        for (int i = 0; i < peoples.length; i++) {
            peoples[i] = new People();
            System.out.println("Fam");
            peoples[i].fam = sc.nextLine();
            System.out.println("Ima");
            peoples[i].ima = sc.nextLine();
            System.out.println("Otch");
            peoples[i].otch = sc.nextLine();
            System.out.println("Voz");
            peoples[i].voz = sc.nextInt();
            System.out.println("Raz_Odejdi");
            peoples[i].raz_odejdi = sc.nextInt();
            sc.nextLine();
        }
        System.out.println("\n");
        for (int i = 0; i < peoples.length; i++) {
            //System.out.println("People" + peoples[i].fam + "\t" + peoples[i].ima + "\t" + peoples[i].otch + "\t" + peoples[i].voz + " Let " + peoples[i].raz_odejdi + " Raz_odejdi"  );
            System.out.println(peoples[i]);
        }
        int indexMax = 0;
        int maxSize = peoples[indexMax].raz_odejdi;

        for (int i = 1; i < peoples.length; i++) {
            if (peoples[i].raz_odejdi > maxSize) {
                indexMax = i;
                maxSize = peoples[indexMax].raz_odejdi;
            }
        }
        System.out.println("Человек с макс размером одежды");
        System.out.println(peoples[indexMax]);

        int s = 0;

        int kol = 0;
        for (int i = 0; i < peoples.length; i++) {
            if (peoples[i].voz > 40) {
                s += peoples[i].raz_odejdi;
                kol++;
            }
        }

        if (kol != 0) {
            int sr = s / kol;
            System.out.println("Средний размер одежды " + sr);
        } else {
            System.out.println("Нет людей больше 40 лет");
        }
        for (int i = 0; i < peoples.length-1 ; i++)
            for (int j = 0; j < peoples.length-1-i ; j++)
                if (peoples[j].raz_odejdi>peoples[j+1].raz_odejdi){
                    People rab= peoples[j];
                    peoples[j]=peoples[j+1];
                    peoples[j+1]=rab;
                }
        System.out.println("\nОтсортированный список по размеру одежды:");//
        for (int i = 0; i < peoples.length; i++) {
            System.out.println(peoples[i]);
        }

        System.out.println("Введите человека=> ");
        String name=sc.nextLine();
        int nom=-1;

        for (int i = 0; i < peoples.length; i++)
            if (name.equalsIgnoreCase(peoples[i].fam))
                nom=i;
        if (nom!= -1) {
            System.out.println("Такой человек есть в списке. Это "
                    +peoples[nom].toString());
        }else System.out.println("Такого человека нет в списке");
        People newPeople; {
            Scanner scan = new Scanner(System.in);
            System.out.print("Введите фамилию: ");
            String fam = scan.next();
            System.out.print("Введите имя: ");
            String ima = scan.next();
            System.out.print("Введите отчество: ");
            String otch = scan.next();
            System.out.print("Введите возраст: ");
            int voz = scan.nextInt();
            System.out.print("Введите размер одежды: ");
            int raz_odejdi = scan.nextInt();
            People h = new People(fam, ima, otch, voz, raz_odejdi);
            System.out.println(h);
        }

    }
}
