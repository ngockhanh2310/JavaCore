package org.workspace.learn.basic.overview.data_types;

public class DataTypes {
    public static void main(String[] args) {
        System.out.println("Primitive data : kiểu dữ liệu cơ sở");
        // Header
        System.out.printf("| %-10s | %-18s | %-55s | %-40s |%n",
                "Kiểu DL", "Kích thước (bits)", "Phạm vi giá trị", "Ví dụ");
        System.out.println("|------------|--------------------|---------------------------------------------------------|------------------------------------------|");

        // Rows
        System.out.printf("| %-10s | %-18s | %-55s | %-40s |%n",
                "byte", "8", "-128 đến 127", "byte byteNumber = 100;");
        System.out.printf("| %-10s | %-18s | %-55s | %-40s |%n",
                "short", "16", "-32,768 đến 32,767", "short shortNumber = 10000;");
        System.out.printf("| %-10s | %-18s | %-55s | %-40s |%n",
                "int", "32", "-2,147,483,648 đến 2,147,483,647", "int intNumber = 100000;");
        System.out.printf("| %-10s | %-18s | %-55s | %-40s |%n",
                "long", "64", "-9,223,372,036,854,775,808 -> 9,223,372,036,854,775,807", "long longNumber = 100000L;");
        System.out.printf("| %-10s | %-18s | %-55s | %-40s |%n",
                "float", "32", "1.4E-45 đến 3.4028235E38", "float floatNumber = 9.08f;");
        System.out.printf("| %-10s | %-18s | %-55s | %-40s |%n",
                "double", "64", "4.9E-324 đến 1.7976931348623157E308", "double doubleNumber = 9.08;");
        System.out.printf("| %-10s | %-18s | %-55s | %-40s |%n",
                "boolean", "1", "true/false (mặc định false)", "boolean boolValue = true;");
        System.out.printf("| %-10s | %-18s | %-55s | %-40s |%n",
                "char", "16", "0 đến 65,535", "char charValue = 'a';");
        System.out.println();
        System.out.println("Wrapper class");
        // Header
        System.out.printf("| %-15s | %-15s |%n", "Primitive Data", "Wrapper Class");
        System.out.println("|-----------------|-----------------|");

        // Rows
        System.out.printf("| %-15s | %-15s |%n", "boolean", "Boolean");
        System.out.printf("| %-15s | %-15s |%n", "char", "Character");
        System.out.printf("| %-15s | %-15s |%n", "byte", "Byte");
        System.out.printf("| %-15s | %-15s |%n", "short", "Short");
        System.out.printf("| %-15s | %-15s |%n", "int", "Integer");
        System.out.printf("| %-15s | %-15s |%n", "long", "Long");
        System.out.printf("| %-15s | %-15s |%n", "float", "Float");
        System.out.printf("| %-15s | %-15s |%n", "double", "Double");
    }
}
