(ns webapp.models.helpers 
  (:use korma.core
    [korma.db :only (defdb)]))

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
