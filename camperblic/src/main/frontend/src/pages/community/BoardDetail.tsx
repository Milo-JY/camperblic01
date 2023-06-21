import React, { useEffect, useState } from 'react';
import { useParams } from 'react-router-dom';
import axios from 'axios';
import { Posting } from '../../types';
import '../../styles/communityStyles/boardDetail.css';

const BoardDetail: React.FC = () => {
    const { id, category } = useParams<{ id: string, category: string }>();
    const [posting, setPosting] = useState<Posting>();

    useEffect(() => {
        axios
            .get(`/boarddetail/${category}/${id}`)
            .then((response) => setPosting(response.data))
            .catch((error) => {
                console.error('게시물을 가져오는 데 실패했습니다.', error);
            });
    }, [id]);

    return (
        <section>
            <div className="board-detail-container">
                <section className="board-detail">
                    <div className="container">
                        <div className="post">
                            <div className="post-info">
                                <div className="post-header">
                                    <h3>{posting?.title}</h3>
                                    <p>글 번호: {posting?.id}</p>
                                </div>
                                <div className="post-details">
                                    <p>
                                        작성자: {posting?.name} | 작성일: {posting?.createdate} | 조회수: {posting?.views}
                                    </p>
                                </div>
                            </div>
                            <div className="post-content">
                                <p>{posting?.content}</p>
                            </div>
                        </div>
                    </div>
                </section>
            </div>
        </section>
    );
};

export default BoardDetail;