(ns webapp.test.db-test 
  (:use [korma.core]
        [korma.db :only (defdb)]
        [clojure.pprint]
        [clojure.walk]
        [webapp.models.schema]
        )
  (:require
    [webapp.models.helpers :as h ]
    [webapp.models.db :as db     ]))  

(db/get-party-by-word "dublin bay ") 


(def id  {id 17 }) 

(def insert-dictionary {:id 17} :entree_id ) 

(defn crud-truncate-insert-party-details [id, insert-dictionary]

)

(db/crud-create-guest-detail update-dictionary args )


(def crud-create-guest-detail (h/crud-create "guest-detail" ))  


(defentity guest-detail
  (table :guest_detail )
; (has-one entree)
  (has-one party ))
 

(insert guest-detail 
(values {:id 17 :entree "aoesunh" :entree_notes "satnohesantoh aoseut"})
)

(db/crud-create-guest-detail )

(db/crud-create-guest-detail 
 {
  :id 17
  :entree_name "aaosntunaothe" 
  :entree_noets "snaotesnatoheusnthaoe " }   ) 


