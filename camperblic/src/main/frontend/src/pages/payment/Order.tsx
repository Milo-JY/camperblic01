import React from 'react';
import "../../styles/paymentStyles/Order.css";
import TitleLayout from "./TitleLayout";
import ChargeBox from "./ChargeBox";
import ItemlistOrder from "./ItemlistOrder";



const Order = () => {
    return (
        <section className={"orderLayout"}>
            <div className={'section_wrap'}>
                <div className={'list_section'}>
                    <div className={'list_inner'}>
                        <TitleLayout/>
                        <ItemlistOrder/>
                    </div>
                </div>

                <ChargeBox/>

                <div className={'progress_section'}></div>
            </div>
        </section>
    );
};

export default Order;