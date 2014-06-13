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

(defn session-put 
  [ {id :id } ] ; pass map with id in there
  (session/put! :party 
                (select-keys (db/crud-read-party-by-id  id) 
                             [:id :party_name])))  

(defn rsvp-save [args]
  (let 
      [id                 (select-keys  (session/get :party) [:id])
       update-dictionary  (select-keys args [:flag_accepted :email_address :party_name ])  ]
    (db/crud-update-party  update-dictionary id )
    (session/flash-put! :messages (str ("updated guests...") ))

    (db/crud-refresh-guest-detail id (select-keys args [:guest :entree :entree_notes])) 
    (session-put id )

    (resp/redirect "/rsvp-manage")))  

(defn handle-login [word]
  (let [
        party (db/get-party-by-word word)
        ]
    (if (and party
             (= word (:secret_word party)))
      (do      
        (session/put! :party (select-keys  party [:id :party_name ])) 
        (session/flash-put! :messages (str party "Message - logged in.")) 
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
      [
       guest-master (db/crud-read-party-by-id        (:id  (session/get :party  ))  )
       guest-detail (db/crud-read-guest-detail-by-id (:id  (session/get :party  ))  )
       ]
    (layout/render "rsvp-manage.html" {:guest-master guest-master :guest-detail guest-detail })))


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

