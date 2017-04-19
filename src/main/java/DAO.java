
import model.Item;
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
}
