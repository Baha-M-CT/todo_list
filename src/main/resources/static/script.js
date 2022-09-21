function addRowToTable(text) {
    let row = document.getElementById('table').insertRow();
    row.insertCell().innerHTML = text;
}

function sendRowToServer(text) {
    fetch('/task', {
        method: 'POST',
        headers: {'Content-Type':'application/x-www-form-urlencoded'},
        body: 'text=' + text
    }).catch(error => {
        console.log(error);
    });
}

function saveRowToApp() {
    let text = document.getElementById('text').value;

    sendRowToServer(text);
    addRowToTable(text);

    document.getElementById('text').value = '';
}

fetch('/tasks').then(response => {
        return response.json();
}).then(data => {
        for (task of data) {
            addRowToTable(task);
        }
 }).catch(error => {
    console.log(error);
 });