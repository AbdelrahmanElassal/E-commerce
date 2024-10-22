import { Router } from "express";
import { 
    fetchAllOrdersController,
    fetchOrderByIdController, 
    fetchAllCustomerOrderController, 
    createOrderController, 
    updateOrderController 
} from '../controllers/orderControllers.js';

const orderRouter = Router();




orderRouter.get('/order' , fetchAllOrdersController);
orderRouter.get('/order/:id', fetchOrderByIdController);
orderRouter.get('/order/customer/:id', fetchAllCustomerOrderController);
orderRouter.post('/order', createOrderController);
orderRouter.put('/order/:id', updateOrderController);


export default orderRouter;