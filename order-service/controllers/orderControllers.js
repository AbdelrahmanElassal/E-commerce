import { 
    getAllOrdersService,
    getAllCustomerOrderService , 
    getOrderByIdService ,
    updateOrderService ,
    createOrderService
 } from "../services/orderServices.js";

 
export async function fetchAllOrdersController(req, res, next){
    const orders = await getAllOrdersService();
    res.status(200).json(orders);
}
export async function fetchOrderByIdController(req, res, next){
    const order = await getOrderByIdService(req.params.id);
    console.log(order);
    res.status(200).json(order);
}
export async function fetchAllCustomerOrderController(req, res, next){
    const orders = await getAllCustomerOrderService(req.params.id);
    res.status(200).json(orders);
}
export async function updateOrderController(req, res, next){
    const order = await updateOrderService(req.body);
    res.status(200).json(order);
}
export async function createOrderController(req, res, next){
    const order = await createOrderService(req.body);
    res.status(201).json(order);
}



