var menu = [
{"name" : "cat sushi", "description" : "tuna wraped in a leaf of catnip" ,"price" : "$4.50"},
	{"name" : "cat caeser salad" , "description" : "a salad with out all the nasty green parts." ,"price" : "$4.50"},
	{"name" : "cat" , "description" : "dont ask questions." ,"price" : "$4.50"},
		{"name" : "cat tuna salad" , "description" : "fresh tuna served with a side of cat nip." ,"price" : "$4.50"},
			{"name" : "stake" , "description" : "our cats meaty faivriot. served with a side of cat nit." ,"price" : "$4.50"},

]

var food = ("<br/>");
for (var i =0; i < menu.length; i++) {
food += "<li>" + menu[i].name +" <br/>" + " description:" + menu[i].description + " <br/>" + menu[i].price + "</li>" + " <br/>";
	document.getElementById("cafe").innerHTML = food;
}
