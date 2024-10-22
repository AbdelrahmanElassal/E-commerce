import { createOrder } from "./Repos/orderRepo.js";


const orders = await createOrder({customerId : 34 , totalPrice : 324 , products:[
    {id:1, quantity:2},
    {id:2, quantity:3},
    {id:3, quantity:4}
]});


console.log(orders);