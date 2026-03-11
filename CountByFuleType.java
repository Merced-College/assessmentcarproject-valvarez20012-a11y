public static void fuelCounts(ArrayList<Car> cars) {

    HashMap<String, Integer> map = new HashMap<>();

    for (Car car : cars) {

        String fuel = car.getFuelType();

        map.put(fuel, map.getOrDefault(fuel, 0) + 1);
    }

    System.out.println("Fuel Type Counts:");

    for (String fuel : map.keySet()) {
        System.out.println(fuel + ": " + map.get(fuel));
    }
}
