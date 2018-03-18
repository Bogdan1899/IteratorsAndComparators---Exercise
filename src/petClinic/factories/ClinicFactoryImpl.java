package iteratorsAndComparators.petClinic.factories;

import iteratorsAndComparators.petClinic.models.interfaces.Clinic;
import iteratorsAndComparators.petClinic.models.ClinicImpl;
import iteratorsAndComparators.petClinic.factories.interfaces.ClinicFactory;

public class ClinicFactoryImpl implements ClinicFactory {


    @Override
    public Clinic createClinic(String name, int rooms) {
        return new ClinicImpl(name, rooms);
    }
}
