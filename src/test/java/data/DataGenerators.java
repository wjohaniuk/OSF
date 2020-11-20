package data;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DataGenerators {

    public static String generateIssnNumber(){
        Random random = new Random();
        String checksum;

        List<Integer> numbers = new ArrayList<>();
        for(int i=0;i<7;i++){
            numbers.add(random.nextInt(10));
        }

        int temp = 11-((numbers.get(0)*8+numbers.get(1)*7+numbers.get(2)*6+numbers.get(3)*5+numbers.get(4)*4
                +numbers.get(5)*3+numbers.get(6)*2)%11);
        if (temp == 11) temp = 0;
        if (temp == 10){ checksum = "X";} else { checksum = Integer.toString(temp); }

        StringBuilder issnNumber = new StringBuilder();
        numbers.forEach(issnNumber::append);
        issnNumber.insert(4,"-",0,1).append(checksum);

        return issnNumber.toString();
    }

    public static String nipNumber(){
        Random random = new Random();
        List<Integer> numbers = new ArrayList<>();
        for(int i=0;i<9;i++){
            numbers.add(random.nextInt(10));
        }
        int temp = ((numbers.get(0)*6+numbers.get(1)*5+numbers.get(2)*7+numbers.get(3)*2+numbers.get(4)*3
                +numbers.get(5)*4+numbers.get(6)*5+numbers.get(7)*6+numbers.get(8)*7)%11);
        if (temp == 10) {
            return nipNumber();
        }
        else {
            String checksum = Integer.toString(temp);
            StringBuilder nipNumber = new StringBuilder();
            for (Integer x : numbers) {
                nipNumber.append(x);
            }
            String razem = nipNumber + checksum;
            return razem;
        }
    }
    public static String imiona(){
        Random random = new Random();
        String[] names = {"Marcin", "Tomek", "Rafał", "Karolina", "Anna", "Jan", "Mariusz"};
        int numer = random.nextInt(6);
        return names[numer];
    }
    public static String nazwiska(){
        Random random = new Random();
        String[] surnames = {"Nowak", "Kowalski", "Testowski", "Lewandowski", "Boruc", "Jędrzejewski", "Żdanowski"};
        int numer = random.nextInt(6);
        return surnames[numer];
    }

    public static String kontoBankowe() {
        Random random = new Random();
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < 27; i++) {
            numbers.add(random.nextInt(10));
        }

        String numerKonta = "";
        for (Integer s : numbers){
            numerKonta += s;
        }

        return numerKonta;
    }

}
