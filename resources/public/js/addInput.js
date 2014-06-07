var counter = 1;
var limit = 4;
function addInput(divName){
     if (counter == limit)  {
          alert("Max guests is set to  " + counter + " people");
     }
     else {
          var newdiv = document.createElement('div');
          newdiv.innerHTML = "Guest " + (counter + 1 ) + 
              " <br><input type='text' name='myGuests[]'>";
          document.getElementById(divName).appendChild(newdiv);
          counter++;
     }
}
