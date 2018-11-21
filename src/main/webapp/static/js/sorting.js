function sortingSetup() {
    const urlParams = new URLSearchParams(window.location.search);
    const categoryParam = urlParams.get('categoryID');
    const supplierParam = urlParams.get('supplierID');
    let sortingSelectionCat = document.getElementById("selectioncategory");
    let sortingSelectionSup = document.getElementById("selectionsupplier");
    if (categoryParam != null) {
        sortingSelectionCat.options[categoryParam-1].selected = 'selected';
    }
    if (supplierParam != null) {
        sortingSelectionSup.options[supplierParam-1].selected = 'selected';
    }


    sortingSelectionCat.addEventListener("change", function() {
        let categoryID = this.options[this.selectedIndex].dataset.categoryid;
        urlParams.set("categoryID", categoryID);
        window.location.assign("?" + urlParams.toString());
    });
    sortingSelectionSup.addEventListener("change", function() {
        let supplierID = this.options[this.selectedIndex].dataset.supplierid;
        urlParams.set("supplierID", supplierID);
        window.location.assign("?" + urlParams.toString());
    });
}

sortingSetup();