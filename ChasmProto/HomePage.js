//Persona Movies
var currMovie=1;
//Functionality to use the Arrows
function nextMovie(n) {
  showMovie(currMovie+=n);
}
//Functionality to use the Thumbnails
function currentMovie(n) {
  showMovie(currMovie=n);
}
//Common Functionality
function showMovie(n) {
  var i;
  var movies=document.getElementsByClassName("perMov");
  var tnails=document.getElementsByClassName("pero");
  if (n>movies.length){currMovie = 1}
  if (n<1) {currMovie=movies.length}
  for (i=0;i<movies.length;i++) {
      movies[i].style.display = "none";
  }
  for (i=0;i<tnails.length;i++) {
      tnails[i].className=tnails[i].className.replace(" active", "");
  }
  movies[currMovie-1].style.display="block";
  tnails[currMovie-1].className+=" active";
}


// Get the modal
var modal = document.getElementById('modalBg');
// Get the image and insert it inside the modal - use its "alt" text as a caption
var img = $('.thumb');
var modalImg = $("#img01");
var captionText = document.getElementById("movieDets");
$('.thumb').click(function(){
    modal.style.display = "block";
    var newSrc = this.src;
    modalImg.attr('src', newSrc);
    captionText.innerHTML = this.alt;
});
// Get the <span> element that closes the modal
var span = document.getElementsByClassName("close")[0];
// When the user clicks on <span> (x), close the modal
span.onclick = function() {
  modal.style.display = "none";
}

