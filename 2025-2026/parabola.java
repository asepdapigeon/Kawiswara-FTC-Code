public class parabola {
    public static void main(String[] args) {
        // double voltage = hardwareMap.get(VoltageSensor.class, "Control Hub").getVoltage();
        double voltage = 12;
        double RPM = 6000 * (12.0/voltage);
        double circumferenceMM = 45 * Math.PI;
        double circumferenceM = circumferenceMM/1000;

        double heightdiff = 0.8975;
        double distance = 2;
        double launchDegree = 48;

        double powerneeded = Math.sqrt(
            (9.8*Math.pow(distance, 2))/
            (Math.pow(Math.cos(launchDegree),2)*
            (distance*Math.tan(launchDegree)-(heightdiff-0.12)))
        );
        
        double requiredRPM = (powerneeded * 60) / circumferenceM;
        double motorpower = requiredRPM / RPM;

        System.out.println(motorpower); 
    }
}