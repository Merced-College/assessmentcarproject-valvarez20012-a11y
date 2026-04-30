import java.util.ArrayList;

public class Stats {

    public static void averageMileage(ArrayList<Car> cars) {
        double total = 0;

        for (Car car : cars) {
            total += car.getMileageKmpl();
        }

        double avg = total / cars.size();

        System.out.printf("Average Mileage: %.2f kmpl\n", avg);
    }
}