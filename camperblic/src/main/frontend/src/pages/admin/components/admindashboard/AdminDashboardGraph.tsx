import React, { useEffect, useState } from 'react';
import {GraphDTO, Tmp} from '../../../../types';
import axios from 'axios';
import Barchart from './Barchart';
import { useLocation } from 'react-router-dom';

const AdminDashboardGraph = () => {
    // const [graphDTO, setGraphDTO] = useState<GraphDTO[]>([]);
    const [isChartVisible, setIsChartVisible] = useState(false);
    const [graphDTO, setGraphDTO] = useState<GraphDTO>({
        totalPriceSum: 0,
        tentTotalPrice: 0,
        chairTotalPrice: 0,
        matTotalPrice: 0,
        cookTotalPrice: 0,
        etcTotalPrice: 0,
    });
    useEffect(() => {
        axios
            .get(`/admindashboard/admindashboardchart`)
            .then((response) => setGraphDTO(response.data))
            .catch((error) => console.log(error));
    }, []);

    const handleToggleChart = () => {
        setIsChartVisible((prevState) => !prevState);
    };

    return (
        <section>
            <button onClick={handleToggleChart}>
                {isChartVisible ? '그래프 숨기기' : '그래프 보이기'}
            </button>
            <Barchart graphDTO={graphDTO}/>
        </section>
    );
};

export default AdminDashboardGraph;
