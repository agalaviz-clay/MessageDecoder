import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class MessageDecoder {
    private static void readFileAndPopulateMap(File file, HashMap<Integer, String> fileMap) {
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(" ");
                int num = Integer.parseInt(parts[0]);
                String word = parts[1];
                fileMap.put(num, word);
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }

    private static String decodeMessage(HashMap<Integer, String> fileMap) {
        int index = 1;
        int incrementBy = 2;
        StringBuilder sb = new StringBuilder();
        while (index < fileMap.size() + 1) {
            String targetWord = fileMap.get(index);
            sb.append(targetWord).append(" ");
            index += incrementBy;
            incrementBy++;
        }
        return sb.toString().trim();
    }

    public static String decode(File file) {
        HashMap<Integer, String> fileMap = new HashMap<>();
        readFileAndPopulateMap(file, fileMap);
        return decodeMessage(fileMap);
    }

    public static void main(String[] args) {
        if (args.length < 1) {
            System.err.println("Input a filename: java MessageDecoder <filename>");
            return;
        }

        File file = new File(args[0]);
        if (!file.exists()) {
            System.err.println("File not found: " + args[0]);
            return;
        }

        String decodedMessage = decode(file);
        System.out.println(decodedMessage);
    }
}