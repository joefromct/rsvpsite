(ns webapp.models.db
  (:use [korma.core]
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

(defn crud-update-party [fields args]
  [fields args]
  (update party 
          (set-fields fields)
          (where args )))  


(defn get-party-by-word [word]
  (first (select party
                 (where {:secret_word (clojure.string/lower-case (clojure.string/trim  word))})
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

(defn crud-refresh-guest-detail [id dicts ] 
  "Gets an id dictionary with of form {:id #}, and then the dicts
  dictionary has three keys, each with a vector (even lengths) for the
  values to be destructured."
  (for [c (range 0 (count (:entree dicts))) ]
    (let [ insert-dict 
          {
           :id     (:id id) 
           :entree (nth  (:entree dicts) c)
           :entree_notes (nth  (:entree_notes  dicts) c)
           :guest (nth  (:guest  dicts) c)}] 
      (insert guest-detail (values  insert-dict)))))

(def dicts {:entree_notes ["1" "2" "3" "4"]
            :entree ["Herb Stuffed Chicken Breast" "Pan Seared Samoln with Terriyaki Ginger Glaze" "Vegetarian" "Pan Seared Samoln with Terriyaki Ginger Glaze"]
            :guest ["Bob33" "2" "33" "4"]} 
  )
(def id {:id 17}) 

(apply merge-with conj id dicts) 
