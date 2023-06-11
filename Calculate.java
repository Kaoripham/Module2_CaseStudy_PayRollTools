package AP0_Module2_Case_PayRoll;

public class Calculate {

    public static double l1 = 5000000;
    public static double l2 = 10000000;
    public static double l3 = 18000000;
    public static double l4 = 32000000;
    public static double l5 = 52000000;
    public static double l6 = 80000000;

    private static double pIT;

    public static double canculatePIT(double preTaxSalary) {
        if (preTaxSalary > l6) {
            pIT = ((preTaxSalary - l6) * 0.35 + (l6 - l5) * 0.30 + (l5 - l4) * 0.25 + (l4 - l3) * 0.2 + (l3 - l2) * 0.15 + (l2 - l1) * 0.1 +
                    l1 * 0.05);
        } else if (preTaxSalary > l5) {
            pIT = ((preTaxSalary - l5) * 0.30 + (l5 - l4) * 0.25 + (l4 - l3) * 0.2 + (l3 - l2) * 0.15 + (l2 - l1) * 0.1 +
                    l1 * 0.05);
        } else if (preTaxSalary > l4) {
            pIT = ((preTaxSalary - l4) * 0.25 + (l4 - l3) * 0.2 + (l3 - l2) * 0.15 + (l2 - l1) * 0.1 +
                    l1 * 0.05);
        } else if (preTaxSalary > l3) {
            pIT = ((preTaxSalary - l3) * 0.2 + (l3 - l2) * 0.15 + (l2 - l1) * 0.1 +
                    l1 * 0.05);
        } else if (preTaxSalary > l2) {
            pIT = ((preTaxSalary - l2) * 0.15 + (l2 - l1) * 0.1 +
                    l1 * 0.05);
        } else if (preTaxSalary > l1) {
            pIT = ((preTaxSalary - l1) * 0.1 +
                    l1 * 0.05);
        } else {
            pIT = preTaxSalary * 0.05;
        }
        return pIT;
    }
}

