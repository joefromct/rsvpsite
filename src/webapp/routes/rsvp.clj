(ns webapp.routes.rsvp 
  (:use compojure.core)
  (:require [webapp.views.layout :as layout]
            [webapp.models.db :as db ]
            [webapp.util :as util]))

(defn rsvp-login [] (layout/render "rsvp.html" ))

(defn home-page  [&  [name message error]]
  (layout/render "home.html"
                 {:error    error
                  :name     name
                  :message  message
;:messages  (db/get-messages)   
                  }))

(defroutes rsvp-routes  
  (GET "/rsvp" [] (rsvp-login))
  )
