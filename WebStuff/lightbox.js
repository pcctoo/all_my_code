$(".row1 img").on("click",function(){

event.preventDefault();
var $lightbox = $("<div id = lightbox ></div>)");    
$("#isuck").append($lightbox);
var $image = $("<img>");
$lightbox.append($image);
	var $exit = $("<img id = 'exitimage'>");
$lightbox.append($exit);


var imageSource = $(this).attr("src");
$image.attr("src", imageSource);
$exit.attr("src", imageSource);
$exit.remove();
$lightbox.show();

$("#lightbox").click(function(event) {

$lightbox.append($exit);
event.preventDefault();
$($lightbox).hide();

});
});