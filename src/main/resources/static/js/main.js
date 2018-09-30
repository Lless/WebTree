function load() {
    var children = getRootChildren();
    children.forEach(showFolder);
}

function dblClick(ev) {
   var targetClasses = ev.target.classList;
   targetClasses.add("download");
   getChildren(ev.target.id).forEach(showFolder);
   setTimeout(()=>{targetClasses.remove("download");}, 2000);
   ev.stopPropagation();
}

function newTextNode(text) {
    var textNode = document.createElement("div");
    textNode.innerHTML = text;
    textNode.contentEditable = true;
    return textNode;
}

function showFolder(folder) {
    if (document.getElementById(folder.id)) return document.getElementById(folder.parentId);

    var node = document.createElement("li");
    if (folder.id) node.id = folder.id;
    node.appendChild(newTextNode(folder.folderName));

    var parentNode = document.getElementById(folder.parentId);
    bindNode(node, parentNode);
    return node;
}
function bindNode(node, to) {
    var ulList = to.getElementsByTagName("ul");
    if (ulList.length==0) {
        var list = document.createElement("ul");
        to.appendChild(list);
    };
    to.lastChild.appendChild(node);
}