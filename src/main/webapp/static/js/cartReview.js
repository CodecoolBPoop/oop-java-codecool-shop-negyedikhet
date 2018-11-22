function init(){
    let modal = document.getElementById("checkoutModal");

    let btn = document.getElementById("Cart");

    let tbody = document.getElementById("body");

    let headers = ["productName","productPrice","quantity","totalPrice","#"];

    let checkoutButton = document.getElementById("checkoutButton");

    btn.onclick = function () {
        let url = "/";
        $.post(url,
            {
            }, function(response, status) {
                if (status === "success"){
                    console.log(response);
                    let list_num = 0;
                    while(tbody.firstChild) tbody.removeChild(tbody.firstChild);
                    let productId;
                    for(let i=0; i < response.length; i++){
                        let new_table_row = document.createElement("tr");
                        productId = response[i]["productId"];
                        for(let header of headers){
                            let {new_table_cell, rem_btn, rem_btn_text, add_btn, add_btn_text} = create_btn_variables();
                            if(header==="#" && response[i]["quantity"] > 0){
                                add_buttons(rem_btn, rem_btn_text, add_btn, add_btn_text, new_table_cell, new_table_row, productId, headers, tbody);

                            }
                            else if (response[i]["quantity"]===0) {}
                            else {
                                let cell_text = document.createTextNode(response[i][header]);
                                new_table_cell.appendChild(cell_text);
                                new_table_row.appendChild(new_table_cell);
                                tbody.appendChild(new_table_row);
                            }
                        }
                        list_num += parseInt(response[i]["totalPrice"]);
                        console.log(list_num)

                    }
                    let total_price = document.createTextNode(list_num + "USD");
                    let new_list_element = document.createElement("li");
                    new_list_element.classList.add("list-group-item");
                    new_list_element.setAttribute("id","total");
                    new_list_element.appendChild(total_price);
                    tbody.appendChild(new_list_element);
                }
            }
        );
    };

    checkoutButton.onclick = function(){
        location.href = "checkout";
    };


    window.onclick = function(event) {
        if (event.target === modal) {
            modal.style.display = "none";
        }
    };
}

function add_buttons(rem_btn, rem_btn_text, add_btn, add_btn_text, new_table_cell, new_table_row, productId, headers, tbody) {
    rem_btn.appendChild(rem_btn_text);
    rem_btn.classList.add("btn-sm");
    rem_btn.classList.add("btn");
    rem_btn.classList.add("btn-danger");
    rem_btn.setAttribute("id", headers[0] + productId);
    add_btn.appendChild(add_btn_text);
    add_btn.classList.add("btn-sm");
    add_btn.classList.add("btn");
    add_btn.classList.add("btn-success");
    add_btn.setAttribute("id", headers[0] + productId);
    new_table_cell.appendChild(add_btn);
    new_table_cell.appendChild(rem_btn);
    new_table_row.appendChild(new_table_cell);
    tbody.appendChild(new_table_row);


    add_btn.addEventListener("click", function () {
        let url = "add-to-cart";
        $.post(url,
            {
                "productId" : productId
            }, function(response, status) {
                if (status === "success"){
                    let quantity = add_btn.parentNode.previousSibling.previousSibling.innerHTML;
                    add_btn.parentNode.previousSibling.previousSibling.innerHTML = (parseInt(quantity) + 1).toString();
                    console.log("Successfully added to cart");
                    let totalPrice = parseInt(add_btn.parentNode.previousSibling.innerHTML);
                    let totalList = document.getElementById("total");
                    totalList.innerHTML = (parseInt(totalList.innerHTML) + totalPrice).toString() + "USD"
                }
                else {
                    alert("Status: " + status)
                }
            }
        );
    });

    rem_btn.addEventListener("click", function () {
        let url = "subtract-from-cart";
        $.post(url,
            {
                "productId" : productId
            }, function(response, status) {
                if (status === "success"){
                    let quantity = rem_btn.parentNode.previousSibling.previousSibling.innerHTML;
                    rem_btn.parentNode.previousSibling.previousSibling.innerHTML = (parseInt(quantity) - 1).toString();
                    if (parseInt(rem_btn.parentNode.previousSibling.previousSibling.innerHTML)=== 0) {
                        rem_btn.parentElement.parentElement.remove();
                    }
                    console.log("Successfully subtracted from cart")
                    let totalPrice = parseInt(rem_btn.parentNode.previousSibling.innerHTML);
                    let totalList = document.getElementById("total");
                    totalList.innerHTML = (parseInt(totalList.innerHTML) - totalPrice).toString() + "USD"
                } else {
                    alert("Status: " + status)
                }
            }
        );
    })
}

function create_btn_variables() {
    let new_table_cell = document.createElement("td");
    let rem_btn = document.createElement("BUTTON");
    let rem_btn_text = document.createTextNode(" - ");
    let add_btn = document.createElement("BUTTON");
    let add_btn_text = document.createTextNode("+");
    return {new_table_cell, rem_btn, rem_btn_text, add_btn, add_btn_text};
}

init();