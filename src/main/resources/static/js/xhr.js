function XhrGetNull() {
    var xhr = new XMLHttpRequest();
    xhr.open('GET', '/folders', false);
    xhr.send();
    return JSON.parse(xhr.responseText);
}

function XhrGet(parentId, resultConsumer) {
    var xhr = new XMLHttpRequest();
    xhr.open('GET', '/folders?parentId='+parentId, true);
    xhr.send();
    xhr.onreadystatechange = function() {
        if (xhr.readyState != 4) return;
        var result =  JSON.parse(xhr.responseText);
        resultConsumer(result);
    }
}

function XhrPut(json) {
    var xhr = new XMLHttpRequest();
    xhr.open('PUT', '/folders', false);
    xhr.setRequestHeader('Content-Type', 'application/json');
    xhr.send(json);
}

function XhrDelete(id) {
    var xhr = new XMLHttpRequest();
    xhr.open('DELETE', '/folders?folder='+id, false);
    xhr.setRequestHeader('Content-Type', 'application/json');
    xhr.send();
}

function XhrPost(json, resultConsumer) {
    var xhr = new XMLHttpRequest();
    xhr.open('POST', '/folders', false);
    xhr.setRequestHeader('Content-Type', 'application/json');
    xhr.send(json);
    resultConsumer(JSON.parse(xhr.responseText))
}
