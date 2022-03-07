import java.util.Scanner;

class Sotrudnik{
    String fam, im, otch, doljnost;
    int oklad;
}

public class Example1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in, "cp1251");

        System.out.println("Введите количество сотрудников =>  ");
        int kol = sc.nextInt();
        sc.nextLine();

        Sotrudnik[] sotr = new Sotrudnik[kol];
        System.out.println("Введите информацию о каждом сотруднике: ");
        for (int i = 0; i < sotr.length; i++) {
            sotr[i] = new Sotrudnik();              // получена ссылка на i-тый элемент

            System.out.print("Введите фамилию " + (i + 1) + " сотрудника => ");
            sotr[i].fam = sc.nextLine();
            System.out.print("Введите его имя  => ");
            sotr[i].im = sc.nextLine();
            System.out.print("Введите его отчество => ");
            sotr[i].otch = sc.nextLine();
            System.out.print("Введите его должность => ");
            sotr[i].doljnost = sc.nextLine();
            System.out.print("Введите его оклад => ");
            sotr[i].oklad = sc.nextInt();
            sc.nextLine();
        }
        System.out.println( "\n Сотрудники фирмы: \n фам \t имя \t отч  +\t должность \tОклад");
        for (Sotrudnik s : sotr) {
            System.out.print(s.fam+ "\t"+s.im + "\t"+s.otch
                    + "\t "+s.doljnost + "\t\t"+s.oklad+ "\n");
        }
    }
}
