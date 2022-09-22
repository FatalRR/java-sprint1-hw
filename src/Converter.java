public class Converter {
    static final double oneStepLength=0.00075;
    static final  double oneStepCCal=0.05;

    double convertDist(double sumSteps) {
        return sumSteps * oneStepLength;
    }
    double convertCCal(double sumSteps) {
        return sumSteps * oneStepCCal;
    }
}