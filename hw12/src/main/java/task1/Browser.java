package task1;

import org.jsoup.Jsoup;
import org.jsoup.nodes.*;
import org.jsoup.select.Elements;
import java.io.IOException;
import java.util.*;

public class Browser {

    public List<String> getLinksOfBestPhotos(int qtyOfPhotos) throws IOException {
        List<String> links = new ArrayList<>();
        int page = 1;
        while (links.size() < qtyOfPhotos) {
            Document document = getWebsiteHtml(page);
            Elements images = document.getElementsByTag("img");
            for (Element image : images) {
                String link = image.attr("src");
                if (doesImageHaveLink(link)) {
                    links.add(link);
                }
                if (links.size() == qtyOfPhotos) {
                    break;
                }
            }
            page++;
        }

        return links;
    }

    public Document getWebsiteHtml(int page) throws IOException {
        final String URL = "https://www.gettyimages.com/photos/travel?assettype=image&license=rf" +
                "&alloweduse=availableforalluses&embeddable=true&family=creative" +
                "&phrase=travel&sort=best&page=" + page;

        return Jsoup.connect(URL).get();
    }

    private boolean doesImageHaveLink(String link) {
        return link.startsWith("https");
    }
}
