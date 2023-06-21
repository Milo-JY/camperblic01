import React from 'react';
import {Item} from "../../../../types";
import '../../../../styles/adminStyles/AdminStockLayout.css';
interface ItemLayOutProps {
    items: Item[];
}
const AdminStockLayout:React.FC<ItemLayOutProps> = ({items}) => {
    return (
        <section>
            <table className='AdminStock_tabcontenttable'>
                <thead>
                <tr className='AdminStock_contenttableth'>
                    <th>상품이미지</th>
                    <th>상품코드</th>
                    <th>상품명</th>
                    <th>상품가격(원)</th>
                    <th>재고수량</th>
                    <th>재고수정</th>

                </tr>
                </thead>
                <tbody>
                {items.map((item) => (
                <tr className='AdminStock_contenttabletd'>
                    <td>
                        <img className='AdminStock_contentImg' src={item.imagePath} />
                    </td>
                    <td>{item.itemId}</td>
                    <td>{item.name}</td>
                    <td>{item.price}</td>
                    <td>{item.currentStock}</td>
                    <td>
                        <button className='AdminStock_modifyBtn'>수정</button>
                    </td>
                </tr>
                ))}
                </tbody>
            </table>
        </section>
    );
};

export default AdminStockLayout;