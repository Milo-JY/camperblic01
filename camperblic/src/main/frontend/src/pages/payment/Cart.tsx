import React, {useEffect, useState} from 'react';
import "../../styles/paymentStyles/Cart.css";
import TitleLayout from "./TitleLayout";
import ItemlistCart from "./ItemlistCart";
import ChargeBox from "./ChargeBox";
import axios from "axios";

export interface Cart {
    cartid: number,
    userid: string,
    itemid: string,
    itemcount: number,
}

const Cart = () => {
    const userid = "user1";

    const [carts, setCarts] = useState<Cart[]>([]);

    useEffect(() => {
        axios.get('/cart', {
            params: {
                userid: userid
            }
        })
            .then(response => {
                console.log(response.data);
                setCarts(response.data);
            })
            .catch(error => console.log(error))
    }, [userid]);

    return (
        <section className="cartLayout">
            <div className="section_wrap">
                <div className="list_section">
                    <div className="list_inner">
                        <TitleLayout/>
                        <ItemlistCart carts={carts}/>
                    </div>
                </div>
                <ChargeBox/>
            </div>
            <div className="progress_section"></div>
        </section>
    );
};

export default Cart;