public class Converter {
    static double oneStepLength=0.00075;
    static double oneStepCCal=0.05;

    static double convertDist(double sumSteps) {
        return sumSteps * oneStepLength;
    }
    static double convertCCal(double sumSteps) {
        return sumSteps * oneStepCCal;
    }
}