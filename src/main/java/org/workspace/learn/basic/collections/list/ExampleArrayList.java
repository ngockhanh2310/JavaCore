package org.workspace.learn.basic.collections.list;

import java.util.*;

public class ExampleArrayList {
    public static void main(String[] args) {
        List<String> listString = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        // Thêm phần tử vào list - Add elements
        Collections.addAll(listString, "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday");

        // Duyệt bằng Iterator - Traverse using Iterator
        System.out.println("Hiển thị phần tử sử dụng Iterator: ");
        Iterator<String> iterator = listString.iterator();
        if (iterator.hasNext()) {
            do {
                System.out.println(iterator.next());
            } while (iterator.hasNext());
        }

        // Duyệt bằng ListIterator - Traverse using ListIterator
        System.out.println("\nHiển thị phần tử sử dụng ListIterator: ");
        ListIterator<String> listIterator = listString.listIterator();
        while (listIterator.hasNext()) {
            System.out.println(listIterator.next());
        }

        // Thay đổi phần tử - Modify element
        System.out.print("\nNhập vào phần tử mới: ");
        String element = scanner.nextLine();
        System.out.print("Nhập vào chỉ số cần thay đổi (0 - " + (listString.size() - 1) + "): ");
        int index = scanner.nextInt();

        if (index >= 0 && index < listString.size()) {
            listString.set(index, element);
        } else {
            System.out.println("❌ Chỉ số không hợp lệ! - Invalid index!");
        }

        // In danh sách sau khi thay đổi - Print list after modification
        System.out.println("\nDanh sách sau khi thay đổi:");
        listString.forEach(System.out::println);

        // Duyệt ngược - Traverse backward
        System.out.println("\nHiển thị các phần tử của List theo thứ tự từ dưới lên:");
        //listIterator = listString.listIterator(listString.size()); // reset con trỏ - reset iterator
        while (listIterator.hasPrevious()) {
            System.out.println(listIterator.previous());
        }

        // Xóa phần tử - Remove element
        if (index >= 0 && index < listString.size()) {
            listString.remove(index);
        }

        System.out.println("\nDanh sách sau khi xóa:");
        listString.forEach(System.out::println);

        scanner.close();
    }
}
