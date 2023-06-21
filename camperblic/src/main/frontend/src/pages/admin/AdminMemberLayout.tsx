import React from 'react';
import {Member} from "../../types";
import '../../styles/adminStyles/AdminMemberLayout.css';

interface MemberLayOut {
    member: Member[];
}

const AdminMemberLayout:React.FC<MemberLayOut> = ({member}) => {
    return (
        <section className='homeWidgets'>
            <table className='widgettable'>
                <thead>
                <tr className='widgetmember1'>
                    <th>id</th>
                    <th>이름</th>
                    <th>전화번호</th>
                    <th>이메일</th>
                    <th>상세보기</th>
                </tr>
                </thead>
                <tbody>
                {member.map((item) => (
                <tr className='widgetmember2'>
                    <td>{item.userid}</td>
                    <td>{item.name}</td>
                    <td>{item.phone}</td>
                    <td>{item.email}</td>
                    <td>
                        <button className='widgetbtn'>detail</button>
                    </td>
                </tr>
                ))}
                </tbody>
            </table>
        </section>
    );
};

export default AdminMemberLayout;