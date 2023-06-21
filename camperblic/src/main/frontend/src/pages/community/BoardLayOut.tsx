import React, { useState } from 'react';
import { Link, useNavigate } from 'react-router-dom';
import { Posting } from '../../types';
import '../../styles/communityStyles/boardLayout.css';

interface BoardLayOutProps {
    postings: Posting[];
}

const BoardLayOut: React.FC<BoardLayOutProps> = ({ postings }) => {
    const navigate = useNavigate();
    const [visiblePostCount, setVisiblePostCount] = useState(15);

    const handleTitleClick = (id: number, category: string) => {
        navigate(`/boarddetail/${category}/${id}`);
    };

    const visiblePostings = postings.slice(0, visiblePostCount);
    const liCount = Math.ceil(postings.length / visiblePostCount);

    return (
        <section className="boardLayOut">
            <div className="topSide"></div>
            <div className="innerWrap">
                <div className="tableContainer">
                    <table>
                        <colgroup>
                            <col style={{ width: '10%' }} />
                            <col style={{ width: '15%' }} />
                            <col style={{ width: '45%' }} />
                            <col style={{ width: '20%' }} />
                            <col style={{ width: '10%' }} />
                        </colgroup>
                        <thead>
                        <tr>
                            <th>글 번호</th>
                            <th>작성자</th>
                            <th>제목</th>
                            <th>작성일</th>
                            <th>조회수</th>
                        </tr>
                        </thead>
                        <tbody>
                        {visiblePostings.map((posting) => (
                            <tr key={posting.id}>
                                <td>{posting.id}</td>
                                <td>{posting.name}</td>
                                <td
                                    className="linkTd"
                                    onClick={() => handleTitleClick(posting.id, posting.category)}
                                >
                                    {posting.title}
                                </td>
                                <td>{posting.createdate}</td>
                                <td>{posting.views}</td>
                            </tr>
                        ))}
                        </tbody>
                    </table>
                </div>
                <button className="writeBtn">
                    <Link to="/write">글쓰기</Link>
                </button>
                <nav>
                    <button>왼쪽</button>
                    <ul>
                        {Array.from({ length: liCount }, (_, index) => (
                            <li key={index + 1}>
                                <button>{index + 1}</button>
                            </li>
                        ))}
                    </ul>
                    <button>오른쪽</button>
                </nav>
            </div>
            <div className="bottomSide"></div>
        </section>
    );
};

export default BoardLayOut;