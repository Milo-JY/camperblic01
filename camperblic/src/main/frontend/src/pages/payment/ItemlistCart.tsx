import React from 'react';
import "../../styles/paymentStyles/ItemlistCart.css"
import {Cart} from "./Cart";

interface ItemlistCartProps {
    carts : Cart[];
}

const ItemlistCart: React.FC<ItemlistCartProps> = ({carts}) => {

    return (
        <div className="item_cart">
            <div className="table_wrap">
                <div aria-hidden="true" className="thead_bar">
                    <div className="btn_area">
                        <a href="#" role="button" className="btn_delete_select">선택 삭제
                            <span className="count">1개</span>
                            <span className="blind">비활성</span>
                        </a>
                    </div>

                    <div className="bar_inner">
                        <div className="select">
                            <input type="checkbox" id="chk_all" title="전체 선택" className="input_check"/>
                        </div>
                        <div className="img_and_itemname">상품명</div>
                        <div className="item_count">수량</div>
                        <div className="pay">가격</div>
                        <div className="delivery_fee">배송비</div>
                        <div className="delete">삭제</div>
                    </div>
                    <div tabIndex={0} className="tooltip">
                        <span className="text">최소 주문금액 20,000원 이상부터 배송비는 무료입니다. 20,000원 미만의 경우 배송료 3000원이 부과됩니다.</span>
                        <a href="#" role="button" className="ly_btn_close"><span className="blind">팝업 닫기</span></a>
                    </div>
                </div>

                <table border={1}>
                    <caption>
                <span className="blind">
                    상품 이미지, 상품명, 수량, 가격 정보 및 선택 기능, 삭제 기능을 제공하는 표
                </span>
                    </caption>

                    {/*thead는 Blind 처리*/}
                    <thead>
                    <tr>
                        <th scope="col" className="select">
                            <span className="blind">선택</span>
                        </th>
                        <th scope="col" colSpan={2} className="img_and_itemname">
                            <span className="blind">상품명</span>
                        </th>
                        <th scope="col" className="item_count">
                            <span className="blind">수량</span>
                        </th>
                        <th scope="col" className="price">
                            <span className="blind">가격</span>
                        </th>
                        <th scope="col" className="delivery_fee">
                            <span className="blind">배송비</span>
                        </th>
                        <th scope="col" className="delete">
                            <span className="blind">삭제</span>
                        </th>
                    </tr>
                    </thead>

                    <tbody>
                    {carts.map((cart) => (
                        <tr className="selected">
                            <td className="select">
                                <input type="checkbox" id="{itemname}" title="상품 선택" className="input_check checked"/>
                            </td>
                            <td className="itemimg">
                                <img src="" alt="" className="img_item"
                                />
                            </td>
                            <td className="itemTitle">
                                <div className="title_badge_wrap">
                                <span className="inner_cell">
                                    <span key={cart.itemid} title="{itemname}" className="text">{cart.itemid}
                                    </span>
                                </span>
                                </div>
                            </td>
                            {/* 수량변경 버튼 */}
                            <td key={cart.itemcount} title="수량변경" className="item_count">
                                <input type="number" min="1" max="100" value={cart.itemcount}/>
                            </td>
                            <td className="pay">
                                <div className="price">
                                    {/*{itemprice}*/}
                                    1000원
                                </div>
                            </td>
                            <td className="delivery_fee">
                                <div className="price">3000원 또는 무료</div>
                            </td>
                            <td className="delete">
                                <a href="#" role="button" className="btn_delete"
                                ><span className="blind">삭제</span></a
                                >
                            </td>
                        </tr>
                    ))}
                    </tbody>
                </table>
            </div>
        </div>
    );
};

export default ItemlistCart;