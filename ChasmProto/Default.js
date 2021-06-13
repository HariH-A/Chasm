function responsiveNaviBar() {
  var x = document.getElementById("nb");
  if (x.className==="navibar") {
    x.className+=" responsiveNB";
  } else {
    x.className="navibar";
  }
}

function menuBar(x) {
  x.classList.toggle("changeBar");
}

//Submits dropdown browse films form to the servlet
function submitMyForm(yo){
 	document.forms[yo].submit();
}

 location.reload(true);
