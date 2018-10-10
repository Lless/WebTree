function load() {
    var children = XhrGetNull();
    children.forEach(showFolder);
    var root = document.getElementById(null);
    root.insertBefore(newBtn("add",addNode), root.firstChild);
}

function getJson(node) {
    var info = {};
    if (node.id) info.id = node.id;
    info.folderName = node.firstChild.innerHTML;
    info.parentId = node.parentNode.parentNode.id;
    return JSON.stringify(info);
}

function downloadFolderChildren(folder) {
    folder.classList.add("download");
    XhrGet(folder.id, function(result) {
        result.forEach(showFolder);
        folder.classList.remove("download");
    });
}

function newTextNode(text) {
    var textNode = document.createElement("div");
    textNode.innerHTML = text;
    textNode.contentEditable = true;
    textNode.addEventListener("keypress", leaveIfEnter);
    textNode.addEventListener("blur", saveChanges)
    return textNode;
}

function showFolder(folder) {
    if (document.getElementById(folder.id)) return document.getElementById(folder.parentId);

    var node = document.createElement("li");
    node.draggable = true;
    if (folder.id) node.id = folder.id;
    node.appendChild(newTextNode(folder.folderName));
    node.appendChild(newBtn("add",addNode));
    node.appendChild(newBtn("delete",deleteNode));

    var parentNode = document.getElementById(folder.parentId);
    bindNode(node, parentNode);
    return node;
}

function deleteNode() {
    var node = this.parentNode;
    XhrDelete(node.id);
    node.parentNode.removeChild(node);
}

function addNode(parent) {
    var parent = this.parentNode;
    var node = showFolder({parentId:parent.id, folderName:"new Folder"});
    node.firstChild.focus();
}

function updateFolder(node){
    if (node.id) {
        XhrPut(getJson(node));
    }
    else {
        XhrPost(getJson(node), function(id) {
            node.id = id;
        })
    }
}

function bindNode(node, to) {
    if (to.getElementsByTagName("ul").length == 0) {
        var list = document.createElement("ul");
        to.appendChild(list);
    };
    to.getElementsByTagName("ul")[0].appendChild(node);
}

function newBtn(imgName, onclick) {
    var btn = document.createElement("input");
    btn.type = "image";
    btn.onclick = onclick;
    btn.src = "/img/icons/"+imgName+".png";
    return btn;
}