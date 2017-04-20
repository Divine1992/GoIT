package Module11;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Stream;

import static java.nio.file.StandardOpenOption.APPEND;

public class Main {

    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("merry","m");
        map.put("Hark","h");
        map.put("Christmas","C");
        System.out.println(checkWordWithResources("Christmas", "lyrics"));
        System.out.println(checkWord("Christmas", "lyrics"));
        try {
            replacer(map, "lyrics");
            fileContentReplacer(map, "lyrics");
            fileContentMerger(map, "lyrics");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String replacer(Map<String, String> map, String path) throws IOException {
        StringBuilder sb = new StringBuilder();
        if (Files.exists(FileSystems.getDefault().getPath(path))){
            Stream<String> strStream = Files.lines(Paths.get(path), StandardCharsets.UTF_8);
            strStream.forEach(i -> {
                String [] line = i.split("\\.|\\,|\\s");
                String str = i;
                for (String word: line){
                        if(word.length()>1){
                            Optional<Map.Entry<String, String>> optional = map.entrySet().parallelStream()
                                    .filter((k) -> k.getKey().equals(word)).findFirst();
                            if (optional.isPresent()) {
                                str = str.replace(optional.get().getKey(),optional.get().getValue());
                            }
                        }
                }
                sb.append(str+"\n");
            });
        } else throw new IOException("File doesn't exist");
        sb.trimToSize();
        return sb.toString();
    }

    private static File fileContentReplacer(Map<String, String> map, String path) throws IOException {
        Path pathVariable = FileSystems.getDefault().getPath(path);
        if (Files.exists(pathVariable)) {
            List<String> list = Arrays.asList(replacer(map, path));
            return Files.write(pathVariable, list, StandardCharsets.UTF_8).toFile();
        }
        throw new IOException("File doesn't exist");
    }

    private static File fileContentMerger(Map<String, String> map, String path) throws IOException {
        Path pathVariable = FileSystems.getDefault().getPath(path);
        if (Files.exists(pathVariable)) {
            List<String> list = Arrays.asList(replacer(map, path));
            return Files.write(pathVariable, list, StandardCharsets.UTF_8, APPEND).toFile();
        }
        throw new IOException("File doesn't exist");
    }

    private static int checkWordWithResources(String word, String path){
        int result = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String sCurrentLine;
            while ((sCurrentLine = br.readLine()) != null) {
                int index = sCurrentLine.indexOf(word);
                while(index >= 0) {
                    index = sCurrentLine.indexOf(word, index+1);
                    result++;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    private static int checkWord(String word, String path){
        int result = 0;
        FileReader  fr = null;
        BufferedReader br = null;
        try {
            fr = new FileReader(path);
            br = new BufferedReader(fr);
            String sCurrentLine;
            while ((sCurrentLine = br.readLine()) != null) {
                int index = sCurrentLine.indexOf(word);
                while(index >= 0) {
                    index = sCurrentLine.indexOf(word, index+1);
                    result++;
                }
            }
        } catch (IOException e){
            e.printStackTrace();
        } finally {
            try {
                if(br != null){
                    br.close();
                }
                if(fr != null){
                    fr.close();
                }
            } catch (IOException e){
                e.printStackTrace();
            }
        }
        return result;
    }

}
