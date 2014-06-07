(ns webapp.handler
  (:require [compojure.core                  :refer [defroutes]]   
            [webapp.routes.home              :refer [home-routes]] 
            [webapp.routes.rsvp              :refer [rsvp-routes]] 
;           [webapp.routes.auth              :refer [auth-routes]] 
            [webapp.middleware               :as middleware]       
            [noir.util.middleware            :refer [app-handler]] 
            [noir.session                    :as session]
            [compojure.route                 :as route]            
            [taoensso.timbre                 :as timbre]           
            [taoensso.timbre.appenders.rotor :as rotor]            
            [selmer.parser                   :as parser]           
            [environ.core                    :refer [env]]         
            [webapp.models.schema            :as schema]))         

(defroutes app-routes
  (route/resources "/")
  (route/not-found "Not Found"))

(defn init
  "init will be called once when app is deployed as a servlet on an app server
  such as Tomcat put any initialization code here"
  []
  (timbre/set-config!  [:appenders :rotor] {:min-level :info,
                                            :enabled? true,
                                            :async? false,
                                            :max-message-per-msecs nil,
                                            :fn rotor/appender-fn})
  (timbre/set-config!  [:shared-appender-config :rotor]
                      {:path "webapp.log", :max-size (* 512 1024), :backlog 10})
  (if (env :dev) (parser/cache-off!))
  (timbre/info "webapp started successfully"))

(defn destroy
  "destroy will be called when your application shuts
  down, put any clean up code here"
  []
  (timbre/info "webapp is shutting down..."))

 (defn rsvp-page [_]
  (session/get :party))

(def app
  (app-handler [ 
                ; You _have_ to put app-routes last... or 404 will take over.
                ; auth-routes 
                home-routes rsvp-routes app-routes  ]
               :middleware   [middleware/template-error-page
                              middleware/log-request] 
               :access-rules [rsvp-page]
               :formats      [:json-kw :edn]))

