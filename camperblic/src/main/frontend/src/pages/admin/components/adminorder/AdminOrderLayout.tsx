import React from 'react';
import {Item, Posting, Tmp} from "../../../../types";
import '../../../../styles/adminStyles/admindashboard/AdminDashboardOrderLayout.css';

interface TmpLayOut {
    tmp: Tmp[];
}
const AdminOrderLayout:React.FC<TmpLayOut> = ({tmp}) => {
    return (
        <section>
            <table className='AdminBoard_table'>
                <thead>
                <tr className='AdminBoardFormth'>
                    <th>상품</th>
                    <th>주문자ID</th>
                    {/*<th>주문상품</th>*/}
                    <th>가격</th>
                    <th>주문시간</th>
                    <th>배송상태</th>
                    <th>주문취소하기</th>
                </tr>
                </thead>
                <tbody>
                {tmp.map((item) => (
                    <tr className='AdminBoardFormtd'>
                        <td className='AdminBoardFormtdcenter'>{item.orderid}</td>
                        <td className='AdminBoardFormtdcenter'>{item.userid}</td>
                        {/*<td className='AdminBoardFormtdcenter'>{item.orderItem}</td>*/}
                        <td className='AdminBoardFormtdcenter'>{item.deliverycost}</td>
                        <td className='AdminBoardFormtdcenter'>{item.orderdate}</td>
                        <td className='AdminBoardFormtdcenter'>{item.orderstatus}</td>
                        <td className='AdminBoardFormtdcenter'>
                            <button className='adminBoardForm_btn'>주문취소</button>
                        </td>
                    </tr>
                ))}
                </tbody>
            </table>
        </section>
    );
};

export default AdminOrderLayout;