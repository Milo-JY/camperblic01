import { Link } from "react-router-dom";
import "../styles/header.css";
import {useState} from "react";
import Admin from "./Admin";

const Header = () => {
    const [isMall, setIsMall] = useState<boolean>(true);
    const [isAdmin, setIsAdmin] = useState<boolean>(true);

    const handleOfIsMall = () => {
        setIsMall((p) => !p);
    };

    return (
        <header>
            <div className="justDeco top"></div>

            <aside className="asideTop">
                <h1 className="headerLogo">
                    <Link to="/">CAMPERBLIC.</Link>
                </h1>
                <button className="headerBtn"><Link to="/login">로그인</Link></button>
                <button className="headerBtn" onClick={handleOfIsMall}>쇼핑몰</button>

                <nav className="totalMenu">
                    <Link to="/cart">장바구니</Link>
                </nav>

                <nav className="mall" style={{ display: isMall ? "block" : "none" }}>
                    <Link to="/itemall">전체상품</Link>
                    <Link to="/tent">텐트/타프</Link>
                    <Link to="/chair">테이블/체어</Link>
                    <Link to="/mat">침낭/매트</Link>
                    <Link to="/cook">취사용품</Link>
                    <Link to="/etc">소품</Link>
                    <button className="logInBtn">검색(())</button>
                </nav>

                <nav className="community" style={{ display: isMall ? "none" : "block" }}>
                    <Link to="/community">대시보드</Link>
                    <Link to="/campstory">캠핑 이야기</Link>
                    <Link to="/freeboard">자유 게시판</Link>
                    <Link to="/gathercamper">캠퍼 구인</Link>
                    <Link to="/reviewcampingsite">캠핑장 후기</Link>
                </nav>

                {isAdmin && <Admin/>}

            </aside>

            <aside className="asideBottom">
                <button className="bottomBtn">어쩌구 고객</button>
                <button className="bottomBtn">뭐시기 저거</button>
            </aside>

            <div className="justDeco bottom"></div>
            <div className="right"></div>
        </header>
    );
}

export default Header;