import java.util.*;

public class BinarySearch {

    public static Car binarySearchBrand(ArrayList<Car> cars, String target) {

        int low = 0;
        int high = cars.size() - 1;

        while (low <= high) {

            int mid = (low + high) / 2;

            int compare = cars.get(mid).getBrand().compareToIgnoreCase(target);

            if (compare == 0) {
                return cars.get(mid);
            }
            else if (compare < 0) {
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        }

        return null;
    }

    public static ArrayList<Car> searchByYearRange(ArrayList<Car> cars, int startYear, int endYear) {
        ArrayList<Car> results = new ArrayList<>();
        
        for (Car car : cars) {
            if (car.getYear() >= startYear && car.getYear() <= endYear) {
                results.add(car);
            }
        }
        
        return results;
    }

    public static ArrayList<Car> searchByColor(ArrayList<Car> cars, String targetColor) {
        ArrayList<Car> results = new ArrayList<>();
        
        for (Car car : cars) {
            if (car.getColor().equalsIgnoreCase(targetColor)) {
                results.add(car);
            }
        }
        
        return results;
    }
}
