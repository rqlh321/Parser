import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;

public class MongoDb {
    private static Datastore datastore = null;

    private MongoDb(){}

    public static Datastore getInstance() {
        if (datastore == null) {
            MongoClientURI connectionString = new MongoClientURI("mongodb://user:user@ds163060.mlab.com:63060/prices");
            MongoClient mongoClient = new MongoClient(connectionString);

            Morphia morphia = new Morphia();
            morphia.mapPackage("model");
            datastore = morphia.createDatastore(mongoClient,"prices" );
            datastore.ensureIndexes();
        }
        return datastore;
    }
}
