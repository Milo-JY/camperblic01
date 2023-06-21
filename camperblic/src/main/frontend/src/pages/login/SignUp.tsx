import React, {useState} from 'react';
import { useNavigate  } from 'react-router-dom';
import '../../styles/loginStyles/SignUp.css';
import axios from "axios";
interface SignUpForm{
    userid :string,
    password : string,
    name : string,
    email : string,
    phone : string,
}
const SignUp = () => {
    const history = useNavigate ();
    const [signUpForm , setSignUpForm] =
        useState<SignUpForm>({
            userid :'',
            password :'' ,
            name : '' ,
            email :'' ,
            phone : '',
        });
    const handleInputChange = (e: React.ChangeEvent<HTMLInputElement>) => {
        setSignUpForm({ ...signUpForm, [e.target.name]: e.target.value });
        console.log(signUpForm);
    };

    const SigupBtn = (e: React.FormEvent<HTMLFormElement>) => {
        e.preventDefault();
        axios.post('/signup', signUpForm)
            .then((response) => {
                // 회원가입 성공 시 로그인으로 이동
                if (response.status === 200) {
                    history('/login'); // 로그인 페이지
                    alert("회원 가입 성공 ");
                }
            })
            .catch((error) => {
                console.error(error);
                window.location.href = '/signup';
                alert("회원 가입 실패 ");
            });
    }

    return (
        <section className={"SignUpMainDiv"}>
            <div className={"MainDivForm"}>
                <h1>회원가입</h1>
                <form onSubmit={SigupBtn}>
                    <table>
                        <colgroup>
                            <col style={{width: '50%'}}/>
                            <col style={{width: '50%'}}/>
                        </colgroup>
                        <tbody>
                        <tr>
                            <td><label htmlFor={'name'}>이름</label></td>
                            <td>
                                <input type="text" placeholder="이름을 입력하세요" id={"name"} name={"name"} onChange={handleInputChange} />
                            </td>
                        </tr>
                        <tr>
                            <td><label htmlFor={'id'}>아이디</label></td>
                            <td>
                                <input type="text" placeholder="아이디를 입력하세요" id={"id"} name={"userid"} onChange={handleInputChange}/>
                            </td>
                        </tr>
                        <tr>
                            <td><label htmlFor={'pw'}>비밀번호</label></td>
                            <td>
                                <input type="password" placeholder="비밀번호를 입력하세요"  id={"pw"} name={"password"} onChange={handleInputChange}/>
                            </td>
                        </tr>
                        <tr>
                            <td><label htmlFor={'email'}>이메일</label></td>
                            <td>
                                <input type="text" placeholder="이메일을 입력하세요" id={"email"} name={"email"} onChange={handleInputChange}/>
                            </td>
                        </tr>
                        <tr>
                            <td><label htmlFor={'phone'}>휴대전화번호</label></td>
                            <td>
                                <input type="text" placeholder="휴대전화번호를 입력하세요" id={"phone"} name={"phone"} onChange={handleInputChange}/>
                            </td>
                        </tr>
                        {/*<tr>*/}
                        {/*    <td>이미지</td>*/}
                        {/*    <td>*/}
                        {/*        <input type="file" placeholder="전화번호를 입력하세요"/>*/}
                        {/*    </td>*/}
                        {/*</tr>*/}
                        </tbody>
                    </table>
                    <button>회원가입</button>
                </form>
            </div>
        </section>
    );
};

export default SignUp;