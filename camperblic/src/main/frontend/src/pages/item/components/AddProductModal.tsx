import React, { useState } from 'react';
import Modal from 'react-modal';
import { Item } from '../../../types';

Modal.setAppElement('#root');

interface AddProductModalProps {
    isOpen: boolean;
    closeModal: () => void;
    addProduct: (product: Item) => void;
}

const AddProductModal: React.FC<AddProductModalProps> = ({
                                                             isOpen,
                                                             closeModal,
                                                             addProduct,
                                                         }) => {
    const [name, setName] = useState('');
    const [price, setPrice] = useState('');
    const [description, setDescription] = useState('');
    const [categoryId, setCategoryId] = useState('');
    const [imagePath, setImagePath] = useState('');
    const [amount, setAmount] = useState(0);
    const [currentStock, setCurrentStock] = useState(0);

    const handleSubmit = (e: React.FormEvent) => {
        e.preventDefault();
        if (!name || !price) {
            return;
        }
        const newProduct: Item = {
            itemId: 'uniqueItemId',
            name,
            price: parseFloat(price),
            description,
            categoryId,
            imagePath,
            amount,
            currentStock,
        };
        addProduct(newProduct);
        setName('');
        setPrice('');
        setDescription('');
        setCategoryId('');
        setImagePath('');
        setAmount(0);
        setCurrentStock(0);
        closeModal();
    };

    return (
        <Modal
            isOpen={isOpen}
            onRequestClose={closeModal}
            contentLabel="Add Product Modal"
        >
            <h2>상품 등록 페이지입니다~~</h2>
            <form onSubmit={handleSubmit}>
                <input
                    type="text"
                    placeholder="상품 이름"
                    value={name}
                    onChange={(e) => setName(e.target.value)}
                />
                <input
                    type="number"
                    placeholder="상품 가격"
                    value={price}
                    onChange={(e) => setPrice(e.target.value)}
                />
                {/* 추가 필드를 여기에 추가하세요 */}
                <button type="submit">상품 등록</button>
                <button onClick={closeModal}>취소</button>
            </form>
        </Modal>
    );
};

export default AddProductModal;
