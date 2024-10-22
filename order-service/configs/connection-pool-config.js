import mysql2 from 'mysql2';
import dotenv from 'dotenv';

const dote = dotenv.config();


const pool = new mysql2.createPool({
    host: process.env.DATABASE_HOST,
    user: process.env.DATABASE_USER,
    password: process.env.DATABASE_PASSWORD,
    database: process.env.DATABASE_NAME
}).promise();



export default pool;