package iteratorsAndComparators.equalityLogic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));

        TreeSet<Person> setPersons = new TreeSet<>();
        HashSet<Person> hashPersons = new HashSet<>();

        int lines = Integer.parseInt(bfr.readLine());

        for (int i = 0; i < lines; i++) {
            String[] input = bfr.readLine().split(" ");
            Person person = new Person(input[0], Integer.parseInt(input[1]));
            setPersons.add(person);
            hashPersons.add(person);
        }

        System.out.println(setPersons.size());
        System.out.println(hashPersons.size());
    }
}
