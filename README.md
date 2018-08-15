## ScrpaeYobitProfit

This scraper scrapes profit data from [yobit.net/en/dice][yobit.net dice page] page.
The page loads the profit data per user, and about every 500 milisecond the table is updated as you can see in the following image.

![yobit.net dice page][yobit.net dice page - profit]

[yobit.net dice page - profit]: https://i.imgur.com/ElcWXaG.gif

This scraper takes a simple approach, first it takes page source data from **Selenium WebDriver**,
parse source using **jsoup** and then take all the required info and write down into a file.
As the client had requirement to run it for 24 hours, I setup it so it will create a new file every hour.
There will be definitely duplicates, so while there is a separate method to create final file removing all the dups.