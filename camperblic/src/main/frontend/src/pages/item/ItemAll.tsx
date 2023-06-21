import React, { useEffect, useState } from 'react';
import { Link } from 'react-router-dom';
import { Item } from "../../types";
import axios from "axios";
import ItemLayOut from "./ItemLayOut";

const ItemAll = () => {
    const [items, setItems] = useState<Item[]>([]);
    const [isLoading, setIsLoading] = useState(false);

    const fetchItems = () => {
        setIsLoading(true);

        axios.get('/cook')
            .then(response => setItems(prevItems => [...prevItems, ...response.data]))
            .catch(error => console.log(error));

        axios.get('/etc')
            .then(response => setItems(prevItems => [...prevItems, ...response.data]))
            .catch(error => console.log(error));

        axios.get('/mat')
            .then(response => setItems(prevItems => [...prevItems, ...response.data]))
            .catch(error => console.log(error));

        axios.get('/chair')
            .then(response => setItems(prevItems => [...prevItems, ...response.data]))
            .catch(error => console.log(error));

        axios.get('/tent')
            .then(response => setItems(prevItems => [...prevItems, ...response.data]))
            .catch(error => console.log(error));

        setIsLoading(false);
    };

    const loadMoreItems = () => {
        fetchItems();
    };

    useEffect(() => {
        fetchItems();
    }, []);

    return (
        <ItemLayOut items={items} topText="전체상품" onLoadMore={loadMoreItems} />
    );
};

export default ItemAll;
