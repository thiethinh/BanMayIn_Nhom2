//List sản phẩm tượng trưng trong giỏ hàng
let products = [
    // {id: 1, name: "Máy in phun màu Epson L6270", price: 16990000 , quantity: 1},
    // {id: 2, name: "Máy in HP Laser MFP 3303fdn", price: 10490000, quantity: 2},
    // {id: 3, name: "Máy in Laser DCP-L3560CDW", price: 11790000, quantity: 1}
    // {id: 4; name: "Máy in Brother HL-L2321D", price: 3000000, quantity: 1},
    // {id: 5; name: "Máy in Samsung Xpress M2020W", price: 2800000, quantity: 1}
];
    // chọn khối 2 khối main
    const mainList = document.querySelectorAll("main");
    const mainEmpty = mainList[0];
    const mainFill = mainList[1];

    //kiểm tra nếu giỏ hàng rỗng
    if (products.length === 0) {
        mainFill.style.display = "none";
        mainEmpty.style.display = "block";
    } else {
        mainFill.style.display = "block";
        mainEmpty.style.display = "none";
    
    }