import java.util.*;

public class Menu {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        ArrayList<Car> cars = loadCars("Car_Data.csv");

        int choice = 0;

        while (choice != 4) {

            System.out.println("\n--- Project B: Year + Color Explorer ---");
            System.out.println("1. Sort by Year");
            System.out.println("2. Search by Year Range");
            System.out.println("3. Search by Color");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");

            choice = sc.nextInt();
            sc.nextLine();

            if (choice == 1) {
                SimpleSort.selectionSortYear(cars);
                System.out.println("\nCars sorted by Year. Displaying first 10:");
                for (int i = 0; i < 10 && i < cars.size(); i++) {
                    System.out.println(cars.get(i));
                }
            }

            else if (choice == 2) {
                System.out.print("Enter start year: ");
                int startYear = sc.nextInt();
                
                System.out.print("Enter end year: ");
                int endYear = sc.nextInt();
                sc.nextLine();

                ArrayList<Car> results = BinarySearch.searchByYearRange(cars, startYear, endYear);

                if (!results.isEmpty()) {
                    System.out.println("\nFound " + results.size() + " car(s) in year range " + startYear + "-" + endYear + ":");
                    for (Car car : results) {
                        System.out.println(car);
                    }
                } else {
                    System.out.println("No cars found in that year range.");
                }
            }

            else if (choice == 3) {
                System.out.print("Enter color to search: ");
                String color = sc.nextLine();

                ArrayList<Car> results = BinarySearch.searchByColor(cars, color);

                if (!results.isEmpty()) {
                    System.out.println("\nFound " + results.size() + " car(s) with color " + color + ":");
                    for (Car car : results) {
                        System.out.println(car);
                    }
                } else {
                    System.out.println("No cars found with that color.");
                }
            }

            else if (choice == 4) {
                System.out.println("Goodbye!");
            }

            else {
                System.out.println("Invalid choice. Please try again.");
            }
        }

        sc.close();
    }

    public static ArrayList<Car> loadCars(String filename) {
        ArrayList<Car> cars = new ArrayList<>();
        try (Scanner fileScanner = new Scanner(new java.io.File(filename))) {
            fileScanner.nextLine(); // Skip header
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                String[] parts = line.split(",");
                if (parts.length == 7) {
                    int id = Integer.parseInt(parts[0].substring(1)); // Remove 'C' prefix
                    String brand = parts[1];
                    String model = parts[2];
                    int year = Integer.parseInt(parts[3]);
                    String fuelType = parts[4];
                    String color = parts[5];
                    int mileage = (int) Double.parseDouble(parts[6]);
                    
                    cars.add(new Car(id, brand, model, year, fuelType, color, mileage));
                }
            }
        } catch (Exception e) {
            System.out.println("Error loading cars: " + e.getMessage());
        }
        return cars;
    }
}
