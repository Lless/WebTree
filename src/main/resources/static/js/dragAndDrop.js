function forbidDrop(ev) {
    ev.stopPropagation();
}

function dragStart(ev) {
    ev.dataTransfer.setData("folderId", ev.target.id);
    ev.target.addEventListener("dragover", forbidDrop);
}

function dragEnd(ev) {
    ev.target.removeEventListener("dragover", forbidDrop);
}

function drop(ev) {
    ev.preventDefault();
    var toFolder = ev.target;

    var folderId = ev.dataTransfer.getData("folderId");
    var folder = document.getElementById(folderId);
    bindNode(folder, toFolder);
    saveFolder(folder);
}
