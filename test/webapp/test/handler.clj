(ns webapp.test.rsvp-test
  (:use [ webapp.routes.rsvp] ))

(def args {:test "aoeus" :myGuests "asoutnh"} )

(apply dissoc args [:myGuests] ) 


