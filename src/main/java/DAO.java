
import model.Item;
import model.Page;
import org.mongodb.morphia.query.Query;

import java.util.List;

public class DAO {

    public static void postItem(Item item) {
        MongoDb.getInstance().save(item);
    }

    public static List<Item> getItems() {
        Query<Item> query = MongoDb.getInstance().createQuery(Item.class);
        return query.asList();
    }

    public static List<Page> getPages() {
        Query<Page> query = MongoDb.getInstance().createQuery(Page.class);
        return query.asList();
    }
}
