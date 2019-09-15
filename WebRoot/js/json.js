function loadStyle(url) {
  var link = document.createElement('link');
  link.type = 'text/css';
  link.rel = 'stylesheet';
  link.href = url;

  var head = document.querySelector('head');
  head.appendChild(link);
}


var xhr = new XMLHttpRequest();
xhr.open('GET', '../json/product_info.json', true);

xhr.onload = function() {
  if (this.status == 200 && this.readyState == 4) {
    var products = JSON.parse(this.responseText);

    var output = '';
    for (var i in products) {
      output += '<div class="slide">' +
      '<img src="data:image/png; base64, ' + products[i].img + '" class="img-responsive" alt="" />' +
      '<div class="slide_content">' +
      '<div class="slide_content_wrap">' +
      '<h1 class="title">' + products[i].title + '</h1>' +
      '<div class="button"><a href="#">See Details</a></div>' +
      '</div>' +
      '</div>' +
      '</div>';
    }

    document.querySelector('.slider_container').innerHTML = output;
  }
}

xhr.send();

loadStyle('css/bootstrap.css');
loadStyle('css/style.css');
loadStyle('css/fwslider.css');
loadStyle('css/etalage.css');
