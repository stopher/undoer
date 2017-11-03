package datomic.samples;

import datomic.Connection;
import datomic.Database;

import java.io.IOException;

import static datomic.Peer.query;
import static datomic.samples.Fns.scratchConnection;
import static datomic.samples.IO.transactAllFromResource;
import static datomic.samples.PrettyPrint.print;

public class Eiendommer {

    public static void main(String[] args) throws IOException {
        Connection conn = scratchConnection();
        transactAllFromResource(conn, "data/eiendommer.edn");
        Database db = conn.db();

        print(randomObject(db));
        print(dyresteBolig(db));
    }

    public static Object dyresteBolig(Database db) {
        return query("[:find (max ?verdi) ." +
                     " :where [_ :object/verdi ?verdi]]", db);
    }

    public static Object randomObject(Database db) {
        return query("[:find (rand ?name) ." +
                     " :where [?e :object/name ?name]]", db);
    }

}
