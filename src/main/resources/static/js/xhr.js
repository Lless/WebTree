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