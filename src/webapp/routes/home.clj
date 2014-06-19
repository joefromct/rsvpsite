(ns webapp.routes.home
  (:use compojure.core)
  (:require [webapp.views.layout :as layout]
            [webapp.util :as util]))

;(defn home-page2 []
;  (layout/render
;    "home.html" {:content (util/md->html "/md/docs.md")}))

(defn home-page []
  (layout/render
    "index-base.html" {:content (str "some content blah blah")}))

(defn our-proposal []      ( layout/render "our-proposal.html"      {:dynamic-content (str " our-proposal.html      content")} )  ) 
(defn wedding-party []     ( layout/render "wedding-party.html"     {:dynamic-content (str " wedding-party.html     content")})  ) 
(defn guest-information [] ( layout/render "guest-information.html" {:dynamic-content (str " guest-information.html content")})  ) 
(defn contact []           ( layout/render "contact.html"           {:dynamic-content (str " contact.html           content")})  ) 

(defroutes home-routes
    ( GET "/" []                  ( home-page))
    ( GET "/our-proposal" []      ( our-proposal))
    ( GET "/wedding-party" []     ( wedding-party))
    ( GET "/guest-information" [] ( guest-information))
    ( GET "/contact" []           ( contact)))

