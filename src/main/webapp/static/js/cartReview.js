let modal = document.getElementById("checkoutModal");

let btn = document.getElementById("Cart");

let tbody = document.getElementById("body");

let headers = ["productName","productPrice","quantity","totalPrice"];



btn.onclick = function () {
    let url = "/";
    $.post(url,
        {
        }, function(response, status) {
            if (status === "success"){
                console.log(response);
                while(tbody.firstChild) tbody.removeChild(tbody.firstChild);
                for(let i=0; i < response.length; i++){
                    let new_table_row = document.createElement("tr");
                    for(let header of headers){
                        let new_table_cell = document.createElement("td");
                        let cell_text = document.createTextNode(response[i][header]);
                        new_table_cell.appendChild(cell_text);
                        new_table_row.appendChild(new_table_cell);
                        tbody.appendChild(new_table_row);
                    }
                }
            }
        }
    )
};


window.onclick = function(event) {
    if (event.target == modal) {
        modal.style.display = "none";
    }
}