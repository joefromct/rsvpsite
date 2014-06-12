(ns webapp.test.db-test 
  (:use [korma.core]
        [korma.db :only (defdb)]
        [clojure.pprint]
        [clojure.walk]
        [webapp.models.schema]
        [webapp.routes.rsvp] 
        )
  (:require
   [webapp.views.layout :as layout]
   [webapp.models.db :as db ]
   [noir.util.route  :refer [restricted]]
   [webapp.util      :as util]
   [noir.response    :as resp]
   [noir.session     :as session]
   [taoensso.timbre  :as timbre]
   [noir.util.crypt  :as crypt]
   [selmer.parser    :as sp ] 
   [noir.validation  :as vali]
   [webapp.models.helpers :as h ]
   [webapp.models.db :as db     ]))     

;(db/get-party-by-word "dublin bay") 


; i have something like this:
(def orders {:entree_notes ["no salt" "extra mayo"]
             :entree ["chicken sandwich" "meatball sub"]
             :guest ["bill" "ted"]}) 


(map #(nth (:entree_notes orders) % ) (range (count (:entree_notes orders))))

(session-put {:id 12})

(binding [sesh/*noir-session* (atom {:somekey "somevalue"})]
  (session/put! :party 
                (select-keys (db/crud-read-party-by-id  180) [:id :party_name])))   

(sesion/put! :party 30) 

(db/crud-read-party-by-id {:id17})

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



{:entree_notes ["" "" "" ""],
 :entree ["Herb Stuffed Chicken Breast" "Herb Stuffed Chicken Breast" "Pan Seared Samoln with Terriyaki Ginger Glaze" "Herb Stuffed Chicken Breast"],
 :guest ["Bob Baumann yyfp" "" "" ""],
 :flag_accepted "  ",
 :email_address " ",
 :party_name "Bob Baumann yyfp"} 



(normalize dicts) 

(db/crud-refresh-guest-detail {:id 170} dicts )  



(insert guest-detail (values  insert-dict)) 


(:entree dicts) 

(for [c  (range 0 (count  (:entree dicts)))]
  (do 
    (pprint c)))  



(for [c (range 0 (count (:entree dicts))) ]
  (do 
    (timbre/error "TEST HERE again JR  ")
    (let [ insert-dict 
          {
           :id     (:id id) 
           :entree (nth  (:entree dicts) c)
           :entree_notes (nth  (:entree_notes  dicts) c)
           :guest (nth  (:guest  dicts) c)}] 
      (timbre/error  (sql-only  (insert guest-detail (values  insert-dict))))
      (insert guest-detail (values  insert-dict)))) 
  )

(db/crud-refresh-guest-detail 
 {:id 167}
 {:entree_notes ["" ""],
  :entree ["bitch Breast" "Herb Stuffed Chicken Breast"],
  :guest ["Bob Baumann yyfp" ""]})   


(def dicts {:entree_notes ["1" "2" "3" "4"]
            :entree ["Herb Stuffed Chicken Breast" "Pan Seared Samoln with Terriyaki Ginger Glaze" "Vegetarian" "Pan Seared Samoln with Terriyaki Ginger Glaze"]
            :guest ["Bob33" "2" "33" "4"]})  

(let [
      ]  
  (for [c (range  (count (:entree dicts))) ]
    (do 
      (let [ insert-dict 
            {
             :id           (:id id ) 
             :entree       (nth  (:entree dicts) c)
             :entree_notes (nth  (:entree_notes  dicts) c)
             :guest        (nth  (:guest  dicts) c)}] 
        (insert guest-detail (values  insert-dict))))))    


