

var counter = 1;
function addInput(divName){
    if (counter >= 4)  {
        alert("Max Guests is set to " + counter + " inputs");
    }
    else {
        var newdiv = document.createElement('div');
        newdiv.innerHTML = "<input type='text' placeholder='Guest " + (counter + 1 )+ "' name='guest[]'  > \
<select name='entree[]'> \
<option>Herb Stuffed Chicken Breast</option>\
<option>Pan Seared Samoln with Terriyaki Ginger Glaze</option>\
<option>Grilled Top Sirloin Steak</option>\
<option>Vegetarian            </option>\
</select> \
<textarea style='height: 45px; width: 352px; ' placeholder='special meal instructions' name='entree_notes[]'></textarea> <br>"
        document.getElementById(divName).appendChild(newdiv);
        counter++;
    }
}

$(function() {
    $('#flash').delay(500).fadeIn('normal', function() {
        $(this).delay(2500).fadeOut();
    });
});


$(function() {
    $('#messages').delay(500).fadeIn('normal', function() {
        $(this).delay(2500).fadeOut();
    });
});
