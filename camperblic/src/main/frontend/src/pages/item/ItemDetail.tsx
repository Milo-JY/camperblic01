import React, { useEffect, useState } from 'react';
import { Link, useParams } from 'react-router-dom';
import axios from "axios";
import { Item } from '../../types';
import "../../styles/itemStyles/itemDetail.css";

const ItemDetail = () => {
    const { itemId, categoryId } = useParams<{ itemId: string, categoryId: string }>();
    const [item, setItem] = useState<Item>();

    const addToCart = () => {
        axios
            .post("/cart", {
                itemid: itemId,
                itemcount: 1 // 한 번에 하나의 상품만 장바구니에 추가하는 것으로 가정
            })
            .then(() => {
                alert("상품이 장바구니에 담겼습니다.");
            })
            .catch((error) => {
                alert("상품을 장바구니에 추가하는 데 실패했습니다.");
                console.error('상품을 장바구니에 추가하는 데 실패했습니다.', error);
            });
    };

    useEffect(() => {
        axios
            .get(`/itemdetail/${categoryId}/${itemId}`)
            .then((response) => setItem(response.data))
            .catch((error) => {
                console.error('게시물을 가져오는 데 실패했습니다.', error);
            });
    }, [itemId]);

    if (!item) {
        return <p>로딩 중...</p>;
    }

    return (
        <>
            <h1 className="detailTop">CAMPERBLIC.</h1>
            <div className="item-detail-container">
                <div className="item-detail-image">
                    {item && <img src={item.imagePath} alt={item.name} />}
                </div>
                <div className="item-detail-content">
                    <h1 className="item-detail-title">{item?.categoryId}의 {item?.name} 상세페이지입니다</h1>
                    <h2 className="item-detail-subtitle">{item?.name}</h2>
                    <p className="item-detail-text">가격: {item?.price}</p>
                    <p className="item-detail-text">설명: {item?.description}</p>
                    <p className="item-detail-text">카테고리 ID: {item?.categoryId}</p>
                    <p className="item-detail-text">수량: {item?.amount}</p>
                    <p className="item-detail-text">재고: {item?.currentStock}</p>
                    <button onClick={addToCart} className="item-detail-link">장바구니</button>
                    <Link to="/itemall" className="item-detail-link">상품목록</Link>
                </div>
            </div>
            <div className="item-detail-description">
                <p>상세 설명 내용</p>
                <img src="/path/to/detailed-image.jpg" alt="상세 설명 이미지" />
            </div>
        </>
    );
};

export default ItemDetail;
