import jdk.nashorn.internal.ir.WhileNode;

import java.io.*;
import java.util.Scanner;

public class CopyFileText {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhap ten file goc");
        String sourceTextFile = scanner.nextLine();
        System.out.println("Nhap ten file dich");
        String targetTextFile = scanner.nextLine();
        try {
            copyTextFile(sourceTextFile,targetTextFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void copyTextFile(String TextSourceFile, String targetTextFile) throws IOException {

        File file = new File(TextSourceFile);
        if (!file.exists()) {
            System.out.println("tap tin goc khong ton tai");
            return;
        }

        FileReader file1 = new FileReader(file);
        BufferedReader reader = new BufferedReader(file1);

        String line = null;

        File fileTarget = new File(targetTextFile);

        if (!fileTarget.exists()) {
            System.out.println("da tao thu muc dich moi");
            fileTarget.createNewFile();
        } else {
            System.out.println("ghi de file "+targetTextFile);
        }
        FileWriter fileWriter = new FileWriter(fileTarget);

        BufferedWriter writer = new BufferedWriter(fileWriter);

        while ((line = reader.readLine()) != null) {
            writer.write(line+"\n");
        }
        reader.close();
        writer.close();

    }

}
