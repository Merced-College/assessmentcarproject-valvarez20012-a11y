import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        ArrayList<Car> cars = loadCars("cars.csv");

        int choice = 0;

        while (choice != 4) {

            System.out.println("\n--- Car Menu ---");
            System.out.println("1. Sort by Brand");
            System.out.println("2. Search by Brand");
            System.out.println("3. Show Stats");
            System.out.println("4. Exit");

            choice = sc.nextInt();
            sc.nextLine();

            if (choice == 1) {

                selectionSortBrand(cars);

                System.out.println("First 10 cars after sort:");

                for (int i = 0; i < 10 && i < cars.size(); i++) {
                    System.out.println(cars.get(i));
                }
            }

            else if (choice == 2) {

                System.out.print("Enter brand: ");
                String brand = sc.nextLine();

                Car result = binarySearchBrand(cars, brand);

                if (result != null)
                    System.out.println(result);
                else
                    System.out.println("Car not found.");
            }

            else if (choice == 3) {

                averageMileage(cars);
                fuelCounts(cars);
            }
        }

        sc.close();
    }
}
