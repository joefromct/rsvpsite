(ns webapp.models.helpers
  (:use korma.core
        [korma.db :only (defdb)]
        [clojure.pprint]
        ))

; Inspired by https://github.com/cldwalker/datomico
; create-model-fns taken from: https://github.com/cldwalker/datomico/blob/master/src/datomico/core.clj
; create-model-fn taken from: https://github.com/cldwalker/datomico/blob/master/src/datomico/model.clj


(defn crud-create [entity]
  "Returns crud-insert function for a passed entity."
  (fn
    [fields]
    (insert entity
            (values fields))))


(defn crud-read [entity]
  " Returns a function selects data; Two arities, one for args such as {:id 1}
  and another for the \"select all\" "
  (fn
    ( [args]  (select entity (where  args )))
    ( []      (select entity ))))

(defn crud-update [entity]
  "Returns crud-update function for a passed entity. "
  (fn
    [fields args]
    (update entity
            (set-fields fields)
            (where args ))))

(defn crud-delete [entity]
  "Returns crud-delete function for a passed entity. "
  (fn
    [args]
    (delete entity
            (where args ))))


(defmacro create-model-fn
  "Creates a local function that wraps a fn with a keyword namespace (model scope)."
  [fn-name nsp entity]
  `(do
    (def ~(symbol (name fn-name))
      (partial ~(deref (resolve (symbol "webapp.db.helpers" (name fn-name)))) ~nsp ~entity))))


(defmacro create-model-fns
  "Creates model fns that are scoped to the given model (keyword namespace)."
[nsp entity]
(let [fns [:crud-create :crud-read :crud-update :crud-delete]]
  `(do ~@(map (fn [name] `(create-model-fn ~name ~nsp ~entity)) fns))
   ))

;(symbol (name :crud-read))

;(macroexpand '(create-model-fn :crud-read *ns* entree))

;(do
;    (webapp.models.helpers/create-model-fn :crud-read *ns* entree)
;    (webapp.models.helpers/create-model-fn :crud-update *ns* entree)
;    (webapp.models.helpers/create-model-fn :crud-delete *ns* entree))
;

;(defmacro create-model-finder-fn
;  "Creates a local function that wraps a fn with a keyword namespace (model scope)."
;  [nsp fn-name]
;  `(do
;    (def ~(symbol (str "find-by-" (name fn-name)))
;      (partial ~(deref (resolve (symbol "personnel.models.helpers" "find-by"))) ~nsp ~fn-name))
;    (def ~(symbol (str "find-by-" (name fn-name) "!"))
;      (partial ~(deref (resolve (symbol "personnel.models.helpers" "find-by!"))) ~nsp ~fn-name)) ))
;
;(defmacro create-model-finder-fns
;  "Creates model finder fns that are scoped to the given model (keyword
;    namespace)."
;[nsp fns]
;`(do ~@(map (fn [name] `(create-model-finder-fn ~nsp ~name)) fns)))
;

;(select entree (where {:id 2 } ) )
;(defmacro generate-crud-functions [entity]
;  (let [
;        functions [:read :update :insert]
;        string-name (str "crud-read-"  entity)]
;    (for [funs functions]
;      `(do
;         (def ~(symbol string-name)
;           (h/crud-create ~(name  funs) ~(name  entity)  ))))))
;(pprint (macroexpand '(generate-crud-functions "entree") ))
; test
;(crud-read-party {:id 2})
;(crud-read-guest-detail {:id 2})
;(read-by-id entree )
;
;(defmacro [thing ]
;  `(fn [x]  (select 'thing )))
;
;(defmacro code-praiser
;    [entity]
;    `(select 'entity ))
;
;(select
;  entree
;        )
;
;(macroexpand '(code-praiser  (+ 1 1)))
;; (create-model-fns *ns* employees)
;
;;(create-model-finder-fns *ns* [:name :email])
;
;;(defn find-all  [&  [attr]]
;;    (if  (map? attr)
;;          (select entree  (with addresses)  (where attr))
;;          (select entree  (with addresses))))
;(defmacro defcrudfn [name] 
;  `(defn ~(symbol name) [args#] 
;     (println args#)))
;
;
;#_(defmacro defcrudfn [name]
;   `(defn ~(symbol name) [args#]
;      (println args#)))
;
;
;(defmacro create-fun [fun name]
;  (let [ops ["create","read","update","delete"]]
;  (for [d ops] 
;  `(defn 
;     ~(symbol (str "crud-" d "-" name)) [args#]
;     (~fun args#))))) 
;
;(pprint  (macroexpand '(create-fun prn "entity"))) 
