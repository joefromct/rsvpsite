(ns webapp.routes.home
  (:use compojure.core)
  (:require [webapp.views.layout :as layout]
            [webapp.util :as util]))

;(defn home-page2 []
;  (layout/render
;    "home.html" {:content (util/md->html "/md/docs.md")}))

(defn home-page []
  (layout/render
    "base.html" {:content (str "some content blah blah")}))

(defn our-proposal []      ( layout/render "our-proposal.html"      {:dynamic-content (str " our-proposal.html      content")} )  ) 
(defn wedding-party []     ( layout/render "wedding-party.html"     {:dynamic-content (str " wedding-party.html     content")})  ) 
(defn guest-information [] ( layout/render "guest-information.html" {:dynamic-content (str " guest-information.html content")})  ) 
(defn contact []           ( layout/render "contact.html"           {:dynamic-content (str " contact.html           content")})  ) 

(defn accommodation []           ( layout/render "accommodation.html"           {:dynamic-content (str " accommodation.html           content")})  ) 

(defn ceremony-reception []           ( layout/render "ceremony-reception.html"           {:dynamic-content (str "ceremony-reception.html           content")})  ) 
(defn location []           ( layout/render "location.html"           {:dynamic-content (str "location.html           content")})  ) 


(defn other-information []           ( layout/render "other-information.html"           {:dynamic-content (str "other-information.html           content")})  ) 

(defroutes home-routes
    ( GET "/" []                  ( home-page))
    ( GET "/our-proposal" []      ( our-proposal))
    ( GET "/wedding-party" []     ( wedding-party))
    ( GET "/guest-information" [] ( guest-information))
    ( GET "/ceremony-reception" [] ( ceremony-reception ))
    ( GET "/location" [] ( location ))
    ( GET "/other-information" [] ( other-information ))
    ( GET "/contact" []           ( contact))
    ( GET "/accommodation" []           ( accommodation)))

