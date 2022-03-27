import java.util.Scanner;
class Human{
    String fam, ima, otch;
    double voz, raz_odejdi;
}
public class Var {
    public static Human[] setHumanArr(int k){
        Scanner sc = new Scanner(System.in);
        Human peoples[] = new Human[k];
        System.out.println("Введите информацию");
        for (int i = 0; i < peoples.length; i++) {
            peoples[i] = new Human();
            System.out.println("Фамилия " + (i+1));
            peoples[i].fam = sc.nextLine();
            System.out.println("Имя " + (i+1));
            peoples[i].ima = sc.nextLine();
            System.out.println("Отчество " + (i+1));
            peoples[i].otch = sc.nextLine();
            System.out.println("Возраст " + (i+1));
            peoples[i].voz = sc.nextDouble();
            System.out.println("Размер " + (i+1));
            peoples[i].raz_odejdi = sc.nextDouble();
        }
        return peoples;
    }
    public static void showArray(Human[]cntr){
        for (int i = 0; i < cntr.length; i++) {
            System.out.println("" + cntr[i].fam + " " + cntr[i].ima + " " + cntr[i].otch + " " + cntr[i].voz + " " + cntr[i].raz_odejdi );
        }
    }
    public static void showHuman(Human cntr){
        System.out.println("" + cntr.fam + " " + cntr.ima + " " + cntr.otch + " " + cntr.voz + " " + cntr.raz_odejdi); }

    public static int indexMax(Human[]st){
        int indexmax=0;
        double max=st[indexmax].raz_odejdi;
        for (int i = 0; i < st.length; i++)
        if(st[i].raz_odejdi>max){
            max=st[i].raz_odejdi;
            indexmax=i;
        }
        return indexmax;
    }

    public static double avgRaz_odejdi( Human [] cntr){
        double s=0;
        for (int i = 0; i < cntr.length; i++)
            s+=cntr[i].raz_odejdi;
        double sr=s/cntr.length;
        return sr;
    }

    public static Human [] Bigger(Human cntr[]){
        double sred=avgRaz_odejdi(cntr);
        int kol=0; // количество стран
        for (int i = 0; i < cntr.length; i++) {
            if (cntr[i].raz_odejdi>sred)
                ++kol;
        }
        if (kol != 0){
            Human [] bigCountry=new Human[kol];
            int n=-1;
            for (int i = 0; i < cntr.length; i++)
                if (cntr[i].raz_odejdi>sred) {
                    bigCountry[++n]=cntr[i];
                }
            return bigCountry;
        } else return null;
    }
    public static void sortRaz_Odejdi(Human []cntr){
        for (int i = 0; i < cntr.length-1; i++)
            for (int j = 0; j < cntr.length-1-i; j++)
                if (cntr[j].raz_odejdi>cntr[j+1].raz_odejdi){
                    Human rab=cntr[j];
                    cntr[j]=cntr[j+1];
                    cntr[j+1]=rab;
                }
    }
    public static Human findForName(Human cntr[], String name){
        int n=-1;
        for (int i = 0; i < cntr.length; i++)
            if (name.equals(cntr[i].fam))
                n=i;
        if (n!= -1) {
            return cntr[n];
        }else return null;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in,"cp1251");
        System.out.print("Введите количество людей=> ");
        int n=sc.nextInt();
        Human peoples[]= setHumanArr(n);

        System.out.println("\nХарактеристики людей:");
        showArray(peoples);

        int indexmax=indexMax(peoples);
        System.out.println("\nЧеловек с максисальным размером одежды:");
        showHuman(peoples[indexmax]);

        sortRaz_Odejdi(peoples);
        System.out.println("\nОтсортированный список по размеру одежды:");
        showArray(peoples);
// cредняя площадь
        System.out.println("Средний размер одежды ="+avgRaz_odejdi(peoples));

// площадь больше средней
        System.out.println("\nЛюди с размером больше средней");
        Human [] larger=Bigger(peoples);
        showArray(larger);
// поиск страны
        System.out.println("\nПОИСК ЧЕЛОВЕКА \n Введите фамилию человека => ");
        sc.nextLine();
        String sname=sc.nextLine();
        Human sfind =findForName(peoples, sname);
        if (sfind!=null) {
            showHuman(sfind);
        } else {
            System.out.println("Такого человека нет в списке!");
        }}
}


