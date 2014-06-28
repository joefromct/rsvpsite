(ns webapp.routes.rsvp 
  (:use 
    [ compojure.core]
    [taoensso.timbre :only [debug info]]
    [clojure.pprint]     )
  (:require [webapp.views.layout :as layout]
            [webapp.models.db :as db ]
            [noir.util.route :refer [restricted]]
            [webapp.util :as util]
            [noir.response :as resp]
            [noir.session :as session]
            [noir.util.crypt :as crypt]
            [selmer.parser :as sp ] 
            [noir.validation :as vali]))

(defn handle-login [word]
  (let [
        party (db/get-party-by-word word)
        ]
    (if (and party
             (= word (:secret_word party)))
      (do      
        (session/put! :party party )
        (session/flash-put! :messages "Message - Now that your logged in you can pick food, manage guests, etc.") 
        ;(resp/redirect "/rsvp/manage" )
        (resp/redirect ""))
      (do 
        (session/flash-put! :messages "Wrong Word?") 
        (resp/redirect "/rsvp" )))))


(defn rsvp-home [] 
  (layout/render "rsvp.html" ))

(defn rsvp-manage []
       (layout/render "rsvp-manage.html")
  )

;{:dynamic-content blockcontent }     
(defn logout []
  (session/clear!)
  (resp/redirect "/"))

(defroutes rsvp-routes  
         ( GET  "/rsvp"        []     (rsvp-home ))
         ( POST "/rsvp"        [word] (handle-login word ))
         ( GET  "/rsvp/manage" []     (restricted  (rsvp-manage )))
         ( GET  "/logout"      []     (logout))
       )




