import MyPageInputAdd from "./MyPageInputAdd";
import React, {useEffect, useState} from 'react';
import {Member} from "../../types";
import axios from "axios";
import {useNavigate} from "react-router-dom";
import {Simulate} from "react-dom/test-utils";
import error = Simulate.error;

interface UserData {
    label: string;
    value: string;
}

interface ChangeInfoData {
    userid: string,
    name: string,
    email: string,
    phone: string,
}

const RenderUserInformation: React.FC<{ user: Member }> = ({user}) => {
    const history = useNavigate ();
    // 넘어온 user 데이터에서 반복문 사용 뽑을 값들 저장
    const addressUserDatas: UserData[] = [
        {label: '우편번호', value: user.address1},
        {label: '도로명 주소', value: user.address2},
        {label: '상세 주소', value: user.address3},
        {label: '참고 항목', value: user.address4},
    ];

    // 넘어온 값들에서 라벨에 주소가 포함된 값들이 있는지 체크 없으면 true
    const hasIncompleteAddress = !addressUserDatas.some(
        (data) => data.label.includes('주소') && data.value
    );

    //트리거 스테이트
    const [change, setChange] = useState(false);
    const [changeRed, setChangeRed] = useState(true);

    //트리거 버튼 클릭시 이벤트 처리
    const addressChange = () => {
        setChange(!change);
    };
    const changeRedOnly = (e: React.MouseEvent<HTMLButtonElement>) => {
        e.preventDefault();
        setChangeRed(!changeRed);
    }

    // changeForm
    const [changeFormData, setChangeFormData] = useState<ChangeInfoData>({
        userid: "",
        name: "",
        email: "",
        phone: "",
    });

    const [userData , setUserData] = useState<ChangeInfoData>({
        userid: "",
        name: "",
        email: "",
        phone: "",
    })

    useEffect(() => {
        setChangeFormData({
            userid: user.userid,
            name: user.name,
            email: user.email,
            phone: user.phone,
        });
        setUserData({
            userid: user.userid,
            name: user.name,
            email: user.email,
            phone: user.phone,
        });
    }, [user]);

    const HandleChange = (e: React.ChangeEvent<HTMLInputElement>) => {
        setChangeFormData({...changeFormData, [e.target.name]: e.target.value});
    }

    // Form submit 이벤트 처리
    const changeInfo = (e: React.FormEvent<HTMLFormElement>) => {
        e.preventDefault();
        axios.put("/updateinfo" ,changeFormData )
            .then((response) => {
                alert(response.status);
                window.location.href = '/mypage';
            })
            .catch((error) =>{
                console.log(error);
                alert("회원정보 수정 실패")
                history("/mypage")
            });
    }
    // 취소 버튼 데이터 초기화
    const retunData = () => {
        setChangeFormData(userData);
    }
    const deleteid =(e: React.MouseEvent<HTMLButtonElement>) => {
        e.preventDefault();
        axios.put("/deletemember", userData)
            .then((respose) => {
                window.location.href = '/';
            })
            .catch((error) => {
                console.log(error)
                history("/mypage");
            });
    }

    const handlLogout = () => {
        axios
            .post("/logout", null, {
                withCredentials: true,
            })
            .then((response) => {
                alert(response.data);
                window.location.href = '/';
            })
            .catch((error) => {
                console.log(error);
                alert("로그아웃 실패");
                history("/mypage");
            });
    };


    return (
        <div>
            <button onClick={handlLogout}>로그아웃</button>
            <form onSubmit={changeInfo}>
                <table>
                    <thead>
                    <tr>
                        <th>항목</th>
                        <th>정보</th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr>
                        {/*회원정보 수정 버튼 클릭식 readOnly = false*/}
                        <td><label htmlFor="userId">아이디</label></td>
                        <td><input type="text" id="userId" value={changeFormData.userid} name={"userid"}
                                   readOnly/></td>
                    </tr>
                    <tr>
                        <td><label htmlFor="userName">이름</label></td>
                        <td><input type="text" id="userName" value={changeFormData.name} name={"name"}
                                   readOnly={changeRed}
                                   onChange={HandleChange}/></td>
                    </tr>
                    <tr>
                        <td><label htmlFor="userEmail">이메일</label></td>
                        <td><input type="text" id="userEmail" value={changeFormData.email} name={"email"}
                                   readOnly={changeRed}
                                   onChange={HandleChange}/></td>
                    </tr>
                    <tr>
                        <td><label htmlFor="userPhone">전화번호</label></td>
                        <td><input type="text" id="userPhone" value={changeFormData.phone} name={"phone"}
                                   readOnly={changeRed}
                                   onChange={HandleChange}/></td>
                    </tr>
                    <tr>
                        <td>가입 날짜</td>
                        <td>{user.createdDate}</td>
                    </tr>
                    </tbody>
                </table>
                {/*정보수정 버튼 클릭시 true 나오고 false면 안나옴*/}
                {!changeRed &&
                    <div>
                        <button type={"submit"}>저장하기</button>
                        <button onClick={retunData}>취소</button>
                    </div>
                }

            </form>
            <button type={"button"} onClick={changeRedOnly}>회원정보 수정</button>
            <button type={"button"} onClick={deleteid}>회원탈퇴</button>
            <table>
                <thead>
                <tr>
                    <th>주소</th>
                    <th>정보</th>
                </tr>
                </thead>
                <tbody>
                {addressUserDatas.map(({label, value}) => (
                    <React.Fragment key={label}>
                        <tr>
                            <td>{label}</td>
                            <td>{value}</td>
                        </tr>
                    </React.Fragment>
                ))}
                <tr>
                    <td>
                        <button onClick={addressChange}>주소 정보 수정</button>
                    </td>
                </tr>
                </tbody>
            </table>

            <div>
                {(hasIncompleteAddress || change) && <MyPageInputAdd/>}
            </div>
        </div>
    );
};

export default RenderUserInformation;
