(ns webapp.routes.rsvp 
  (:use compojure.core)
  (:require [webapp.views.layout :as layout]
            [webapp.util :as util]))

(defn rsvp-login [] (layout/render "rsvp.html" ))

(defroutes rsvp-routes  
  (GET "/rsvp" [] (rsvp-login))
  )
