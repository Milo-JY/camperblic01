import React, { useState } from 'react';
import { Link, useNavigate } from 'react-router-dom';
import '../../../../styles/adminStyles/admindashboard/AdminDashboardSecond.css';
import AdminDashboardSecondTime from './AdminDashboardSecondTime';
import {Tmp} from "../../../../types";
import AdminDashboardOrder from "./AdminDashboardOrder";

interface AdminDashboardSecondProps {
    isOrderStatusVisible: boolean;
    onToggleOrderStatus: () => void;
    tmp:Tmp[];
}

const AdminDashboardSecond: React.FC<AdminDashboardSecondProps> = ({ tmp }) => {
    const navigate = useNavigate();

    return (
        <section className="second_div">
            <Link className="second_member" to="/adminmember">
                회원관리
            </Link>
            {/*<div>*/}
            {/*    <div className="admindashboard_test">*/}
            {/*        <div>주문현황</div>*/}
            {/*        <AdminDashboardOrder tmp={tmp}/>*/}
            {/*    </div>*/}
            {/*</div>*/}
            <AdminDashboardSecondTime />
        </section>
    );
};

export default AdminDashboardSecond;
