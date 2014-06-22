(ns webapp.models.db
  (:use korma.core
        [korma.db :only (defdb)])
  (:require 
    [webapp.models.schema :as schema]
    [webapp.models.helpers :as h]
    ))

(defdb db schema/db-spec)

(defentity entree )

(defentity party )

(defentity guest-detail 
  (table :guest_detail :guest-detail ) 
  (has-one entree)
  (has-one party ))

;(select entree (where {:id 2 } ) )  

(defn get-user    [& stuff] "test"  ) 
(defn create-user [& stuff] "test"  ) 
(defn update-user [& stuff] "test"  ) 


;( defn not-nil? [x & args] (complement (nil? x))) 


;(let [
;      read-things (fn  [& attr] 
;                    (if (not-nil? attr)
;                      (select entree (where {:id 1 } ))
;                      (select entree )))
;      ]
;  (read-things '(attr  {:id 1}) ) ) 
;  (prn '(attr  {:id 1}) )   




;(defmacro read-by-id [entity ]  
;  `(fn [x] ( select ~entity  (where x ))))
;
;
;
;(read-by-id entree )
;
;
;
;(defmacro [thing ]
;  `(fn [x]  (select 'thing )))
;
;
;
;(defmacro code-praiser
;    [entity]
;    `(select 'entity ))
;
;(select 
;  entree 
;        )
;
;
;
;(macroexpand '(code-praiser  (+ 1 1)))
;
;; (create-model-fns *ns* employees)
;
;;(create-model-finder-fns *ns* [:name :email])
;
;
;
;;(defn find-all  [&  [attr]]
;;    (if  (map? attr)
;;          (select entree  (with addresses)  (where attr))
;;          (select entree  (with addresses))))
;;
