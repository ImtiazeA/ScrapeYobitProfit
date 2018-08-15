package finalize;

import org.apache.commons.io.IOUtils;

import java.io.*;
import java.util.LinkedHashSet;

public class FinalizeFile {

    public static void main(String[] args) throws IOException {

        File finalFile = new File("final/final.txt");

        File folder = new File("export/");

        File[] files = folder.listFiles();


        LinkedHashSet<String> uniqueLines = new LinkedHashSet<>();

        for (File file : files) {

            uniqueLines.addAll(IOUtils.readLines(new FileReader(file)));

        }

        IOUtils.writeLines(
                uniqueLines, System.lineSeparator()
                , new BufferedWriter(new FileWriter(finalFile)));


    }

}

