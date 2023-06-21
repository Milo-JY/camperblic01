import React, {useEffect, useState} from 'react';
import {Posting} from "../../../../types";
import '../../../../styles/adminStyles/AdminBoardLayout.css';
import {useNavigate, useParams} from "react-router-dom";
import axios from "axios/index";

interface BoardLayOutProps {
    postings: Posting[];
}


const AdminBoardLayout:React.FC<BoardLayOutProps> = ({ postings }) => {
    const todayTime = () => {
        let now= new Date();
        let todayYear = now.getFullYear();
        let todayMonth = now.getMonth()+1;
        let todayDate = now.getDate();
        const week = ['Sun','Mon','Tue','Wed','Thr','Fri','Sat'];
        let dayOfWeek = week[now.getDay()];
        let hours = now.getHours();
        let minutes = now.getMinutes();

        return {
            date: todayYear + '.' + todayMonth + '.' + todayDate,
            dayOfWeek: dayOfWeek,
            time: hours + '시' + minutes + '분',
        };
    }
    const navigate = useNavigate();

    const handleEdit = (bid: number, category: string) => {
        navigate(`/boarddetail/${category}/${bid}`);
    };

    return (
        <section>
            <table className='AdminBoard_table'>
                <thead>
                <tr className='AdminBoardFormth'>
                    <th>ID</th>
                    <th>작성자</th>
                    <th>제목</th>
                    <th>작성일</th>
                    <th>Views</th>
                    <th>수정</th>
                </tr>
                </thead>
                <tbody>
                {postings.map((item) => (
                <tr className='AdminBoardFormtd'>
                    <td className='AdminBoardFormtdcenter'>{item.id}</td>
                    <td className='AdminBoardFormtdcenter'>{item.name}</td>
                    <td className='AdminBoardFormtdcenter'>{item.title}</td>
                    <td className='AdminBoardFormtdcenter'>
                        {todayTime().date} {todayTime().dayOfWeek} {todayTime().time}
                    </td>
                    <td className='AdminBoardFormtdcenter'>{item.views}</td>
                    <td className='AdminBoardFormtdcenter'>
                        <button className='adminBoardForm_btn' onClick={() => handleEdit(item.id,item.category)}>수정</button>
                    </td>
                </tr>
                ))}
                </tbody>
            </table>
        </section>
    );
};

export default AdminBoardLayout;