const url = 'http://localhost:8080/api/person'
const tableDiv = document.querySelector('#table_person')

function loadContent() {
    sendRequest('GET',url)
        .then(JsonData => JSON.parse(JsonData))
        .then(data => {
            let element = viewTable(data)
            tableDiv.prepend(element)}
        )
}

function sendRequest(method, url, body){
    return new Promise(resolve => {
        const xhr = new XMLHttpRequest()
        xhr.open(method, url)
        xhr.setRequestHeader('Content-Type','application/json')

        xhr.onload = () => {
            resolve(xhr.response)
        }
        xhr.send(JSON.stringify(body))
    })
}

function viewTable(args) {
    let table = document.createElement("table")
    let thead = table.createTHead()
    let row = thead.insertRow()

    Object.getOwnPropertyNames(args[0]).forEach((k) => {
        let data = document.createTextNode(k)
        let newCell = row.insertCell(-1)
        newCell.appendChild(data)
    })
    thead.appendChild(row)
    let tbody = table.createTBody();
    args.forEach((arg) => addRow(tbody, arg))

    return table
}

function addRow(tbody, obj) {
    let row = tbody.insertRow()

    for (let value of Object.values(obj)){
        let data = document.createTextNode(value)
        let newCell = row.insertCell(-1)
        newCell.appendChild(data)
    }

    tbody.appendChild(row)
}
