import React, {useEffect, useState} from 'react';
import "../../styles/loginStyles/MyPageInputAdd.css"
import axios from "axios";
import {Simulate} from "react-dom/test-utils";
import error = Simulate.error;
import {useNavigate} from "react-router-dom";
interface AddressData {
    zonecode: string;
    roadAddress: string;
    jibunAddress: string;
    bname: string;
    apartment: string;
    buildingName: string;
    autoRoadAddress: string;
    autoJibunAddress: string;
}

interface  AddressForm{
    address1: string;
    address2: string;
    address3: string;
    address4: string;
}

const MyPageInputAdd: React.FC = () => {
    const history = useNavigate ();
    const [userAddress , setUserAdderss] = useState<AddressForm>({
        address1 :"",
        address2 :"",
        address3 :"",
        address4 :"",

    });

    const handlePostcodeSearch = () => {
        new (window as any).daum.Postcode({
            oncomplete: (data: AddressData) => {
                const roadAddr = data.roadAddress;
                const extraRoadAddr = /[동|로|가]$/g.test(data.bname) ? data.bname : '';
                const buildingName = data.buildingName;
                let extraAddress = '';

                if (buildingName !== '' && data.apartment === 'Y') {
                    extraAddress = extraRoadAddr !== '' ? `, ${buildingName}` : buildingName;
                }

                if (extraAddress !== '') {
                    extraAddress = ` (${extraAddress})`;
                }

                (document.getElementById('sample4_postcode') as HTMLInputElement).value = data.zonecode;
                (document.getElementById('sample4_roadAddress') as HTMLInputElement).value = roadAddr;
                (document.getElementById('sample4_jibunAddress') as HTMLInputElement).value = data.jibunAddress;
                (document.getElementById('sample4_extraAddress') as HTMLInputElement).value = extraAddress;

                setUserAdderss({
                    ...userAddress,
                    address1 : data.zonecode,
                    address2 : roadAddr,
                    address4 : extraAddress,
                });

                const guideTextBox = document.getElementById('guide');
                if (data.autoRoadAddress) {
                    const expRoadAddr = `${data.autoRoadAddress}${extraAddress}`;
                    guideTextBox!.innerHTML = `(예상 도로명 주소: ${expRoadAddr})`;
                    guideTextBox!.style.display = 'block';
                } else if (data.autoJibunAddress) {
                    const expJibunAddr = data.autoJibunAddress;
                    guideTextBox!.innerHTML = `(예상 지번 주소: ${expJibunAddr})`;
                    guideTextBox!.style.display = 'block';
                } else {
                    guideTextBox!.innerHTML = '';
                    guideTextBox!.style.display = 'none';
                }
            },
        }).open();
    };

    const handleInputChange = (e: React.ChangeEvent<HTMLInputElement>) => {
        setUserAdderss({ ...userAddress, [e.target.name]: e.target.value });
        console.log(userAddress);
    };

    const handleSubmit =  (e:React.MouseEvent<HTMLButtonElement>) => {
        e.preventDefault();
        axios.put("/addAddress" , userAddress)
            .then((response) => {
                if (response.status === 200) {
                    window.location.href = '/mypage';// 성공시 마이페이지
                    alert("정보 수정 성공 ");
                }
            })
            .catch((error) => {
                console.log(error);
                window.location.href = '/mypage';
                alert(error);
            });
    }

    useEffect(() => {
        const script = document.createElement('script');
        script.src = '//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js';
        script.async = true;
        document.body.appendChild(script);

        return () => {
            document.body.removeChild(script);
        };
    }, []);

    return (
        <form className="addMainTable" >
            <h1>주소 추가</h1>
            <table>
                <tbody>
                <tr>
                    <th>우편번호</th>
                    <td>
                        <input type="text" id={"sample4_postcode"} name={"address1"} placeholder="우편번호" onChange={handleInputChange} readOnly />
                    </td>
                    <td>
                        <button type="button" onClick={handlePostcodeSearch}>우편번호 찾기</button>
                    </td>
                </tr>
                <tr>
                    <th>도로명 주소</th>
                    <td>
                        <input type="text" id={"sample4_roadAddress"} name={"address2"} placeholder="도로명주소"  onChange={handleInputChange } readOnly/>
                    </td>
                </tr>
                <tr className={"jibunAddress"}>
                    <th>지번 주소</th>
                    <td>
                        <input type="text" id="sample4_jibunAddress" placeholder="지번주소" readOnly/>
                    </td>
                </tr>
                <tr>
                    <th></th>
                    <td>
                        <span id="guide" style={{ color: '#999', display: 'none' }}></span>
                    </td>
                </tr>
                <tr>
                    <th>상세 주소</th>
                    <td>
                        <input type="text" id={"sample4_detailAddress"} name={"address3"} placeholder="상세주소" onChange={handleInputChange}/>
                    </td>
                </tr>
                <tr>
                    <th>참고 항목</th>
                    <td>
                        <input type="text" id={"sample4_extraAddress"} name={"address4"} placeholder="참고항목" onChange={handleInputChange} readOnly/>
                    </td>
                </tr>
                </tbody>
            </table>
            <button type="submit" onClick={handleSubmit}>저장</button>
        </form>
    );
};

export default MyPageInputAdd;
