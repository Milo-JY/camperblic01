import React, { useEffect, useState } from 'react';
import axios from 'axios';
import RenderUserInformation from './RenderUserInformation';
import {Member} from "../../types";


const MyPage = () => {
    const [user, setUser] = useState<Member>({
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
    const [errorMessage, setErrorMessage] = useState<string>('');
    useEffect(() => {
        // 유저 정보를 가져오는 API 호출
        axios
            .get('/mypage' ,{ withCredentials: true })
            .then((response) => {
                if (response.status === 200) {
                    setUser(response.data);
                } else {
                    setErrorMessage(response.data);
                }
            })
            .catch((error) => {
                console.error(error);
            });
    }, []);

    return (
        <section>
            <div className="mypageMainDiv">
                {errorMessage ? <p>{errorMessage}</p> : <RenderUserInformation user={user} />}
            </div>
        </section>
    );
};

export default MyPage;
