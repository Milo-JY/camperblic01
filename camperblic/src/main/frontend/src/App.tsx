import React from 'react';

import "./styles/App.css"
import { BrowserRouter, Route, Routes } from "react-router-dom";
import Header from "./components/Header";
import Footer from "./components/Footer";
import Main from "./pages/Main";
import Cook from "./pages/item/Cook";
import Etc from "./pages/item/Etc";
import Mat from "./pages/item/Mat";
import ItemDetail from "./pages/item/ItemDetail";
import ItemAll from "./pages/item/ItemAll";
import Chair from "./pages/item/Chair";
import Tent from "./pages/item/Tent";
import Login from "./pages/login/Login";

import Cart from "./pages/payment/Cart";
import Order from "./pages/payment/Order";
import AdminDashboard from "./pages/admin/AdminDashboard";
import AdminBoard from "./pages/admin/AdminBoard";
import AdminMember from "./pages/admin/AdminMember";
import AdminStock from "./pages/admin/AdminStock";
import FindAccount from "./pages/login/FindAccount";
import FindPassword from "./pages/login/FindPassword";
import MyPage from "./pages/login/MyPage";
import OrderList from "./pages/login/OrderList";
import OrderDetail from "./pages/payment/OrderDetail";
import CampStroy from "./pages/community/CampStroy";
import CommunityDashboard from "./pages/community/CommunityDashboard";
import FreeBoard from "./pages/community/FreeBoard";
import GatherCamperBoard from "./pages/community/GatherCamperBoard";
import ReviewCampSite from "./pages/community/ReviewCampSite";
import BoardDetail from "./pages/community/BoardDetail";
import SignUp from "./pages/login/SignUp";

function App() {

    return (

        <div>
            <BrowserRouter>
                <Header/>

                <main>
                    <Routes>
                        <Route path='/' element={<Main/>}/>

                        {/* 호준 로그인 관련 페이지 */}
                        <Route path='/login' element={<Login/>}/>
                        <Route path='/signup' element={<SignUp/>}/>
                        <Route path='/mypage' element={<MyPage/>}/>
                        <Route path='/orderlist' element={<OrderList/>}/>
                        <Route path='/findaccount' element={<FindAccount/>}/>
                        <Route path='/findpassword' element={<FindPassword/>}/>

                        {/* 민수 커뮤니티 관련 페이지 */}
                        <Route path='/campstory' element={<CampStroy/>}/>
                        <Route path='/community' element={<CommunityDashboard/>}/>
                        <Route path='/freeboard' element={<FreeBoard/>}/>
                        <Route path='/gathercamper' element={<GatherCamperBoard/>}/>
                        <Route path='/reviewcampingsite' element={<ReviewCampSite/>}/>
                        <Route path='/boarddetail/:category/:id' element={<BoardDetail/>}/>

                        {/* 신준 상품 관련 페이지 */}
                        <Route path='/itemall' element={<ItemAll/>}/>
                        <Route path='/itemdetail/:categoryId/:itemId' element={<ItemDetail/>}/>
                        <Route path='/cook' element={<Cook/>}/>
                        <Route path='/etc' element={<Etc/>}/>
                        <Route path='/mat' element={<Mat/>}/>
                        <Route path='/chair' element={<Chair/>}/>
                        <Route path='/tent' element={<Tent/>}/>

                        {/* 종윤 결제 관련 페이지 */}
                        <Route path='/cart' element={<Cart/>}/>
                        <Route path='/order' element={<Order/>}/>
                        <Route path='/orderdetail' element={<OrderDetail/>}/>

                        {/* 민우 관리자 페이지 */}
                        <Route path='/admindashboard' element={<AdminDashboard/>}/>
                        <Route path='/adminboard' element={<AdminBoard/>}/>
                        <Route path='/adminmember' element={<AdminMember/>}/>
                        <Route path='/adminstock' element={<AdminStock/>}/>
                    </Routes>
                </main>

                <Footer/>
            </BrowserRouter>
        </div>
    );
}

export default App;