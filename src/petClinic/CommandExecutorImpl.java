package iteratorsAndComparators.petClinic;

import iteratorsAndComparators.petClinic.factories.interfaces.ClinicFactory;
import iteratorsAndComparators.petClinic.factories.interfaces.PetFactory;
import iteratorsAndComparators.petClinic.models.interfaces.Clinic;
import iteratorsAndComparators.petClinic.models.interfaces.Pet;

public class CommandExecutorImpl implements CommandExecutor{

    private ClinicFactory clinicFactory;

    private PetFactory petFactory;

    private Database database;

    public CommandExecutorImpl(ClinicFactory clinicFactory, PetFactory petFactory, Database database) {
        this.clinicFactory = clinicFactory;
        this.petFactory = petFactory;
        this.database = database;
    }

    public void execute(String[] inputArgs){
        try {
            Clinic clinic = null;
            Pet pet = null;

            switch (inputArgs[0].toLowerCase()){
                case "create":
                    if (inputArgs[1].equalsIgnoreCase("clinic")){
                        clinic = this.clinicFactory.createClinic(inputArgs[2], Integer.parseInt(inputArgs[3]));
                        this.database.addClinic(clinic);
                    } else {
                        pet = this.petFactory.createPet(inputArgs[2], Integer.parseInt(inputArgs[3]), inputArgs[4]);
                        this.database.addPet(pet);
                    }
                    break;
                case "add":
                    clinic = this.database.getClinic(inputArgs[2]);
                    pet = this.database.getPet(inputArgs[1]);
                    System.out.println(clinic.addPet(pet));
                    break;
                case "release":
                    clinic = this.database.getClinic(inputArgs[1]);
                    System.out.println(clinic.release());
                    break;
                case "hasemptyrooms":
                    clinic = this.database.getClinic(inputArgs[1]);
                    System.out.println(clinic.hasEmptyRooms());
                    break;
                case "print":
                    clinic = this.database.getClinic(inputArgs[1]);

                    if (inputArgs.length == 2){
                        System.out.println(clinic.toString());
                    } else {
                        System.out.println(clinic.print(Integer.parseInt(inputArgs[2])));
                    }
            }
        } catch (IllegalArgumentException ex){
            System.out.println("Invalid operation!");
        }
    }
}
