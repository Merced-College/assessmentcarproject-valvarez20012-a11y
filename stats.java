public static void averageMileage(ArrayList<Car> cars) {

    int total = 0;

    for (Car car : cars) {
        total += car.getMileage();
    }

    double avg = (double) total / cars.size();

    System.out.println("Average Mileage: " + avg);
}
