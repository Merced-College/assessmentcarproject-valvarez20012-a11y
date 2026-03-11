public static void selectionSortBrand(ArrayList<Car> cars) {

    for (int i = 0; i < cars.size() - 1; i++) {

        int minIndex = i;

        for (int j = i + 1; j < cars.size(); j++) {

            if (cars.get(j).getBrand().compareToIgnoreCase(cars.get(minIndex).getBrand()) < 0) {
                minIndex = j;
            }
        }

        Car temp = cars.get(i);
        cars.set(i, cars.get(minIndex));
        cars.set(minIndex, temp);
    }
}
