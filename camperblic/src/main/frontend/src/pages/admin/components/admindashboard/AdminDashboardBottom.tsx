import React, { useEffect, useState } from 'react';
import AdminDashboardStock from './AdminDashboardStock';
import AdminDashboardBoard from './AdminDashboardBoard';
import '../../../../styles/adminStyles/admindashboard/AdminDashboardBottom.css';
import { Item, Posting } from "../../../../types";
import axios from "axios";

interface Props {
    items: Item[];
    postings: Posting[];
}

const AdminDashboardBottom: React.FC<Props> = ({ items, postings }) => {
    // const [items, setItems] = useState<Item[]>([]);

    // useEffect(() => {
    //     axios.get('/admindashboard')
    //         .then(response => setItems(response.data))
    //         .catch(error => console.log(error))
    // }, []);

    return (
        <section className='admindashboard_bottom'>
            <AdminDashboardStock items={items} />
            <AdminDashboardBoard postings={postings} />
        </section>
    );
};

export default AdminDashboardBottom;
