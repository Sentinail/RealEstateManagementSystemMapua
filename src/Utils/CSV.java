/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utils;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

/**
 *
 * @author Sentinail
 */
public class CSV {
    public static void writeToFile(String filePath, List<String[]> data) {
        try (FileWriter writer = new FileWriter(filePath)) {
            for (String[] row : data) {
                for (int i = 0; i < row.length; i++) {
                    writer.append(escapeCSV(row[i])); // Escape and enclose in quotes if needed
                    if (i < row.length - 1) {
                        writer.append(",");
                    }
                }
                writer.append("\n");
            }
            System.out.println("CSV file written successfully: " + filePath);
        } catch (IOException e) {
            System.err.println("Error writing CSV file: " + e.getMessage());
        }
    }

    private static String escapeCSV(String value) {
        if (value.contains(",") || value.contains("\"") || value.contains("\n")) {
            value = value.replace("\"", "\"\""); // Escape double quotes
            return "\"" + value + "\""; // Enclose in quotes
        }
        return value;
    }
}
