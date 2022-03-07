import java.util.Scanner;
class Rodina {
    String name;
    double square;
}
public class Example4 {
    static Scanner sc;
    public static Rodina [] setCountry(int count){
        Scanner sc=new Scanner(System.in,"cp1251");
        Rodina[] countries = new Rodina[count];
        sc.nextLine();
        System.out.println("Введите информацию о странах: ");
        for (int i = 0; i < countries.length; i++){
            countries[i] = new Rodina();
            System.out.println("name " + (i + 1));
            countries[i].name = sc.nextLine();
            System.out.println("square " + (i + 1));
            countries[i].square = sc.nextDouble();
            sc.nextLine();
        }
        return countries;
    }

    public static void showArray(Rodina[] countries){
        for (int i=0; i<countries.length;i++){
            System.out.println(countries[i].name + " " + countries[i].square);
        }
    }

    public static void showCountry(Rodina rodina){
        System.out.println(rodina.name + " " + rodina.square);
    }

    public static void sortSquare(Rodina[] countries){
        for(int i =0; i <countries.length-1;i++){
            for (int j =0;j<countries.length-i-1;j++){
                if(countries[j].square > countries[j+1].square){
                    Rodina temp = countries[j];
                    countries[j] = countries[j+1];
                    countries[j+1] = temp;
                }
            }
        }
    }
    public static void sortName(Rodina[] countries){
        for (int i=0;i<countries.length-1;i++){
            for (int j=0;j<countries.length-i-1;j++){
                if(countries[j].name.compareTo(countries[j+1].name)>0){
                    Rodina temp = countries[j];
                    countries[j]=countries[j+1];
                    countries[j+1] =temp;
                }
            }
        }
    }
    public static int nomMax(Rodina[] countries){
        int indexMax = 0;
        double maxSquare = countries[indexMax].square;
        for (int i = 1;i < countries.length;i++){
            if(countries[i].square > maxSquare){
                indexMax = i;
                maxSquare = countries[indexMax].square;
            }
        }
        return indexMax;
    }
    public static double avgSquare(Rodina[] countries){
        double sumSquare =0;
        for(int i = 0; i < countries.length; i++){
            sumSquare += countries[i].square;
        }
        double avgSquare = (double)(sumSquare/countries.length);
        return avgSquare;
    }
    public static Rodina[] bigger(Rodina[] countries){
        double avgSquare = avgSquare(countries);
        int kol = 0;
        for (int i = 0; i < countries.length; i++){
            if(countries[i].square > avgSquare){
                ++kol;
            }
        }
        if(kol!=0){
            int n = -1;
            Rodina[] biggerCountries = new Rodina[kol];
            for (int i = 0; i < countries.length; i++){
                if(countries[i].square > avgSquare){
                    biggerCountries[++n] = countries[i];
                }
            }
            return biggerCountries;
        }
        else{
            return null;
        }
    }
    public static Rodina findForName(Rodina[] countries, String searchName){
        int indexSearch = -1;
        for (int i = 0; i < countries.length; i++){
            if(countries[i].name.equals(searchName)){
                indexSearch = i;
            }
        }
        if (indexSearch!=-1){
            return countries[indexSearch];
        }
        else{
            return null;
        }
    }
    public static void main(String[] args){
        sc = new Scanner(System.in);
        int count = sc.nextInt();
        Rodina[] countries = setCountry(count);
        showArray(countries);

        int indexMax = nomMax(countries);
        System.out.println("Max country");
        showCountry(countries[indexMax]);

        sortSquare(countries);
        System.out.println("Sort by Square");
        showArray(countries);

        sortName(countries);
        System.out.println("Sort by name");
        showArray(countries);

        System.out.println("Countries with square > avgSquare");
        if(bigger(countries)!=null){
            showArray(bigger(countries));
        }
        else {
            System.out.println("Not exist where square > avgSquare");
        }
        sc.nextLine();
        System.out.println("SearchName =>");
        String searchName = sc.nextLine();
        Rodina searchRodina = findForName(countries, searchName);
        if(searchRodina !=null){
            System.out.println("Country is found");
            showCountry(searchRodina);
        }
        else{
            System.out.println("Nothing found");
        }
    }
}