package iteratorsAndComparators.petClinic;

import iteratorsAndComparators.petClinic.models.interfaces.Clinic;
import iteratorsAndComparators.petClinic.models.interfaces.Pet;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DatabaseImpl implements Database{

    private List<Pet> pets;

    private List<Clinic> clinics;

    public DatabaseImpl() {
        this.setPets(new ArrayList<>());
        this.setClinics(new ArrayList<>());
    }

    public List<Pet> getPets() {
        return Collections.unmodifiableList(this.getPets());
    }

    private void setPets(List<Pet> pets) {
        this.pets = pets;
    }

    public List<Clinic> getClinics() {
        return Collections.unmodifiableList(this.getClinics());
    }

    private void setClinics(List<Clinic> clinics) {
        this.clinics = clinics;
    }

    public void addPet(Pet pet){
        this.pets.add(pet);
    }

    public void addClinic(Clinic clinic){
        this.clinics.add(clinic);
    }

    public boolean addPetToClinic(String petName, String clinicName){
        for (Clinic clinic : clinics) {
            if (clinic.getName().equals(clinicName)){
                for (Pet pet : pets) {
                    if (pet.getName().equals(petName)){
                        return clinic.addPet(pet);
                    }
                }
            }
        }

        return false;
    }

    @Override
    public Pet getPet(String name) {
        for (Pet pet : pets) {
            if (pet.getName().equalsIgnoreCase(name)){
                return pet;
            }
        }

        return null;
    }

    @Override
    public Clinic getClinic(String name) {
        for (Clinic clinic : clinics) {
            if (clinic.getName().equalsIgnoreCase(name)){
                return clinic;
            }
        }

        return null;
    }
}
