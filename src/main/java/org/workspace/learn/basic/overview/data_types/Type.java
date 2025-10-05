package org.workspace.learn.basic.overview.data_types;

public class Type {
    public static void main(String[] args) {
        System.out.println("Có hai loại kiểu dữ liệu lớn trong Java:" +
                " kiểu nguyên thủy và kiểu đối tượng/tham chiếu.\n" +
                "Các kiểu nguyên thủy là các kiểu dữ liệu cơ bản lưu trữ dữ liệu " +
                "đơn giản và tạo thành nền tảng của thao tác dữ liệu.\n " +
                "Ví dụ, Java có các kiểu nguyên thủy cho các giá trị số nguyên " +
                "(int, dài, byte, ngắn),\n giá trị dấu phẩy động (float và double), " +
                "giá trị ký tự (ký tự) và giá trị logic (boolean).\n" +
                "\n" +
                "Mặt khác, các loại tham chiếu là các đối tượng chứa tham chiếu đến các giá trị và / hoặc các đối tượng khác,\n" +
                " hoặc đến giá trị đặc biệt null để biểu thị sự vắng mặt của giá trị.\n" +
                "Lớp String là một ví dụ điển hình về kiểu tham chiếu. Một thực thể của lớp, được gọi là đối tượng,\n" +
                " đại diện cho một chuỗi các ký tự, chẳng hạn như \"Hello World\".\n");
        System.out.println("primitive types : int, long, byte, short, boolean, float, char, double...");
        System.out.println("objects/reference types : String, Double, Float, Integer, Boolean, Char...");
    }
}
