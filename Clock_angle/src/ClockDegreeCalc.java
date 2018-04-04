public class ClockDegreeCalc {
    private  int[] arguments = new int[2];

    public static void main(String[] args) {
        ClockDegreeCalc clockDegreeCalc = new ClockDegreeCalc();
        if (clockDegreeCalc.checkForArguments(args)) {
            System.out.println(clockDegreeCalc.getAngle(clockDegreeCalc.arguments[0], clockDegreeCalc.arguments[1]));
        }
    }

    boolean checkForArguments(String[] args) {
        try {
            arguments[0] = Integer.valueOf(args[0]);
            arguments[1] = Integer.valueOf(args[1]);
            return true;
        } catch (ArrayIndexOutOfBoundsException exception) {
            System.out.println("Not enough arguments provided. Need at least 2.");
            throw new ArrayIndexOutOfBoundsException();
        } catch (NumberFormatException formatException) {
            System.out.println("Arguments have to integers.");
            throw new NumberFormatException();
        }

    }


    double getAngle(int hour, int minute) {
        double hourAngle = calculateHourAngle(hour, minute);
        int minuteAngle = calculateMinuteAngle(minute);

        double totalAngle = Math.abs(hourAngle - minuteAngle);
        totalAngle = reduceOverAngle(totalAngle);

        return Math.abs(totalAngle);
    }

    double reduceOverAngle(double totalAngle) {
        while (totalAngle > 180) {
            totalAngle -= 360;
        }
        return totalAngle;
    }

    int calculateMinuteAngle(int minute) {
        return Math.abs(6 * minute);
    }

    double calculateHourAngle(int hour, int minute) {
        return Math.abs(0.5 * (60 * hour + minute));
    }
}
