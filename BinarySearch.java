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
