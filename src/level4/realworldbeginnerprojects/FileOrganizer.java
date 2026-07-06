package level4.realworldbeginnerprojects;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.Scanner;

public class FileOrganizer {

    public static String getFileExtension(String fileName) {
        int dotIndex = fileName.lastIndexOf('.');
        if (dotIndex == -1 || dotIndex == fileName.length() - 1) {
            return "";
        }
        return fileName.substring(dotIndex).toLowerCase();
    }

    public static String getCategory(String extension) {
        if (extension.equals(".jpg") || extension.equals(".jpeg") || extension.equals(".png") || extension.equals(".gif")) {
            return "Images";
        } else if (extension.equals(".pdf") || extension.equals(".doc") || extension.equals(".docx") || extension.equals(".txt")) {
            return "Documents";
        } else if (extension.equals(".mp4") || extension.equals(".avi") || extension.equals(".mkv") || extension.equals(".mov")) {
            return "Videos";
        } else if (extension.equals(".mp3") || extension.equals(".wav") || extension.equals(".aac")) {
            return "Audio";
        } else if (extension.equals(".zip") || extension.equals(".rar") || extension.equals(".7z")) {
            return "Archives";
        } else if (extension.equals(".java") || extension.equals(".cpp") || extension.equals(".py") || extension.equals(".js")) {
            return "Code";
        } else {
            return "Others";
        }
    }

    public static void organizeFiles(String folderPath) {
        File folder = new File(folderPath);

        if (!folder.exists() || !folder.isDirectory()) {
            System.out.println("Invalid folder path.");
            return;
        }

        File[] files = folder.listFiles();
        if (files == null || files.length == 0) {
            System.out.println("No files found.");
            return;
        }

        for (File file : files) {
            if (file.isFile()) {
                String extension = getFileExtension(file.getName());
                String category = getCategory(extension);

                File categoryFolder = new File(folder, category);
                if (!categoryFolder.exists()) {
                    categoryFolder.mkdirs();
                }

                File destination = new File(categoryFolder, file.getName());

                try {
                    Files.move(file.toPath(), destination.toPath(), StandardCopyOption.REPLACE_EXISTING);
                    System.out.println("Moved: " + file.getName() + " -> " + category);
                } catch (IOException e) {
                    System.out.println("Could not move: " + file.getName());
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter folder path: ");
        String folderPath = scanner.nextLine().trim();

        if (folderPath.isEmpty()) {
            System.out.println("Folder path cannot be empty.");
            scanner.close();
            return;
        }

        organizeFiles(folderPath);
        scanner.close();
    }
}