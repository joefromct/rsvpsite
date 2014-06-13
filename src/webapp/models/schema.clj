(ns webapp.models.schema
  (:use korma.core
        [korma.db :only (defdb)]
        [environ.core]
        [clojure.walk])
  (:import javax.sql.DataSource, org.postgresql.ds.PGPoolingDataSource)) 

#_(def db-spec
  {:datasource
   (doto (new PGPoolingDataSource)
     (.setServerName   "localhost")
     (.setDatabaseName "webapp")
     (.setUser         "webapp")
     (.setPassword     "DrRoot13")
     (.setMaxConnections 30))})

(def db-spec
  {:datasource
   (doto (new PGPoolingDataSource)
     (.setServerName     (env :pg-server-name        ))
     (.setDatabaseName   (env :pg-database           ))
     (.setUser           (env :pg-user               ))
     (.setPassword       (env :pg-password           ))
     (.setMaxConnections (env :pg-max-connections  )))})

(defdb db  db-spec)

;(defentity entree )
(defentity party )

(defentity guest-detail
  (table :guest_detail )
; (has-one entree)
  (has-one party ))
