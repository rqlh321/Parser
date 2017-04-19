import model.Item;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.sql.SQLException;

public class Parser {

    public static void main(String[] args) throws IOException, SQLException {
        Document doc = Jsoup.connect("http://en.wikipedia.org/").get();
        Elements elements = doc.select("#mp-itn b a");

        for (Element element:elements){
            Item item=new Item(element.toString(),"",12.55f,"");
            DAO.postItem(item);
        }

        Util.writeIntoExcel("/home/alexandr/test.excel");
    }
}
