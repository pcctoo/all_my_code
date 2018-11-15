function clickhandeler() {
var items = document.getElementsByClassName("favorite-item");
items[0].parentNode.removeChild(items[0]);

}
function highlight(text)
{
    var items = document.getElementsByClassName("favorite-item");
    var innerHTML = favorite-item.innerHTML;
    var index = innerHTML.indexOf(text);
    if ( index >= 0 )
    { 
        innerHTML = innerHTML.substring(0,index) + "<span class='highlight'>" + innerHTML.substring(index,index+text.length) + "</span>" + innerHTML.substring(index + text.length);
        favorite-item.innerHTML = innerHTML; 
    }

}