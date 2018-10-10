function getRootChildren() {
    var xhr = new XMLHttpRequest();
    xhr.open('GET', '/folders', false);
    xhr.send();
    return JSON.parse(xhr.responseText);
}

function getChildren(parentId) {
    var xhr = new XMLHttpRequest();
    xhr.open('GET', '/folders?parentId='+parentId, false);
    xhr.send();
    return JSON.parse(xhr.responseText);
}

function saveFolder(json) {
    var xhr = new XMLHttpRequest();
    xhr.open('PUT', '/folders', false);
    xhr.setRequestHeader('Content-Type', 'application/json');
    xhr.send([json]);
}
