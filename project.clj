(defproject
  webapp "0.1.0-SNAPSHOT"
  :repl-options  {:host "0.0.0.0" :port 12454 :init-ns webapp.repl }
  :dependencies [[ring-server "0.3.1"]
                 [postgresql/postgresql "9.1-901-1.jdbc4"]
                 [ragtime "0.3.6"]
                 [environ "0.5.0"]
                 [markdown-clj "0.9.43"]
                 [com.taoensso/timbre "3.1.6"]
                 [org.clojure/clojure "1.6.0"]
                 [com.taoensso/tower "2.0.2"]
                 [log4j "1.2.17" 
                  :exclusions [javax.mail/mail
                               javax.jms/jms
                               com.sun.jdmk/jmxtools
                               com.sun.jmx/jmxri]]
                 [korma "0.3.1"]
                 [compojure "1.1.6"]
                 [selmer "0.6.6"]
                 [lib-noir "0.8.2"]]
  :ring {:handler webapp.handler/app,
         :init webapp.handler/init,
         :destroy webapp.handler/destroy}
  :ragtime {:migrations ragtime.sql.files/migrations,
            :database "jdbc:postgresql://localhost/webapp?user=webapp&password=DrRoot13"}
  :profiles {:uberjar {:aot :all},
             :production {:ring
                          {:open-browser? false, :stacktraces? false, :auto-reload? false}
                          },
             :dev {:dependencies [[ring-mock "0.1.5"] [ring/ring-devel "1.2.2"]],
                   :env {
                         :dev                 true        
                         :pg-server-name      "localhost" 
                         :pg-database         "webapp"     
                         :pg-user             "webapp"     
                         :pg-password         "password"}}}
  :url "http://rochettes.com/"
  :plugins [[lein-ring "0.8.10"]
            [lein-environ "0.5.0"]
            [ragtime/ragtime.lein "0.3.6"]
            [cider/cider-nrepl "0.8.0-SNAPSHOT"]]
  :description "FIXME: first compojure + ring + selmer + postgres app"
  :min-lein-version "2.0.0")
