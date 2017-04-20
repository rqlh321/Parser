import model.Item;
import model.Page;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.sql.SQLException;

public class Parser {

    public static void main(String[] args) throws IOException, SQLException {
        for (Page page:DAO.getPages()){
            try {
                Document doc = Jsoup.connect(page.getAddress()).get();

                String name = doc.select(page.getNameKey())
                        .first()
                        .childNode(0)
                        .toString();
                System.out.println(name);

                String price = doc.select(page.getPriceKey())
                        .first()
                        .childNode(0)
                        .toString();
                System.out.println(Util.split(price));

                DAO.postItem(new Item(page, name, Util.split(price)));
            }catch (Exception e){
                System.out.print("ERROR ON: "+page.getAddress());
                e.printStackTrace();
            }
        }

        Util.writeIntoExcel("/home/alexandr/test.excel");
    }
}
