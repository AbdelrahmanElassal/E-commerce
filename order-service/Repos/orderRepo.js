import pool from "../configs/connection-pool-config.js";


export async function findAllOrders() { 
    const orderQuery = "SELECT * FROM orders"
    const orderProductQuery = "SELECT product_id, quantity FROM order_products WHERE order_id = ?"

    // Fetch orders from the database
    const [orders] = await pool.query(orderQuery);  

    //for each order fetch the products associated with it
    const result = await Promise.all(orders.map(async (order) => {
        const [products] = await pool.query(orderProductQuery , [order.id]);
        return {...order, products}; 
    }));

    return result;
}


export async function findOrderByID(id){
    const orderQuery = "SELECT * FROM orders WHERE id = ?"
    const orderProductQuery = "SELECT product_id, quantity FROM order_products WHERE order_id =?"

    const [order] = await pool.query(orderQuery, [id]);

    if(!order[0]) throw new Error(`Order with id ${id} not found`);

    const [products] = await pool.query(orderProductQuery, [id]);

    return {...order, products};
}



export async function findAllCustomerOrders(customerId){
    const orderQuery = "SELECT * FROM orders WHERE customer_id =?";
    const orderProductQuery = "SELECT product_id, quantity FROM order_products WHERE order_id =?";

    const [orders] = await pool.query(orderQuery, [customerId]);

    const result =  await Promise.all(orders.map(async (order) => {
        const [products] = await pool.query(orderProductQuery, [order.id]);
        return {...order, products}; 
    }));

    return result;
}


export async function createOrder({customerId , totalPrice , products}){
    const createOrderQuery = "INSERT INTO orders (customer_id, total_price) VALUES (? , ?)";
    const createOrderProductsQuery = "INSERT INTO order_products (order_id , product_id , quantity) VALUES (?, ? , ?)";

    const [order] = await pool.query(createOrderQuery, [customerId, totalPrice]);
    const orderId = order.insertId;

    products.forEach(product => {
        pool.query(createOrderProductsQuery,[orderId , product.id , product.quantity]);
    });

    return orderId;
}