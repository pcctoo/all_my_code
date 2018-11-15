var a = { "name": '-my housemate', "test": '"Patrick get out of my room!!! It is three in the morning!!!! I am not helping you with your stupid project!!! how did you even get in to my room any way? i locked the door!!!"'};
var b = { "name": "-some guy i met in a back alley", "test": '"i love patrick he his check cleared so i am more then happy to tell you he chill."'};
var c = { "name": "-me", "test": '"i think i am a good guy."'}
var cal = [ a, b, c];
var max = cal.length;
var chose = Math.floor(Math.random() * max); 
var choice = cal[chose];
document.getElementById("testt").innerHTML = ("see what my guest think!!!" + "<br/>" + (choice.test) + "<br/>" + (choice.name));