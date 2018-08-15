package scraper;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScrapeYobit {

    public static List<String> allRows = new ArrayList<>();

    public static void main(String[] args) throws InterruptedException {

        GetDataFromYobit getDataFromYobit = new GetDataFromYobit();

        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
        scheduler.scheduleWithFixedDelay(getDataFromYobit, 0, 500, TimeUnit.MILLISECONDS);

    }
}
