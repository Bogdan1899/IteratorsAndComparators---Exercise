package iteratorsAndComparators.petClinic;

import iteratorsAndComparators.petClinic.factories.ClinicFactoryImpl;
import iteratorsAndComparators.petClinic.factories.PetFactoryImpl;
import iteratorsAndComparators.petClinic.factories.interfaces.ClinicFactory;
import iteratorsAndComparators.petClinic.factories.interfaces.PetFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        int numberOfCommands = Integer.parseInt(bfr.readLine());

        ClinicFactory clinicFactory = new ClinicFactoryImpl();
        PetFactory petFactory = new PetFactoryImpl();
        Database database = new DatabaseImpl();
        CommandExecutor commandExecutor = new CommandExecutorImpl(clinicFactory, petFactory, database);

        for (int i = 0; i < numberOfCommands; i++) {
            String[] inputArgs = bfr.readLine().split(" ");
            commandExecutor.execute(inputArgs);
        }
    }
}
