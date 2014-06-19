(ns webapp.models.schema
  (:import javax.sql.DataSource, org.postgresql.ds.PGPoolingDataSource))

#_(def db-spec
  {:subprotocol "postgresql"
   :subname "//localhost/webapp"
   :user "webapp"
   :password "DrRoot13"})


(def db-spec
  {:datasource
    (doto (new PGPoolingDataSource)
     (.setServerName   "localhost")
     (.setDatabaseName "webapp")
     (.setUser         "webapp")
     (.setPassword     "DrRoot13")
     (.setMaxConnections 30))})

