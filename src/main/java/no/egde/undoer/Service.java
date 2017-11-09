package no.egde.undoer;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import datomic.Connection;
import datomic.Database;

import java.io.IOException;

import datomic.Peer;
import java.util.UUID;
import datomic.Connection;
import java.util.Collection;
import java.util.Iterator;
import java.util.UUID;

import static datomic.Peer.query;
import static no.egde.undoer.IO.transactAllFromResource;

@Component
public class Service {

    @Value("${message:World}")
    private String msg;

    public String message() {
        return this.msg;
    }

    private Connection conn;

    private Connection obtainConn() {
        if(conn == null) {
            String uri = "datomic:mem://" + java.util.UUID.randomUUID();
            Peer.createDatabase(uri);
            conn =Peer.connect(uri);
        }
        return conn;
    }


    public void initDb() {
        transactAllFromResource(obtainConn(), "data/eiendommer.edn");
        Database db = obtainConn().db();
    }

    public Object dyresteBolig() {
        Database db = obtainConn().db();
        return query("[:find (max ?verdi) ." +
                " :where [_ :object/verdi ?verdi]]", db);
    }

    public Object randomObject() {
        Database db = obtainConn().db();
        return query("[:find (rand ?name) ." +
                " :where [?e :object/name ?name]]", db);
    }

}