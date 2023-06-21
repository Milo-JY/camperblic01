import React from 'react';
import "../../styles/paymentStyles/ChargeBox.css";
const ChargeBox = () => {
    return (
        <div className={'charge_section'}>
            <div className={'charge_area'}>
                <div className={'count_area'}>
                    <div className={'count_item'}>
                        <span className={'title'}>선택 상품 수</span>
                        <span className={'data positive'}>1개</span>
                    </div>
                </div>
                <div className={'coupon_area'}>
                    <div className={'usestatus_coupon'}>
                        <span className={'title'}>쿠폰 사용여부</span>
                        <span className={'data positive'}>미적용</span>
                    </div>
                </div>
                <hr></hr>
                <div className={'discount_area'}>
                    <span className={'title'}>총 할인금액</span>
                    <span className={'discount_cost'}>10,000원</span>
                </div>
                <div className={'total_area'}>
                    <span className={'title'}>총 결제금액</span>
                    <div className={'total_price'}>
                        <strong className={'charge'}>200,000원</strong>
                        <span className={'text_vat'}>(부가세 포함)</span>
                    </div>
                </div>
            </div>
            <div className={'agree_area'}>
                <input type={"checkbox"} id={'agree_terms'} className={'input_agree'}/>
                <label className={'label_agree'}>CAMPERBLIC 이용약관에 동의합니다.</label>
            </div>
            <a href={'/order'} target={'_blank'} rel={'noreferrer'} className={'link_pay disabled'}>
                결제하기
            </a>
        </div>
    );
};

export default ChargeBox;