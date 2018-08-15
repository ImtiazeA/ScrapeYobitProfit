package scraper;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class WriteToFile {

    static PrintWriter printer;

    static long startTime = System.currentTimeMillis();

    static {
        try {
            printer = new PrintWriter(new FileWriter(new File("export/yobit-dice-" + System.nanoTime() + ".txt")));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeToFile(String tableHTML) {

        // Every Minute - 60000
        // Every Hour - 3600000
        if ((System.currentTimeMillis() - startTime) > 60000) {
            try {
                printer = new PrintWriter(new FileWriter(new File("export/yobit-dice-" + System.nanoTime() + ".txt")));
            } catch (IOException e) {
                e.printStackTrace();
            }
            startTime = System.currentTimeMillis();
        }

        Document html = Jsoup.parseBodyFragment(tableHTML, "UTF-8");
        Elements rows = html.select("tbody > tr");

        for (Element row : rows) {
            printer.write(
                    row.select("td:nth-child(1)").text()
                            + "," + row.select("td:nth-child(2)").text()
                            + "," + row.select("td:nth-child(3) span").text()
                            + "," + row.select("td:nth-child(4) a").text()
                            + "," + row.select("td:nth-child(5)").text()
                            + "," + row.select("td:nth-child(6)").text()
                            + "," + row.select("td:nth-child(7)").text()
                            + "," + row.select("td:nth-child(8)").text()
                            + "\n");
        }

        printer.flush();
    }
}
