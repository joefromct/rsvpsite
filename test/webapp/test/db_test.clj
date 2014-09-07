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
  :guest ["Bob yyfp" ""]})   


(def dicts {:entree_notes ["1" "2" "3" "4"]
            :entree ["Herb Stuffed Chicken Breast" "Pan Seared Salmon with Terriyaki Ginger Glaze" "Vegetarian" "Pan Seared Samoln with Terriyaki Ginger Glaze"]
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


