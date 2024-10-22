import express from 'express';
import orderRouter from './routes/order-routes.js';

const app = express();


app.use(orderRouter);



app.listen(5000 , ()=>{
    console.log('Server running on port 5000');
})