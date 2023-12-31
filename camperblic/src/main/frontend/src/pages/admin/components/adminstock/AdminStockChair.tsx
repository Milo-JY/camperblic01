import React, {useEffect, useState} from 'react';
import {Item} from "../../../../types";
import axios from "axios";
import AdminBoardLayout from "../adminboard/AdminBoardLayout";
import AdminStockLayout from "./AdminStockLayout";

const AdminStockChair = () => {
    const [items, setItems] = useState<Item[]>([]);

    useEffect(() => {
        axios.get('/adminstock/chair')
            .then(response => setItems(response.data))
            .catch(error => console.log(error))
    }, []);
    return (
        <AdminStockLayout items={items} />
    );
};

export default AdminStockChair;