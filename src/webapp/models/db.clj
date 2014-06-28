(ns webapp.models.db
  (:use korma.core
        [korma.db :only (defdb)]
        [clojure.pprint]
        [clojure.walk]
        [webapp.models.schema] 
        )
  (:require
    [webapp.models.helpers :as h ]))

;(create-fun "read" "entity")  
;(crud-read-entity "entree" ) 
; Each of the below returns a function, the app will be calling these throughout
(def crud-read-entree         (h/crud-read   "entree"       ))
(def crud-read-party          (h/crud-read   "party"        ))
(def crud-read-guest-detail   (h/crud-read   "guest-detail" ))   
(def crud-update-entree       (h/crud-update "entree"       ))
(def crud-update-party        (h/crud-update "party"        ))
(def crud-update-guest-detail (h/crud-update "guest-detail" ))  
(def crud-create-entree       (h/crud-create "entree"       ))
(def crud-create-party        (h/crud-create "party"        ))
(def crud-create-guest-detail (h/crud-create "guest-detail" )) 


(defn get-party-by-word [word]
  (first (select party 
                 (where {:secret_word word})
                 (fields :id
                         :postal_code
                         :secret_word
                         :flag_accepted
                         :email_address
                         :party_name
                         :flag_sent_mail
                         :estimated_number_in_party)
                 (limit 1))))

