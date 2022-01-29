package task1;

import org.jsoup.Jsoup;
import org.jsoup.nodes.*;
import org.jsoup.select.Elements;
import java.io.IOException;
import java.util.*;

public class Browser {

    public Document getWebsiteHtml(int page) throws IOException {
        final String URL = "https://www.gettyimages.com/photos/travel?assettype=image&license=rf" +
                "&alloweduse=availableforalluses&embeddable=true&family=creative" +
                "&phrase=travel&sort=best&page=" + page;

        return Jsoup.connect(URL).get();
    }

    public List<String> getLinksOf200BestPhotos() throws IOException {
        List<String> linksOf200BestPhotos = new ArrayList<>();
        int page = 1;
        while (linksOf200BestPhotos.size() < 200) {
            Document document = getWebsiteHtml(page);
            Elements images = document.getElementsByTag("img");
            for (Element image : images) {
                String link = image.attr("src");
                if (doesImageHaveLink(link)) {
                    linksOf200BestPhotos.add(link);
                }
                if (linksOf200BestPhotos.size() == 200) {
                    break;
                }
            }
            page++;
        }

        return linksOf200BestPhotos;
    }

    private boolean doesImageHaveLink(String link) {
        return link.startsWith("https");
    }
}
