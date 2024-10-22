import { findAllOrders,
    findOrderByID,
    findAllCustomerOrders,
    createOrder
 } from "../Repos/orderRepo.js";

export async function getAllOrdersService(){
    try{
        const orders = await findAllOrders();
        return orders;
    }catch(e){
        throw e;
    }
}

export async function getOrderByIdService(orderId){
    try {
        const order = await findOrderByID(orderId);
        return order;
    }catch(e){
        throw e;
    }
}

export async function getAllCustomerOrderService(customerId){
    try{
        const orders = await findAllCustomerOrders(customerId);
        return orders;
    }catch(e){
        throw e;
    }
}


export async function createOrderService(order){
    try{
        const order = await createOrder(order);
        return order;
    }catch(e){
        throw e;
    }
}

export function updateOrderService(order){

}


