import React, {useEffect, useState} from 'react';
import axios from "axios";
import {Simulate} from "react-dom/test-utils";
import error = Simulate.error;
import {Member} from "../../types";
import {useNavigate} from "react-router-dom";
const FindPassword = () => {
    const history = useNavigate ();
    const [userIdData  , setUserIdData ] = useState("");
    const [changePw  , setChangePw ] = useState("");
    const [flag , setFlag] = useState(0);
    const [userDataPw , setUserDataPw] = useState<Member>({
        userid: "",
        name: "",
        email: "",
        phone: "",
        address1: "",
        address2: "",
        address3: "",
        address4: "",
        createdDate: "",
    });
    useEffect(() => {
        console.log('useEffect 실행');
        console.log(userDataPw);
    }, [userDataPw]); // count 상태를 의존성 배열에 추가


    const handleChan = ((e: React.ChangeEvent<HTMLInputElement>) => {
        setUserIdData(e.target.value);
        console.log(userIdData);
    });
    const handlePw = (e: React.FormEvent<HTMLFormElement>) =>{
        e.preventDefault();
        axios.get("/finduserid", {params : {userIdData : userIdData}})
            .then((response) =>{
                setUserDataPw({...response.data});
                console.log("axios")
                console.log(userDataPw);
                setFlag(1);
            })
            .catch((error) => {
                console.log(error);
                alert("아이디가 일치하지 않습니다.")
            });
    };
    const handleChangePw = ((e: React.ChangeEvent<HTMLInputElement>) => {
        setChangePw(e.target.value);
        console.log(e.target.value);
    });

    const handleChangeForm = (e:React.MouseEvent<HTMLButtonElement>) => {
        e.preventDefault();
        axios.put("/changepw" , userDataPw , {params : {changePw : changePw}})
            .then((response) => {
                alert(response.data)
            })
            .catch((error) => {
                console.log(error);

            })
    };


    return (
        <section>
            <h1>CAMPERBLIC</h1>
            <form onSubmit={handlePw}>
                <div>
                    <label>아이디</label>
                    <input type={"text"} name={"userid"} placeholder={"아이디를 입력하세요"} onChange={handleChan}/>
                </div>
                <button>다음</button>
            </form>
            {flag == 1 &&
                <div>
                    <h3>비밀번호 변경</h3>
                    <input type={"text"} name={"password"} placeholder={"변경할 비밀번호를 입력해주세요."} onChange={handleChangePw}/>
                    <button type={"button"} onClick={handleChangeForm}>변경하기</button>
                </div>
            }

        </section>
    );
};

export default FindPassword;