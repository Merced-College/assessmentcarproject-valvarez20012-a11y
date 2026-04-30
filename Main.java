import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        ArrayList<Car> cars = loadCars("Car_Data.csv");

        if (cars.size() < 2000) {
            System.out.println("Not enough cars loaded to create working list.");
            return;
        }

        ArrayList<Car> working = new ArrayList<>(cars.subList(0, 2000));

        Scanner input = new Scanner(System.in);
        boolean sorted = false;
        int choice;

        do {
            System.out.println("\n===== Project A: Brand + Efficiency Finder =====");
            System.out.println("1. Sort by Brand");
            System.out.println("2. Search by Brand");
            System.out.println("3. Show Statistics");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");

            choice = input.nextInt();
            input.nextLine();

            if (choice == 1) {
                selectionSortByBrand(working);
                sorted = true;

                System.out.println("\nFirst 10 cars after sorting by brand:");
                printFirstTen(working);
            }
            else if (choice == 2) {
                if (!sorted) {
                    selectionSortByBrand(working);
                    sorted = true;
                }

                System.out.print("Enter brand to search: ");
                String brand = input.nextLine();

                ArrayList<Car> results = binarySearchByBrand(working, brand);

                if (results.isEmpty()) {
                    System.out.println("No cars found with brand: " + brand);
                } else {
                    System.out.println("\nFound cars:");
                    for (Car car : results) {
                        System.out.println(car);
                    }
                }
            }
            else if (choice == 3) {
                showStats(working);
            }
            else if (choice == 4) {
                System.out.println("Goodbye!");
            }
            else {
                System.out.println("Invalid choice.");
            }

        } while (choice != 4);

        input.close();
    }

    public static ArrayList<Car> loadCars(String filename) {
        ArrayList<Car> cars = new ArrayList<>();

        try {
            Scanner fileScanner = new Scanner(new File(filename));

            if (fileScanner.hasNextLine()) {
                fileScanner.nextLine();
            }

            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                String[] parts = line.split(",");

                if (parts.length == 7) {
                    try {
                        int carID = Integer.parseInt(parts[0].trim());
                        String brand = parts[1].trim();
                        String model = parts[2].trim();
                        int year = Integer.parseInt(parts[3].trim());
                        String fuelType = parts[4].trim();
                        String color = parts[5].trim();
                        double mileage = Double.parseDouble(parts[6].trim());

                        Car car = new Car(carID, brand, model, year, fuelType, color, mileage);
                        cars.add(car);
                    } catch (NumberFormatException e) {
                        // skips malformed rows safely
                    }
                }
            }

            fileScanner.close();

        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + filename);
        }

        System.out.println("Total cars loaded: " + cars.size());
        return cars;
    }

    public static void selectionSortByBrand(ArrayList<Car> list) {
        for (int i = 0; i < list.size() - 1; i++) {
            int minIndex = i;

            for (int j = i + 1; j < list.size(); j++) {
                if (list.get(j).getBrand().compareToIgnoreCase(list.get(minIndex).getBrand()) < 0) {
                    minIndex = j;
                }
            }

            Car temp = list.get(i);
            list.set(i, list.get(minIndex));
            list.set(minIndex, temp);
        }
    }

    public static ArrayList<Car> binarySearchByBrand(ArrayList<Car> list, String targetBrand) {
        ArrayList<Car> matches = new ArrayList<>();

        int low = 0;
        int high = list.size() - 1;
        int foundIndex = -1;

        while (low <= high) {
            int mid = (low + high) / 2;
            int compare = list.get(mid).getBrand().compareToIgnoreCase(targetBrand);

            if (compare == 0) {
                foundIndex = mid;
                break;
            }
            else if (compare < 0) {
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        }

        if (foundIndex == -1) {
            return matches;
        }

        int left = foundIndex;
        while (left >= 0 && list.get(left).getBrand().equalsIgnoreCase(targetBrand)) {
            left--;
        }

        int right = foundIndex + 1;
        while (right < list.size() && list.get(right).getBrand().equalsIgnoreCase(targetBrand)) {
            right++;
        }

        for (int i = left + 1; i < right; i++) {
            matches.add(list.get(i));
        }

        return matches;
    }

    public static void showStats(ArrayList<Car> list) {
        double totalMileage = 0;

        int petrolCount = 0;
        int dieselCount = 0;
        int electricCount = 0;
        int hybridCount = 0;
        int otherCount = 0;

        for (Car car : list) {
            totalMileage += car.getMileageKmpl();

            String fuel = car.getFuelType().toLowerCase();

            if (fuel.equals("petrol")) {
                petrolCount++;
            }
            else if (fuel.equals("diesel")) {
                dieselCount++;
            }
            else if (fuel.equals("electric")) {
                electricCount++;
            }
            else if (fuel.equals("hybrid")) {
                hybridCount++;
            }
            else {
                otherCount++;
            }
        }

        double averageMileage = totalMileage / list.size();

        System.out.println("\n===== Statistics =====");
        System.out.printf("Average mileage: %.2f kmpl\n", averageMileage);
        System.out.println("Petrol count: " + petrolCount);
        System.out.println("Diesel count: " + dieselCount);
        System.out.println("Electric count: " + electricCount);
        System.out.println("Hybrid count: " + hybridCount);
        System.out.println("Other fuel count: " + otherCount);
    }

    public static void printFirstTen(ArrayList<Car> list) {
        int limit = Math.min(10, list.size());

        for (int i = 0; i < limit; i++) {
            System.out.println(list.get(i));
        }
    }
}