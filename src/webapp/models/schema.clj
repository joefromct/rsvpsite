(ns webapp.models.schema
  (:use korma.core
        [korma.db :only (defdb)]
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
     (.setServerName   "ec2-54-225-101-199.compute-1.amazonaws.com")
     (.setDatabaseName "de9fht8m1k5pfo")
     (.setUser         "dmkypsxnomgpkr")
     (.setPassword     "H0S9EDBPxKsAfX_OuVCNgMvtS1")
     (.setMaxConnections 30))})

(defdb db  db-spec)

;(defentity entree )
(defentity party )

(defentity guest-detail
  (table :guest_detail )
; (has-one entree)
  (has-one party ))

#_(def db-spec
  {:subprotocol "postgresql"
   :subname "//localhost/webapp"
   :user "webapp"
   :password "DrRoot13"})
