package org.workspace.learn.basic.string.methods;

public class StringMethodsExample {
    public static void main(String[] args) {
        String text = "  Hello Java World  ";
        String text2 = "Khanh dep trai";

        System.out.println(text.length()); // Get length - Lấy độ dài chuỗi
        System.out.println(text.toUpperCase()); // To uppercase - Chuyển thành chữ hoa
        System.out.println(text.toLowerCase()); // To lowercase - Chuyển thành chữ thường
        System.out.println(text.trim()); // Remove spaces - Xóa khoảng trắng đầu & cuối
        System.out.println(text.contains("Java")); // Check contains - Kiểm tra chứa "Java"
        System.out.println(text.startsWith("  He")); // Check start - Bắt đầu bằng
        System.out.println(text.endsWith("ld  ")); // Check end - Kết thúc bằng
        System.out.println(text.replace("Java", "Khanh")); // Replace - Thay thế chuỗi
        System.out.println(text.indexOf("Java")); // Find index - Tìm vị trí xuất hiện đầu tiên
        System.out.println(text.lastIndexOf("Java")); // Find last index - Tìm vị trí xuất hiện cuối cùng
        System.out.println(text.substring(2, 7)); // Substring - Cắt chuỗi con

        int result = text.compareTo(text2);
        //Nếu result = 0 thì hai chuỗi đó bằng nhau.
        //Nếu result < 0 thì chuỗi string1 < string2.
        //Nếu result > 0 thì chuỗi string1 > string2.
        System.out.println(result == 0 ? "Equal" : "Not equal");
    }
}
