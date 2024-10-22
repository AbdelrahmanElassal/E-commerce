//import orderProduct from "./orderProduct";

export default class Order{
    constructor(id, customerId, totalPrice, status, createdAt){
        this.id = id;
        this.customerId = customerId;
        this.totalPrice = totalPrice;
        this.status = status;
        this.createdAt = createdAt;
        this.products = [];
    }
}
