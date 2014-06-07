(ns webapp.routes.rsvp 
  (:use 
   [compojure.core]
   [clojure.pprint]     )
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
   [noir.validation  :as vali]))

(defn session-put [{party_name :party_name id :id} ]
  (timbre/info party_name) 
  (session/put! :party 
                (select-keys  
                 (db/crud-read-party-by-id  1) 
                 [:id party_name])))

(defn rsvp-save [args]
  (let 
    [id                 (select-keys  (session/get :party) [:id])
     update-dictionary  (apply dissoc args [:myGuests ])  ]
    (db/crud-update-party  update-dictionary id )
    (session/put! :party 
                  (select-keys  
                    (db/crud-read-party-by-id  1) 
                    [:id :party_name]))
    (session/flash-put! :messages  (str "did an update args was "  args))
    (resp/redirect "/rsvp-manage"))) 

(defn handle-login [word]
  (let [
        party (db/get-party-by-word word)
        ]
    (timbre/info "logging in") 
    (if (and party
             (= word (:secret_word party)))
      (do      
        (session/put! :party (select-keys  party [:id :party_name ])) 
        (session/flash-put! :messages (str party "Message - Now that your logged in you can pick food, manage guests, etc.")) 
        ;(resp/redirect "/rsvp/manage" )
        (resp/redirect "/rsvp-manage"))
      (do 
        (session/flash-put! :messages "Wrong Word?") 
        (resp/redirect "/rsvp" )))))

(defn rsvp-home [] 
  (if (session/get :party) 
    (resp/redirect "/rsvp-manage" )    
    (layout/render "rsvp.html" )))

(defn rsvp-manage []
  (let 
    [t (db/crud-read-party-by-id (:id  (session/get :party  ))  )]
    (layout/render "rsvp-manage.html" t  )))


(defn rsvp-manage-details []
  (let 
    [t (db/crud-read-party-by-id (:id  (session/get :party  )))]
    (layout/render "rsvp-manage-details.html" t  )))

;{:dynamic-content blockcontent }     
(defn logout []
  (session/clear!)
  (resp/redirect "/"))

(defroutes rsvp-routes  
   (GET  "/rsvp"        []         (rsvp-home ))
   (POST "/rsvp"        [word]     (handle-login word ))
   (GET  "/rsvp-manage" []         (restricted (rsvp-manage )))
   (POST "/rsvp-manage" [& args ]  (restricted (rsvp-save args )))
   (GET  "/logout"      []         (logout)))

