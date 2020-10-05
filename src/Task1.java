
public class Task1 {
    private static int limitLength = 4;

    public static void main(String[] args) {
        if(args.length != limitLength) {
            System.out.println("Make sure that the number of command line arguments is four");
            return;
        }

        int[] intArray = new int[limitLength];
        boolean error = false;
        for (int i = 0; i < limitLength; i++) {
            try {
                intArray[i] = Integer.parseInt(args[i]);
            } catch (NumberFormatException e) {
                error = true;
                System.out.println("Please enter an integer: " + args[i]);
            }
        }
        if (error) {
            return;
        }

        int max = intArray[0];
        int min = intArray[0];
        for (int v: intArray) {
            if (max < v) {
                max = v;
            }
            if (min > v) {
                min = v;
            }
        }
        System.out.println("Maximum value: " + max);
        System.out.println("Minimum value: " + min);
    }
}
