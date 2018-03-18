package iteratorsAndComparators.petClinic.factories;

import iteratorsAndComparators.petClinic.models.interfaces.Pet;
import iteratorsAndComparators.petClinic.models.PetImpl;
import iteratorsAndComparators.petClinic.factories.interfaces.PetFactory;

public class PetFactoryImpl implements PetFactory{

    @Override
    public Pet createPet(String name, int age, String kind) {
        return new PetImpl(name, age, kind);
    }
}
