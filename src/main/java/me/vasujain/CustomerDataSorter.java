package me.vasujain;

import java.util.List;

public class CustomerDataSorter {

    public static void quickSort(List<Customer> customers, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(customers, low, high);
            quickSort(customers, low, pivotIndex - 1);
            quickSort(customers, pivotIndex + 1, high);
        }
    }

    private static int partition(List<Customer> customers, int low, int high) {
        Customer pivot = customers.get(high);
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (customers.get(j).getId() < pivot.getId()) {
                i++;
                swap(customers, i, j);
            }
        }
        swap(customers, i + 1, high);
        return i + 1;
    }

    private static void swap(List<Customer> customers, int i, int j) {
        Customer temp = customers.get(i);
        customers.set(i, customers.get(j));
        customers.set(j, temp);
    }

    public static void mergeSort(List<Customer> customers, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            mergeSort(customers, left, mid);
            mergeSort(customers, mid + 1, right);
            merge(customers, left, mid, right);
        }
    }

    private static void merge(List<Customer> customers, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        Customer[] leftArray = new Customer[n1];
        Customer[] rightArray = new Customer[n2];

        for (int i = 0; i < n1; i++) leftArray[i] = customers.get(left + i);
        for (int j = 0; j < n2; j++) rightArray[j] = customers.get(mid + 1 + j);

        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            if (leftArray[i].getId() <= rightArray[j].getId()) {
                customers.set(k, leftArray[i]);
                i++;
            } else {
                customers.set(k, rightArray[j]);
                j++;
            }
            k++;
        }

        while (i < n1) {
            customers.set(k, leftArray[i]);
            i++;
            k++;
        }

        while (j < n2) {
            customers.set(k, rightArray[j]);
            j++;
            k++;
        }
    }
}
