function load() {
    var xhr = new XMLHttpRequest();
    xhr.open('GET', '/folders', false);
    xhr.send();
    document.getElementById("root").innerHTML = xhr.responseText;
}