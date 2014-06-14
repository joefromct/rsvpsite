(ns webapp.models.db
  (:use [korma.core]
        [korma.db :only (defdb)]
        [clojure.pprint]
        [clojure.walk]
        [webapp.models.schema]
        )
  (:require
   [taoensso.timbre  :as timbre]
   [webapp.models.helpers :as h ]))  

;(create-fun "read" "entity")
;(crud-read-entity "entree" )
; Each of the below returns a function, the app will be calling these throughout

(defn crud-update-party [fields args]
  [fields args]
  (update party 
          (set-fields fields)
          (where args )))  


(defn get-party-by-word [word]
  (first (select party
                 (where {:secret_word (clojure.string/lower-case 
                                       (clojure.string/trim word))})
                 (fields :id
                         :postal_code
                         :secret_word
                         :flag_accepted
                         :email_address
                         :party_name
                         :flag_sent_mail
                         :estimated_number_in_party)
                 (limit 1))))

(defn crud-read-party-by-id [id ]
  (first
   (select party
           (fields :email_address
                   :id 
                   :estimated_number_in_party
                   :party_name
                   :country
                   :city
                   :state
                   :postal_code
                   :mailing_address_1
                   :mailing_address_2
                   :mailing_address_3
                   :flag_accepted)
           (where {:id id})))) 

(defn crud-read-guest-detail-by-id [id]
  (select guest-detail (where {:id id}))) 


(defn crud-refresh-guest-detail [id dicts ] 
  "Gets an id dictionary with of form {:id #}, and then the dicts
  dictionary has three keys, each with a vector (even lengths) for the
  values to be destructured."
  (let [
        normalize (fn  [orders]
                    (let [os (apply map vector (vals orders))
                          ks (keys orders)]
                      (map #(zipmap ks %) os)))
        orders-list  (normalize dicts) 
        orders-list-with-id (map #(merge % id ) orders-list ) ] 
    (delete guest-detail (where id) ) 
    (insert guest-detail (values orders-list-with-id))))

